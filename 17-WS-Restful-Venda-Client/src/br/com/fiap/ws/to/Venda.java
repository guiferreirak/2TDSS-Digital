package br.com.fiap.ws.to;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Venda {
	
	private int id;
	
	private String descricao;
	
	private float valor;
	
	@JsonFormat(pattern="dd/MM/yyyy") 
	private Calendar data;
	
	public Venda(String descricao, float valor, Calendar data) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}

	public Venda(int id, String descricao, float valor, Calendar data) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}

	public Venda() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
}
