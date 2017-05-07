package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class TelefoneDao {
	
	@PersistenceContext
	private EntityManager manager;

	public List<Telefone> all() {
		return manager.createQuery("select i from Telefone i",
				Telefone.class).getResultList();
	}
	
	public TelefoneUsuario findByUsuario(Long idUsuario) {
		List<TelefoneUsuario> listPU= manager.createQuery("select i from TelefoneUsuario i where idusuario="+idUsuario,
				TelefoneUsuario.class).getResultList();
		if(listPU.size()==0){
			return null;
		}
		return listPU.get(0);
	}
	
	
	public TelefoneLocalCompra findByLocalCompra(Long idLocalCompra) {
		List<TelefoneLocalCompra> listPU= manager.createQuery("select i from TelefoneLocalCompra i where idlocalcompra="+idLocalCompra,
				TelefoneLocalCompra.class).getResultList();
		if(listPU.size()==0){
			return null;
		}
		return listPU.get(0);
	}

	public void save(Telefone telefone) {
		manager.persist(telefone);
	}

	public Telefone findById(Long id) {
		return manager.find(Telefone.class, id);
	}

	public void remove(Telefone telefone) {
		manager.remove(telefone);
	}

	public void update(Telefone telefone) {
		manager.merge(telefone);
	}

	
	
	
	
	
	
	
}
