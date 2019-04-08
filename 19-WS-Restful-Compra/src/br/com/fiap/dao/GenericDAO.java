package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;

public interface GenericDAO<T, K> {
	
	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	T consultar(K codigo) throws ChaveInexistenteException;
	
	void remover(K codigo) throws ChaveInexistenteException;
	
	void commit() throws CommitException;
	
	List<T> listar();
}
