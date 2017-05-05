package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GrupoUsuarioDao {
	
	@PersistenceContext
	private EntityManager manager;

	public List<GrupoUsuario> all() {
		return manager.createQuery("select i from GrupoUsuario i",
				GrupoUsuario.class).getResultList();
	}

	public List<GrupoUsuario> findByUsuario(Long id) {
		return manager.createQuery("select i from GrupoUsuario i where usuarioproprietario_id="+id,
				GrupoUsuario.class).getResultList();
	}

	public void save(GrupoUsuario grupoUsuario) {
		manager.persist(grupoUsuario);
	}

	public GrupoUsuario findById(Long id) {
		return manager.find(GrupoUsuario.class, id);
	}

	public void remove(GrupoUsuario grupoUsuario) {
		manager.remove(grupoUsuario);
	}

	public void update(GrupoUsuario grupoUsuario) {
		manager.merge(GrupoUsuario);
	}	
	
	
	
	

}
