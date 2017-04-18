package br.unifor.bean.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import br.unifor.bean.DisciplinaBeanRemote;
import br.unifor.entity.Disciplina;

@Stateless
public class DisciplinaBean implements DisciplinaBeanRemote {
    static private Map<Integer, Disciplina> disciplinasMap;


	static {
		disciplinasMap = new HashMap<Integer, Disciplina>();
		Disciplina d1 = new Disciplina();
		d1.setCodigo("001");
		d1.setId(1L);
		d1.setNome("Redes de Computadores");
		disciplinasMap.put(d1.getId().intValue(), d1);

		Disciplina d2 = new Disciplina();
		d2.setCodigo("002");
		d2.setId(2L);
		d2.setNome("Prog. Web I");
		disciplinasMap.put(d2.getId().intValue(), d2);

		Disciplina d3 = new Disciplina();
		d3.setCodigo("003");
		d3.setId(3L);
		d3.setNome("IA");
		disciplinasMap.put(d3.getId().intValue(), d3);


   		
    }


	@Override
	public Collection<Disciplina> lista() {
		
		return new ArrayList<Disciplina>(disciplinasMap.values());
	}


	@Override
	public String insere(Disciplina disciplina) {
		disciplina.setId(disciplinasMap.size() + 1L);
		disciplinasMap.put(disciplina.getId().intValue(), disciplina);
		return "Disciplina " + disciplina.getNome() + " adicionada.";
		
	}


	@Override
	public String remove(Long id) {
		Disciplina disciplina = disciplinasMap.remove(id.intValue());		
		return "Disciplina " + disciplina.getNome() + " removida.";
	}


	@Override
	public Disciplina busca(Long id) {		
		return disciplinasMap.get(id.intValue());
	}


	@Override
	public String altera(Disciplina disciplina) {
		disciplinasMap.put(disciplina.getId().intValue(), disciplina);
		return "Disciplina " + disciplina.getNome() + " alterada.";
	}
}
