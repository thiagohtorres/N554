package br.unifor.restful.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;

import br.unifor.bean.AlunoBeanRemote;
import br.unifor.bean.TurmaBeanRemote;
import br.unifor.entity.Aluno;
import br.unifor.entity.Disciplina;
import br.unifor.entity.Turma;

@Stateless
@Path("/turmas")
public class TurmaResource {

	@EJB
	private TurmaBeanRemote turmaBean;


	@GET
	@Produces("application/json")
	public Collection<Turma> lista() {
		return this.turmaBean.lista();
	}

	@Path("{id}")
	@GET
	@Produces("application/json")
	public Turma busca(@PathParam("id") Long id) {
		return this.turmaBean.busca(id);
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
    
    @PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String atualiza(Turma turma) {
		return this.turmaBean.altera(turma);
	}
    @Path("disc/{id}")
	@GET
	@Produces("application/json")
	public Collection<Turma> listarTurmas(@PathParam("id") Long id) {
		return this.turmaBean.listarTurmas(id);
	}



}
