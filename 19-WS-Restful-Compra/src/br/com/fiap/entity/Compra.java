package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@SequenceGenerator(name="compra", sequenceName="SQ_T_COMPRA", allocationSize=1)
public class Compra {
	
	@Id
	@GeneratedValue(generator="compra", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_compra")
	private Integer id;
	
	@Column(name="ds_compra", length=100)
	private String descricao;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name="dt_compra")
	private Calendar data;
	
	@Column(name="vl_compra")
	private double valor;

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
