package models;

public class Polera extends Articulo{

    private String color;

    public Polera(String color) {
        super("Polera");
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + " color " + color;
    }
}