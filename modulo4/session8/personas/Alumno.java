package personas;

public class Alumno  extends Persona{
	
	private Profesor profesor;
	private String hobby;
	
	public Alumno(String nombre, String identificador, Profesor profesor, String hobby) {
		super(nombre, identificador);
		this.profesor = profesor;
		this.hobby = hobby;
	}
	
	 @Override
	    public String hobby() {
	        return "El hobby del alumno " + nombre + " es: " + hobby;
	    }

	    @Override
	    public String toString() {
	        return "Alumno: [nombre: " + nombre + ", identificador: " + identificador + ", profesor = " + profesor + ", hobby: " + hobby + "]";
	    }
}
