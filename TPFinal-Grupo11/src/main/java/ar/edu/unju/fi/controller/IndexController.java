package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.service.ICiudadanoService;

@Controller
public class IndexController {
	@Autowired
	ICiudadanoService ciudadanoService;
	@Autowired
	private Ciudadano ciudadano;
	
	@GetMapping("/inicio")
	public String getIndexPage(Model model) {
		return "index";
	}
	
	@GetMapping("/iniciarSesion")
	public String agregar(Model model) {
		model.addAttribute("ciudadano", ciudadano);

		return "login";
	}
}
