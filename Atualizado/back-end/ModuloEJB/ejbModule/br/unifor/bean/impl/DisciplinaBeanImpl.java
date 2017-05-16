package br.unifor.bean.impl;


import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.unifor.DAO.DisciplinaDAO;
import br.unifor.bean.DisciplinaBeanRemote;
import br.unifor.entity.Disciplina;

/**
 * Session Bean implementation class DisciplinaBeanImpl
 */
@Stateless
public class DisciplinaBeanImpl implements DisciplinaBeanRemote {
	
	@EJB
	private DisciplinaDAO disciplinaDAO;
	

	
	public DisciplinaBeanImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<Disciplina> lista() {
		return this.disciplinaDAO.lista();
	}

	@Override
	public String insere(Disciplina disciplina) {
		return this.disciplinaDAO.insere(disciplina);
	}

	@Override
	public String remove(Long id) {
	    return this.disciplinaDAO.remove(id);
	}

	@Override
    public Disciplina busca(Long id) {
       return this.disciplinaDAO.busca(id);
    }
  

	@Override
	public String altera(Disciplina disciplina) {
	    return this.disciplinaDAO.altera(disciplina);
	}

}
