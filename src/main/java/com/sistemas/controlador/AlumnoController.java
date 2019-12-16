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

import com.sistemas.entidad.Alumno;
import com.sistemas.servicio.AlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	@Autowired
	private AlumnoService alumnoServicio; 
	
	@RequestMapping(value="/poblar", method = RequestMethod.GET)
	public String poblarAlumnos() {
		Alumno a1= new Alumno(10, "Granados", "Moore", "931255821", 
				Date.valueOf("1980-01-01"), "gbenjaminm@sistemas.edu.pe", 
				"Urb. abc", 17.7);
		Alumno a2= new Alumno(20, "Arteaga", "Saenz", "931255822", 
				Date.valueOf("1980-05-11"), "cpelaes@sistemas.edu.pe",
				"Urb. 123", 16.2);
		Alumno a3= new Alumno(30, "Angulo", "Calderon", "931255823", 
				Date.valueOf("1986-02-10"), "calderon12@sistemas.edu.pe",
				"Urb. xyz", 15.2);
		Alumno a4= new Alumno(40, "Camacho", "Miñano", "931255824", 
				Date.valueOf("1980-08-05"), "camacho_miñano@sistemas.edu.pe", 
				"Urb. 789", 14.4);
		Alumno a5= new Alumno(50, "Garcia", "Castillo", "931255825", 
				Date.valueOf("1980-08-05"), "garcia_cast@sistemas.edu.pe", 
				"Urb. 789", 14.4);
		Alumno a6= new Alumno(60, "Castillo", "Aguilar", "931255826", 
				Date.valueOf("1980-08-05"), "castillo_aguilar@sistemas.edu.pe", 
				"Urb. 789", 14.4);
		alumnoServicio.agregar(a1);
		alumnoServicio.agregar(a2);
		alumnoServicio.agregar(a3);
		alumnoServicio.agregar(a4);
		alumnoServicio.agregar(a5);
		alumnoServicio.agregar(a6);
		return "index";
	}
	
	@RequestMapping("/mostrar")
	public String mostarAlumnos() {
		//muestra en consola
		System.out.println("Alumnos en DB:");
		
		for(Alumno x:alumnoServicio.listarTodos()){
			System.out.println(x.toString());
		}
		
		return "index";
	}
	
	@GetMapping(value= {"/", "/index"})
	public String listarAlumnos(Model model) {
		Iterable<Alumno> listadoAlumnos = alumnoServicio.listarTodos();
		
		model.addAttribute("modeloAlumnos", listadoAlumnos);
		
		return "alumnoIndex";
	}
	
	@GetMapping(value = "/nuevo")
	public String mostrarAlumnoFormNuevo(Alumno alumno) {
		return "alumnoFormNuevo";
	}

	@PostMapping(value = "/nuevo")
	public String procesarAlumnoFormNuevo(
			@Valid @ModelAttribute("alumno") Alumno alumno, 
			BindingResult bindingResult,
			Model model) {
		
		if (bindingResult.hasErrors()) {
			// Corregir errores 
			return "alumnoFormNuevo";
		}
		// Si llegamos hasta aqu� es que no hubo errores
		alumnoServicio.agregar(alumno);
		
		return "redirect:/alumno/index";
	}
}
