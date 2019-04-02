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

import br.com.fiap.dao.impl.ComidaDAOImpl;
import br.com.fiap.entity.Comida;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

/*            http://localhost:8080/14-WS-Restful-Comida/rest/comida            */

@Path("/comida")
public class ComidaResource {
	
	private ComidaDAOImpl dao;
	
	public ComidaResource() {
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		dao = new ComidaDAOImpl(em);
	}
	
	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String buscar() {
		return "Hello world";
	}*/
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comida> consultar() {		
		return dao.listar();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Comida comida, @Context UriInfo uri) {
		try {
			dao.cadastrar(comida);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		UriBuilder builder = uri.getAbsolutePathBuilder();
		builder.path(Integer.toString(comida.getCodigo()));
		
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Comida comida, @PathParam("id") int codigo) {
		try {
			comida.setCodigo(codigo);
			dao.atualizar(comida);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			Response.serverError().build();
		}
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public Response remover(@PathParam("id") int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			Response.serverError().build();
		}
		return Response.noContent().build();
	}
	
}
