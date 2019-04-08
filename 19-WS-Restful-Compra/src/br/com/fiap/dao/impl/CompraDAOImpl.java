package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CompraDAO;
import br.com.fiap.entity.Compra;

public class CompraDAOImpl extends GenericDAOImpl<Compra, Integer> implements CompraDAO{

	public CompraDAOImpl(EntityManager em) {
		super(em);
	}

}
