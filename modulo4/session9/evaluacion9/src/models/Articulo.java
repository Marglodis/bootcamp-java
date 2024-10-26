package models;

public abstract class Articulo {
    private String tipo;

    public Articulo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
