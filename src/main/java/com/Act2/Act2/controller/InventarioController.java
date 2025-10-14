package com.Act2.Act2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Act2.Act2.service.InventarioService;

@Controller
@RequestMapping("inventario")

public class InventarioController {
	
	@Autowired
	private InventarioService invServ;

	
	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstInventario",invServ.getAll());
		return "inventario/listado";
	}

}
