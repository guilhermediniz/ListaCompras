package br.com.servico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoUsuarioServico {

		@Autowired
		protected GrupoUsuarioDao dao;
		@Autowired
		protected LogServico logServico;

		public GrupoUsuario findById(Long id) throws Exception {
			GrupoUsuario grupoUsuario = dao.findById(id);
			logServico.saveUsuario("Buscar", "GrupoUsuario com id:\t"+id);
			return grupoUsuario;	
		}
		
		public List<GrupoUsuario> findByUsuario(Usuario usuario) throws Exception {
			List<GrupoUsuario> grupoUsuario = dao.findByUsuario(usuario.getId());
			logServico.saveUsuario("Buscar", "Lista de GrupoUsuario por usuário id:\t"+usuario.getId());
			return grupoUsuario;	
		}
		
		public void saveGrupoUsuario(GrupoUsuario grupoUsuario) throws Exception {
			logServico.saveUsuario("Salvar", "Salvar GrupoUsuario");
			dao.save(grupoUsuario);
		}

		public void removeGrupoUsuario(GrupoUsuario grupoUsuario) throws Exception {
			logServico.saveUsuario("Remover", "Remover GrupoUsuario com id:\t"+grupoUsuario.getId());
			dao.remove(grupoUsuario);
		}

		public void updateGrupoUsuario(GrupoUsuario grupoUsuario) throws Exception{
			logServico.saveUsuario("Remover", "Remover GrupoUsuario com id:\t"+grupoUsuario.getId());
			dao.update(grupoUsuario);
		}		
}
