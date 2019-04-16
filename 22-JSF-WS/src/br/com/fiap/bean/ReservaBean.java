package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.repository.ReservaRepository;
import br.com.fiap.to.ReservaTO;

@ManagedBean
public class ReservaBean {
	
	private ReservaTO reserva;
	
	private ReservaRepository rep;
	
	@PostConstruct
	public void init() {
		setReserva(new ReservaTO());
		rep = new ReservaRepository();
	}
	
	public void cadastrar() {
		FacesMessage msg;
		try {
			rep.cadastrar(getReserva());
			msg = new FacesMessage("Cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro!");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<ReservaTO> listar() {
		try {
			return rep.listar();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro ao listar"));
			return null;
		}
	}

	public ReservaTO getReserva() {
		return reserva;
	}

	public void setReserva(ReservaTO reserva) {
		this.reserva = reserva;
	}
	
}
