package br.com.edielson.conversordemoedas;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Menuconversor {

    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();
    private static final String API_KEY = "87d0f857dba3897869161d1f";

    public Conversor conversor(String baseCurrency, String targetCurrency, Double value) {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/"+ baseCurrency+"/"+targetCurrency+"/"+value;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
                if (jsonObject.get("result").getAsString().equals("success")) {
                    double conversionResult = jsonObject.get("conversion_result").getAsDouble();
                    double rate = jsonObject.get("conversion_rate").getAsDouble();

                    // Criar e retornar um objeto Conversor com os dados necessários
                    Conversor conversor = new Conversor();
                    conversor.setBase_code(baseCurrency);
                    conversor.setTarget_code(targetCurrency);
                    conversor.setConversion_rate(rate);
                    conversor.setConversion_result(conversionResult);

                    return conversor;
                } else {
                    throw new RuntimeException("Erro na API: " + jsonObject.get("error").getAsJsonObject().get("info").getAsString());
                }
            } else {
                throw new RuntimeException("Não foi possível obter taxas de câmbio. Código de status: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace(); // Log da exceção
            throw new RuntimeException("Não consigo converter", e);
        }
    }
}
