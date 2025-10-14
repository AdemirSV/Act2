package com.Act2.Act2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Act2.Act2.model.Inventario;
import com.Act2.Act2.repository.InventarioRepository;

@Service

public class InventarioService {
	
	@Autowired
	private InventarioRepository inventarioRepository;
	
	public List<Inventario> getAll(){
		return inventarioRepository.findByOrderByNumeroDesc();
	}
	
	
	
	
}
