package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class TelefoneUsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	public List<TelefoneUsuario> all() {
		return manager.createQuery("select i from TelefoneUsuario i",
				TelefoneUsuario.class).getResultList();
	}
	
	public List<TelefoneUsuario> findByUsuario(Long id) {
		return manager.createQuery("select i from TelefoneUsuario i where usuarioproprietario_id="+id,
				TelefoneUsuario.class).getResultList();
	}

	public void save(TelefoneUsuario telefoneUsuario) {
		manager.persist(telefoneUsuario);
	}

	public TelefoneUsuario findById(Long id) {
		return manager.find(TelefoneUsuario.class, id);
	}

	public void remove(TelefoneUsuario telefoneUsuario) {
		manager.remove(telefoneUsuario);
	}

	public void update(TelefoneUsuario telefoneUsuario) {
		manager.merge(telefoneUsuario);
	}
	
}
