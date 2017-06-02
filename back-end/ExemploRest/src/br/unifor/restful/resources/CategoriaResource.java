package br.unifor.restful.resources;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.unifor.bean.CategoriaBeanRemote;
import br.unifor.entity.Categoria;

@Stateless
@Path("/categoria")
public class CategoriaResource {
	
	
		
		@EJB
		private CategoriaBeanRemote categoriaBean;
		
		
		
		@GET
		@Produces("application/json")
		public Collection<Categoria> listar() {
			return this.categoriaBean.listar();
		}
		
		
		
		@POST
	    @Consumes("application/json")
	    @Produces("text/plain")
	    public String inserir(Categoria categoria) {    	
	       return this.categoriaBean.inserir(categoria);
	    }
		
		
		
		@Path("{id}")
		@DELETE
		@Produces("text/plain")
		public String remove(@PathParam("id") Long id) {
			return this.categoriaBean.remover(id);
		}
		
		


}
