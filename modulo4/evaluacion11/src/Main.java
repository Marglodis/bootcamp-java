import models.Pelicula;
import models.Usuario;
import service.VideoClub;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Usuario propietario = Usuario.getPropietario("Dueño Video Club");
        VideoClub videoClub = new VideoClub();
        Scanner sc = new Scanner(System.in);
        String opcion;

        while (true) {
            System.out.println("Bienvenido, " + propietario.getNombre());
            System.out.print("""
                    \n*** Menú ***
                    1.- Agregar Película.
                    2.- Mostrar películas disponibles.
                    3.- Arrendar película.
                    4.- Devolver película.
                    5.- Salir.
                    Seleccione ua opción: 
                    """);
            opcion = sc.nextLine();


            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el título de la película: ");
                    String titulo = sc.nextLine();
                    System.out.print("Ingrese el año de estreno: ");
                    int anioEstreno = Integer.parseInt(sc.nextLine());
                    videoClub.agregarPelicula(titulo, anioEstreno);
                    break;
                case "2":
                    List<Pelicula> disponibles = videoClub.mostrarPeliculasDisponibles();
                    if (disponibles.isEmpty()) {
                        System.out.println("No hay pelćulas disponibles");
                    } else {
                        disponibles.forEach(pelicula -> System.out.println(pelicula.getTitulo() + " (" + pelicula.getAnioEstreno() + ")"));
                    }
                    break;
                case "3":
                    System.out.print("Ingrese el título de la película a arrendar: ");
                    String tituloArriendo = sc.nextLine();
                    videoClub.arriendoPelicula(tituloArriendo);
                    break;
                case "4":
                    System.out.print("Ingrese el título de la película a devolver: ");
                    String tituloDevolucion = sc.nextLine();
                    videoClub.devolucionPelicula(tituloDevolucion);
                    break;
                case "5":
                    System.out.println("Saliendo del sistema.");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
     }
}

