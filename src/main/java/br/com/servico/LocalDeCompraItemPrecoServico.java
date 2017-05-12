package br.com.servico;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalDeCompraItemPrecoServico {
	
	@Autowired
	protected LocalDeCompraItemPrecoDao dao;
	@Autowiredao
	protected EnderecoDao enderecoDao;
	@Autowired
	protected ItemDao daoItem;
	@Autowired
	protected LogServico logServico;

	public LocalDeCompraItemPreco findById(Long id) throws Exception {
		LocalDeCompraItemPreco localDeCompraItemPreco = dao.findById(id);
		logServico.saveUsuario("Buscar", "LocalDeCompraItemPreco com id:\t"+id);
		return localDeCompraItemPreco;	
	}
	
	public List<LocalDeCompraItemPreco> findByUser(Long id) throws Exception{
		logServico.saveUsuario("Buscar", "Lista de LocalDeCompraItemPreco por usuário com id:\t"+id);
		return dao.findByUsuario(id);
	}
	
	public List<LocalDeCompraItemPreco> findByPlaceBuy(Long id) throws Exception{
		logServico.saveUsuario("Buscar", "Lista de LocalDeCompraItemPreco por Local de Compra com id:\t"+id);
		return dao.findByLocalCompra(id);
	}
	
	public List<Item> findByIdLocalCompra(Long idLocalCompra) throws Exception{
		List<LocalDeCompraItemPreco> listItemListaItem = dao.findByIdLocalCompra(idLocalCompra);
		List<Item> itemLista=new ArrayList<Item>();
		for(int i=0;i<listItemListaItem.size();i++){
			itemLista.add(daoItem.findById(listItemListaItem.get(i).getIdItem()));
		}
		logServico.saveUsuario("Buscar", "Lista LocalDeCompraItemPreco por Local de Compra com id:\t"+idLocalCompra);
		return itemLista;	
	}

	public void saveLocalDeCompraItemPreco(LocalDeCompraItemPreco localDeCompraItemPreco) throws Exception {
		logServico.saveUsuario("Salvar", "Salvar LocalDeCompraItemPreco por Local de Compra");
		dao.save(localDeCompraItemPreco);
	}

	public void removeLocalDeCompraItemPreco(LocalDeCompraItemPreco localDeCompraItemPreco) throws Exception {
		logServico.saveUsuario("Remover", "Remover LocalDeCompraItemPreco por Local de Compra com id:\t"+LocalDeCompraItemPreco.getId());
		dao.remove(localDeCompraItemPreco);
	}

	public void updateLocalDeCompraItemPreco(LocalDeCompraItemPreco localDeCompraItemPreco) throws Exception{
		logServico.saveUsuario("Atualizar", "Atualizar LocalDeCompraItemPreco por Local de Compra com id:\t"+LocalDeCompraItemPreco.getId());
		dao.update(localDeCompraItemPreco);
	}	
}
