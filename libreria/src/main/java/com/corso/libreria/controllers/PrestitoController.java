package com.corso.libreria.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corso.libreria.entities.PrestitoEntity;
import com.corso.libreria.entities.UtenteEntity;
import com.corso.libreria.services.LibroService;
import com.corso.libreria.services.PrestitoService;
import com.corso.libreria.services.UtenteService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/prestito")
@Slf4j
public class PrestitoController {

	@Autowired
	private PrestitoService prestitoService;
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private LibroService libroService;
	
	@GetMapping("/add/{id}")
	public String create(@PathVariable Long id, Model model) {

		PrestitoEntity prestito = new PrestitoEntity();
		model.addAttribute("prestito", prestito);
		model.addAttribute("libri", libroService.findAll());
		model.addAttribute("utente", utenteService.findById(id));
		
		return "createPrestito";
	}
	
	@PostMapping("/add/{id}")
	public String save(@PathVariable Long id, String inizio, String fine, Long id_libro , Model model) {
		 
		PrestitoEntity prestito = new PrestitoEntity();
		prestito.setInizio(LocalDate.parse(inizio, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		prestito.setFine(LocalDate.parse(fine, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        prestito.setUtente(utenteService.findById(id));
        prestito.setLibro(libroService.findById(id_libro));
      
        
		prestitoService.save(prestito);
		
		model.addAttribute("prestito", prestito);
		
		return "redirect:/utente/" + id;
	}
	
}
