package br.com.fiap.dao.impl;

import br.com.fiap.entity.Serie;

import javax.persistence.EntityManager;

import br.com.fiap.dao.SerieDAO;

public class SerieDAOImpl extends GenericDAOImpl<Serie, Integer> implements SerieDAO{

	public SerieDAOImpl(EntityManager em) {
		super(em);
	}

}
