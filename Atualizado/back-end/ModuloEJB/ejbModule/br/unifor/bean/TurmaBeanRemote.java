package br.unifor.bean;



import java.util.Collection;

import javax.ejb.Remote;

import br.unifor.entity.Disciplina;
import br.unifor.entity.Turma;

@Remote
public interface TurmaBeanRemote {

    public Collection<Turma> lista();
    public String insere(Turma turma);
    public String remove(Long id);    
    public Turma busca(Long id);
    public String altera(Turma turma);
    public Collection<Turma> listarTurmas(Long id);
}