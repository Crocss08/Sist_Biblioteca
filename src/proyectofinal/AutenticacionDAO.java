/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class AutenticacionDAO {
    private final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private final String USER = "root";
    private final String PASSWORD = "40252334";

    public Connection getConexion() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Devuelve el nombre del profesor si el código existe, o null si no
    public String validarAdministrador(String codigo) {
        String sql = "{CALL sp_validar_admin(?, ?)}";
        try (Connection con = getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, codigo);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.execute();
            return cs.getString(2);
        } catch (Exception e) {
            System.out.println("Error al validar: " + e.getMessage());
            return null;
        }
    }
}