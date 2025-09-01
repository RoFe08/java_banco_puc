package com.demo.demo.service;

import org.springframework.stereotype.Component;

@Component
public class Financiamento {

    double valorImovel;
    int prazoFinanciamento;
    double taxaJurosAnual;

    Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    double calcularPagamentoMensal() {
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
    }

    double calcularTotalPagamentos() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }
}
