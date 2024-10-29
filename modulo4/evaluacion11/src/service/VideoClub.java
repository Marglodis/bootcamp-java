package service;

import models.Pelicula;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VideoClub {
    private List<Pelicula> peliculas;
    private Scanner sc;

    public VideoClub(){
        peliculas = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void agregarPelicula(String titulo, int anioEstreno){
        Pelicula nuevaPelicula = new Pelicula(titulo, anioEstreno);
        peliculas.add(nuevaPelicula);
    }

    public List<Pelicula> mostrarPeliculasDisponibles() {
        List<Pelicula> disponibles = new ArrayList<>();
        disponibles.addAll(peliculas.stream()
                .filter(pelicula->!pelicula.isArrendada())
                .collect(Collectors.toList()));
        return disponibles;
    }

    public void arriendoPelicula(String titulo){
        for(Pelicula pelicula : peliculas){
            if(pelicula.getTitulo().equals(titulo) && !pelicula.isArrendada()){
                System.out.print("Seleccione método de pago (1. Efectivo / 2. Tarjeta");
                String metodoPago = sc.nextLine();

                if(metodoPago.equals("1")){
                    System.out.println("Método de pago seleccionado: Efectivo");
                }else if (metodoPago.equals("2")){
                    System.out.println("Método de pago seleccionado: Tarjeta");
                } else{
                    System.out.println("Método de pago no válido. El arriendo no se procesará.");
                    return;
                }
                pelicula.registrarArriendo();
                System.out.println("Pelicula '" + titulo + "' arrendada con pago: " + (metodoPago.equals("1") ? "Efectivo" : "Tarjeta") + ".");
                return;
            }
        }
        System.out.println("Película '" + titulo + "' no disponible para arriendo.");
    }

    public void devolucionPelicula(String titulo){
        for(Pelicula pelicula : peliculas){
            if(pelicula.getTitulo().equals(titulo) && pelicula.isArrendada()){
                pelicula.registrarDevolucion();
                System.out.println("Película '" + titulo + "' devuelta.");
                return;
            }
        }
        System.out.println("Película '" + titulo + "' no está arrendada.");
    }
}
