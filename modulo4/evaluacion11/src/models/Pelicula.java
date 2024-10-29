package models;

public class Pelicula {
    private String titulo;
    private int anioEstreno;
    private boolean arrendada;

    public Pelicula(String titulo, int anioEstreno) {
        this.titulo = titulo;
        this.anioEstreno = anioEstreno;
        this.arrendada = arrendada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public boolean isArrendada() {
        return arrendada;
    }

    public void setArrendada(boolean arrendada) {
        this.arrendada = arrendada;
    }

    public void registrarArriendo() {
        arrendada = true;
    }

    public void registrarDevolucion() {
        arrendada = false;
    }
}
