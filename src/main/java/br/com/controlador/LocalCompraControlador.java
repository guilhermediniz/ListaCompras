package br.com.controlador;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.lista.model.Address;
import br.com.lista.model.AddressPlaceBuy;
import br.com.lista.model.Phone;
import br.com.lista.model.PhonePlaceBuy;
import br.com.lista.model.User;


@Controller
@RequestMapping("/localCompra")
@Transactional
public class LocalCompraControlador {

	@Autowired
	LocalCompraServico servicoLocalCompra;
	@Autowired
	EnderecoServico servicoEndereco;
	@Autowired
	UsuarioServico servicoUsuario;
	@Autowired
	EnderecoLocalCompraServico enderecoLocalCompraServico;
	@Autowired
	TelefoneLocalCompraServico telefoneLocalCompraServico;
	@Autowired
	TelefoneServico telefoneServico;
	@Autowired
	ItemServico itemServico;
	@Autowired
	ItemLocalCompraPrecoServico itemLocalCompraPrecoServico ;
	
	@RequestMapping(value="/form",  method = RequestMethod.GET)
	public ModelAndView form(LocalCompra LocalCompra) {
		ModelAndView modelAndView = new ModelAndView("localCompra/form");
		try {
			modelAndView.addObject("itemList",itemServico.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("500");
		}
		return modelAndView;
	}
	
	@RequestMapping
	public ModelAndView home(LocalCompra localCompra) {
		ModelAndView modelAndView = new ModelAndView("localCompra/list");		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getNome(); 
		try {
			Usuario usuarioAux=servicoUsuario.findByEmail(email);
			modelAndView.addObject("usuario",servicoUsuario.findByEmail(email));
			List<LocalCompra> localCompraList=servicoLocalCompra.findByUsuario(usuarioAux.getId());
			for(int i=0;i<localCompraList.size();i++){
				localCompraList.get(i).updateItemList(itemLocalCompraPrecoServico);
			}			
			modelAndView.addObject("localCompraList",localCompraList);			
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("500");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="alterTelefone/{idLocalCompra}",method = RequestMethod.POST)
	public ModelAndView alterEndereco(@Valid Telefone telefone ,@PathVariable("idLocalCompra") Long idLocalCompra, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView("redirect:/index"); 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getNome(); 
		Usuario usuarioAux;
		try {
			usuarioAux = servicoUsuario.findByEmail(email);
			telefone.setUsuarioProprietario(usuarioAux);
			if(telefone.getId()==null){
				telefoneServico.saveTelefone(telefone);
				TelefoneLocalCompra telefoneLocalCompra=new TelefoneLocalCompra();
				telefoneLocalCompra.setIdTelefone(telefone.getId());
				telefoneLocalCompra.setIdLocalCompra(idLocalCompra);
				Date date=new Date(System.currentTimeMillis());
				telefoneLocalCompra.setDataCriacao(data);
				telefoneLocalCompra.setUsuarioProprietario(usuarioAux);
				telefoneLocalCompraServico.saveTelefoneLocalCompra(telefoneLocalCompra);
			}else{
				telefoneServico.updateTelefone(telefone);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("500");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="alterEndereco/{idLocalCompra}",method = RequestMethod.POST)
	public ModelAndView alterEndereco(@Valid Endereco endereco,@PathVariable("idLocalCompra") Long idLocalCompra, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView("redirect:/index"); 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getNome();
		User userAux;
		try {
			usuarioAux = servicoUsuario.findByEmail(email);
			endereco.setUsuarioProprietario(usuarioAux);
			if(endereco.getId()==null){
				servicoEndereco.saveEndereco(endereco);
				EnderecoLocalCompra enderecoLocalCompra =new EnderecoLocalCompra ();
				enderecoLocalCompra.setIdEndereco(endereco.getId());
				enderecoLocalCompra.setIdLocalCompra(idLocalCompra);
				Data data=new Data(System.currentTimeMillis());
				enderecoLocalCompra.setDataCriacao(data);
				enderecoLocalCompra.setUsuarioProprietario(usuarioAux);
				enderecoLocalCompraServico.saveEnderecoLocalCompra(enderecoLocalCompra);
			}else{
				servicoEndereco.updateEndereco(endereco);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("500");
		}
		
		return modelAndView;
	}
	
	
	
	
	
}
