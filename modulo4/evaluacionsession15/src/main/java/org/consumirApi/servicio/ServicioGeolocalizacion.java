package org.consumirApi.servicio;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import org.consumirApi.modelo.Geolocalizacion;
import org.consumirApi.util.ApiClient;

import java.net.http.HttpResponse;



public class ServicioGeolocalizacion {

    /**
     * La  dirección https://freegeoip.app/json no se encuentra disponible. De ahí que utilizara la de prueba de la página https://app.ipbase.com
     */
// Cambiamos la URL para usar la API Key obtenida de las variables de entorno.
    private static final String API_URL_TEMPLATE = "https://api.ipbase.com/v2/info?apikey=%s";
    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    //cargar el archivo .env

    public ServicioGeolocalizacion() {
        this.apiClient = new ApiClient() ;
        this.objectMapper = new ObjectMapper();
    }

    public Geolocalizacion obtenerDatosGeograficos(){
        try{
            // Obtener la clave API desde la variable de entorno
            Dotenv dotenv = Dotenv.load();
            String apiKey = dotenv.get("IPBASE_API_KEY");
            if (apiKey == null || apiKey.isEmpty()) {
                throw new Exception("La clave API no está configurada en las variables de entorno.");
            }

            // Formatear la URL con la API key
            String apiUrl = String.format(API_URL_TEMPLATE, apiKey);
            HttpResponse<String> response = apiClient.enviarPeticion(apiUrl);
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
