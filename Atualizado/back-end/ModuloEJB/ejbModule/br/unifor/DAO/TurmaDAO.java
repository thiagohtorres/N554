package br.unifor.DAO;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import br.unifor.entity.Disciplina;
import br.unifor.entity.Turma;

@Stateless
public class TurmaDAO {

	@PersistenceContext(unitName="ExemploPU")
	private EntityManager manager;

	public String insere(Turma turma) {
		try {
			manager.persist(turma);
			return "Turma " + turma.getSemestre()+"-"+ " inserida";
		} catch (PersistenceException e) {
			return "Erro ao inserir dados" + e;
		}
	}

	public Collection<Turma> lista() {
		return manager.createQuery("SELECT t FROM Turma t").getResultList();
	}

	public Turma busca(Long id) {
		return manager.find(Turma.class, id);
	}

	public String remove(Long id) {
		try {
			Turma turma = manager.find(Turma.class, id);
			manager.remove(turma);
			return "Turma " + turma.getSemestre() + " removida";
		} catch (PersistenceException e) {
			return "Erro ao remover dados" + e;
		}
	}
	
	public String altera(Turma turma) {
        try {
            Turma turmaDetached = manager.find(Turma.class, turma.getId());
            Turma turmaManaged = manager.merge(turmaDetached);


            turmaManaged.setSemestre(turma.getSemestre());
            turmaManaged.setDisciplina(turma.getDisciplina());
                       
            return "Turma " + turma.getSemestre() + " atualizada";
        } catch (PersistenceException e) {
            return "Erro ao atualizar dados" + e;
        }
    }
	public Collection<Turma> listarTurmas(Long id) {
		return manager.createQuery("SELECT t FROM Turma t WHERE t.disciplina = "+id).getResultList();
	}
	
	
		
	


}
