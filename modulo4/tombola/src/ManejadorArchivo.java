import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejadorArchivo {
    private static final String RUTA_ARCHIVO = "archivos/participantes.txt";
    private static final String DIRECTORIO = "archivos";

    public static List<Participante> cargarParticipantes(){
        List<Participante> participantes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))){
            String linea;
            while ((linea = br.readLine()) != null){
                participantes.add(new Participante(linea.trim()));
            }

            if (participantes.isEmpty()){
                System.out.println("No se encontraron participantes");
            }
        } catch (IOException e) {
            System.out.println("Error al cargar participantes: " + e.getMessage());
        }
        return participantes;
    }

    public static void guardarParticipantes(List<Participante> participantes){
        new File(DIRECTORIO).mkdirs();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))){
            for (Participante participante : participantes){
                bw.write(participante.getNombre());
                bw.newLine();
            }
        }catch (IOException e){
            System.out.println("Error al guardar participantes: " + e.getMessage());
        }
    }

    public static void guardarGanador(Participante ganador){
        new File(DIRECTORIO).mkdirs(); //Asegurar que el directorio existe
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DIRECTORIO + "/"+ ganador.getNombre() + "_ganador.txt"))){
            bw.write("¡Felicidades " + ganador.getNombre() + "! Has ganado la bicicleta.");
        } catch (IOException e){
            System.out.println("Error al guardar ganador: " + e.getMessage());
        }
    }
}
