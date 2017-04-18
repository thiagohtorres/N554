package br.unifor.bean;

import java.util.Collection;

import javax.ejb.Remote;

import br.unifor.entity.Aluno;

@Remote
public interface AlunoBeanRemote {

	public Collection<Aluno> lista();

	public String insere(Aluno aluno);

	public String remove(Long id);

	public Aluno busca(Long id);

	public String altera(Aluno aluno);

}
