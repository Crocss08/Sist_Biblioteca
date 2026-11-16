package proyectofinal;

public class Libro extends Material {
    private String editorial;
    private int paginas;

    public Libro(int codigo, String titulo, String autor, int anio, String editorial, int paginas) {
        super(codigo, titulo, autor, anio);
        this.editorial = editorial;
        this.paginas = paginas;
    }

    @Override public int calcularDiasPrestamo() { return 7; }
    @Override public String getTipo() { return "Libro"; }

    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }
    public int getPaginas() { return paginas; }
    public void setPaginas(int paginas) { this.paginas = paginas; }
}