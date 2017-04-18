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
import br.unifor.bean.TurmaBeanRemote;
import br.unifor.entity.Disciplina;
import br.unifor.entity.Turma;
@Stateless
@Path("/turmas")
public class TurmaResource {
	@EJB
	private TurmaBeanRemote turmaBean;

	
	@Path("{id}")
	@GET
	@Produces("application/json")
	public Turma busca(@PathParam("id") Long id){
		return this.turmaBean.busca(id);
	}

	@GET
	@Produces("application/json")
	public Collection<Turma> lista() {
		return this.turmaBean.lista();
	}
	
	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String alterar(Turma turma) {
		return this.turmaBean.altera(turma);
		
	}


	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String insere(Turma turma) {
		return this.turmaBean.insere(turma);
	}
	
	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String remove(@PathParam("id") Long id) {
		
		return this.turmaBean.remove(id);
		
	}

}
