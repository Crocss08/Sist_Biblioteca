package proyectofinal;

public class Tesis extends Material {
    private String universidad;

    public Tesis(int codigo, String titulo, String autor, int anio, String universidad) {
        super(codigo, titulo, autor, anio);
        this.universidad = universidad;
    }

    @Override public int calcularDiasPrestamo() { return 2; }
    @Override public String getTipo() { return "Tesis"; }

    public String getUniversidad() { return universidad; }
    public void setUniversidad(String universidad) { this.universidad = universidad; }
}