import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestorParticipantes {
    private List<Participante> participantes;

    public GestorParticipantes() {
        this.participantes = ManejadorArchivo.cargarParticipantes();
        if (participantes.isEmpty()) {
            System.out.println("No hay participantes");
        }
    }

    public void agregarParticipantes(String nombre){
        participantes.add(new Participante(nombre));
    }

    public List<Participante> getParticipantes() {
       return participantes;

    }

    public Participante elegirGanador(){
        if(participantes.isEmpty()){
            return null;
        }
        Random random = new Random();
        return participantes.get(random.nextInt(participantes.size()));
    }
    public void guardarParticipantes(){
        ManejadorArchivo.guardarParticipantes(participantes);
    }
}
