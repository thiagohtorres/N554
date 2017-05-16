package br.unifor.bean.impl;


import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.unifor.DAO.TurmaDAO;
import br.unifor.bean.TurmaBeanRemote;
import br.unifor.entity.Turma;

/**
 * Session Bean implementation class DisciplinaBeanImpl
 */
@Stateless
public class TurmaBeanImpl implements TurmaBeanRemote {

	@EJB
	private TurmaDAO turmaDAO;

	
	public Collection<Turma> lista() {
		return this.turmaDAO.lista();

	}

	public String insere(Turma turma) {
		return this.turmaDAO.insere(turma);
	}

	public String remove(Long id) {
		return this.turmaDAO.remove(id);
	}

	public String altera(Turma turma) {
		return this.turmaDAO.altera(turma);	
	}

	public Turma busca(Long id) {
		return this.turmaDAO.busca(id);
	}

	public Collection<Turma> listarTurmas(Long id) {
		
		return this.turmaDAO.listarTurmas(id);
	}

}
