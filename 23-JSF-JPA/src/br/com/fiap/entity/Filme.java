package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="filme",sequenceName="SQ_FILME",allocationSize=1)
public class Filme {

	@Id
	@GeneratedValue(generator="filme",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	private String titulo;
	
	private Calendar dataLancamento;
	
	private boolean dublado;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public boolean isDublado() {
		return dublado;
	}

	public void setDublado(boolean dublado) {
		this.dublado = dublado;
	}
	
}