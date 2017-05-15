package br.com.servico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneServico {

	@Autowired
	protected TelefoneDao dao;
	@Autowired
	protected LogServico logServico;

	public Telefone findById(Long id) throws Exception{
		Telefone telefone = dao.findById(id);
		logServico.saveUsuario("Buscar", "Telefone com id:\t"+id);
		return telefone;	
	}
	
	public List<Telefone> findAll() throws Exception{
		List<Telefone> listTelefone = dao.all();
		logServico.saveUsuario("Buscar", "Todos dos Telefone");
		return listTelefone;	
	}

	public void saveTelefone(Telefone telefone) throws Exception{
		logServico.saveUsuario("Salvar", "Salvar Telefone");
		dao.save(telefone);
	}

	public void removeTelefone(Telefone telefone) throws Exception{
		logServico.saveUsuario("Remover", "Remover Telefone com id:\t"+telefone.getId());
		dao.remove(telefone);
	}

	public void updateTelefone(Telefone telefone) throws Exception{
		logServico.saveUsuario("Atualizar", "Atualizar Telefone com id:\t"+Telefone.getId());
		dao.update(telefone);
	}			
}
