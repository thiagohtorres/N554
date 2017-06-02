package br.unifor.DAO;


import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import br.unifor.entity.Categoria;


@Stateless
public class CategoriaDAO {
	
		
		@PersistenceContext(unitName="ExemploPU")
		private EntityManager manager;
		
		
		
		public String inserir(Categoria categoria) {
			try {
				manager.persist(categoria);
				return "Produto " + categoria.getNome() + " inserido!";
			} catch (PersistenceException e) {
				return "Erro ao inserir dados" + e;
			}
		}
		
		public Collection<Categoria> listar() {
			return manager.createQuery("SELECT c FROM Categoria c").getResultList();
		}
		
		
		public String remover(Long id){
			try {
				Categoria categoria = manager.find(Categoria.class, id);
				manager.remove(categoria);
				return "Disciplina " + categoria.getNome() + " removida";
			} catch (PersistenceException e) {
				return "Erro ao remover dados" + e;
			}
		}
		
		

	
}
