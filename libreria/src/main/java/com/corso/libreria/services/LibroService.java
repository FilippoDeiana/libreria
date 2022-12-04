package com.corso.libreria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corso.libreria.entities.LibroEntity;
import com.corso.libreria.entities.UtenteEntity;
import com.corso.libreria.repositories.LibroRepository;

@Service
public class LibroService {
	@Autowired
	private LibroRepository libroRepository;

	public void save(LibroEntity libro) {

		if (!libro.getNome().isEmpty() && libro.getNome() != null && !libro.getAutore().isEmpty()
				&& libro.getAutore() != null) {
			libroRepository.save(libro);
		}
	}

	public void delete(Long id) {

		libroRepository.deleteById(id);

	}

	public LibroEntity findById(Long id) {

		return libroRepository.findById(id).orElse(null);
	}

	public List<LibroEntity> findAll() {

		return libroRepository.findAll();
	}

}
