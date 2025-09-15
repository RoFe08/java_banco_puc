package com.main;

import com.modelo.Financiamento;
import com.usecase.Casa;
import com.usecase.Apartamento;
import com.usecase.Terreno;
import com.util.InterfaceUsuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FinanceiroApplication {

	public static void main(String[] args) {

		ArrayList<Financiamento> financiamentos = new ArrayList<>();

		// Pede dados do usuário (para 1 Casa)
		InterfaceUsuario usuario = new InterfaceUsuario();
		double taxaJuros = usuario.pedirTaxaJuros();
		int prazoFinanciamento = usuario.pedirPrazoFinanciamento();
		double valorImovel = usuario.pedirValorImovel();

		// Pergunta atributos específicos da Casa
		double areaConstruida = usuario.pedirDouble("Informe a área construída (m²): ");
		double tamanhoTerreno = usuario.pedirDouble("Informe o tamanho do terreno (m²): ");

		financiamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJuros, areaConstruida, tamanhoTerreno));

		// Demais financiamentos fixos no código
		financiamentos.add(new Casa(250000, 20, 9.5, 120, 300));
		financiamentos.add(new Apartamento(300000, 25, 10.0, 2, 8));
		financiamentos.add(new Apartamento(180000, 15, 8.0, 1, 4));
		financiamentos.add(new Terreno(100000, 10, 12.0, "Residencial"));

		double somaImoveis = 0;
		double somaFinanciamentos = 0;

		System.out.println("\n📊 Lista de Financiamentos Criados:\n");

		for (Financiamento f : financiamentos) {
			System.out.println("Imóvel: R$ " + f.getValorImovel());
			System.out.println("Pagamento mensal: R$ " + f.calcularPagamentoMensal());
			System.out.println("Total financiado: R$ " + f.calcularTotalFinanciamento());

			// mostra atributos extras dependendo do tipo
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

			somaImoveis += f.getValorImovel();
			somaFinanciamentos += f.calcularTotalFinanciamento();
		}

		System.out.println("\n💰 Soma do valor dos imóveis: R$ " + somaImoveis);
		System.out.println("💳 Soma do valor total financiado: R$ " + somaFinanciamentos);
	}
}
