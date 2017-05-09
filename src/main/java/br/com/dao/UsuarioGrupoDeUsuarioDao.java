package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioGrupoDeUsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	public List<UsuarioGrupoDeUsuario> all() {
		return manager.createQuery("select i from UsuarioGrupoDeUsuario i",
				UsuarioGrupoDeUsuario.class).getResultList();
	}
	
	public List<UsuarioGrupoDeUsuario> findByIdGrupoUsuario(Long idGrupoUsuario) {
		return manager.createQuery("select i from UsuarioGrupoDeUsuario i where idgrupo="+idGrupoUsuario,
				UsuarioGrupoDeUsuario.class).getResultList();
	}
	
	public List<UsuarioGrupoDeUsuario> findByIdUser(Long idUsuario) {
		return manager.createQuery("select i from UsuarioGrupoDeUsuario i where idusuario="+idUsuario,
				UsuarioGrupoDeUsuario.class).getResultList();
	}
	
	public List<UsuarioGrupoDeUsuario> findByIdGroupIdUsuario(Long idGrupo, Long idUsuario) {
		return manager.createQuery("select i from UsuarioGrupoDeUsuario i where idGrupo="+idGrupo+" AND idUsuario="+idUsuario,
				UsuarioGrupoDeUsuario.class).getResultList();
	}
	
	public List<UsuarioGrupoDeUsuario> findByIdGrupo(Long idGrupo) {
		return manager.createQuery("select i from UsuarioGrupoDeUsuario i where idgrupo="+idGrupo,
				UsuarioGrupoDeUsuario.class).getResultList();
	}

	public void save(UsuarioGrupoDeUsuario usuarioGrupoDeUsuario) {
		manager.persist(usuarioGrupoDeUsuario);
	}

	public UserGroupUser findById(Long id) {
		return manager.find(UsuarioGrupoDeUsuario.class, id);
	}

	public void remove(UsuarioGrupoDeUsuario usuarioGrupoDeUsuario) {
		manager.remove(usuarioGrupoDeUsuario);
	}

	public void update(UsuarioGrupoDeUsuario usuarioGrupoDeUsuario) {
		manager.merge(usuarioGrupoDeUsuario);
	}
}
