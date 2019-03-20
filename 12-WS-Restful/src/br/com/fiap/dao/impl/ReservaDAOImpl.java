package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaoDAO;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva, Integer> implements ReservaoDAO{

	public ReservaDAOImpl(EntityManager em) {
		super(em);
	}

}
