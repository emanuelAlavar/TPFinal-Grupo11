package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.service.ICiudadanoService;

@Controller
@RequestMapping
public class CiudadanoController {
	@Autowired
	ICiudadanoService ciudadanoService;
	@Autowired
	private Ciudadano ciudadano;
	
	@GetMapping("/nuevoCiudadano")
	public String agregar(Model model) {
		model.addAttribute("ciudadano", ciudadano);
		return "nuevo_ciudadano";
	}
	
	@PostMapping("/saveCiudadano")
	public String guardar(@Valid Ciudadano ciudadano, Model model) {
		ciudadanoService.guardarCiudadano(ciudadano);
		return "redirect:/inicio";
	}
}
