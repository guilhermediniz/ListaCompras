package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class TelefoneLocalCompraDao {
	
	@PersistenceContext
	private EntityManager manager;

	public List<TelefoneLocalCompra> all() {
		return manager.createQuery("select i from TelefoneLocalCompra i",
				TelefoneLocalCompra.class).getResultList();
	}
	
	public List<TelefoneLocalCompra> findByUsuario(Long id) {
		return manager.createQuery("select i from TelefoneLocalCompra i where usuarioproprietario_id="+id,
				TelefoneLocalCompra.class).getResultList();
	}

	public void save(TelefoneLocalCompra telefoneLocalCompra) {
		manager.persist(TelefoneLocalCompra);
	}

	public TelefoneLocalCompra findById(Long id) {
		return manager.find(TelefoneLocalCompra.class, id);
	}

	public void remove(TelefoneLocalCompra telefoneLocalCompra) {
		manager.remove(telefoneLocalCompra);
	}

	public void update(TelefoneLocalCompra telefoneLocalCompra) {
		manager.merge(telefoneLocalCompra);
	}

}
