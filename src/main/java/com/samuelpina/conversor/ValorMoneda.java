package com.samuelpina.conversor;

import java.util.Scanner;

public class ValorMoneda {
    public static double valorMoneda(int num){
        double valor_moneda = 0;
        Monedas monedas  = new Monedas();
        monedas =  monedas.setCurrencies();
        Scanner scanner = new Scanner(System.in);
        if (num ==1){
            System.out.println("Escribe un numero de moneda, para la moneda origen: " );
        }
        if (num ==2){
            System.out.println("Escribe un numero de moneda, para la moneda destino: " );
        }
        System.out.println(
                "1. USD\n" +
                "2. EUR\n" +
                "3. ARS\n" +
                "4. BOB\n" +
                "5. COP");
        int opcion =  scanner.nextInt();
        valor_moneda = switch (opcion) {
            case 1 -> monedas.getUSD();
            case 2 -> monedas.getEUR();
            case 3 -> monedas.getARS();
            case 4 -> monedas.getBOB();
            case 5 -> monedas.getCOP();
            default -> {
                System.out.println("Opcion no valida");
                yield valor_moneda;
            }
        };
        return valor_moneda;
    }
}
