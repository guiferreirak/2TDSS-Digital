package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.entity.Reserva;
import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

/* http://localhost:8080/12-WS-Restful/rest/reserva */

@Path("/reserva")
public class ReservaResource {
	
	private ReservaDAOImpl dao;
		
	public ReservaResource() {
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		dao = new ReservaDAOImpl(em);
	}
	
	//SELECT POR CODIGO
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reserva buscarPorCodigo(@PathParam("id") Integer codigo) {
		try {
			return dao.consultar(codigo);
		} catch (ChaveInexistenteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//SELECT ALL
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reserva> buscar() {
		return dao.listar();
	}
	
	//Cadastro
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Reserva reserva, @Context UriInfo uri) {
		try {
			dao.cadastrar(reserva);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build(); //Erro 500
		}
		
		//Construir a URL para acessar o recurso (reserva) cadastrada
		UriBuilder builder = uri.getAbsolutePathBuilder(); //pegando o caminho inteiro da url
		builder.path(Integer.toString(reserva.getCodigo()));
		
		return Response.created(builder.build()).build();
	}
	
	//Atualizar
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") Integer codigo, Reserva reserva) {
		try {
			reserva.setCodigo(codigo);
			dao.atualizar(reserva);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			Response.serverError().build();
		}
		return Response.ok().build(); //200 OK
	}
	
	//Remover
	@DELETE
	@Path("{id}")
	public Response remover(@PathParam("id") Integer codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.noContent().build(); //204 OK
	}
	
	
}
