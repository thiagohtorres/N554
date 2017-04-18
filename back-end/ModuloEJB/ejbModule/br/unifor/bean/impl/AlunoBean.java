package br.unifor.bean.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import br.unifor.bean.AlunoBeanRemote;
import br.unifor.entity.Aluno;
import br.unifor.entity.Turma;
@Stateless
public class AlunoBean implements AlunoBeanRemote{
static private Map<Integer, Aluno> alunosMap;
	
	static{
		alunosMap = new HashMap<Integer,Aluno>();
	}

	@Override
	public Collection<Aluno> lista() {
		return new ArrayList<Aluno>(alunosMap.values());
	}

	@Override
	public String insere(Aluno aluno) {
		aluno.setId(alunosMap.size() + 1L);		
		alunosMap.put(aluno.getId().intValue(), aluno);
		return "Turma "+aluno.getNome() +" adicionada.";
	}

	@Override
	public String remove(Long id) {
		Aluno aluno = alunosMap.remove(id.intValue());		
		return "Disciplina " + aluno.getNome() + " removida.";
	}

	@Override
	public Aluno busca(Long id) {
		return alunosMap.get(id.intValue());
	}

	@Override
	public String altera(Aluno aluno) {
		alunosMap.put(aluno.getId().intValue(), aluno);		
		
		return "Aluno " + aluno.getNome() + " alterada.";
	}

}
