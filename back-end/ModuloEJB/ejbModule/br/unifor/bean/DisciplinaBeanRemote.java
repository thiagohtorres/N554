package br.unifor.bean;

import java.util.Collection;

import javax.ejb.Remote;

import br.unifor.entity.Disciplina;

@Remote
public interface DisciplinaBeanRemote {

    public Collection<Disciplina> lista();
    public String insere(Disciplina disciplina);
    public String remove(Long id);    
    public Disciplina busca(Long id);
    public String altera(Disciplina disciplina);
}
