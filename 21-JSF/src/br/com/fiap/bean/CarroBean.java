package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.CarroBO;
import br.com.fiap.to.CarroTO;

@ManagedBean
public class CarroBean {
	
	private CarroTO carro;
	
	private CarroBO bo;

	public CarroTO getCarro() {
		return carro;
	}

	public void setCarro(CarroTO carro) {
		this.carro = carro;
	}
	
	@PostConstruct //método para inicializar os objetos
	public void init() {
		bo = new CarroBO();
		carro = new CarroTO();
	}
	
	public void cadastrar() {
		bo.cadastrar(carro);
		FacesMessage msg = new FacesMessage("Cadastrado!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<CarroTO> listarCarros(){
		return bo.listar();
	}
	
}
