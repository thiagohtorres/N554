package br.unifor.DAO;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import br.unifor.entity.Aluno;

@Stateless
public class AlunoDAO {

	@PersistenceContext(unitName="ExemploPU")
	private EntityManager manager;

	public String insere(Aluno aluno) {
		try {
			manager.persist(aluno);
			return "Aluno " + aluno.getNome()+"-"+ " inserida";
		} catch (PersistenceException e) {
			return "Erro ao inserir dados" + e;
		}
	}

	public Collection<Aluno> lista() {
		return manager.createQuery("SELECT a FROM Aluno a")
				.getResultList();
	}

	public Aluno busca(Long id) {
		return manager.find(Aluno.class, id);
	}

	public String remove(Long id) {
		try {
			Aluno aluno = manager.find(Aluno.class, id);
			manager.remove(aluno);
			return "Aluno " + aluno.getNome() + " removido";
		} catch (PersistenceException e) {
			return "Erro ao remover dados" + e;
		}
	}
	
	public String altera(Aluno aluno) {
        try {
            Aluno alunoDetached = manager.find(Aluno.class, aluno.getId());
            Aluno alunoManaged = manager.merge(alunoDetached);


            alunoManaged.setNome(aluno.getNome());
            alunoManaged.setMatricula(aluno.getMatricula());
       //     alunoManaged.setTurma(aluno.getTurma());
                       
            return "Aluno " + aluno.getNome()+ " atualizado";
        } catch (PersistenceException e) {
            return "Erro ao atualizar dados" + e;
        }
    }
	public Collection<Aluno> listarAlunos(Long id) {
		return manager.createQuery("SELECT a FROM Aluno a WHERE a.turma = "+id).getResultList();
	}


}
