import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorParticipantes gestor = new GestorParticipantes();

        boolean continuar = true;
        while (continuar) {
            System.out.print(""" 
                    \n*** MENU ***
                    1. Agregar participante.
                    2. Ver participantes.
                    3. Elegir ganador.
                    4. Salir.
                    Seleccione una opción: 
                    """);
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del participante: ");
                    String nombre = sc.nextLine();
                    gestor.agregarParticipantes(nombre);
                    break;
                case 2:
                    System.out.print("\nLista de participantes:\n");

                    for (Participante participante : gestor.getParticipantes()) {
                        System.out.println(participante);
                    }
                    break;
                case 3:
                    Participante ganador = gestor.elegirGanador();
                    if (ganador != null) {
                        System.out.println("El ganador es: " + ganador.getNombre());
                        ManejadorArchivo.guardarGanador(ganador);
                        gestor.guardarParticipantes();
                    } else {
                        System.out.println("No hay participantes para elegir el ganador.");
                    }
                    continuar = false;
                    break;
                case 4:
                    gestor.guardarParticipantes();
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        sc.close();
    }
}
