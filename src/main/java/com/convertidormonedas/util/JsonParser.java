package com.convertidormonedas.util;

import com.convertidormonedas.modelo.TipoCambio;
import com.google.gson.Gson;

public class JsonParser {
    public static TipoCambio parseRates(String jsonResponse) {
        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, TipoCambio.class);
    }
}
