package br.unifor.restful.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.unifor.entity.Aluno;
import br.unifor.entity.Turma;

@Path("/alunos")
public class AlunoResource {
	
	static private Map<Integer, Aluno> alunosMap;
	
	static{
		alunosMap = new HashMap<Integer,Aluno>();
	}
	
	
	
	@Path("{id}")
	@GET
	@Produces("application/json")
	public Aluno busca(@PathParam("id") Long id){
		return alunosMap.get(id.intValue());
	}
	
	@GET
	@Produces("application/json")
	public Collection<Aluno> lista() {
		return new ArrayList<Aluno>(alunosMap.values());
	}
	
	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String alterar(Aluno aluno) {
		
		alunosMap.put(aluno.getId().intValue(), aluno);		
		
		return "Aluno " + aluno.getNome() + " alterada.";
		
	}
	
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String insere(Aluno aluno) {		
		aluno.setId(alunosMap.size() + 1L);		
		alunosMap.put(aluno.getId().intValue(), aluno);
		return "Turma "+aluno.getNome() +" adicionada.";
	}
	
	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String remove(@PathParam("id") Long id) {
		
		Aluno aluno = alunosMap.remove(id.intValue());		
		return "Disciplina " + aluno.getNome() + " removida.";
		
	}
	

}
