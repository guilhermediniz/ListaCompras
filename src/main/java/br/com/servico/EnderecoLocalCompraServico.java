package br.com.servico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class EnderecoLocalCompraServico {
	
	@Service
	public class EnderecoLocalCompraServico {
		@Autowired
		protected EnderecoLocalCompraDao dao;
		@Autowired
		protected EnderecoDao EnderecoDao;
		@Autowired
		protected LogServico logServico;

		public EnderecoLocalCompra findById(Long id) throws Exception {
			EnderecoLocalCompra EnderecoLocalCompra = dao.findById(id);
			logServico.saveUsuario("Buscar", "EnderecoLocalCompra com id:\t"+id);
			return EnderecoLocalCompra;	
		}
		
		public Endereco findByLocalCompra(LocalCompra LocalCompra) throws Exception {
			EnderecoLocalCompra  EnderecoLocalCompra  = dao.findByLocalCompra(localCompra.getId());
			if(EnderecoLocalCompra==null){
				return null;
			}
			logService.saveUsuario("Buscar", "EnderecoLocalCompra com id do LocalCompra:\t"+LocalCompra);
			return enderecoDao.findById(enderecoLocalCompra.getIdEndereco());
		}
		
		public List<EnderecoLocalCompra> findByUser(Long id) throws Exception{
			logServico.saveUsuario("Buscar", "Lista EnderecoLocalCompra por usuário com id:\t"+id);
			return dao.findByUser(id);
		}
		
		public void saveEnderecoLocalCompra(EnderecoLocalCompra EnderecoLocalCompra) throws Exception {	
			logServico.saveUsuario("Salvar", "Salvar EnderecoLocalCompra");
			dao.save(enderecoLocalCompra);
		}

		public void removeEnderecoLocalCompra(EnderecoLocalCompra EnderecoLocalCompra) throws Exception {
			logServico.saveUsuario("Remove", "Remover EnderecoLocalCompra com id:\t"+enderecoLocalCompra.getId());
			dao.remove(enderecoLocalCompra);
		}

		public void updateEnderecoLocalCompra(EnderecoLocalCompra EnderecoLocalCompra) throws Exception{
			logServico.saveUsuario("Atualizar", "Atualizar EnderecoLocalCompra com id:\t"+enderecoLocalCompra.getId());
			dao.update(enderecoLocalCompra);
		}	
}
