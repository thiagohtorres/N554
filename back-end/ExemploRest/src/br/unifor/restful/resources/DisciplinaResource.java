package br.unifor.restful.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.unifor.bean.DisciplinaBeanRemote;
import br.unifor.entity.Disciplina;

@Stateless
@Path("/disciplinas")
public class DisciplinaResource {
	@EJB
	private DisciplinaBeanRemote disciplinaBean;
	
	@GET
	@Produces("application/json")
	public Collection<Disciplina> lista() {
		return this.disciplinaBean.lista();
	}
	
	@Path("{id}")
	@GET
	@Produces("application/json")
	public Disciplina busca(@PathParam("id") Long id) {
		return this.disciplinaBean.busca(id);
	}
	
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String insere(Disciplina disciplina) {
		return this.disciplinaBean.insere(disciplina);
	}
	
	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String alterar(Disciplina disciplina) {
		return this.disciplinaBean.altera(disciplina);
		
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String remove(@PathParam("id") Long id) {
		
		return this.disciplinaBean.remove(id);
		
	}

	
	



}



