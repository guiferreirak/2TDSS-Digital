package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="filme", sequenceName="SQ_T_FILME", allocationSize=1)
public class Filme {
	
	@Id
	@GeneratedValue(generator="filme", strategy=GenerationType.SEQUENCE)
	private int id;

	private String titulo;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataLancamento;
	
	private boolean dublado;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
