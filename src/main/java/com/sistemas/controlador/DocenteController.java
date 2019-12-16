package com.sistemas.controlador;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sistemas.entidad.Docente;
import com.sistemas.servicio.DocenteService;

@Controller
@RequestMapping ("/docente")
public class DocenteController {
	@Autowired
	private DocenteService docenteServicio; 
	
	@RequestMapping(path="/poblar", method=RequestMethod.GET)
	public String poblarDocentes() {
		Docente d1= new Docente((long) 10, "Jorge", "Linares", "95623319", "Sistemas",
							Date.valueOf("1980-01-01"), Date.valueOf("2010-04-03"));
		Docente d2= new Docente((long) 20, "Adriano", "Jimenez", "945244663", "Industrial",
							Date.valueOf("1985-01-02"), Date.valueOf("2006-05-08"));
		Docente d3= new Docente((long) 30, "Juana", "Mendoza", "924587236", "Agronomia",
							Date.valueOf("1970-05-03"), Date.valueOf("2016-07-09"));
		Docente d4= new Docente((long) 40, "Rosa", "Utrilla", "979658137", "Civil",
							Date.valueOf("1965-10-21"), Date.valueOf("2013-04-03"));
		
		docenteServicio.agregar(d1);
		docenteServicio.agregar(d2);
		docenteServicio.agregar(d3);
		docenteServicio.agregar(d4);
		
		return "index";
	}
	
	@RequestMapping(path="/mostrar", method=RequestMethod.GET)
	public String mostarDocentes() {
		//muestra en consola
		System.out.println("Docentes en DB:");
		
		for(Docente x:docenteServicio.listarTodos()){
			System.out.println(x.toString());
		}
		
		return "index";
	}
	
	@GetMapping(value= {"/", "/index"})
	public String listarDocentes(Model model) {
		Iterable<Docente> listadoDocentes = docenteServicio.listarTodos();
		
		model.addAttribute("modeloDocentes", listadoDocentes);
		
		return "docenteIndex";
	}
	
	@GetMapping(value = "/nuevo")
	public String mostrarDocenteFormNuevo(Docente docente) {
		return "docenteFormNuevo";
	}

	@PostMapping(value = "/nuevo")
	public String procesarDocenteFormNuevo(
			@Valid @ModelAttribute("docente") Docente docente, 
			BindingResult bindingResult,
			Model model) {
		
		if (bindingResult.hasErrors()) {
			// Corregir errores 
			return "docenteFormNuevo";
		}
		// Si llegamos hasta aqui es que no hubo errores
		docenteServicio.agregar(docente);
		
		return "redirect:/docente/index";
	}	
}
