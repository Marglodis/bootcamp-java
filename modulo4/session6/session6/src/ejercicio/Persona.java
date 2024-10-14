package ejercicio;

public class Persona {
    private String usuario;
    private String contrasenia;

    public Persona(String usuario, String contrasenia){
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getUsuario(){
        return usuario;
    }

    public String getContrasenia(){
        return contrasenia;
    }

}
