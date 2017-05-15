package br.com.servico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	protected LogServico logServico;
	@Autowired
	protected UsuarioDao dao;
	
	public List<Usuario> findAll() throws Exception{
		List<Usuario> listItemListItem = dao.all();
		logServico.saveUsuario("Buscar", "Todos os Usuario");
		return listItemListItem;
	}

	public Usuario findById(Long id) throws Exception {
		User usuario = dao.findById(id);
		if(usuario==null){
			throw new Exception("Usu�rio n�o encontrado");
		}
		return usuario;
	}
	
	public Usuario findByEmail(String email) throws Exception {
		Usuario usuario = dao.findByEmail(email);
		if(usuario==null){
			throw new Exception("Usuário não encontrado");
		}
		return usuario;	
	}

	public void saveUsuario(Usuario usuario) throws Exception {
		if(dao.findByEmail(usuario.getEmail())!=null){
			throw new Exception("Email j� cadastrado para outro usu�rio");
		}
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		dao.save(usuario);
	}

	public void removeUsuario(Usuario usuario) throws Exception {
		logServico.saveUsuario("Remover", "Remover com o id:\t"+usuario.getId());
		dao.remove(usuario);
	}

	public void updateUsuario(Usuario usuario) throws Exception{
		logServico.saveUsuario("Atualizar", "Atualizar com o id:\t"+usuario.getId());
		dao.update(usuario);
	}	
}
