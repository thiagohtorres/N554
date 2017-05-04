package br.unifor.bean.impl;


import java.util.ArrayList;
import java.util.Collection;
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

import br.unifor.DAO.AlunoDAO;
import br.unifor.bean.AlunoBeanRemote;
import br.unifor.entity.Aluno;

/**
 * Session Bean implementation class DisciplinaBeanImpl
 */
@Stateless
public class AlunoBeanImpl implements AlunoBeanRemote {
	static private Map<Long, Aluno> alunosMap;

	@EJB
	private AlunoDAO alunoDAO;
	

	@GET
	@Produces("application/json")
	public Collection<Aluno> lista() {
		return this.alunoDAO.lista();

	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String insere(Aluno aluno) {
		return this.alunoDAO.insere(aluno);
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String remove(@PathParam("id") Long id) {
		return this.alunoDAO.remove(id);
	}

	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String altera(Aluno aluno) {
		return this.alunoDAO.altera(aluno);
	}

	@Path("{id}")
	@GET
	@Produces("application/json")
	public Aluno busca(@PathParam("id") Long id) {
		return this.alunoDAO.busca(id);
	}


}
