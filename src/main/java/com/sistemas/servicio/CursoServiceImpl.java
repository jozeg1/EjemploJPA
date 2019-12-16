package com.sistemas.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.entidad.Curso;
import com.sistemas.repositorio.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public Curso agregar(Curso entidad) {
		Curso guardado = cursoRepository.saveAndFlush(entidad);
		return guardado;
	}

	@Override
	public List<Curso> listarTodos() {
		List<Curso> result = cursoRepository.findAll();
		return result;
	}

	@Override
	public Curso buscar(Long id) {
		Curso result = null;
		Optional<Curso> buscado = cursoRepository.findById(id);
		
		if (buscado.isPresent()){
			result = cursoRepository.findById(id).get();
		}
		return result;
	}

}
