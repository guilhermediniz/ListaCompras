package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class LogDao {
	@PersistenceContext
	private EntityManager manager;

	public List<Log> all() {
		return manager.createQuery("select i from Log i",
				Log.class).getResultList();
	}

	public Log findByEmail(String email) {
		List<Log> referenceProjects = manager
				.createQuery("SELECT r FROM Log r WHERE email = '" + email + "'", Log.class)
				.getResultList();
		if (referenceProjects.size() > 0) {
			return (Log) referenceProjects.get(0);
		}
		return null;
	}

	public void save(Log log) {
		manager.persist(log);
	}

	public Log findById(Long id) {
		return manager.find(Log.class, id);
	}

	public void remove(Log log) {
		manager.remove(log);
	}

	public void update(Log log) {
		manager.merge(log);
	}
	
	
	
	

}
