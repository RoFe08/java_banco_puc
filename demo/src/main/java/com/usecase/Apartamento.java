package com.usecase;

import com.modelo.Financiamento;
import lombok.Getter;

@Getter
public class Apartamento extends Financiamento {

    private final int vagasGaragem;
    private final int numeroAndar;

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

}
