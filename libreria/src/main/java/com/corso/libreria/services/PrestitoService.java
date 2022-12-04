package com.corso.libreria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corso.libreria.entities.PrestitoEntity;
import com.corso.libreria.repositories.PrestitoRepository;

import java.util.List;

@Service
public class PrestitoService {

	@Autowired
	private PrestitoRepository prestitoRepository;
	
	public void save (PrestitoEntity prestitoEntity) {
		
		prestitoRepository.save(prestitoEntity);
	}

	public List<PrestitoEntity> findAll () {

		return prestitoRepository.findAll();
	}
	
}
