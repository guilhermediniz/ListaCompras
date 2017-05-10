package br.com.servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoUsuarioServico {

	@Autowired
	protected EnderecoUsuarioDao dao;
	@Autowired
	protected EnderecoDao enderecoDao;
	@Autowired
	protected LogServico logServico;

	public EnderecoUsuario findById(Long id) throws Exception {
		EnderecoUsuario enderecoUsuario = dao.findById(id);
		logServico.saveUsuario("Buscar", "EnderecoUsuario com id:\t"+id);
		return enderecoUsuario;	
	}
	
	public Endereco findByUsuario(Usuario usuario) throws Exception {
		EnderecoUsuario enderecoUsuario = dao.findByUser(usuario.getId());
		if(enderecoUsuario==null){
			return null;
		}
		logServico.saveUsuario("Buscar", "EnderecoUsuario por usuário com id:\t"+usuario.getId());
		return enderecoDao.findById(enderecoUsuario.getIdEndereco());
	}
	
	public void saveEnderecoUsuario(EnderecoUsuario enderecoUsuario) throws Exception {	
		logServico.saveUsuario("Salvar", "Salvar EnderecoUsuario");
		dao.save(enderecoUsuario);
	}

	public void removeEnderecoUsuario(EnderecoUsuario enderecoUsuario) throws Exception {
		logServico.saveUsuario("Remover", "Remover EnderecoUsuario com id:\t"+enderecoUsuario.getId());
		dao.remove(enderecoUsuario);
	}

	public void updateEnderecoUsuario(EnderecoUsuario enderecoUsuario) throws Exception{
		logServico.saveUsuario("Atualizar", "Atualizar EnderecoUsuario com id:\t"+enderecoUsuario.getId());
		dao.update(enderecoUsuario);
	}		
}
