package models;

class Persona implements IPersona {
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public void hablar() {
        System.out.println(nombre + " " + apellido + " dice: ¡Hola!");
    }

    @Override
    public void celebrar() {
        System.out.println(nombre + " " + apellido + " celebra.");
    }

    @Override
    public String toString() {
        return  nombre + ' ' + apellido + ", Edad: " + edad;
    }
}
