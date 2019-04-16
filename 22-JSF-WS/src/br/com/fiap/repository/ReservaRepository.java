package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.ReservaTO;

public class ReservaRepository {
	
	//1. Precisamos do Client
	private Client client = Client.create();
	
	private static final String url ="http://localhost:8080/12-WS-Restful/rest/reserva/";
		
	//Consultar todos
	public List<ReservaTO> listar() throws Exception{
		
		//2. Criamos o recurso a partir do client - Acessar a url
		WebResource resource = client.resource(url);
		
		//3.Chamar o WS - queremos JSON
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		//4.Validar o status do http
		if(response.getStatus() != 200) {
			throw new Exception();
		}
		//Recuperar reservas
		ReservaTO[] vetor = response.getEntity(ReservaTO[].class);
		
		return Arrays.asList(vetor); //transformar Array em List
	}
	
	//Consultar por código
	public ReservaTO pesquisar(int codigo) throws Exception {
		
		WebResource resource = client.resource(url + codigo);
		
		//Tipo de dado que estou retornando (accept)
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception();
		}
		
		return response.getEntity(ReservaTO.class);
	}
	
	//Cadastrar
	public void cadastrar(ReservaTO reserva) throws Exception{
		WebResource resource = client.resource(url);
		
		//Tipo de dado que estou enviando (type)
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, reserva);
		
		if (response.getStatus() != 201) {
			throw new Exception();
		}
	}
	
	//Atualizar
	public void atualizar(ReservaTO reserva) throws Exception {
		WebResource resource = client.resource(url + reserva.getCodigo());
		
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, reserva);
		
		if (response.getStatus() != 200) {
			throw new Exception();
		}
	}
	
	//Remover
	public void remover(int codigo) throws Exception {
		WebResource resource = client.resource(url + codigo);
		
		ClientResponse response = resource.delete(ClientResponse.class);
		
		if (response.getStatus() != 204) {
			throw new Exception();
		}
	}
	
}
