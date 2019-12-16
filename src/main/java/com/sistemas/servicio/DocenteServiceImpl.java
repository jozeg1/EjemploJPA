package com.sistemas.servicio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.entidad.Docente;
import com.sistemas.repositorio.DocenteRepository;

@Service
public class DocenteServiceImpl implements DocenteService {
	@Autowired
	private DocenteRepository docenteRepository;
	
	@Override
	public Docente agregar(Docente entidad) {
		Docente Agregado;
		
		entidad.setCreationTime(new Date());
		entidad.setModificationTime(new Date());
		Agregado = docenteRepository.saveAndFlush(entidad);
		return Agregado;
	}

	@Override
	public List<Docente> listarTodos() {
		List<Docente> result = docenteRepository.findAll();
		
		return result;
	}

	@Override
	public Docente buscar(Long id) {
		Docente result = null;
		Optional<Docente> buscado = docenteRepository.findById(id);
		
		if (buscado.isPresent()){
			result = buscado.get();
		}
		return result;
	}

}
