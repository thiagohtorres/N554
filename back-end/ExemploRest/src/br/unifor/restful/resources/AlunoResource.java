package br.unifor.restful.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.unifor.bean.AlunoBeanRemote;

import br.unifor.entity.Disciplina;
import br.unifor.entity.Turma;
import br.unifor.entity.Aluno;

@Path("/alunos")
public class AlunoResource {

	@EJB
	private AlunoBeanRemote alunoBean;


	@GET
	@Produces("application/json")
	public Collection<Aluno> lista() {
		return this.alunoBean.lista();
	}

	@Path("{id}")
	@GET
	@Produces("application/json")
	public Aluno busca(@PathParam("id") Long id) {
		return this.alunoBean.busca(id);
	}
	
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public String insere(Aluno aluno) {    	
       return this.alunoBean.insere(aluno);
    }
    
    @Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String remove(@PathParam("id") Long id) {
		return this.alunoBean.remove(id);
	}
    
    @PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String altera(Aluno aluno) {
		return this.alunoBean.altera(aluno);
	}




}
