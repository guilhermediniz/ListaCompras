package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class EnderecoDao {
	
		@PersistenceContext
		private EntityManager manager;

		public List<Endereco> all() {
			return manager.createQuery("select i from Endereco i",
					Endereco.class).getResultList();
		}

		public void save(Endereco endereco) {
			manager.persist(endereco);
		}

		public Endereco findById(Long id) {
			return manager.find(Endereco.class, id);
		}

		public void remove(Endereco endereco) {
			manager.remove(endereco);
		}

		public void update(Endereco endereco) {
			manager.merge(endereco);
		}
	}
	