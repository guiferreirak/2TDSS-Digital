package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;

public interface GenericDAO<T, K> {
	
	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	void consultar(K codigo);
	
	void remover(K codigo);
	
	void commit() throws CommitException;
	
}
