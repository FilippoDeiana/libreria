package com.corso.libreria.controllers;

import com.corso.libreria.services.PrestitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.corso.libreria.entities.UtenteEntity;
import com.corso.libreria.services.UtenteService;

@Controller
@RequestMapping("/utente")
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private PrestitoService prestitoService;

	@GetMapping("/lista")
	public String listaLibri(Model model) {

		model.addAttribute("utenti", utenteService.findAll());

		return "listaUtenti";
	}
	
	@GetMapping("/add")
	public String create(Model model) {

		UtenteEntity utente = new UtenteEntity();
		model.addAttribute("utente", utente);
		
		return "createUtente";
	}
	
	@PostMapping("/add")
	public String save(@ModelAttribute UtenteEntity utente, Model model) {

		utenteService.save(utente);
		model.addAttribute("utente", utente);
		
		return "redirect:/utente/lista";
	}


	@GetMapping("/{id}")
	public String utente(@PathVariable Long id, Model model) {

		UtenteEntity utente = new UtenteEntity();
		utente.setId(id);
		model.addAttribute("utente", utenteService.findById(id));


		return "utente";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {

		utenteService.delete(id);
		
		return "redirect:/utente/lista";
	}
	


}
