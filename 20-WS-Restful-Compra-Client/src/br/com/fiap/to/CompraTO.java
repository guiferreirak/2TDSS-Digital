package br.com.fiap.to;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CompraTO {
	
	private Integer id;
		
	private String descricao;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Calendar data;
	
	private double valor;
	
	public CompraTO() {
		super();
	}
	
	public CompraTO(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public CompraTO(String descricao, Calendar data, double valor) {
		super();
		this.descricao = descricao;
		this.data = data;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
