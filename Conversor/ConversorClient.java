package Conversor;

import com.google.gson.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConversorClient {

    private final HttpClient client;


    public ConversorClient() {
        client = HttpClient.newHttpClient();  // Paso: Construyendo el cliente para Solicitudes.
    }

    // Paso: Filtrando las monedas y Paso: Convirtiendo los valores;
    public double findAll(String base, String target, double amount) throws IOException, InterruptedException {
        final String BASE_URL = "https://v6.exchangerate-api.com/v6/228c89164f41153beb0cbe52/pair/";

        // Paso: Construyendo  la Solicitud
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + base + "/" + target + "/" + amount))
                .GET()
                .build();
        // Paso: Construyendo la Respuesta
        HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Paso: Analizando la respuesta en formato JSON
        String jsonData = response.body();

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Response resObject = gson.fromJson(jsonData, Response.class);

        return resObject.conversion_result();

    }

}





/*//Paso: Construyendo la Solicitud
        //https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP/AMOUNT
        String BASE_URL = "https://v6.exchangerate-api.com/v6/228c89164f41153beb0cbe52/pair/";
        URL url = new URL(BASE_URL + base + "/" + target + "/" + amount);
        HttpsURLConnection request = (HttpsURLConnection) url.openConnection();
        request.connect();

        //Paso: Analizando la respuesta en formato JSON
        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing object
        String req_result = jsonobj.get("conversion_result").getAsString();
        return req_result;*/
