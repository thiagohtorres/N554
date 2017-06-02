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

import br.unifor.bean.ProdutoBeanRemote;
import br.unifor.entity.Produto;

@Stateless
@Path("/produto")
public class ProdutoResource {
	
	@EJB
	private ProdutoBeanRemote produtoBean;
	
	
	
	@GET
	@Produces("application/json")
	public Collection<Produto> listar() {
		return this.produtoBean.listar();
	}
	
	@Path("carrinho/{id}")
	@GET
	@Produces("text/plain")
	public String addCarrinho(@PathParam("id") Long id) {
		return this.produtoBean.addCarrinho(id);
	}
	
	@POST
    @Consumes("application/json")
    @Produces("text/plain")
    public String inserir(Produto produto) {    	
       return this.produtoBean.inserir(produto);
    }
	
	@Path("carrinho")
	@GET
	@Produces("application/json")
	public Collection<Produto> listarCarrinho() {
		return this.produtoBean.listarCarrinho();
	}
	
	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String remove(@PathParam("id") Long id) {
		return this.produtoBean.remover(id);
	}
	
	@Path("carrinho/compra")
	@GET
	@Produces("text/plain")
	public String compra() {
		return this.produtoBean.compraConcluida();
	}

}
