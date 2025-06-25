package com.danieldupree.conversor;

public class ConversorMoedas {
    public static void converter(String de, String para, double valor) {
        double cotacao = RequisicaoAPI.buscarCotacao(de, para);
        if (cotacao == -1) {
            System.out.println("Não foi possível obter a cotação.");
            return;
        }

        double convertido = valor * cotacao;
        System.out.printf("%.2f %s = %.2f %s%n", valor, de, convertido, para);

    }
}
