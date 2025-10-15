package com.Act2.Act2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Act2.Act2.model.Inventario;
import com.Act2.Act2.service.InventarioService;
import com.Act2.Act2.service.ProductoService;
import com.Act2.Act2.util.Alert;

@Controller
@RequestMapping("inventario")

public class InventarioController {
	
	//COMMIT LISTADO
	
	@Autowired
	private InventarioService invServ;
		
	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstInventario",invServ.getAll());
		return "inventario/listado";
	}
	
	
	//COMMIT REGISTRAR Y NUEVO
	
	@Autowired
	private ProductoService proServ;
	
	
	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("lstProducto",proServ.getAll());
		model.addAttribute("inventario", new Inventario());
		return "inventario/nuevo";
	}
	
	@PostMapping("registrar")
	public String registrar(@ModelAttribute Inventario inventario,Model model,RedirectAttributes flash) {
		var response = invServ.create(inventario);
		
		if(!response.success) {
			model.addAttribute("alert",Alert.sweetAlertError(response.mensaje));
			model.addAttribute("lstInventario",invServ.getAll());
			model.addAttribute("lstProducto",proServ.getAll());
			return "inventario/nuevo";
		}
		flash.addFlashAttribute("toast",Alert.sweetToast(response.mensaje,"success",5000));		
		return "redirect:/inventario/listado";
	}

}
