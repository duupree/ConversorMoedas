package com.danieldupree.conversor;

import java.util.Scanner;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Conversor de Moedas ====");
            System.out.println("1 - Dólar para Real");
            System.out.println("2 - Real para Dólar");
            System.out.println("3 - Euro para Real");
            System.out.println("4 - Real para Euro");
            System.out.println("5 - Dólar para Euro");
            System.out.println("6 - Euro para Dólar");
            System.out.println("7 - Sair");
            System.out.println("Escolha uma opção: ");
            int opcao = entrada.nextInt();

            if (opcao == 7) {
                System.out.println("Saindo do programa. Até logo!");
                break;
            }

            System.out.println("Digite o valor que deseja converter: ");
            double valor = entrada.nextDouble();

            switch (opcao) {
                case 1 -> ConversorMoedas.converter("USD", "BRL", valor);
                case 2 -> ConversorMoedas.converter("BRL", "USD", valor);
                case 3 -> ConversorMoedas.converter("EUR", "BRL", valor);
                case 4 -> ConversorMoedas.converter("BRL", "EUR", valor);
                case 5 -> ConversorMoedas.converter("USD", "EUR", valor);
                case 6 -> ConversorMoedas.converter("EUR", "USD", valor);
                default -> System.out.println("Opção inválida!");
            }

        }

        entrada.close();

    }
}