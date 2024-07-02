package com.rameunderscore.conversormonedas;

import com.rameunderscore.conversormonedas.models.CurrencyAPI;

public class Currency{
    public String monedaOrigen;
    public String monedaDestino;
    public double valorConvertido = 0.0;
    public double valorInicial;

    //Constructores
    public Currency(String monedaOrigen, String monedaDestino, double valorConvertido) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.valorConvertido = valorConvertido;
    }

    public Currency(CurrencyAPI currencyAPI){
        this.monedaOrigen = currencyAPI.base_code();
        this.monedaDestino = currencyAPI.target_code();
        this.valorConvertido = Double.valueOf(currencyAPI.conversion_result());
    }
//Getters
    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

//Setters
    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public void setValorConvertido(double valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

    @Override
    public String toString() {
        return " ";
//        return "$ " + monedaOrigen + " = $"+ valorConvertido + " " + monedaDestino;
    }

//    @Override
//    public int compareTo(Currency otraCurrency) {
//        return this.getMonedaOrigen().compareTo(otraCurrency.getMonedaOrigen());
//    }
}
