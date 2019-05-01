package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.SerieDAO;
import br.com.fiap.dao.impl.SerieDAOImpl;
import br.com.fiap.entity.Serie;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@ManagedBean
@RequestScoped
public class SerieBean implements Serializable{
	
	private Serie serie;
	
	private SerieDAO dao;

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public SerieDAO getDao() {
		return dao;
	}

	public void setDao(SerieDAO dao) {
		this.dao = dao;
	}
	
	@PostConstruct
	public void init() {
		serie = new Serie();
		serie.setDataLancamento(Calendar.getInstance());
		dao = new SerieDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
}
