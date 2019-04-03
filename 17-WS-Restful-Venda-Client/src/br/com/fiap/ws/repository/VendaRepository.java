package br.com.fiap.ws.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.to.Venda;

public class VendaRepository {
	
	private Client client = Client.create();
	
	private static final String url = "http://localhost:8080/16-WS-Restful-Venda/rest/venda/";
	
	public List<Venda> listar() throws Exception{
		WebResource r = client.resource(url);
		ClientResponse response = r.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception();
		}
		
		Venda[] v = response.getEntity(Venda[].class);
		return Arrays.asList(v);
	}
	
	public Venda consultar(int id) throws Exception{
		WebResource r = client.resource(url + id);
		ClientResponse response = r.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception();
		}
		
		return response.getEntity(Venda.class);
	}
	
	public void cadastrar(Venda venda) throws Exception{
		WebResource r = client.resource(url);
		ClientResponse response = r.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, venda);
		
		if (response.getStatus() != 201) {
			throw new Exception();
		}
	}
	
	public void atualizar(Venda venda) throws Exception{
		WebResource r = client.resource(url + venda.getId());
		ClientResponse response = r.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, venda);
		
		if (response.getStatus() != 200) {
			throw new Exception();
		}
	}
	
	public void remover(int id) throws Exception{
		WebResource r = client.resource(url + id);
		ClientResponse response = r.delete(ClientResponse.class);
		
		if (response.getStatus() != 204) {
			throw new Exception();
		}
	}
	
}
