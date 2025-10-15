package com.Act2.Act2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Act2.Act2.dto.ResultadoResponse;
import com.Act2.Act2.model.Inventario;
import com.Act2.Act2.repository.InventarioRepository;

@Service

public class InventarioService {
	
	//COMMIT LISTADO
	
	@Autowired
	private InventarioRepository inventarioRepository;
	
	public List<Inventario> getAll(){
		return inventarioRepository.findByOrderByNumeroDesc();
	}
	
	
	//COMMIT NUEVO Y REGISTRAR
	
	public ResultadoResponse create(Inventario inventario) {
		try {
			Inventario inventarioRegistrado = inventarioRepository.save(inventario);
			
			String mensaje = String.format("Producto registrado con ID %s", inventarioRegistrado.getNumero());
			return new ResultadoResponse(true, mensaje);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Error en InventarioService: "+e.getMessage());
		}
	}
	
	//COMMIT CRUD COMPLETO
	public Inventario getOne(Integer id) {
		return inventarioRepository.findById(id).orElseThrow();
	}
	
	public ResultadoResponse update(Inventario inventario) {
		try {
			Inventario inventarioRegistrado = inventarioRepository.save(inventario);
			
			String mensaje = String.format("Producto actualizado con ID %s",inventarioRegistrado.getNumero());
			return new ResultadoResponse(true,mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Error en InventarioService: "+e.getMessage());
		}
	}
}
