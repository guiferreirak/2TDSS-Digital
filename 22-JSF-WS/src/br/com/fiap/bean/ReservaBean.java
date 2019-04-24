package br.com.fiap.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.repository.ReservaRepository;
import br.com.fiap.to.ReservaTO;

@ManagedBean
@ViewScoped
public class ReservaBean implements Serializable{
	
	private ReservaTO reserva;
	
	private ReservaRepository rep;
	
	@PostConstruct
	public void init() {
		setReserva(new ReservaTO());
		rep = new ReservaRepository();
	}

	public ReservaTO getReserva() {
		return reserva;
	}

	public void setReserva(ReservaTO reserva) {
		this.reserva = reserva;
	}
	
	public void exibeMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void cadastrar() {
		try {
			if (reserva.getCodigo() == null) {
				rep.cadastrar(getReserva());
				exibeMensagem("Cadastrado");
			}
			else {
				rep.atualizar(reserva);
				exibeMensagem("Atualizado");
			}
		} catch (Exception e) {
			e.printStackTrace();
			exibeMensagem("Erro");
		}
	}
	
	public List<ReservaTO> listar() {
		try {
			return rep.listar();
		} catch (Exception e) {
			e.printStackTrace();
			exibeMensagem("Erro ao listar");
			return null;
		}
	}
		
	/*public void deletar() {
		try {
			rep.remover(codigo);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/
	
}
