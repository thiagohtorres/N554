package br.unifor.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import br.unifor.entity.Disciplina;
import br.unifor.entity.Produto;


@Stateless
public class ProdutoDAO {
	
	@PersistenceContext(unitName="ExemploPU")
	private EntityManager manager;
	
	static private Map<Long,Produto> carrinhoMap;
	
	static{
		carrinhoMap = new HashMap<Long, Produto>();
	}
	
	public String inserir(Produto produto) {
		try {
			manager.persist(produto);
			return "Produto " + produto.getNome() + " inserido!";
		} catch (PersistenceException e) {
			return "Erro ao inserir dados" + e;
		}
	}
	
	public Collection<Produto> listar() {
		return manager.createQuery("SELECT p FROM Produto p").getResultList();
	}
	

	public String addCarrinho(Long id) {
		Produto produto = new Produto();
		produto = manager.find(Produto.class, id);
		carrinhoMap.put(produto.getId(),produto);
		
		
		return "Produto "+produto.getNome()+" foi adicionado ao Carrinho!";
		
	}
	
	public Collection<Produto> listarCarrinho(){
		return new ArrayList<Produto>(carrinhoMap.values());
	}
	
	public String remover(Long id){
		carrinhoMap.remove(id);
		
		
		return "Produto removido com sucesso!";
	}
	
	public String compraConcluida(){
		carrinhoMap.clear();
		
		return "Obrigado pela compra!";
	}

}
