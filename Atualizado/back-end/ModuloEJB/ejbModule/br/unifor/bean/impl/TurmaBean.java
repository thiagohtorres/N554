package br.unifor.bean.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import br.unifor.bean.TurmaBeanRemote;
import br.unifor.entity.Disciplina;
import br.unifor.entity.Turma;
@Stateless
public class TurmaBean implements TurmaBeanRemote {
	static private Map<Integer, Turma> turmasMap;

	static {
		turmasMap = new HashMap<Integer, Turma>();

		Turma t1 = new Turma();
		Disciplina d1 = new Disciplina();
		d1.setCodigo("001");
		d1.setId(1L);
		d1.setNome("Redes de Computadores");
		t1.setId(1L);
		t1.setSemestre("2016.1");
		t1.setDisciplina(d1);
		turmasMap.put(t1.getId().intValue(), t1);

		Turma t2 = new Turma();
		Disciplina d2 = new Disciplina();
		d2.setCodigo("002");
		d2.setId(2L);
		d2.setNome("Prog. Web I");
		t2.setId(2L);
		t2.setSemestre("2017.1");
		t2.setDisciplina(d2);
		turmasMap.put(t2.getId().intValue(), t2);

		Turma t3 = new Turma();
		Disciplina d3 = new Disciplina();
		d3.setCodigo("003");
		d3.setId(3L);
		d3.setNome("IA");
		t3.setId(3L);
		t3.setSemestre("2017.2");
		t3.setDisciplina(d3);
		turmasMap.put(t3.getId().intValue(), t3);

	}

	@Override
	public Collection<Turma> lista() {
		return new ArrayList<Turma>(turmasMap.values());
	}

	@Override
	public String insere(Turma turma) {
		turma.setId(turmasMap.size() + 1L);		
		turmasMap.put(turma.getId().intValue(), turma);
		return "Turma "+turma.getDisciplina().getNome() +" adicionada.";
	}

	@Override
	public String remove(Long id) {
		Turma turma = turmasMap.remove(id.intValue());		
		return "Disciplina " + turma.getDisciplina().getNome() + " removida.";
	}

	@Override
	public Turma busca(Long id) {
		return turmasMap.get(id.intValue());
	}

	@Override
	public String altera(Turma turma) {

		turmasMap.put(turma.getId().intValue(), turma);		
		
		return "Disciplina " + turma.getDisciplina().getNome() + " alterada.";
	}

}
