package com.corso.libreria.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prestito")
@AllArgsConstructor
@NoArgsConstructor
public class PrestitoEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "inizio")
	private LocalDate inizio;
	
	@Column(name = "fine")
	private LocalDate fine;
	
	@ManyToOne
	@JoinColumn(name = "utente", referencedColumnName = "id")
	@JsonBackReference
	private UtenteEntity utente;
	
	@ManyToOne
	@JoinColumn(name = "libro", referencedColumnName = "id")
	private LibroEntity libro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getInizio() {
		return inizio;
	}

	public void setInizio(LocalDate inizio) {
		this.inizio = inizio;
	}

	public LocalDate getFine() {
		return fine;
	}

	public void setFine(LocalDate fine) {
		this.fine = fine;
	}

	public UtenteEntity getUtente() {
		return utente;
	}

	public void setUtente(UtenteEntity utente) {
		this.utente = utente;
	}

	public LibroEntity getLibro() {
		return libro;
	}

	public void setLibro(LibroEntity libro) {
		this.libro = libro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fine, id, inizio, libro, utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrestitoEntity other = (PrestitoEntity) obj;
		return Objects.equals(fine, other.fine) && Objects.equals(id, other.id) && Objects.equals(inizio, other.inizio)
				&& Objects.equals(libro, other.libro) && Objects.equals(utente, other.utente);
	}

	@Override
	public String toString() {
		return "PrestitoEntity [id=" + id + ", inizio=" + inizio + ", fine=" + fine + ", utente=" + utente + ", libro="
				+ libro + "]";
	}
	
	
}
