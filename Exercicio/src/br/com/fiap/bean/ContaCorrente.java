package br.com.fiap.bean;

import java.util.Calendar;

public class ContaCorrente extends Conta{

	private TipoConta tipoConta;

	public ContaCorrente() {
		super();
	}


	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipoConta) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipoConta = tipoConta;
	}


	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	@Override
	public double retirar(double valor) throws Exception {
		double saldoTemp = saldo;
		saldoTemp -= valor;
		if (tipoConta == TipoConta.COMUM && saldoTemp < 0) {
			throw new Exception("Impossível realizar a operação. Sua conta é Comum e negativou o saldo");
		}
		saldo -= valor;
		return saldo;
	}
		
}
