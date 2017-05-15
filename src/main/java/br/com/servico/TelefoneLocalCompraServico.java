package br.com.servico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneLocalCompraServico {

	@Autowired
	protected TelefoneLocalCompraDao dao;
	@Autowired
	protected PhoneDao telefoneDao;
	@Autowired
	protected LogService logServico;

	public TelefoneLocalCompra findById(Long id) throws Exception{
		TelefoneLocalCompra telefoneLocalCompra = dao.findById(id);
		logServico.saveUsuario("Buscar", "TelefoneLocalCompra com id:\t"+id);
		return telefoneLocalCompra;	
	}
	
	public Telefone findByLocalCompra(LocalCompra localCompra) throws Exception {
		TelefoneLocalCompra telefoneLocalCompra = telefoneDao.findByLocalCompra(localCompra.getId());
		if(telefoneLocalCompra==null){
			return null;
		}
		logServico.saveUsuario("Buscar", "Telefone por LocalCompra com id:\t"+localCompra.getId());
		return telefoneDao.findById(telefoneLocalCompra.getIdTelefone());
	}
	
	public List<TelefoneLocalCompra> findAll() throws Exception{
		List<TelefoneLocalCompra> telefoneLocalCompra = dao.all();
		logServico.saveUsuario("Buscar", "Todos os TelefoneLocalCompra");
		return telefoneLocalCompra;	
	}
	
	public List<TelefoneLocalCompra> findByUsuario(Long id) throws Exception{
		List<TelefoneLocalCompra> telefoneLocalCompra = dao.findByUsuario(id);
		logServico.saveUsuario("Buscar", "Lista de TelefoneLocalCompra por Usuario com id:\t"+id);
		return telefoneLocalCompra;	
	}

	public void saveTelefoneLocalCompra(TelefoneLocalCompra telefoneLocalCompra) throws Exception{
		logServico.saveUsuario("Salvar", "Salvar TelefoneLocalCompra");
		dao.save(telefoneLocalCompra);
	}

	public void removeTelefoneLocalCompra(TelefoneLocalCompra telefoneLocalCompra) throws Exception {
		logServico.saveUsuario("Remover", "Remover TelefoneLocalCompra com id:\t"+telefoneLocalCompra.getId());
		dao.remove(telefoneLocalCompra);
	}

	public void updateTelefoneLocalCompra(TelefoneLocalCompra telefoneLocalCompra) throws Exception{
		logServico.saveUsuario("Atualizar", "Atualizar TelefoneLocalCompra com id:\t"+telefoneLocalCompra.getId());
		dao.update(telefoneLocalCompra);
	}	
}
