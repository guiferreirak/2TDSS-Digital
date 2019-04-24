package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;

public interface GenericDAO<T,K> {

	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	void remover(K chave) throws ChaveInexistenteException;
	
	T consultar(K chave) throws ChaveInexistenteException;
	
	List<T> listar();
	
	void commit() throws CommitException;
	
}