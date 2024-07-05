package com.samuelpina.conversor;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Monedas {
    @JsonProperty("USD")
     double USD;
    @JsonProperty("EUR")
      double EUR;
    @JsonProperty("ARS")
      double ARS;
    @JsonProperty("BOB")
      double BOB;
    @JsonProperty("COP")
      double COP;
   Map<String, Double> mapMonedas;
public Monedas(){

}
//    public static Monedas setCurrencies(Conversion_rates conversion_rates){
//
//        ObjectMapper mapper = new ObjectMapper();
//
////        monedas = mapper.convertValue(conversion_rates.conversion_rates(), Monedas.class);
//        System.out.println(conversion_rates.conversion_rates());
//        return ;
//    }


    public  double getEUR() {
        return EUR;
    }

    public  double getARS() {
        return ARS;
    }

    public  double getBOB() {
        return BOB;
    }
    public  double getUSD(){
        return USD;
    }

    public  double getCOP() {
        return COP;
    }
    public  Monedas setCurrencies() {

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/ee6577d08dae4332667fe194/latest/USD")).build();

        try {
            Monedas monedas  = new Monedas();
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            Conversion_rates conversiones = gson.fromJson(response.body().toString(), Conversion_rates.class);

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            monedas = mapper.convertValue(conversiones.conversion_rates(), Monedas.class);

            client.close();
            return monedas;
        } catch (IOException e) {
            client.close();
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            client.close();
            throw new RuntimeException(e);
        }

    }
    public static double getCurrency(String currency1, String currency2) {
        return currency1.compareTo(currency2);
    }



//    public  Monedas setCurrencies(Conversion_rates conversion_rates) {
//
//        Monedas monedas = new Monedas();
//        ObjectMapper mapper = new ObjectMapper();
//        monedas = mapper.convertValue(conversion_rates.conversion_rates(), Monedas.class);
//       return monedas ;
//    }



}


