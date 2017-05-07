package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
@Repository
public class LocalDeCompraItemPrecoDao {
	
	@PersistenceContext
	private EntityManager manager;
	public List<LocalDeCompraItemPreco> all() {
		return manager.createQuery("select i from LocalDeCompraItemPreco i",
				LocalDeCompraItemPreco.class).getResultList();
	}
	
	public List<LocalDeCompraItemPreco> findByUsuario(Long id) {
		return manager.createQuery("select i from LocalDeCompraItemPreco i where usuarioproprietario_id="+id,
				LocalDeCompraItemPreco.class).getResultList();
	}
	
	public List<LocalDeCompraItemPreco> findByLocalCompra(Long id) {
		return manager.createQuery("select i from LocalDeCompraItemPreco i where idlocalcompra="+id,
				LocalDeCompraItemPreco.class).getResultList();
	}

	public List<LocalDeCompraItemPreco> findByIdLocalCompra(Long idLocalCompra) {
		return manager.createQuery("select i from LocalDeCompraItemPreco i where idlocalcompra="+idLocalCompra,
				LocalDeCompraItemPreco.class).getResultList();
	}
	
	public void save(LocalDeCompraItemPreco localDeCompraItemPreco) {
		manager.persist(localDeCompraItemPreco);
	}

	public LocalDeCompraItemPreco findById(Long id) {
		return manager.find(LocalDeCompraItemPreco.class, id);
	}

	public void remove(LocalDeCompraItemPrecoDao localDeCompraItemPrecoDao) {
		manager.remove(localDeCompraItemPrecoDao);
	}

	public void update(LocalDeCompraItemPrecoDao localDeCompraItemPrecoDao) {
		manager.merge(localDeCompraItemPrecoDao);
	}
}
