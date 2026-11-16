package proyectofinal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {
    private final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private final String USER = "root";
    private final String PASSWORD = "40252334";

    public Connection getConexion() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Llama a sp_registrar_material
    public boolean registrarMaterial(Material m) {
        String sql = "{CALL sp_registrar_material(?, ?, ?, ?, ?, ?, ?)}";
        try (Connection con = getConexion();
             CallableStatement cs = con.prepareCall(sql)) {

            String extra1 = "";
            int extra2 = 0;
            if (m instanceof Libro l) {
                extra1 = l.getEditorial();
                extra2 = l.getPaginas();
            } else if (m instanceof Revista r) {
                extra1 = r.getNumeroEdicion();
            } else if (m instanceof Tesis t) {
                extra1 = t.getUniversidad();
            }

            cs.setInt(1, m.getCodigo());
            cs.setString(2, m.getTitulo());
            cs.setString(3, m.getAutor());
            cs.setInt(4, m.getAnio());
            cs.setString(5, m.getTipo());
            cs.setString(6, extra1);
            cs.setInt(7, extra2);

            cs.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al registrar: " + e.getMessage());
            return false;
        }
    }

    // Llama a sp_listar_materiales
    public List<Material> listarMateriales() {
        List<Material> lista = new ArrayList<>();
        String sql = "{CALL sp_listar_materiales()}";
        try (Connection con = getConexion();
             CallableStatement cs = con.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            leer(rs, lista);
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    // Llama a sp_buscar_catalogo (tipo: Todos, Libro, Revista o Tesis)
    public List<Material> buscarCatalogo(String texto, String tipo) {
        List<Material> lista = new ArrayList<>();
        String sql = "{CALL sp_buscar_catalogo(?, ?)}";
        try (Connection con = getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, texto);
            cs.setString(2, tipo);
            try (ResultSet rs = cs.executeQuery()) {
                leer(rs, lista);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        return lista;
    }

    // Llama a sp_eliminar_material (parámetro de salida: filas eliminadas)
    public boolean eliminarMaterial(int codigo) {
        String sql = "{CALL sp_eliminar_material(?, ?)}";
        try (Connection con = getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, codigo);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.execute();
            return cs.getInt(2) > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    // Convierte cada fila en un Libro, Revista o Tesis
    private void leer(ResultSet rs, List<Material> lista) throws Exception {
        while (rs.next()) {
            int codigo = rs.getInt("codigo");
            String titulo = rs.getString("titulo");
            String autor = rs.getString("autor");
            int anio = rs.getInt("anio");
            String tipo = rs.getString("tipo");
            String extra1 = rs.getString("extra1");
            int extra2 = rs.getInt("extra2");

            Material m;
            switch (tipo) {
                case "Libro":
                    m = new Libro(codigo, titulo, autor, anio, extra1, extra2);
                    break;
                case "Revista":
                    m = new Revista(codigo, titulo, autor, anio, extra1);
                    break;
                default:
                    m = new Tesis(codigo, titulo, autor, anio, extra1);
            }
            m.setDisponible(rs.getBoolean("disponible"));
            lista.add(m);
        }
    }
}