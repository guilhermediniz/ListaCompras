package br.com.servico;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.lista.dao.LogDao;
import br.com.lista.model.Log;
import br.com.lista.model.User;
import br.com.lista.service.UserService;

@Service class LogServico {
	
	@Autowired
	protected LogDao dao;
	@Autowired
	protected UsuarioServico usuarioServico;
	
	public List<Log> findAll(){
		List<Log> logList = dao.all();
		return logList;	
	}

	public void saveUsuario(String type,String descricao) throws Exception {
		Log log=new Log();
		log.setTipo(tipo);
		log.setDescricao(descricao);
		log.setDataCriacao(new Date());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getNome(); 
		Usuario usuarioAux=usuarioServico.findByEmail(email);
		log.setIdUsuario(usuarioAux.getId());
		dao.save(log);
	}
}
