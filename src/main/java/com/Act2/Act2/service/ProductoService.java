package com.Act2.Act2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Act2.Act2.model.Producto;
import com.Act2.Act2.repository.ProductoRepository;

@Service

public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public List<Producto>getAll(){
		return productoRepository.findAll();
	}

}
