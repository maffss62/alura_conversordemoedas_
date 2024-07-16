package br.com.edielson.conversordemoedas;

import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        int opcao = 0;
        Menuconversor menuconversor = new Menuconversor();

        String menu = """
                ******************* Bem Vindo ao conversor de moedas *******************
                Selecione uma opção:
                1 - [USD] para [BRL]
                2 - [BRL] para [USD]
                3 - [EUR] para [BRL]
                4 - [BRL] para [EUR]
                5 - [USD] para [EUR]
                6 - [BRL] para [GBP]
                7 - SAIR
                """;

        while (opcao != 7) {
            try {
                System.out.println(menu);
                opcao = scanner.nextInt();
                double valor;

                if(opcao >= 1 && opcao <= 6) {
                    System.out.println("Digite o valor:");
                    valor = scanner.nextDouble();
                    Conversor conversao = null;

                    switch (opcao) {
                        case 1 -> conversao = menuconversor.conversor("USD", "BRL", valor);
                        case 2 -> conversao = menuconversor.conversor("BRL", "USD", valor);
                        case 3 -> conversao = menuconversor.conversor("EUR", "BRL", valor);
                        case 4 -> conversao = menuconversor.conversor("BRL", "EUR", valor);
                        case 5 -> conversao = menuconversor.conversor("USD", "EUR", valor);
                        case 6 -> conversao = menuconversor.conversor("BRL", "GBP", valor);
                    }

                    if (conversao != null) {
                        System.out.printf("O valor de %.2f %s convertido para %s é: %.2f %s%n%n",
                                valor, conversao.getBase_code(), conversao.getTarget_code(),
                                conversao.getConversion_result(), conversao.getTarget_code());
                    }
                } else if (opcao == 7) {
                    System.out.printf("Finalizando a Aplicação%n%n");
                } else {
                    System.out.printf("Opção inválida%n%n");
                }

            } catch (Exception e) {
                System.out.printf("Não foi possível converter, verifique se você digitou o valor corretamente%n%n");
                System.out.printf("Finalizando a Aplicação%n%n");
                break;
            }
        }
    }
}