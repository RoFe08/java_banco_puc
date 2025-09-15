package com.usecase;

import com.modelo.Financiamento;

public class Casa extends Financiamento {

    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual,
                double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = (getTaxaJurosAnual() / 100) / 12;
        double parcelaBase = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + taxaMensal);
        return parcelaBase + 80.0; // acréscimo fixo de R$80
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }
}
