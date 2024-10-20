package personas;

public abstract class Persona {
	protected String nombre;
	protected String identificador;
	
	public Persona(String nombre, String identificador) {
		this.nombre = nombre;
		this.identificador = identificador;
	}
	
	public abstract String hobby();
		
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", identificador: " + identificador;
	}
}
