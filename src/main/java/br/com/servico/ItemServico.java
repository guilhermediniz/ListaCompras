package br.com.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lista.dao.ItemDao;
import br.com.lista.model.Item;
import br.com.lista.service.LogService;

@Service
public class ItemServico {

	@Autowired
	protected ItemDao dao;
	@Autowired
	protected LogServico logServico;

	public Item findById(Long id) throws Exception{
		Item item = dao.findById(id);
		return item;	
	}
	
	public List<Item> findAll() throws Exception{
		List<Item> listItem = dao.all();
		logServico.saveUsuario("Buscar", "Todos os Itens");
		return listItem;	
	}
	
	public List<Item> findByUser(Long id) throws Exception{
		List<Item> listItem = dao.findByUsuario(id);
		logServico.saveUsuario("Buscar", "Lista de Item por usuário com id:\t"+id);
		return listItem;	
	}

	public void saveItem(Item item) throws Exception{
		logServico.saveUsuario("Salvar", "Salvar Item");
		dao.save(item);
	}

	public void removeItem(Item item) throws Exception{
		logServico.saveUsuario("Remover", "Remover Item com id:\t"+item.getId());
		dao.remove(item);
	}

	public void updateItem(Item item) throws Exception{
		logServico.saveUsuario("Atualizar", "Atualizar Item com id:\t"+item.getId());
		dao.update(item);
	}		
}
