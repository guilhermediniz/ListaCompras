package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	public List<Usuario> all() {
		return manager.createQuery("select i from Usuario i",
				Usuario.class).getResultList();
	}

	public Usuario findByEmail(String email) {
		List<Usuario> referenceProjects = manager
				.createQuery("SELECT r FROM User r WHERE email = '" + email + "'", Usuario.class)
				.getResultList();
		if (referenceProjects.size() > 0) {
			return (Usuario) referenceProjects.get(0);
		}
		return null;
	}

	public void save(Usuario usuario) {
		manager.persist(usuario);
	}

	public User findById(Long id) {
		return manager.find(Usuario.class, id);
	}

	public void remove(Usuario usuario) {
		manager.remove(usuario);
	}

	public void update(Usuario usuario) {
		manager.merge(usuario);
	}
}
