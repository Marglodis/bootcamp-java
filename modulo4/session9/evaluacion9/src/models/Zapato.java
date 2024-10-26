package models;

public class Zapato extends Articulo{
        private String marca;

        public Zapato(String marca) {
            super("Zapatos");
            this.marca = marca;
        }

    @Override
    public String toString() {
        return super.toString() + " marca " + marca;
    }
}
