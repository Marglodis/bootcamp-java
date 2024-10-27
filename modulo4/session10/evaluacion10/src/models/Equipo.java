package models;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private DirectorTecnico directorTecnico;
    private List<Jugador> jugadores;

    public Equipo(DirectorTecnico directorTecnico) {
        this.directorTecnico = directorTecnico;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador){
        if(jugadores.size() < 11){
            jugadores.add(jugador);
        }else {
            System.out.println("El equipo ya tiene 11 jugadores.");
        }
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void mostrarEquipo(){
        System.out.println("Director Técnico: " + directorTecnico.toString());
        System.out.println("Jugadores: ");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.toString());
        }
    }
}
