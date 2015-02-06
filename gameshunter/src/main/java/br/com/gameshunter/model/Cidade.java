package br.com.gameshunter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Representa uma cidade
 * 
 * @author Alex
 */
/**
 * @author Myho
 *
 */
/**
 * @author Myho
 *
 */
@Entity
public class Cidade implements Cep {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@ManyToOne
	private Estado estado;
	private String cep;

	/** @return o id */
	public Integer getId() {
		return id;
	}

	/** @param id */
	public void setId(Integer id) {
		this.id = id;
	}

	/** @return o nome da cidade */
	public String getNome() {
		return nome;
	}

	/** @param nome */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/** @return o estado da cidade */
	public Estado getEstado() {
		return estado;
	}

	/** @param estado */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/* (non-Javadoc)
	 * @see br.com.gameshunter.model.Cep#getCep()
	 */
	@Override
	public String getCep() {
		return cep;
	}

	/** @param cep */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/** @return o pais da cidade */
	public Pais getPais() {
		return estado.getPais();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cidade [id = " + id + ", nome = " + nome + ", estado = " + estado + "]";
	}
}