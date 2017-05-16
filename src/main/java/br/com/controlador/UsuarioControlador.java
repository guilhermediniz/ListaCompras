package br.com.controlador;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuario")
@Transactional
public class UsuarioControlador {
	
	@Autowired
	UserService servicoUsuario;
	@Autowired
	AddressUserService enderecoUsuarioServico;
	@Autowired
	AddressService servicoEndereco;
	@Autowired
	PhoneUserService telefoneUsuarioServico;
	@Autowired
	PhoneService telefoneServico;
	@Autowired
	SenderMail senderMail;
	
	@RequestMapping (value="/register", method=RequestMethod.GET)
	public ModelAndView register(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuario/register");		
		return modelAndView;
	}
	
	@RequestMapping(value="alterTelefone",method = RequestMethod.POST)
	public ModelAndView alterAddress(@Valid Telefone telefone,BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView("redirect:/index"); 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getNome(); 
		User usuarioAux;
		try {
			usuarioAux = servicoUsuario.findByEmail(email);
			telefone.setUsuarioProprietario(usuarioAux);
			if(telefone.getId()==null){
				telefoneServico.saveTelefone(telefone);
				TelefoneUsuario telefoneUsuario=new TelefoneUsuario();
				telefoneUsuario.setIdTelefone(telefone.getId());
				telefoneUsuario.setIdUsuario(usuarioAux.getId());
				Date date=new Date(System.currentTimeMillis());
				telefoneUsuario.setDataCriacao(date);
				telefoneUsuario.setUsuarioProprietario(usuarioAux);
				telefoneUsuarioServico.saveTelefoneUsuario(telefoneUsuario);
			}else{
				telefoneServico.updateTelefone(telefone);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("500");
		}
		return modelAndView;
	}	
		
	@RequestMapping(value="alterEndereco",method = RequestMethod.POST)
	public ModelAndView alterEndereco(@Valid Endereco endereco,BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView("redirect:/index"); 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getNome(); 
		Usuario usuarioAux;
		try {
			usuarioAux = servicoUsuario.findByEmail(email);
			endereco.setUsuarioProprietario(usuarioAux);
			if(endereco.getId()==null){
				servicoEndereco.saveEndereco(endereco);
				EnderecoUsuario enderecoUsuario=new EnderecoUsuario();
				enderecoUsuario.setIdEndereco(endereco.getId());
				enderecoUsuario.setIdUsuario(usuarioAux.getId());
				Date date=new Date(System.currentTimeMillis());
				enderecoUsuario.setDataCriacao(data);
				enderecoUsuario.setUsuarioProprietario(usuarioAux);
				enderecoUsuarioServico.saveEnderecoUsuario(enderecoUsuario);
			}else{
				servicoEndereco.updateEndereco(endereco);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("500");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/save",  method = RequestMethod.POST)
	public ModelAndView saveUsuario(@Valid Usuario usuario, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/login");
		String password=usuario.getPassword();
		try {
			if(usuario.getId()==null){
				servicoUsuario.saveUsuario(usuario);
				String subjectEmail = "Cadastro realizado com sucesso!";
				String msgEmail = usuario.getNome() + ", seu cadastro foi realizado com sucesso!\nSua senha é:\t"+password;
				senderMail.enviarEmailParaUsuario(usuario.getEmail(), subjectEmail, msgEmail);
			}else{
				servicoUsuario.updateUsuario(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("500");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/edit",  method = RequestMethod.GET)
	public ModelAndView loadUsuario() {
		ModelAndView modelAndView = new ModelAndView("user/form");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getNome(); 
		try {
			Usuario usuarioAux=servicoUsuario.findByEmail(email);
			modelAndView.addObject("usuario",usuarioAux);
			if(enderecoUsuarioServico.findByUser(usuarioAux)==null){
				modelAndView.addObject("endereco",new Endereco());
			}else{
				modelAndView.addObject("endereco",enderecoUsuarioServico.findByUsuario(usuarioAux));
			}
			if(telefoneUsuarioServico.findByUsuario(usuarioAux)==null){
				modelAndView.addObject("telefone",new Telefone());
			}else{
				modelAndView.addObject("telefone",telefoneUsuarioServico.findByUsuario(usuarioAux));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("500");
		}
		return modelAndView;
	}
		
	@RequestMapping(value="/remove",  method = RequestMethod.GET)
	public ModelAndView removeUsuario() {
		ModelAndView modelAndView = new ModelAndView("redirect:/logout");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getNome(); 
		try {
			Usuario usuarioAux=servicoUsuario.findByEmail(email);
			servicoUsuario.removeUsuario(servicoUsuario.findById(usuarioAux.getId()));
		} catch (Exception e) {
			return new ModelAndView("500");
		}
		return modelAndView;
	}		
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
	        @Override
	        public void setAsText(String date) {
	        	try {
	    			String[] dates = date.split("/");
	    			@SuppressWarnings("deprecation")
					Date dateAux=new Date(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
	    			this.setValue(dateAux);
	    		}catch (Exception e) {
	    			e.printStackTrace();
	    		}
	        }
		});
	}	
}
