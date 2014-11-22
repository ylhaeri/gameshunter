package br.com.gameshunter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Representa um país
 * 
 * @author Alex
 */
@Entity
@XStreamAlias("país")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XStreamOmitField
	private Integer id;
	private String nome;
	private String sigla;

	/** @return o id */
	public Integer getId() {
		return id;
	}

	/** @param id */
	public void setId(Integer id) {
		this.id = id;
	}

	/** @return o nome */
	public String getNome() {
		return nome;
	}

	/** @param nome */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/** @return a sigla */
	public String getSigla() {
		return sigla;
	}

	/** @param sigla */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Pais other = (Pais) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + ", sigla=" + sigla + "]";
	}
}