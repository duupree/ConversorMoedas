package com.danieldupree.conversor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;


public class RequisicaoAPI {

    private static final String API_KEY = "74b7f6b35e239bce64203ac8";

    public static double buscarCotacao(String moedaBase, String moedaDestino) {
        String urlStr = "https://v6.exchangerate-api.com/v6/" + "74b7f6b35e239bce64203ac8" + "/pair/" + moedaBase + "/" + moedaDestino;


        try {
            URL url = new URL(urlStr);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.setRequestMethod("GET");

            if (request.getResponseCode() != 200) {
                System.err.println("Erro na API: HTTP " + request.getResponseCode());
                return -1;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String linha;

            while ((linha = in.readLine()) != null) {
                resposta.append(linha);
            }

            in.close();

            System.out.println("[DEBUG] Resposta da API: " + resposta.toString());

            Gson gson = new Gson();
            ExchangeResponse dados = gson.fromJson(resposta.toString(), ExchangeResponse.class);
            return dados.getConversionRate();


        } catch (Exception e) {
            System.out.println("Erro ao conectar com a API: " + e.getMessage());
            return -1;
        }
    }
}
