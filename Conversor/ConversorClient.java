package Conversor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.http.HttpClient;


public class ConversorClient {

    private final HttpClient client;


    public ConversorClient() {
        client = HttpClient.newHttpClient();  // Paso: Construyendo el cliente para Solicitudes.
    }

    // Paso: Filtrando las monedas y Paso: Convirtiendo los valores;
    public String findAll(String base, String target, double amount) throws IOException {

        //Paso: Construyendo la Solicitud
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
        return req_result;

    }

}
