import models.Alumno;
import models.Persona;
import models.Profesor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Persona> personas = Arrays.asList(
                new Profesor("Juan Pérez", LocalDate.of(1980, 5, 15)),
                new Alumno("Ana Gómez", LocalDate.of(2005, 3, 20), Arrays.asList("Tarea 1", "Tarea 2")),
                new Alumno("Luis Torres", LocalDate.of(2006, 7, 10), Arrays.asList("Tarea 3")),
                new Profesor("María López", LocalDate.of(1975, 11, 30))
        );
        for (Persona persona: personas){
            System.out.println("Persona tipo " + persona);
        }
        System.out.println();
        for (Persona persona : personas){
            System.out.println("Super clase de " + persona.getTipo() + ": " + persona.getClass().getSuperclass().getSimpleName());
        }

        System.out.println("\nLista de personas: " );
        for (Persona persona: personas){
            System.out.println(persona);
        }
    }
}