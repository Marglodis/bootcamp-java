package evaluacion;

import ejercicio.Color;
import ejercicio.Persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Registro {
    private List<Persona> usuarios = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public void registrarUsuario(){

        while(usuarios.size() < 10){
            System.out.print(Color.BLUE + "\nIngrese nuevo nombre de usuario: ");
            String nombreUsuario = sc.nextLine();
            String contrasenia;

            while(true){
                System.out.print(Color.BLUE + "Ingresa la contraseña: ");
                contrasenia = sc.nextLine();
                String resultado = validarContrasenia(contrasenia);
                if(resultado.equals("Fuerte")){
                    break;
                } else {
                    System.out.println(Color.RED +"Contraseña " + resultado + ".");
                }
            }
            System.out.print("Ingrese su nombre completo: ");
            String nombreCompleto = sc.nextLine();
            String fechaNacimiento;

            while (true) {
                System.out.print("Ingrese fecha de nacimiento (DD-MM-YYYY): ");
                fechaNacimiento = sc.nextLine();
                if (validarFecha(fechaNacimiento)) {
                    break;
                } else {
                    System.out.println(Color.RED + "Fecha inválida. Por favor ingrese una fecha válida en formato DD-MM-YYYY." + Color.RESET);
                }
            }

            if(esMayorDeEdad(fechaNacimiento)){
                usuarios.add(new Persona(nombreUsuario,contrasenia, nombreCompleto,fechaNacimiento));
                System.out.println(Color.GREEN + "Usuario registrado con éxito.");
            } else{
                System.out.println(Color.RED + "Debes ser mayor de edad para registrarte.");
            }
            mostrarUsuario();
        }
        System.out.println("Se alcanzó el límite de usuarios registrados.");
        sc.close();
    }

    private String validarContrasenia(String contrasenia){
        if (contrasenia.length() <= 10) {
            return "Débil";
        }
        if(Pattern.compile("[A-Z].*[A-Z]").matcher(contrasenia).find() && // Al menos 2 mayúsculas
           Pattern.compile("[0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]").matcher(contrasenia).find())// Al menos 3 números o símbolos
        {
            return "Fuerte";
        }
       return "Débil";
    }

    private boolean validarFecha(String fecha) {
        try {
            LocalDate.parse(fecha, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean esMayorDeEdad(String fechaNacimiento){
        int anioNacimiento = Integer.parseInt(fechaNacimiento.split("-")[2]);
        int anioActual = java.time.LocalDate.now().getYear();
        return (anioActual-anioNacimiento) >= 18;
    }

    private void mostrarUsuario(){
        System.out.println("Usuarios registrados: ");
        for (Persona usuario : usuarios){
            System.out.println(Color.YELLOW + "Nombre usuario: " + usuario.getUsuario() + ", Nombre Completo: " + usuario.getNombreCompleto() + Color.RESET );
        }
    }
}
