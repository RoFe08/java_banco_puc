package com.usecase;

import com.modelo.Financiamento;
import lombok.Getter;

@Getter
public class Terreno extends Financiamento {

    private final String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual,
                   String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = (getTaxaJurosAnual() / 100) / 12;
        double parcelaBase = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + taxaMensal);
        return parcelaBase * 1.02;
    }

}
