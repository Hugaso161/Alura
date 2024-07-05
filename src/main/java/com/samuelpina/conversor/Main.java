package com.samuelpina.conversor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

import static com.samuelpina.conversor.ValorMoneda.valorMoneda;


public class Main {
    public static void main(String[] args) {

            Monedas monedas  = new Monedas();
           monedas =  monedas.setCurrencies();
//        System.out.println(monedas.getBOB());
        double moneda1 = 0;
        double monto = 0;
        double moneda2 = 0;
     while (moneda1==0 || moneda2==0) {
        if (monto==0) {
            System.out.println("Monto que desea cambiar:");
            Scanner scanner = new Scanner(System.in);
            monto = scanner.nextDouble();
        }
         else if(moneda1==0){

             moneda1 =valorMoneda(1);
         } else {
             moneda2 = valorMoneda(2);
         }
     }
        System.out.println("El monto total es: "+  new conversion_monedas().convertor(moneda1, moneda2, monto));
//

    }

}

