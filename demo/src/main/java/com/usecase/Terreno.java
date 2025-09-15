package com.usecase;

import com.modelo.Financiamento;

public class Terreno extends Financiamento {

    private String tipoZona; // residencial ou comercial

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual,
                   String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = (getTaxaJurosAnual() / 100) / 12;
        double parcelaBase = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + taxaMensal);
        return parcelaBase * 1.02; // acréscimo de 2%
    }

    public String getTipoZona() {
        return tipoZona;
    }
}
