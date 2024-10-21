package evaluacionS8.modelos;

public class Vestuario extends Producto{
	private String talla;
    private String color;

    public Vestuario(String nombre, String codigo, double precio, String talla, String color) {
        super(nombre, codigo, precio);
        this.talla = talla;
        this.color = color;
    }

    
    
    public String getTalla() {
		return talla;
	}

	public String getColor() {
		return color;
	}

	   @Override
	    public String toString() {
	        return "Vestuario [nombre=" + getNombre() + ", codigo=" + getCodigo() + ", precio=" + getPrecio() +
	               ", talla=" + talla + ", color=" + color + "]";
	    }
}
