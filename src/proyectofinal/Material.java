package proyectofinal;

public abstract class Material implements Prestable {
    private int codigo;
    private String titulo;
    private String autor;
    private int anio;
    private boolean disponible = true;

    public Material(int codigo, String titulo, String autor, int anio) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public abstract int calcularDiasPrestamo();
    public abstract String getTipo();

    @Override
    public boolean prestar() {
        if (disponible) {
            disponible = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean devolver() {
        if (!disponible) {
            disponible = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean estaDisponible() { return disponible; }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}