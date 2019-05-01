package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.dao.FilmeDAO;
import br.com.fiap.dao.impl.FilmeDAOImpl;
import br.com.fiap.entity.Filme;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@ManagedBean
@RequestScoped
public class FilmeBean implements Serializable {

	private Filme filme;
	
	private FilmeDAO dao;
	
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	@PostConstruct
	public void init() {
		filme = new Filme();
		filme.setDataLancamento(Calendar.getInstance());
		dao = new FilmeDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	public List<Filme> listar(){
		return dao.listar();
	}

	public String salvar() {
		try {
			if (filme.getCodigo() == 0) {
				dao.cadastrar(filme);
				dao.commit();
				adicionarMensagem("Cadastrado!");
			} else {
				dao.atualizar(filme);
				dao.commit();
				adicionarMensagem("Atualizado!");
			}
			return "lista-filme?faces-redirect=true"; //navega para a pág lista-filme.xhtml
		} catch (Exception e) {
			e.printStackTrace();
			adicionarMensagem("Erro..");
			return "cadastro-filme";
		}
	}
	
	public String deletar(int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
			adicionarMensagem("Excluido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			adicionarMensagem("Erro ao excluir");
		}
		return "lista-filme?faces-redirect=true";
	}
	
	private void adicionarMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}
	
}
