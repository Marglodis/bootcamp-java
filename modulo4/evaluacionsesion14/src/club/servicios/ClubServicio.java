package club.servicios;

import club.excepciones.LimiteSociosException;
import club.excepciones.SocioDuplicadoException;
import club.modelo.Socio;

import java.util.ArrayList;
import java.util.List;

public class ClubServicio {
    private List<Socio> socios = new ArrayList<>();
    private static final int LIMITE_SOCIOS = 6;

    public void agregarSocio(Socio socioNuevo) throws LimiteSociosException, SocioDuplicadoException {
        if (socios.size() >= LIMITE_SOCIOS) {
            throw new LimiteSociosException("No se pueden agregar más de " + LIMITE_SOCIOS + " socios");
        }
        if(socios.contains(socioNuevo)){
            throw new SocioDuplicadoException("Socio ya existe");
        }
        socios.add(socioNuevo);

    }

    public void mostrarSocios(){
        if(socios.isEmpty()){
            System.out.println("El club no tiene socios.");
        } else {
            System.out.println("Socios del club: \n");
            for (Socio socio : socios) {
                System.out.println(socio);
            }
            System.out.println("Total socios: " + socios.size());
        }
    }
}
