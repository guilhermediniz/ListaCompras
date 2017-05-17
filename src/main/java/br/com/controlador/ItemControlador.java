package br.com.controlador;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.lista.model.Item;

@Controller
@RequestMapping("/item")
@Transactional
public class ItemControlador {
	@Autowired
	UserService servicoUsuario;
	@Autowired
	ItemService servicoItem;

	@RequestMapping
	public ModelAndView home(Item item) {
		ModelAndView modelAndView = new ModelAndView("item/list");		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getNome(); 
		try {
			Usuario usuarioAux=servicoUsuario.findByEmail(email);
			modelAndView.addObject("usuario",servicoUsuario.findByEmail(email));
			modelAndView.addObject("listItem",servicoItem.findByUsuario(usuarioAux.getId()));			
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("500");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/save",  method = RequestMethod.POST)
	public ModelAndView saveItem(@Valid Item item,@RequestParam("type") String type,BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/item");
		System.out.println(type);
		Item itemAux = null;
		if(type.equals("comida")){
			itemAux = new Comida();
		}else if(type.equals("bebida")){
			itemAux= new Bebida();
		}	
		if(!type.equals("item")){
			itemAux.setId(item.getId());
			itemAux.setNome(item.getNome());
			itemAux.setMarca(item.getMarca());
			itemAux.setDescricao(item.getDescricao());
			itemAux.setSugestao(item.getSugestao());
			item = itemAux;
		}
		try {
			Date date = new Date();
			if(item.getId()==null){
				item.setDataCriacao(data);
				item.setDataUltimaAlteracao(data);		
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				String email = auth.getNome();
				User usuarioAux=servicoUsuario.findByEmail(email);
				item.setUsuarioProprietario(usuarioAux);
				servicoItem.saveItem(item);
			}else{
				Item itemUpdate=servicoItem.findById(item.getId());
				itemUpdate.setNome(item.getNome());
				itemUpdate.setMarca(item.getMarca());
				itemUpdate.setDescricao(item.getDescricao());
				itemUpdate.setSugestao(item.getSugestao());
				itemUpdate.setDataUltimaAlteracao(data);
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				String email = auth.getNome();
				User usuarioAux=servicoUsuario.findByEmail(email);
				itemUpdate.setUsuarioProprietario(usuarioAux);
				servicoItem.updateItem(itemUpdate);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("500");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}",  method = RequestMethod.GET)
	public ModelAndView loadItem(@PathVariable("id") Long idItem) {
		ModelAndView modelAndView = new ModelAndView("item/form");
		try {
			modelAndView.addObject("item",servicoItem.findById(idItem));
			modelAndView.addObject("listItem",servicoItem.findAll());			
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("500");
		}
		return modelAndView;
	}
		
	@RequestMapping(value="/form",  method = RequestMethod.GET)
	public ModelAndView form(Item item) {
		ModelAndView modelAndView = new ModelAndView("item/form");
		return modelAndView;
	}
	
	@RequestMapping(value="/remove/{id}",  method = RequestMethod.GET)
	public ModelAndView removeItem(@PathVariable("id") Long idItem) {
		ModelAndView modelAndView = new ModelAndView("redirect:/item");
		try {
			servicoItem.remocoItem(servicoItem.findById(idItem));
		} catch (Exception e) {
			return new ModelAndView("500");
		}
		return modelAndView;
	}	
	
}
