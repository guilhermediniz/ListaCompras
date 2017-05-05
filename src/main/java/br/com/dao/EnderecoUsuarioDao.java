package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class EnderecoUsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	public List<EnderecoUsuario> all() {
		return manager.createQuery("select i from EnderecoUsuario i",
				EnderecoUsuario.class).getResultList();
	}

	public void save(EnderecoUsuario enderecoUsuario) {
		manager.persist(enderecoUsuario);
	}

	public EnderecoUsuario findById(Long id) {
		return manager.find(EnderecoUsuario.class, id);
	}
	
	public EnderecoUsuario findByUsuario(Long idUsuario) {
		List<EnderecoUsuario> listAU = manager.createQuery("select i from EnderecoUsuario i where idusuario="+idUsuario,
				EnderecoUsuario.class).getResultList();
		if(listAU.size()==0){
			return null;
		}
		return listAU.get(0);
	}

	public void remove(EnderecoUsuario enderecoUsuario) {
		manager.remove(enderecoUsuario);
	}

	public void update(EnderecoUsuario enderecoUsuario) {
		manager.merge(enderecoUsuario);
	}
	
	
	
	
	
	
	
	
}
