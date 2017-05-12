package br.com.servico;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemListaItemServico {

	@Autowired
	protected ItemListaItemDao dao;
	@Autowired
	protected ItemDao daoItem;
	@Autowired
	protected LogServico logServico;

	public ItemListaItem findById(Long id) throws Exception{
		ItemListaItem itemListaItem = dao.findById(id);
		logServico.saveUsuario("Buscar", "ItemListaItem com id:\t"+id);
		return itemListaItem;	
	}
	
	public List<Item> findByIdListaItem(Long idListaItem) throws Exception{
		List<ItemListaItem> listaItemListaItem = dao.findByIdListItem(idListaItem);
		List<Item> itemLista=new ArrayList<Item>();
		for(int i=0;i<listaItemListaItem.size();i++){
			itemLista.add(daoItem.findById(listaItemListaItem.get(i).getIdItem()));
		}
		logServico.saveUsuario("Buscar", "Lista de Item da lista com id:\t"+idListaItem);
		return itemLista;	
	}
	
	public List<ItemListaItem> findByIdListaItemIdItem(Long idListaItem, Long idItem) throws Exception{
		List<ItemListaItem> listaItemListaItem = dao.findByIdListaItemIdItem(idListaItem,idItem);
		logServico.saveUsuario("Buscar", "Lista de ItemListaItem por lista id: '"+idListaItem+"' e item de id: '"+idItem+"'");
		return listaItemListaItem;	
	}
	
	public List<ItemListaItem> findAll() throws Exception{
		List<ItemListaItem> listaItemListaItem = dao.all();
		logServico.saveUsuario("Buscar", "Todos ItemListaItem");
		return listaItemListaItem;	
	}

	public void saveItemListaItem(ItemListaItem itemListaItem) throws Exception{
		logServico.saveUsuario("Salvar", "Salvar ItemListaItem");
		dao.save(itemListaItem);
	}

	public void removeItemListaItem(ItemListaItem itemListaItem) throws Exception{
		logServico.saveUsuario("Remover", "Remover ItemListaItem de id: \t"+itemListaItem.getId());
		dao.remove(itemListaItem);
	}

	public void updateItemListaItem(ItemListaItem itemListaItem) throws Exception{
		logServico.saveUsuario("Atualizar", "Atualizar ItemListaItem de id: \t"+itemListaItem.getId());
		dao.update(itemListaItem);
	}	
}
