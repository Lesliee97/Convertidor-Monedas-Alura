package com.convertidormonedas;

import com.convertidormonedas.api.Convertidor;
import com.convertidormonedas.modelo.TipoCambio;
import com.convertidormonedas.operaciones.Operaciones;
import com.convertidormonedas.util.JsonParser;

public class Main {
    public static void main(String[] args) {
        String jsonResponse = Convertidor.fetchRates();

        if (jsonResponse != null) {
            TipoCambio rates = JsonParser.parseRates(jsonResponse);
            Operaciones.convertCurrency(rates);
        } else {
            System.out.println("No se pudieron obtener las tasas de cambio.");
        }
    }
}
