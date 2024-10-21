package evaluacionS8.modelos;

import java.time.LocalDate;

public class Vegetal extends Producto{
	private LocalDate  fechaEnvasado;
	private LocalDate  fechaCaducidad;

	public Vegetal(String nombre, String codigo, double precio, LocalDate  fechaEnvasado, LocalDate fechaCaducidad) {
		super(nombre, codigo, precio);
		this.fechaEnvasado = fechaEnvasado;
        this.fechaCaducidad = fechaCaducidad;
	}
	
	
	public LocalDate getFechaEnvasado() {
		return fechaEnvasado;
	}


	public LocalDate  getFechaCaducidad() {
		return fechaCaducidad;
	}

	 @Override
	    public String toString() {
	        return "Vegetal [nombre=" + getNombre() + ", codigo=" + getCodigo() + ", precio=" + getPrecio() + 
	                ", fechaEnvasado=" + fechaEnvasado + ", fechaCaducidad=" + fechaCaducidad + "]";
	    }

}
