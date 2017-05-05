package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class EnderecoLocalCompraDao {
	@PersistenceContext
	private EntityManager manager;

	public List<EnderecoLocalCompra> all() {
		return manager.createQuery("select i from EnderecoLocalCompra i",
				EnderecoLocalCompra.class).getResultList();
	}

	public void save(EnderecoLocalCompra enderecoLocalCompra) {
		manager.persist(enderecoLocalCompra);
	}

	public EnderecoLocalCompra findById(Long id) {
		return manager.find(EnderecoLocalCompra.class, id);
	}
	
	public EnderecoLocalCompra findByLocalCompra(Long idLocalCompra) {
		List<EnderecoLocalCompra> listAU = manager.createQuery("select i from EnderecoLocalCompra i where idlocalcompra="+idLocalCompra,
				EnderecoLocalCompra.class).getResultList();
		if(listAU.size()==0){
			return null;
		}
		return listAU.get(0);
	}
	
	public List<EnderecoLocalCompra> findByUsuario(Long id) {
		return manager.createQuery("select i from EnderecoLocalCompra i where usuarioproprietario_id="+id,
				EnderecoLocalCompra.class).getResultList();
	}

	public void remove(EnderecoLocalCompra enderecoLocalCompra) {
		manager.remove(enderecoLocalCompra);
	}

	public void update(EnderecoLocalCompra enderecoLocalCompra) {
		manager.merge(enderecoLocalCompra);
	}
}
