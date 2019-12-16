package com.sistemas.controlador;

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
import com.sistemas.entidad.Curso;
import com.sistemas.servicio.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {
	@Autowired
	private CursoService cursoServicio; 
	
	@RequestMapping(value="/poblar", method = RequestMethod.GET)
	public String poblarCursos() {
		Curso c1= new Curso(1001-0012,20181401, "INGLES II", "impletacion de nuevo idioma",3,2,2,2);
		Curso c2= new Curso(1411-0032,20171401, "COMUNICACION DE DATOS", "Interaccion con redes inalambricas",4,6,2,4);
		Curso c3= new Curso(1411-0034,20171401, "ARQUITECTURA DE SOFTWARE EMPRESARIAL", "Construccio ndel sowftware",4,6,2,4);
		Curso c4= new Curso(1411-0031,20171401, "APLICACIONES DISTRIBUIDAS", "Xreacion de paginas web",4,6,2,4);
		Curso c5= new Curso(1411-0033,20171401, "BASE DE DATOS II", "Creacion de la BD",4,6,2,4);
		Curso c6= new Curso(1411-0035,20171401, "SISTEMAS DE INFORMACION II", "Construccion de modelos de Si",3,6,2,2);
		
		cursoServicio.agregar(c1);
		cursoServicio.agregar(c2);
		cursoServicio.agregar(c3);
		cursoServicio.agregar(c4);
		cursoServicio.agregar(c5);
		cursoServicio.agregar(c6);
		return "index";
	}
	
	@RequestMapping("/mostrar")
	public String mostarCurso() {
		//muestra en consola
		System.out.println("Cursos en DB:");
		
		for(Curso x:cursoServicio.listarTodos()){
			System.out.println(x.toString());
		}
		
		return "index";
	}
	
	@GetMapping(value= {"/", "/index"})
	public String listarAlumnos(Model model) {
		Iterable<Curso> listadoCursos= cursoServicio.listarTodos();
		
		model.addAttribute("modeloCursos", listadoCursos);
		
		return "cursoIndex";
	}
	
	@GetMapping(value = "/nuevo")
	public String mostrarAlumnoFormNuevo(Curso curso) {
		return "cursoFormNuevo";
	}

	@PostMapping(value = "/nuevo")
	public String procesaCursoFormNuevo(
			@Valid @ModelAttribute("curso") Curso curso, 
			BindingResult bindingResult,
			Model model) {
		
		if (bindingResult.hasErrors()) {
			// Corregir errores 
			return "cursoFormNuevo";
		}
		// Si llegamos hasta aqu� es que no hubo errores
		cursoServicio.agregar(curso);
		
		return "redirect:/curso/index";
	}
}
