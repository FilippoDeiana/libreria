package com.corso.libreria.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name="libro")
@AllArgsConstructor
@NoArgsConstructor
public class LibroEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome")
	private String nome;
    
    @Column(name = "autore")
	private String autore;
	
	
	@OneToMany(mappedBy = "libro",  cascade= CascadeType.ALL)
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


	public String getAutore() {
		return autore;
	}


	public void setAutore(String autore) {
		this.autore = autore;
	}


	public List<PrestitoEntity> getPrestito() {
		return prestito;
	}


	public void setPrestito(List<PrestitoEntity> prestito) {
		this.prestito = prestito;
	}


	@Override
	public int hashCode() {
		return Objects.hash(autore, id, nome, prestito);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibroEntity other = (LibroEntity) obj;
		return Objects.equals(autore, other.autore) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(prestito, other.prestito);
	}


	@Override
	public String toString() {
		return "LibroEntity [id=" + id + ", nome=" + nome + ", autore=" + autore + ", prestito=" + prestito + "]";
	}
	
	
	
}
