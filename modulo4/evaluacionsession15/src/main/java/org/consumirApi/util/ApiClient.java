package org.consumirApi.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private final HttpClient client;

    public ApiClient() {
        this.client = HttpClient.newHttpClient();
    }

    public HttpResponse<String> enviarPeticion(String url) throws Exception {
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            System.out.println("Error en la petición HTTP: " + e.getMessage());
            throw new Exception("Error al realizar la petición HTTP: " + e.getMessage(), e);
        }
    }
}
