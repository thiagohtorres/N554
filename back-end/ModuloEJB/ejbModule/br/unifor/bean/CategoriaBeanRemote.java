package br.unifor.bean;

import java.util.Collection;

import javax.ejb.Remote;

import br.unifor.entity.Categoria;




@Remote
public interface CategoriaBeanRemote {
	
	public Collection<Categoria> listar();
	public String inserir(Categoria categoria);
	public String remover(Long id);
	
	

}
