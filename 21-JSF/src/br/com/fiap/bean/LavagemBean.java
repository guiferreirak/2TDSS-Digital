package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.LavagemBO;
import br.com.fiap.to.LavagemTO;

@ManagedBean
public class LavagemBean {
	
	private LavagemTO lavagem;
	private LavagemBO bo;

	public LavagemTO getLavagem() {
		return lavagem;
	}

	public void setLavagem(LavagemTO lavagem) {
		this.lavagem = lavagem;
	}
	
	@PostConstruct
	public void init() {
		bo = new LavagemBO();
		lavagem = new LavagemTO();
	}
	
	public void cadastrar() {
		bo.cadastrar(lavagem);
	}
	
	public List<LavagemTO> listar() {
		return bo.listar();
	}
	
}
