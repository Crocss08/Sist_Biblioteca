package proyectofinal;

public class Revista extends Material {
    private String numeroEdicion;

    public Revista(int codigo, String titulo, String autor, int anio, String numeroEdicion) {
        super(codigo, titulo, autor, anio);
        this.numeroEdicion = numeroEdicion;
    }

    @Override public int calcularDiasPrestamo() { return 3; }
    @Override public String getTipo() { return "Revista"; }

    public String getNumeroEdicion() { return numeroEdicion; }
    public void setNumeroEdicion(String numeroEdicion) { this.numeroEdicion = numeroEdicion; }
}