package br.unifor.bean.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.unifor.DAO.ProdutoDAO;
import br.unifor.bean.ProdutoBeanRemote;
import br.unifor.entity.Produto;

@Stateless
public class ProdutoBeanImpl implements ProdutoBeanRemote{
	
	@EJB
	private ProdutoDAO produtoDAO;
	

	@Override
	public Collection<Produto> listar() {
		return this.produtoDAO.listar();
	}

	@Override
	public String inserir(Produto produto) {
		return this.produtoDAO.inserir(produto);
	}

	@Override
	public String addCarrinho(Long id) {
		return this.produtoDAO.addCarrinho(id);
	}

	@Override
	public Collection<Produto> listarCarrinho() {
		
		return this.produtoDAO.listarCarrinho();
	}

	@Override
	public String remover(Long id) {		
		return this.produtoDAO.remover(id);
	}

}
