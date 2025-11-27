package pe.edu.tecsup.mvvm.app.modelo;

public class Tarea {
    private int id;
    private String titulo;
    private boolean completado;

    public Tarea() {}

    public Tarea(int id, String titulo, boolean completado) {
        this.id = id;
        this.titulo = titulo;
        this.completado = completado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public boolean isCompletado() { return completado; }
    public void setCompletado(boolean completado) { this.completado = completado; }
}