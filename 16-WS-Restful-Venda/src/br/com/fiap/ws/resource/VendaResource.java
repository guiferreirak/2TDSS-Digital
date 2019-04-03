package br.com.fiap.ws.resource;

import java.util.List;

import javax.persistence.EntityManager;
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

import br.com.fiap.ws.dao.impl.VendaDAOImpl;
import br.com.fiap.ws.entity.Venda;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/venda")
public class VendaResource {
	
	private VendaDAOImpl dao;

	public VendaResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new VendaDAOImpl(em);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Venda> listar(){
		return dao.listar();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Venda consultar(@PathParam("id") int id) {
		try {
			return dao.buscar(id);
		} catch (Exception e) {
			e.printStackTrace();
			Response.serverError().build();
			return null;
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Venda venda, @Context UriInfo uri) {
		try {
			dao.cadastrar(venda);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			Response.serverError().build();
		}
		
		UriBuilder builder = uri.getAbsolutePathBuilder();
		builder.path(Integer.toString(venda.getId()));
		
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(Venda venda, @PathParam("id") int id) {
		try {
			venda.setId(id);
			dao.atualizar(venda);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			Response.serverError().build();
		}
		
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public Response remover(@PathParam("id") int id) {
		try {
			dao.remover(id);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			Response.serverError().build();
		}
		
		return Response.noContent().build();
	}
	
}
