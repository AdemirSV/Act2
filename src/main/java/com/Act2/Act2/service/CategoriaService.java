package com.Act2.Act2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Act2.Act2.model.Categoria;
import com.Act2.Act2.repository.CategoriaRepository;

@Service

public class CategoriaService {
	
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAll(){
		return categoriaRepository.findAll();
	}

}
