package br.com.servico;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioGrupoUsuarioServico {

	@Autowired
	protected UsuarioGrupoUsuarioDao dao;
	@Autowired
	protected UsuarioDao usuarioDao;
	@Autowired
	protected GrupoUsuarioDao grupoDao;
	@Autowired
	protected ListaItemDao listaItemDao;
	@Autowired
	protected LogServico logServico;

	public UsuarioGrupoUsuario findById(Long id) throws Exception{
		UsuarioGrupoUsuario usuarioGrupoUsuario = dao.findById(id);
		logServico.saveUsuario("Buscar", "UsuarioGrupoUsuario com id:\t"+id);
		return usuarioGrupoUsuario;	
	}
	
	public List<Usuario> findByIdGrupoUsuario(Long idGrupoUsuario) throws Exception{
		List<UsuarioGrupoUsuario> listUsuarioGrupoUsuario = dao.findByIdGrupoUsuario(idGrupoUsuario);
		List<Usuario> usuarioList=new ArrayList<Usuario>();
		for(int i=0;i<listUsuarioGrupoUsuario.size();i++){
			usuarioList.add(usuarioDao.findById(listUsuarioGrupoUsuario.get(i).getIdUsuario()));
		}
		logServico.saveUsuario("Buscar", "lista de Usuario por grupo com id:\t"+idGrupoUsuario);
		return usuarioList;	
	}
	
	public List<UsuarioGrupoUsuario> findByIdGrupoIdUsuario(Long idGrupo, Long idUsuario) throws Exception{
		List<UsuarioGrupoUsuario> listUsuarioGrupoUsuario = dao.findByIdGrupoIdUsuario(idGrupo, idUsuario);
		logServico.saveUsuario("Buscar", "Lista de UsuarioGrupoUsuario por grupo com id '"+idGrupo+"' e usuário com id '"+idUsuario+"'");
		return listUsuarioGrupoUsuario;	
	}
	
	public List<ListItem> findListItemByIdUsuario(Long idUsuario) throws Exception{
		List<UsuarioGrupoUsuario> ugu=dao.findByIdUsuario(idUsuario);
		List<Long> listIdsGrupos=new ArrayList<Long>();
		for(int i=0;i<ugu.size();i++){
			if(!listIdsGrupos.contains(ugu.get(i).getIdGrupo()))
				listIdsGrupos.add(ugu.get(i).getIdGrupo());
		}
		List<ListItem> ll=new ArrayList<ListItem>();
		for(int i=0;i<listIdsGrupos.size();i++){
			ugu=dao.findByIdGrupo(listIdsGrupos.get(i));
			for(int j=0;j<ugu.size();j++){
				Usuario usuario=usuarioDao.findById(ugu.get(j).getIdUsuario());
				List<ListItem> li=listItemDao.findByUsuario(usuario.getId());
				for(int k=0;k<li.size();k++){
					if(!ll.contains(li.get(k).getId())){
						ll.add(li.get(k));
					}
				}
			}
		}
		List<ListItem> liAux=listItemDao.findByUsuario(idUsuario);
		for(int i=0;i<liAux.size();i++){
			for(int j=0;j<ll.size();j++){
				if(liAux.get(i).getId()==ll.get(j).getId()){
					ll.remove(j);
					j=-1;
				}
			}
		}
		return ll;	
	}

	public List<UsuarioGrupoUsuario> findAll() throws Exception{
		List<UsuarioGrupoUsuario> listUsuarioGrupoUsuario = dao.all();
		logServico.saveUsuario("Buscar", "Todos os UsuarioGrupoUsuario");
		return listUsuarioGrupoUsuario;	
	}

	public void saveUsuarioGrupoUsuario(UsuarioGrupoUsuario usuarioGrupoUsuario) throws Exception{
		logServico.saveUsuario("Salvar", "Salvar UsuarioGrupoUsuario");
		dao.save(usuarioGrupoUsuario);
	}

	public void removeUsuarioGrupoUsuario(UsuarioGrupoUsuario usuarioGrupoUsuario) throws Exception{
		logServico.saveUsuario("Remover", "Remover UsuarioGrupoUsuario com id:\t"+usuarioGrupoUsuario.getId());
		dao.remove(usuarioGrupoUsuario);
	}

	public void updateUsuarioGrupoUsuario(UsuarioGrupoUsuario usuarioGrupoUsuario) throws Exception{
		logServico.saveUsuario("Atualizar", "Atualizar UsuarioGrupoUsuario com id:\t"+usuarioGrupoUsuario.getId());
		dao.update(usuarioGrupoUsuario);
	}	
}
