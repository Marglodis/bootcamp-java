package ejercicio;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Autenticacion auth = new Autenticacion();

        int intentos = 0;
        boolean acceso = false;

        while (intentos < 3 && !acceso) {
            System.out.print(Color.BLUE + "Ingrese su nombre de usuario: " + Color.RESET);
            String usuarioIngresado = sc.nextLine();
            System.out.print(Color.BLUE + "Ingrese su contraseña: " + Color.RESET);
            String contraseniaIngresada = sc.nextLine();

            if (auth.autenticar(usuarioIngresado, contraseniaIngresada)) {
                acceso = true;
                System.out.print(Color.GREEN + "Bienvenido " + usuarioIngresado + Color.RESET);
                auth.mostrarMenu();
            } else {
                intentos++;
                System.out.println(Color.RED + "Usuario o contraseña incorrectos.");
            }

        }
        if (!acceso) {
            System.out.println(Color.RED + "Número máximo de intentos alcanzados. Saliendo del programa");
        }
        sc.close();
    }
}
