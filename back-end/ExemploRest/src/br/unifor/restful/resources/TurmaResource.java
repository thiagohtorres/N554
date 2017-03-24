package br.unifor.restful.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.unifor.entity.Disciplina;
import br.unifor.entity.Turma;

@Path("/turmas")
public class TurmaResource {

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
	@Path("{id}")
	@GET
	@Produces("application/json")
	public Turma busca(@PathParam("id") Long id){
		return turmasMap.get(id.intValue());
	}

	@GET
	@Produces("application/json")
	public Collection<Turma> lista() {
		return new ArrayList<Turma>(turmasMap.values());
	}
	
	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String alterar(Turma turma) {
		
		turmasMap.put(turma.getId().intValue(), turma);		
		
		return "Disciplina " + turma.getDisciplina().getNome() + " alterada.";
		
	}


	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String insere(Turma turma) {
		turma.setId(turmasMap.size() + 1L);		
		turmasMap.put(turma.getId().intValue(), turma);
		return "Turma "+turma.getDisciplina().getNome() +" adicionada.";
	}
	
	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String remove(@PathParam("id") Long id) {
		
		Turma turma = turmasMap.remove(id.intValue());		
		return "Disciplina " + turma.getDisciplina().getNome() + " removida.";
		
	}

}
