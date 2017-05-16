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
	

	
	public Collection<Aluno> lista() {
		return this.alunoDAO.lista();

	}

	
	public String insere(Aluno aluno) {
		return this.alunoDAO.insere(aluno);
	}

	
	public String remove(@PathParam("id") Long id) {
		return this.alunoDAO.remove(id);
	}

	
	public String altera(Aluno aluno) {
		return this.alunoDAO.altera(aluno);
	}

	
	public Aluno busca(@PathParam("id") Long id) {
		return this.alunoDAO.busca(id);
	}
	
	public Collection<Aluno> listarAlunos(Long id) {
		return this.alunoDAO.listarAlunos(id);
	}


}
