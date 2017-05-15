package br.com.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneUsuarioServico {
	
	@Autowired
	protected TelefoneUsuarioDao dao;
	@Autowired
	protected TelefoneDao telefoneDao;
	@Autowired
	protected LogServico logServico;

	public TelefoneUsuario findById(Long id) throws Exception{
		TelefoneUsuario telefoneUsuario = dao.findById(id);
		logServico.saveUsuario("Buscar", "TelefoneUsuario com id:\t"+id);
		return telefoneUsuario;	
	}
	
	public Telefone findByUsuario(Usuario usuario) throws Exception {
		TelefoneUsuario telefoneUsuario = telefoneDao.findByUsuario(usuario.getId());
		if(telefoneUsuario==null){
			return null;
		}
		logServico.saveUsuario("Buscar", "Telefone por usuário com id:\t"+usuario.getId());
		return telefoneDao.findById(telefoneUsuario.getIdTelefone());
	}
	
	public List<TelefoneUsuario> findAll() throws Exception{
		List<TelefoneUsuario> telefoneUsuario = dao.all();
		logServico.saveUsuario("Buscar", "Todos os TelefoneUsuario");
		return telefoneUsuario;	
	}
	
	public List<TelefoneUsuario> findByUsuario(Long id) throws Exception{
		List<TelefoneUsuario> telefoneUsuario = dao.findByUsuario(id);
		logServico.saveUsuario("Buscar", "List de TelefoneUsuario por usuário com id:\t"+id);
		return telefoneUsuario;	
	}

	public void saveTelefoneUsuario(TelefoneUsuario telefoneUsuario) throws Exception{
		logServico.saveUsuario("Salvar", "Salvar TelefoneUsuario");
		dao.save(telefoneUsuario);
	}

	public void removeTelefoneUsuario(TelefoneUsuario telefoneUsuario) throws Exception {
		logServico.saveUsuario("Remover", "Remover TelefoneUsuario com id:\t"+telefoneUsuario.getId());
		dao.remove(telefoneUsuario);
	}

	public void updateTelefoneUsuario(TelefoneUsuario telefoneUsuario) throws Exception{
		logServico.saveUsuario("Atualizar", "Atualizar TelefoneUsuario com id:\t"+telefoneUsuario.getId());
		dao.update(telefoneUsuario);
	}	
}
