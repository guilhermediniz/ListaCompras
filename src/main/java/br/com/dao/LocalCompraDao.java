package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class LocalCompraDao {
	@PersistenceContext
	private EntityManager manager;

	public List<LocalCompra> all() {
		return manager.createQuery("select i from LocalCompra i",
				LocalCompra.class).getResultList();
	}
	
	public List<LocalCompra> findByUsuario(Long id) {
		return manager.createQuery("select i from LocalCompra i where usuarioproprietario_id="+id,
				LocalCompra.class).getResultList();
	}

	public void save(LocalCompra localCompra) {
		manager.persist(localCompra);
	}

	public LocalCompra findById(Long id) {
		return manager.find(LocalCompra.class, id);
	}

	public void remove(LocalCompra localCompra) {
		manager.remove(localCompra);
	}

	public void update(LocalCompra localCompra) {
		manager.merge(localCompra);
	}
	
	
	
	
}
