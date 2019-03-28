package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ComidaDAO;
import br.com.fiap.entity.Comida;

public class ComidaDAOImpl extends GenericDAOImpl<Comida, Integer> implements ComidaDAO{

	public ComidaDAOImpl(EntityManager em) {
		super(em);
	}

}
