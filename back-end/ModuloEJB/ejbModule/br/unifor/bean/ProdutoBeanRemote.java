package br.unifor.bean;
import java.util.Collection;

import javax.ejb.Remote;

import br.unifor.entity.Produto;

@Remote
public interface ProdutoBeanRemote {
	
	public Collection<Produto> listar();
	public String inserir(Produto produto);
	public String addCarrinho(Long id);
	public Collection<Produto> listarCarrinho();
	public String remover(Long id);

}
