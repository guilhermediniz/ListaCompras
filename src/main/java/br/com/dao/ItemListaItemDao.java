package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ItemListaItemDao {

	@PersistenceContext
	private EntityManager manager;

	public List<ItemListaItem> all() {
		return manager.createQuery("select i from ItemListaItem i",
				ItemListaItem.class).getResultList();
	}
	
	public List<ItemListaItem> findByIdListItem(Long idListaItem) {
		return manager.createQuery("select i from ItemListaItem i where idListaItem="+idListaItem,
				ItemListaItem.class).getResultList();
	}
	
	public List<ItemListaItem> findByIdListaItemIdItem(Long idListaItem, Long idItem) {
		return manager.createQuery("select i from ItemListaItem i where idListaItem="+idListaItem+" AND idItem="+idItem,
				ItemListaItem.class).getResultList();
	}

	public void save(ItemListaItem itemListaItem) {
		manager.persist(itemListItem);
	}

	public ItemListaItem findById(Long id) {
		return manager.find(ItemListaItem.class, id);
	}

	public void remove(ItemListaItem itemListaItem) {
		manager.remove(itemListaItem);
	}

	public void update(ItemListaItem itemListaItem) {
		manager.merge(itemListaItem);
	}
	
	
	
	
	
	
	
	
	

}
