package com.rameunderscore.conversormonedas.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rameunderscore.conversormonedas.Currency;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//Clase para conectar con la API con el paquete HTTP
public class CheckConversion{
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
//Creo el método para realizar la solicitud al API
//El usuaria elige la moneda origen y destino asi como el valor a convertir.
    public CurrencyAPI doConversion(String initialCurrency,String targetCurrency, double value){
        //APIKey modificable obtenida en https://www.exchangerate-api.com/
        final String apiKey = "INGRESA TU API KEY";

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"
                +initialCurrency+"/"+targetCurrency+"/"+value);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            double result = new Gson().fromJson(response.body(), Currency.class).getValorConvertido();
            return new Gson().fromJson(response.body(), CurrencyAPI.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No pude realizar la conversion.");
        }



    }
}
