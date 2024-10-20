package ejercicioS8;

import java.util.ArrayList;
import java.util.List;

import personas.Alumno;
import personas.Persona;
import personas.Profesor;

public class Curso {

	public static void main(String[] args) {
		 
		Profesor profesor = new Profesor("Francisco vargas", "15486-9", "historis"); 

		Alumno alumno1 = new Alumno("Eloy Palacios", "15468-5", profesor, "Jugar futbol");
        Alumno alumno2 = new Alumno("Maria González", "15470-2", profesor, "Leer libros");
        Alumno alumno3 = new Alumno("Carlos Ruiz", "15471-3", profesor, "Correr");

        
        List<Persona> curso = new ArrayList<>();
        curso.add(profesor);
        curso.add(alumno1);
        curso.add(alumno2);
        curso.add(alumno3);
        
        System.out.println("El curso está compuesto por:");
        for (Persona integrante : curso) {
            System.out.println(integrante);
        }
	}

}
