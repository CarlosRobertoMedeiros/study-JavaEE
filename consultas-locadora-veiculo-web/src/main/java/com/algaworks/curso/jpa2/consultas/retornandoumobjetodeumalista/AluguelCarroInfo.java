package com.algaworks.curso.jpa2.consultas.retornandoumobjetodeumalista;

import java.math.BigDecimal;

import com.algaworks.curso.jpa2.modelo.Carro;

public class AluguelCarroInfo {

	private Carro carro;
	private Long totalAlugueis;
	private BigDecimal valorMaximo;
	private BigDecimal valorMedio;
	private BigDecimal valorMinimo;
	private BigDecimal soma;

	public AluguelCarroInfo(Carro carro, Long totalAlugueis, Number valorMaximo, Number valorMedio, Number valorMinimo,
			Number soma) {
		this.carro = carro;
		this.totalAlugueis = totalAlugueis;
		this.valorMaximo = BigDecimal.valueOf(valorMaximo.doubleValue());
		this.valorMedio = BigDecimal.valueOf(valorMedio.doubleValue());
		this.valorMinimo = BigDecimal.valueOf(valorMinimo.doubleValue());
		this.soma = BigDecimal.valueOf(soma.doubleValue());
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Long getTotalAlugueis() {
		return totalAlugueis;
	}

	public void setTotalAlugueis(Long totalAlugueis) {
		this.totalAlugueis = totalAlugueis;
	}

	public BigDecimal getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(BigDecimal valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public BigDecimal getValorMedio() {
		return valorMedio;
	}

	public void setValorMedio(BigDecimal valorMedio) {
		this.valorMedio = valorMedio;
	}

	public BigDecimal getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(BigDecimal valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public BigDecimal getSoma() {
		return soma;
	}

	public void setSoma(BigDecimal soma) {
		this.soma = soma;
	}

}
