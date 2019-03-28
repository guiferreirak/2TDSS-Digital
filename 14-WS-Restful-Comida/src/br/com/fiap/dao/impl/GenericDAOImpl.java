package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K>{
	
	private EntityManager em;
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void cadastrar(T entidade) {
		em.persist(entidade);
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	@Override
	public T consultar(K codigo) throws ChaveInexistenteException {
		T entidade = em.find(clazz, codigo);
		if (entidade == null) {
			throw new ChaveInexistenteException("Nenhum dado retornado");
		}
		return entidade;
	}

	@Override
	public void remover(K codigo) throws ChaveInexistenteException {
		em.remove(consultar(codigo));
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException("Falha no commit");
		}
	}
	
	@Override
	public List<T> listar() {
		return em.createQuery("from " + clazz.getName(),clazz).getResultList();
	}

}
