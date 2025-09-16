package com.main;

import com.modelo.Financiamento;
import com.usecase.Casa;
import com.usecase.Apartamento;
import com.usecase.Terreno;
import com.util.InterfaceUsuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class FinanceiroApplication {

	public static void main(String[] args) {

		ArrayList<Financiamento> financiamentos = new ArrayList<>();
		var formatarValor = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

		InterfaceUsuario usuario = new InterfaceUsuario();
		var taxaJuros = usuario.pedirTaxaJuros();
		var prazoFinanciamento = usuario.pedirPrazoFinanciamento();
		var valorImovel = usuario.pedirValorImovel();

		var areaConstruida = usuario.pedirDouble("Informe a área construída (m²): ");
		var tamanhoTerreno = usuario.pedirDouble("Informe o tamanho do terreno (m²): ");

		financiamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJuros, areaConstruida, tamanhoTerreno));

		//mock para o loop
		financiamentos.add(new Casa(250000, 20, 9.5, 120, 300));
		financiamentos.add(new Apartamento(300000, 25, 10.0, 2, 8));
		financiamentos.add(new Apartamento(180000, 15, 8.0, 1, 4));
		financiamentos.add(new Terreno(100000, 10, 12.0, "Residencial"));

		var somaImoveis = financiamentos.stream()
				.mapToDouble(Financiamento::getValorImovel)
				.sum();

		var somaFinanciamentos = financiamentos.stream()
				.mapToDouble(Financiamento::calcularTotalFinanciamento)
				.sum();

		System.out.println("\n📊 Lista de Financiamentos Criados:\n");

		financiamentos.forEach(f -> {
			System.out.println("Imóvel: R$ " + formatarValor.format(f.getValorImovel()));
			System.out.println("Pagamento mensal: R$ " + formatarValor.format(f.calcularPagamentoMensal()));
			System.out.println("Total financiado: R$ " + formatarValor.format(f.calcularTotalFinanciamento()));

			if (f instanceof Casa casa) {
				System.out.println("Área construída: " + casa.getAreaConstruida() + " m²");
				System.out.println("Tamanho do terreno: " + casa.getTamanhoTerreno() + " m²");
			} else if (f instanceof Apartamento apto) {
				System.out.println("Vagas de garagem: " + apto.getVagasGaragem());
				System.out.println("Número do andar: " + apto.getNumeroAndar());
			} else if (f instanceof Terreno terreno) {
				System.out.println("Tipo de zona: " + terreno.getTipoZona());
			}

			System.out.println("-----------------------------");
		});

		System.out.println("\n💰 Soma do valor dos imóveis: R$ " + formatarValor.format(somaImoveis));
		System.out.println("💳 Soma do valor total financiado: R$ " + formatarValor.format(somaFinanciamentos));
	}
}
