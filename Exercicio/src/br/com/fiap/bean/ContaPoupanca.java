package br.com.fiap.bean;

import java.util.Calendar;

public class ContaPoupanca extends Conta implements ContaInvestimento{
	
	private float taxa;

	public static final float RENDIMENTO = 0.6f; //Declarando uma constante
	
	public ContaPoupanca() {
		super();
	}
	
	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	@Override
	public double calculaRetornoInvestimento() {
		return saldo * RENDIMENTO;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
	
	@Override
	public double retirar(double valor) {
		double saldoTemp = saldo;
		saldoTemp -= (valor + taxa);
		if (saldoTemp >= 0) {
			saldo -= (valor + taxa);
			System.out.println("Valor retirado com sucesso");
		}
		return saldo;
	}
	
}
