package br.unifor.bean.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.unifor.DAO.CategoriaDAO;
import br.unifor.bean.CategoriaBeanRemote;
import br.unifor.entity.Categoria;


@Stateless
public class CategoriaBeanImpl implements CategoriaBeanRemote{
	
	@EJB
	private CategoriaDAO categoriaDAO;

	@Override
	public Collection<Categoria> listar() {
		
		return this.categoriaDAO.listar();
	}

	@Override
	public String inserir(Categoria categoria) {
		return this.categoriaDAO.inserir(categoria);
	}

	@Override
	public String remover(Long id) {
		return this.categoriaDAO.remover(id);
	}

}
