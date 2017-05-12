package br.com.servico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaItemServico {

	@Autowired
	protected ListaItemDao dao;
	@Autowired
	protected GrupoUsuarioDao grupoDao;
	@Autowired
	protected LogServico logServico;

	public ListaItem findById(Long id) throws Exception{
		ListaItem listaItem = dao.findById(id);
		logServico.saveUsuario("Buscar", "ListaItem com id:\t"+id);
		return listaItem;	
	}
	
	public List<ListaItem> findAll() throws Exception{
		List<ListaItem> listaItem = dao.all();
		logServico.saveUsuario("Buscar", "Todos ListaItem");
		return listaItem;	
	}
	
	public List<ListaItem> findByUsuario(Long id) throws Exception{
		List<ListItem> listItem = dao.findByUsuario(id);
		logServico.saveUsuario("Buscar", "Lista de ListaItem por usuário com id:\t"+id);
		return listaItem;	
	}

	public void saveListaItem(ListaItem listaItem) throws Exception{
		logServico.saveUsuario("Salvar", "Saltar ListaItem");
		dao.save(listaItem);
	}

	public void removeListaItem(ListaItem listaItem) throws Exception {
		logServico.saveUsuario("Remover", "Lista ListaItem por usuário com id:\t"+listaItem.getId());
		dao.remove(listaItem);
	}

	public void updateListaItem(ListItem listaItem) throws Exception{
		logServico.saveUsuario("Atualizar", "Atualizar ListaItem por usuário com id:\t"+listaItem.getId());
		dao.update(listaItem);
	}	
}
