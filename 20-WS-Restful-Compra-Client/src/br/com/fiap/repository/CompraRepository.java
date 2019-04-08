package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.CompraTO;

public class CompraRepository {
	
	Client client = Client.create();
	
	private static final String url = "http://localhost:8080/19-WS-Restful-Compra/rest/compra/";
	
	public List<CompraTO> listar() throws Exception{
		WebResource r = client.resource(url);
		ClientResponse response = r.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception("Falha ao retornar dados");
		}
		
		CompraTO[] v = response.getEntity(CompraTO[].class);
		
		return Arrays.asList(v);
	}
	
	public CompraTO buscar(int id) throws Exception {
		WebResource r = client.resource(url + id);
		ClientResponse response = r.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception("Falha ao retornar dados");
		}
		
		return response.getEntity(CompraTO.class);
	}
	
	public void cadastrar(CompraTO c) throws Exception {
		WebResource r = client.resource(url);
		ClientResponse response = r.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, c);
		
		if (response.getStatus() != 201) {
			throw new Exception("Falha ao cadastar");
		}	
	}
	
	public void atualizar(CompraTO c) throws Exception {
		WebResource r = client.resource(url + c.getId());
		ClientResponse response = r.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, c);
		
		if (response.getStatus() != 200) {
			throw new Exception("Falha ao atualizar");
		}	
	}
	
	public void remover(int id) throws Exception {
		WebResource r = client.resource(url + id);
		ClientResponse response = r.delete(ClientResponse.class);
		
		if (response.getStatus() != 204) {
			throw new Exception("Falha ao remover");
		}	
	}
	
}
