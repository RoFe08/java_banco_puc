package com.util;

import java.util.Scanner;

public class InterfaceUsuario {

    private Scanner scanner = new Scanner(System.in);

    public double pedirTaxaJuros() {
        double taxa;
        do {
            System.out.print("Digite a taxa de juros anual (%): ");
            taxa = scanner.nextDouble();

            if (taxa <= 0 || taxa > 100) {
                System.out.println("❌ A taxa de juros deve estar entre 0% e 100%.");
            }

        } while (taxa <= 0 || taxa > 100);

        return taxa;
    }

    public int pedirPrazoFinanciamento() {
        int prazo;
        do {
            System.out.print("Digite o prazo do financiamento (em anos): ");
            prazo = scanner.nextInt();

            if (prazo <= 0) {
                System.out.println("❌ O prazo do financiamento deve ser um valor positivo.");
            }

        } while (prazo <= 0);

        return prazo;
    }

    public double pedirValorImovel() {
        double valor;
        do {
            System.out.print("Digite o valor do imóvel: ");
            valor = scanner.nextDouble();

            if (valor <= 0) {
                System.out.println("❌ O valor do imóvel deve ser um valor positivo.");
            }

        } while (valor <= 0);

        return valor;
    }

    public double pedirDouble(String mensagem) {
        double valor;
        do {
            System.out.print(mensagem);
            valor = scanner.nextDouble();

            if (valor <= 0) {
                System.out.println("❌ O valor deve ser positivo.");
            }

        } while (valor <= 0);

        return valor;
    }

    public int pedirInt(String mensagem) {
        int valor;
        do {
            System.out.print(mensagem);
            valor = scanner.nextInt();

            if (valor <= 0) {
                System.out.println("❌ O valor deve ser positivo.");
            }

        } while (valor <= 0);

        return valor;
    }

    public String pedirString(String mensagem) {
        String valor;
        do {
            System.out.print(mensagem);
            valor = scanner.next();

            if (valor.isEmpty()) {
                System.out.println("❌ O valor não pode estar vazio.");
            }

        } while (valor.isEmpty());

        return valor;
    }
}
