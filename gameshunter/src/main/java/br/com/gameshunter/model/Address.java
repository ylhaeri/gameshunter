package br.com.gameshunter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Representa um endereço
 * 
 * @author Myho
 */
@Entity
public class Address {

	public void init() {
		System.out.println("Novo Endereço");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Logradouro logradouro;
	private Integer numero;
	private String complemento = "";

	/** @return o id */
	public Integer getId() {
		return id;
	}

	/** @param id */
	public void setId(Integer id) {
		this.id = id;
	}

	/** @return o cep */
	public String getCep() {
		return logradouro.getCep();
	}

	/** @return o logradouro */
	public Logradouro getLogradouro() {
		return logradouro;
	}

	/** @param logradouro */
	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	/** @return o número */
	public Integer getNumero() {
		return numero;
	}

	/** @param numero */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/** @return o complemento */
	public String getComplemento() {
		return complemento;
	}

	/** @param complemento */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/** @return O bairro */
	public Bairro getBairro() {
		return logradouro.getBairro();
	}

	/** @return a cidade */
	public Cidade getCidade() {
		return logradouro.getCidade();
	}

	/** @return o estado */
	public Estado getEstado() {
		return logradouro.getEstado();
	}

	/** @return o país */
	public Pais getPais() {
		return logradouro.getPais();
	}

	/**
	 * Construtor padrão de endereço.
	 */
	public Address() {
	}

	/**
	 * Construtor completo de endereço.
	 * 
	 * @param rua
	 * @param numero
	 * @param complemento
	 */
	public Address(Logradouro logradouro, Integer numero, String complemento) {
		this.logradouro = logradouro;
		if (complemento == null)
			this.complemento = "";
		else
			this.complemento = complemento;
		this.numero = numero;
	}

	/**
	 * Formata o endereço
	 * 
	 * @return String com o endereço formatado
	 * @throws Exception
	 */
	public String formatado() throws Exception {
		/*
		 * FIXME Pode esperar, prioridade para os outros
		 * 
		 * Formatos:
		 * 
		 * Se não tiver logradouro
		 * 
		 * Rua Vergueiro, N.° 12 - Bairro Ararinha São Paulo/SP CEP: 12345-678
		 * 
		 * Ou
		 * 
		 * Se tiver logradouro
		 * 
		 * Rua Vergueiro, N.° 12 - Casa A do Julião - Bairro Ararinha São
		 * Paulo/SP CEP: 12345-678
		 * 
		 * Tentar resolver sem if
		 * 
		 * Ou similar
		 */
		throw new Exception();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result
				+ ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Address other = (Address) obj;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
}