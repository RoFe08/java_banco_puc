package com.usecase;

import com.modelo.Financiamento;

public class Apartamento extends Financiamento {

    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual,
                       int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = (getTaxaJurosAnual() / 100) / 12;
        int meses = getPrazoFinanciamento() * 12;

        return (getValorImovel() * taxaMensal * Math.pow(1 + taxaMensal, meses)) /
                (Math.pow(1 + taxaMensal, meses) - 1);
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }
}
