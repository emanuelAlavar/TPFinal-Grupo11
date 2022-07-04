package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.service.IOfertaService;





@Controller
@RequestMapping
public class OfertaController {
	@Autowired
	IOfertaService ofertaService;
	private static final Log LOGGER = LogFactory.getLog(OfertaController.class);
	
	@Autowired
	private Oferta oferta;
	@GetMapping("/perfil")
	public String getIndexPage(Model model) {
		return "perfil_empleador";
	}
	
	@GetMapping("/nuevaOferta")
	public String agregar(Model model) {
		model.addAttribute("oferta", oferta);
		return "nueva_oferta";
	}
	
	@PostMapping("/saveOferta")
	public String guardar(@Valid Oferta oferta, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			return "nueva_oferta";
		
		}
	
		ofertaService.guardarOferta(oferta);
		    return "registro_confirmado";
	}
	
	

	
	@GetMapping("/ofertaEditar/{codigo}")
	public ModelAndView getEditOfertaPage(@PathVariable(value="codigo")int codigo) {
		if(codigo==0) {
			ModelAndView mav = new ModelAndView("redirect:/ofertas");
			return mav;
		}
		ModelAndView mav= new ModelAndView("edicion_oferta");
		Oferta oferta = ofertaService.buscarOferta(codigo);
		mav.addObject("oferta",oferta);
		return mav;
	}
	
	@PostMapping("/ofertaModificar")
	public ModelAndView editarDatosOferta(@Validated @ModelAttribute("oferta")Oferta oferta, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
		LOGGER.info("ocurrio un error"+oferta);
			ModelAndView mav= new ModelAndView("edicion_oferta");
			mav.addObject("oferta",oferta);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ofertas");
		ofertaService.modificarOferta(oferta);
	LOGGER.info("Se ha modificado la oferta codigo: "+oferta.getCodigo());
		return mav;
	}
	
	@GetMapping("/ofertaEliminar/{codigo}")
	public ModelAndView eliminarOferta(@PathVariable("codigo") int codigo) {
		ModelAndView mav=new ModelAndView("redirect:/ofertas");
        ofertaService.eliminarOferta(codigo);
        return mav;
	}
}