package com.corso.libreria.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name="utente")
@AllArgsConstructor
@NoArgsConstructor
public class UtenteEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column (name="nome")
	private String nome;
	
	@OneToMany(mappedBy = "utente", cascade= CascadeType.ALL)
	@JsonManagedReference
	private List<PrestitoEntity> prestito;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PrestitoEntity> getPrestito() {
		return prestito;
	}

	public void setPrestito(List<PrestitoEntity> prestito) {
		this.prestito = prestito;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, prestito);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtenteEntity other = (UtenteEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(prestito, other.prestito);
	}

	@Override
	public String toString() {
		return "UtenteEntity [id=" + id + ", nome=" + nome + ", prestito=" + prestito + "]";
	}
	

}
