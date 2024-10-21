package evaluacionS8.modelos;

public abstract class Producto implements ProductoInterface{
	protected String nombre;
	protected String codigo;
	protected double precio;

	public Producto(String nombre, String codigo, double precio) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
	}

	@Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

}

