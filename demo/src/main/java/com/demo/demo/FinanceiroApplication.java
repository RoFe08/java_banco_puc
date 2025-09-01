package com.demo.demo;

import com.demo.demo.service.Financiamento;
import com.demo.demo.service.InterfaceUsuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinanceiroApplication {

	public static void main(String[] args) {

		SpringApplication.run(FinanceiroApplication.class, args);
		InterfaceUsuario usuario = new InterfaceUsuario();
		double taxaJuros = usuario.pedirTaxaJuros();
		int prazoFinanciamento = usuario.pedirPrazoFinanciamento();
		double valorImovel = usuario.pedirValorImovel();
		Financiamento financiamento = new Financiamento(taxaJuros, prazoFinanciamento, valorImovel);

	}

}
