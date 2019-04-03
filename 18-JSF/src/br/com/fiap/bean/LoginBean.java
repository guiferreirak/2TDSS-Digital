package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {
	
	private String login;
	
	private String senha;
	
	public void entrar() {
		if (getLogin().equals("FIAP") && getSenha().equals("FIAP2019")) {
			System.out.println("Usuário cadastrado");
		}
		else {
			System.out.println("Usuário ou senha incorretos");
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
