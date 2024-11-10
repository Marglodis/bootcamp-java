package org.consumirApi.servicio;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.consumirApi.modelo.Geolocalizacion;
import org.consumirApi.util.ApiClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ServicioGeolocalizacion {

    /**
     * La  dirección https://freegeoip.app/json no se encuentra disponible. De ahí que utilizara la de prueba de la página https://app.ipbase.com
     */

    private static final String API_URL = "https://api.ipbase.com/v2/info?apikey=ipb_live_gVw19isQ5PpaQLB3ZLe26w01gY2T545nwkcEXiDh&ip=1.1.1.1";
    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public ServicioGeolocalizacion() {
        this.apiClient = new ApiClient() ;
        this.objectMapper = new ObjectMapper();
    }

    public Geolocalizacion obtenerDatosGeograficos(){
        try{

            HttpResponse<String> response = apiClient.enviarPeticion(API_URL);
          if (response.statusCode() == 200){

              //Se convierte la respuesta JSON en un objeto Geolocalización
              JsonNode jsonNode = objectMapper.readTree(response.body());

              // Extraemos los datos de ubicación
              Geolocalizacion geolocalizacion = new Geolocalizacion();
              geolocalizacion.setCiudad(jsonNode.path("data").path("location").path("city").path("name").asText());
              geolocalizacion.setRegion(jsonNode.path("data").path("location").path("region").path("name").toString());
              geolocalizacion.setPais(jsonNode.path("data").path("location").path("country").path("name").asText());
              geolocalizacion.setContinente(jsonNode.path("data").path("location").path("continent").path("name").asText());

              return geolocalizacion;
          }else {
              throw new Exception("Error al obtener datos geográficos. Código respuesta: " + response.statusCode());
          }
        }catch (Exception e){
            System.out.println("Error al obtener geolocalización: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
