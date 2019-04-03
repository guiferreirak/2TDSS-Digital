package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexBean {
	
	private String nome;
	
	public void ok() {
		System.out.println(getNome());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
