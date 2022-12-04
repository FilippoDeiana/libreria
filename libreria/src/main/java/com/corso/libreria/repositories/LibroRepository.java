package com.corso.libreria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corso.libreria.entities.LibroEntity;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long> {

}
