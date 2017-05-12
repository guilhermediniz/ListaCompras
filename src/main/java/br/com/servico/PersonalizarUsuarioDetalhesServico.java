package br.com.servico;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

	@Service("PersonalizarUsuarioDetalhesServico")
	public class PersonalizarUsuarioDetalhesServico implements UserDetailsService{
		static final Logger logger = LoggerFactory.getLogger(PersonalizarUsuarioDetalhesServico.class);
		@Autowired
		private UsuarioServico usuarioServico;
		
		@Transactional(readOnly=true)
		public UserDetails loadUserByUsername(String email)
				throws UsernameNotFoundException {
			User user=null;
			try {
				usuario = usuarioServico.findByEmail(email);
			} catch (Exception e) {
				e.printStackTrace();
				throw new UsernameNotFoundException(e.getMessage());
			}
			return new org.springframework.security.core.userdetails.Usuario(usuario.getEmail(), usuario.getPassword(), 
					true, true, true, true, getGrantedAuthorities(usuario));
		}	
		
		private List<GrantedAuthority> getGrantedAuthorities(Usuario usuario){
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();		
			authorities.add(new SimpleGrantedAuthority("ROLE_ALL"));		
			logger.info("authorities : {}", authorities);
			return authorities;
		}	
}
