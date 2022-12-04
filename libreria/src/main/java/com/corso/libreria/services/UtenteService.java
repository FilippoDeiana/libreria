package com.corso.libreria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corso.libreria.entities.LibroEntity;
import com.corso.libreria.entities.UtenteEntity;
import com.corso.libreria.repositories.LibroRepository;
import com.corso.libreria.repositories.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
	private UtenteRepository utenteRepository;

	public void save(UtenteEntity utente) {

		if (!utente.getNome().isEmpty() && utente.getNome() != null) {
			utenteRepository.save(utente);
		}
	}
	
	public void delete(Long id) {

		utenteRepository.deleteById(id);
		
	}
	
	public UtenteEntity findById(Long id) {

		return utenteRepository.findById(id).orElse(null);
		
	}
	
	public List<UtenteEntity> findAll() {

		return utenteRepository.findAll();
		
	}
	
	
}
