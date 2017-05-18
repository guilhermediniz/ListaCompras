package br.com.controlador;
import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="alterValues/{idLocalCompra}",method = RequestMethod.POST)
	public ModelAndView alterEndereco(String precos,@PathVariable("idLocalCompra") Long idLocalCompra){
		System.out.println("AQUIII");
		System.out.println(precos);
		ModelAndView modelAndView = new ModelAndView("redirect:/index"); 
		try {
			String[] pricesArray = prices.split(",");
			List<ItemLocalCompraPreco> ippList=itemLocalCompraPrecoServico.findByPlaceBuy(idLocalCompra);
			for(int i=0;i<ippList.size();i++){
				ippList.get(i).setPreco(Float.parseFloat(precosArray[i]));
				itemLocalCompraPrecoServico.updateItemLocalCompraPreco(ippList.get(i));
			}
			List<ItemLocalCompraPreco> itemLocalCompraPrecoList = itemLocalCompraPrecoServico.findByLocalCompra(idLocalCompra);
			for(int i=0;i<itemLocalCompraPrecoList.size();i++){
				itemLocalCompraPrecoServico.updateItemLocalCompraPreco(itemLocalCompraPrecoList.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("500");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/save",  method = RequestMethod.POST)
	public ModelAndView saveLocalCompra(@Valid LocalCompra localcompra, @RequestParam("itemList") String idsItemList, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/localCompra");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getNome(); 
		Data data=new Data();
		try {
			Usuario usuarioAux=servicoUsuario.findByEmail(email);
			localCompra.setUsuarioProprietario(usuarioAux);
			if(localCompra.getId()==null){
			   localCompra.setDataCriacao(data);
			   localCompra.setDataUltimaAlteracao(data);
			   servicoLocalCompra.saveLocalCompra(localcompra);
			}else{
				localCompra.setDataUltimaAlteracao(data);
				servicoLocalCompra.updateLocalCompra(localcompra);
				List<ItemLocalCompraPreco> rpList=itemLocalCompraPrecoServico.findByLocalCompra(localcompra.getId());
				for(int i=0;i<rpList.size();i++){
					itemLocalCompraPrecoServico.removeItemLocalCompraPreco(rpList.get(i));
				}
			}
			String[] ids = idsItemList.split(",");
			for(int i=0;i<ids.length;i++){
				ItemLocalCompraPreco itemLocalCompraPreco= new ItemLocalCompraPreco();
				itemLocalCompraPreco.setDataCriacao(new Data());
				itemLocalCompraPreco.setIdItem(Long.parseLong(ids[i]));
				itemLocalCompraPreco.setIdLocalCompra(localcompra.getId());
				itemLocalCompraPreco.setUsuarioProprietario(usuarioAux);
				itemLocalCompraPrecoServico.saveItemLocalCompraPreco(itemLocalCompraPreco);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("500");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{idLocalCompra}",  method = RequestMethod.GET)
	public ModelAndView loadLocalCompra(@PathVariable Long idLocalCompra) {
		ModelAndView modelAndView = new ModelAndView("LocalCompra/formEdit");
		try {
			LocalCompra localCompraAux=servicoLocalCompra.findById(idLocalCompra);
			modelAndView.addObject("localCompra",localCompraAux);		
			modelAndView.addObject("itemList",itemServico.findAll());
			List<ItemLocalCompraPreco> itemPrecoAuxLisc = itemLocalCompraPrecoServico.findByLocalCompra(idLocalCompra);
			for(int i=0;i<itemPrecoAuxLisc.size();i++){
				itemPrecoAuxLisc.get(i).setNomeItem(itemServico.findById(itemPrecoAuxLisc.get(i).getIdItem()).getNome());
			}
			modelAndView.addObject("itemLocalCompraPrecoList",itemPrecoAuxLisc);
			if(addressPlaceBuyService.findByPlaceBuy(placeBuyAux)==null){
				modelAndView.addObject("endereco",new Endereco());
			}else{
				modelAndView.addObject("endereco",enderecoLocalCompraServico.findByLocalCompra(localCompraAux));
			}
			if(telefoneLocalCompraServico.findByLocalCompra(localCompraAux)==null){
				modelAndView.addObject("telefone",new Telefone());
			}else{
				modelAndView.addObject("telefone",telefoneLocalCompraServico.findByLocalCompra(localCompraAux));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("500");
		}
		return modelAndView;
	}
		
	@RequestMapping(value="/remove/{idLocalCompra}",  method = RequestMethod.GET)
	public ModelAndView removeLocalCompra(@PathVariable Long idLocalCompra) {
		ModelAndView modelAndView = new ModelAndView("redirect:/localCompra");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getNome(); 
		try {
			Usuario usuarioAux=servicoUsuario.findByEmail(email);
			LocalCompra localCompraAux=servicoLocalCompra.findById(idLocalCompra);
			Telefone telefone = telefoneLocalCompraServico.findByPlaceBuy(localCompraAux);
			if(phone!=null){
				telefoneServico.removeTelefone(telefone);
			}
			Endereco endereco = enderecoLocalCompraServico.findByLocalCompra(localCompraAux);
			if(endereco!=null){
				servicoEndereco.removeEndereco(endereco);
			}
			List<EnderecoLocalCompra> apbList=enderecoLocalCompraServico.findByUsuario(usuarioAux.getId());
			for(int i=0;i<apbList.size();i++){
				EnderecoLocalCompra apb=apbList.get(i);
				enderecoLocalCompraServico.removeEnderecoLocalCompra(apb);
			}
			List<TelefoneLocalCompra> ppbList= telefoneLocalCompraServico.findByUsuario(usuarioAux.getId());
			for(int i=0;i<ppbList.size();i++){
				TelefoneLocalCompra ppb=ppbList.get(i);
				telefoneLocalCompraServico.removeTelefoneLocalCompra(ppb);
			}
			List<ItemLocalCompraPreco> ippList=itemLocalCompraPrecoServico.findByLocalCompra(idLocalCompra);
			for(int i=0;i<ippList.size();i++){
				ItemLocalCompraPreco ipp=ippList.get(i);
				itemLocalCompraPrecoServico.removeItemLocalCompraPreco(ipp);
			}
			servicoLocalCompra.removeLocalCompra(servicoLocalCompra.findById(localCompraAux.getId()));
		} catch (Exception e) {
			return new ModelAndView("500");
		}
		return modelAndView;
	}	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(List.class, new PropertyEditorSupport() {
	        @Override
	        public void setAsText(String id) {
	        	try {
	    			String[] ids = id.split(",");
	    			List<ItemLocalCompraPreco> rpList=new ArrayList<ItemLocalCompraPreco>();
	    			for(int i=0;i<ids.length;i++){
	    				if(!ids[i].endsWith("null")){
	    					rpList.add(itemLocalCompraPrecoServico.findById(Long.parseLong(ids[i])));
	    				}
    				}
	    			this.setValue(rpList);
	    		} catch (NumberFormatException e) {
	    			e.printStackTrace();
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	        }
		});
	}
	
	
}
