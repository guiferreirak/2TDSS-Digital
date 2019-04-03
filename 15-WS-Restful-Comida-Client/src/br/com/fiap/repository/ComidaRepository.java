package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.ComidaTO;

public class ComidaRepository {
	
	private Client client = Client.create();
	
	private static final String url = "http://localhost:8080/14-WS-Restful-Comida/rest/comida/";
	
	//Listar todo conteúdo da minha Entity
	public List<ComidaTO> listar() throws Exception{
		WebResource r = client.resource(url);
		ClientResponse response = r.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception();
		}
		
		ComidaTO[] v = response.getEntity(ComidaTO[].class);
		return Arrays.asList(v);
	}
	
	//Listar por codigo
	public ComidaTO buscar(int codigo) throws Exception{
		WebResource r = client.resource(url + codigo);
		ClientResponse response = r.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception();
		}
		
		return response.getEntity(ComidaTO.class);
	}
	
	//Cadastrar
	public void cadastrar(ComidaTO comida) throws Exception{
		WebResource r = client.resource(url);
		ClientResponse response = r.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, comida);
		
		if (response.getStatus() != 201) {
			throw new Exception();
		}
	}
	
	//Atualizar
	public void atualizar(ComidaTO comida) throws Exception {
		WebResource r = client.resource(url + comida.getCodigo());
		ClientResponse response = r.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, comida);
		
		if (response.getStatus() != 200) {
			throw new Exception();
		}
	}
	
	//Remover
	public void remover(int codigo) throws Exception {
		WebResource r = client.resource(url + codigo);
		ClientResponse response = r.delete(ClientResponse.class);
		
		if (response.getStatus() != 204) {
			throw new Exception();
		}
	}

}
