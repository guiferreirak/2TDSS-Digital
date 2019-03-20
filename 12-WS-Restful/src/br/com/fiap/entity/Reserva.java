package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_RESERVA")
@SequenceGenerator(name="reserva", sequenceName="SQ_T_RESERVA", allocationSize=1)
public class Reserva {
	
	@Id
	@Column(name="cd_reserva")
	@GeneratedValue(generator="reserva", strategy=GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nm_cliente", length=100, nullable=false)
	private String cliente;
	
	@Column(name="vl_preco", nullable=false)
	private float preco;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
}
