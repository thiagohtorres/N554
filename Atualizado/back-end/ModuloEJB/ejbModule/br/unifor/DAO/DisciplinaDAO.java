package br.unifor.DAO;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import br.unifor.entity.Disciplina;

@Stateless
public class DisciplinaDAO {

	@PersistenceContext(unitName="ExemploPU")
	private EntityManager manager;

	public String insere(Disciplina disciplina) {
		try {
			manager.persist(disciplina);
			return "Disciplina " + disciplina.getNome() + " inserida";
		} catch (PersistenceException e) {
			return "Erro ao inserir dados" + e;
		}
	}

	public Collection<Disciplina> lista() {
		return manager.createQuery("SELECT d FROM Disciplina d").getResultList();
	}

	public Disciplina busca(Long id) {
		return manager.find(Disciplina.class, id);
		
	}

	public String remove(Long id) {
		try {
			Disciplina disciplina = manager.find(Disciplina.class, id);
			manager.remove(disciplina);
			return "Disciplina " + disciplina.getNome() + " removida";
		} catch (PersistenceException e) {
			return "Erro ao remover dados" + e;
		}
	}
	
	public String altera(Disciplina disciplina) {
        try {
            Disciplina disciplinaDetached = manager.find(Disciplina.class, disciplina.getId());
            Disciplina disciplinaManaged = manager.merge(disciplinaDetached);


            disciplinaManaged.setCodigo(disciplina.getCodigo());        
            disciplinaManaged.setNome(disciplina.getNome());            
            return "Disciplina " + disciplina.getNome() + " atualizada";
        } catch (PersistenceException e) {
            return "Erro ao atualizar dados" + e;
        }
    }


}
