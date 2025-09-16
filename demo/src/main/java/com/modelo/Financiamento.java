package com.modelo;

import lombok.Getter;

@Getter
public abstract class Financiamento {

    private final double valorImovel;
    private final int prazoFinanciamento;
    private final double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();

    public double calcularTotalFinanciamento() {
        return calcularPagamentoMensal() * (prazoFinanciamento * 12);
    }

}
