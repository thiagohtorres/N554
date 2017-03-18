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

@Path("/disciplinas")
public class DisciplinaResource {

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
	
	@GET
	@Produces("application/json")
	public Collection<Disciplina> lista() {
		return new ArrayList<Disciplina>(disciplinasMap.values());
	}
	
	@Path("{id}")
	@GET
	@Produces("application/json")
	public Disciplina busca(@PathParam("id") Long id) {
		return disciplinasMap.get(id.intValue());
	}
	
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String insere(Disciplina disciplina) {
		disciplina.setId(disciplinasMap.size() + 1L);
		disciplinasMap.put(disciplina.getId().intValue(), disciplina);
		return "Disciplina " + disciplina.getNome() + " adicionada.";
	}
	
	



}



