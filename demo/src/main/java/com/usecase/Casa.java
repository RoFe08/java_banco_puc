package com.usecase;

import com.modelo.Financiamento;
import lombok.Getter;

@Getter
public class Casa extends Financiamento {

    private final double areaConstruida;
    private final double tamanhoTerreno;

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
        return parcelaBase + 80.0;
    }

}
