package br.com.servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServico {

	@Autowired
	protected EnderecoDao dao;
	@Autowired
	protected LogServico logServico;

	public Endereco findById(Long id) throws Exception {
		Endereco Endereco = dao.findById(id);
		logServico.saveUsuario("Buscar", "Endereco com id:\t"+id);
		return endereco;	
	}

	public void saveEndereco(Endereco endereco) throws Exception {	
		logServico.saveUsuario("Salvar", "Salvar Endereco");
		dao.save(endereco);
	}

	public void removeEndereco(Endereco endereco) throws Exception {
		logServico.saveUsuario("Remover", "Remover Endereco com id:\t"+endereco.getId());
		dao.remove(endereco);
	}

	public void updateEndereco(Endereco endereco) throws Exception{
		logServico.saveUsuario("Atualizar", "Atualizar Endereco com id:\t"+endereco.getId());
		dao.update(endereco);
	}	
}
