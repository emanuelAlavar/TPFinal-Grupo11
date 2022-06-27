package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.service.IEmpleadorService;

@Controller
@RequestMapping
public class EmpleadorController {
	@Autowired
	IEmpleadorService empleadorService;
	@Autowired
	private Empleador empleador;
	
	@GetMapping("/nuevoEmpleador")
	public String agregar(Model model) {
		model.addAttribute("empleador", empleador);
		return "nuevo_empleador";
	}
	
	@PostMapping("/saveEmpleador")
	public String guardar(@Valid Empleador empleador, Model model) {
		empleadorService.guardarEmpleador(empleador);
		return "redirect:/inicio";
	}
}
