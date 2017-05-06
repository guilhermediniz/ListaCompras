package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ListaItemDao {
	
	@PersistenceContext
	private EntityManager manager;

	public List<ListaItem> all() {
		return manager.createQuery("select i from ListaItem i",
				ListaItem.class).getResultList();
	}
	
	public List<ListaItem> findByUsuario(Long id) {
		return manager.createQuery("select i from ListaItem i where usuarioproprietario_id="+id,
				ListaItem.class).getResultList();
	}

	public void save(ListaItem listaItem) {
		manager.persist(listaItem);
	}

	public ListaItem findById(Long id) {
		return manager.find(ListaItem.class, id);
	}

	public void remove(ListaItem listaItem) {
		manager.remove(listaItem);
	}

	public void update(ListaItem listaItem) {
		manager.merge(listaItem);
	}
	
	

}
