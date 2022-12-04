package com.corso.libreria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corso.libreria.entities.LibroEntity;
import com.corso.libreria.entities.UtenteEntity;
import com.corso.libreria.services.LibroService;

@Controller
@RequestMapping("/libro")
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	
	
	@GetMapping("/lista")
	public String listaAuto(Model model) {

		model.addAttribute("libri", libroService.findAll());

		return "listaLibri";
	}

	@GetMapping("/add")
	public String create(Model model) {

		LibroEntity libro = new LibroEntity();
		model.addAttribute("libro", libro);
		
		return "createLibro";
	}
	
	@PostMapping("/add")
	public String save(@ModelAttribute LibroEntity libro, Model model) {

		libroService.save(libro);
		model.addAttribute("libro", libro);
		
		return "redirect:/libro/lista";
	}

	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {

		libroService.delete(id);
		
		return "redirect:/libro/lista";
	}

}
