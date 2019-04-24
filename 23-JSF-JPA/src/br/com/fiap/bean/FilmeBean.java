package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.FilmeDAOImpl;
import br.com.fiap.entity.Filme;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@ManagedBean
@ViewScoped
public class FilmeBean implements Serializable{
	
	private Filme filme;
	
	private FilmeDAOImpl dao;
	
	private EntityManager em; 

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public FilmeDAOImpl getDao() {
		return dao;
	}

	public void setDao(FilmeDAOImpl dao) {
		this.dao = dao;
	}
	
	@PostConstruct
	public void init() {
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		setFilme(new Filme());
		filme.setDataLancamento(Calendar.getInstance());
		dao = new FilmeDAOImpl(em);
	}
	
	public void exibeMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void cadastrar() {
		System.out.println("aqui");
		try {
			dao.cadastrar(filme);
			dao.commit();
			exibeMensagem("Cadastrado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			exibeMensagem("Erro ao cadastrar");
		}
	}
	
	public List<Filme> listar(){
		return dao.listar();
	}
	
}
