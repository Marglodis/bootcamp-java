package personas;

public class Profesor  extends Persona{

	private String especialidad;
	
	public Profesor(String nombre, String identificador, String especialidad) {
		super(nombre, identificador);
		this.especialidad = especialidad;
	}

	@Override
	public String hobby() {
		return "El profesor " + nombre + " está realizando ejercicios.";
	}
	
	 @Override
	    public String toString() {
	        return "Profesor [especialidad: " + especialidad + ", " + super.toString() + "]";
	    }
}
