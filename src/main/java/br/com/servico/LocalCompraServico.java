package br.com.servico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalCompraServico {
	
	@Autowired
	protected LocalCompraDao dao;
	@Autowired
	protected LogServico logServico;

	public LocalCompra findById(Long id) throws Exception{
		LocalCompra localCompra = dao.findById(id);
		logServico.saveUsuario("Buscar", "LocalCompra com id:\t"+id);
		return localCompra;	
	}
	
	public List<LocalCompra> findAll() throws Exception{
		List<LocalCompra> localCompra = dao.all();
		logServico.saveUsuario("Buscar", "Todos os LocalCompra");
		return localCompra;	
	}
	
	public List<LocalCompra> findByUsuario(Long id) throws Exception{
		List<LocalCompra> localCompra = dao.findByUsuario(id);
		logServico.saveUsuario("Buscar", "Lista LocalCompra por usuário com id:\t"+id);
		return localCompra;	
	}

	public void saveLocalCompra(LocalCompra localCompra) throws Exception{
		logServico.saveUsuario("Salvar", "Salvar LocalCompra");
		dao.save(localCompra);
	}

	public void removeLocalCompra(LocalCompra localCompra) throws Exception {
		logServico.saveUsuario("Remover", "Remover LocalCompra com id:\t"+localCompra.getId());
		dao.remove(localCompra);
	}

	public void updateLocalCompra(LocalCompra localCompra) throws Exception{
		logServico.saveUsuario("Atualizar", "Atualizar LocalCompra com id:\t"+localCompra.getId());
		dao.update(localCompra);
	}	
}
