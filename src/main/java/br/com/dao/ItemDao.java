package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {

	@PersistenceContext
	private EntityManager manager;

	public List<Item> all() {
		return manager.createQuery("select i from Item i",
				Item.class).getResultList();
	}

	public List<Item> findByUser(Long id) {
		return manager.createQuery("select i from Item i where usuarioproprietario_id="+id,
				Item.class).getResultList();
	}

	public void save(Item item) {
		manager.persist(item);
	}

	public Item findById(Long id) {
		return manager.find(Item.class, id);
	}

	public void remove(Item item) {
		manager.remove(item);
	}

	public void update(Item item) {
		manager.merge(item);
	}
	
	
	
	
	
}
