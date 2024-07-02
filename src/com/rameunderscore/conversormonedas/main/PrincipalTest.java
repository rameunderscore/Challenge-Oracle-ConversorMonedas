package com.rameunderscore.conversormonedas.main;

import com.rameunderscore.conversormonedas.models.CheckConversion;
import com.rameunderscore.conversormonedas.models.CurrencyAPI;

import java.util.Scanner;

public class PrincipalTest {
    public static void main(String[] args) {
        Scanner userScanner = new Scanner(System.in);
        CheckConversion conversion = new CheckConversion();
        boolean appOn = true;

        while (appOn == true){
            System.out.println("""
                *****************************-MONEDAS-*******************************
                                        
                    <MXN>   <IDR>   <CAD>   <HNL>
                    <USD>   <VES>   <COP>   <JPY>              <SALIR>
                    <BRL>   <ARS>   <CRC>   <VES>
                    <EUR>   <BOB>   <GTQ>   <OTRO: Escriba el codigo de moneda>
                ********************************************************************
                    
                Escriba la moneda inicial (3 letras):\040
                """);
            String initialCurrency = userScanner.nextLine().toUpperCase();
            if (initialCurrency.equals("SALIR")){
                appOn = false;
                System.out.println("Gracias por usar la app");
                break;
            }
            System.out.println("""
                ******************************-MONEDAS-******************************
                                        
                    <MXN>   <IDR>   <CAD>   <HNL>
                    <USD>   <VES>   <COP>   <JPY>              <SALIR>
                    <BRL>   <ARS>   <CRC>   <VES>
                    <EUR>   <BOB>   <GTQ>   <OTRO: Escriba el codigo de moneda>
                ********************************************************************
                    
                Escriba la moneda a convertir (3 letras):\040
                """);
            String targetCurrency = userScanner.nextLine().toUpperCase();
            if (targetCurrency.equals("SALIR")){
                appOn = false;
                System.out.println("Gracias por usar la app");
                break;
            }

            System.out.println("Digite el valor a convertir: ");
            double value = userScanner.nextDouble();

            try {
                CurrencyAPI miConversion = conversion.doConversion(initialCurrency, targetCurrency, value);
                System.out.println("Conversion: " + miConversion.toString());
                System.out.println("Desea realizar otra conversion?");
            } catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.println("Gracias por usar la app");
            }

        }


    }
}
