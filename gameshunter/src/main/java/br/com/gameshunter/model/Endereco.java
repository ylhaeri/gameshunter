package br.com.gameshunter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * Representa um endereço
 * 
 * @author Myho
 */
@Validations
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cep;
	private String logradouro;
	private Integer numero;
	private String complemento = "";
	private String bairro;
	@ManyToOne
	private Cidade cidade;

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
		return cep;
	}

	/** @param cep */
	@RequiredStringValidator(key = "endereco.cep.vazio")
	public void setCep(String cep) {
		this.cep = cep;
	}

	/** @return o logradouro */
	public String getLogradouro() {
		return logradouro;
	}

	/** @param logradouro */
	@RequiredStringValidator(key = "endereco.logradouro.vazio")
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/** @return o número */
	public Integer getNumero() {
		return numero;
	}

	/** @param numero */
	@RequiredFieldValidator(key = "endereco.numero.vazio")
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
	public String getBairro() {
		return bairro;
	}

	/** @param bairro */
	@RequiredStringValidator(key = "endereco.bairro.vazio")
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/** @return a cidade */
	public Cidade getCidade() {
		return cidade;
	}

	/** @param cidade */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	/** @return o estado */
	public Estado getEstado() {
		return cidade.getEstado();
	}

	/** @return o país */
	public Pais getPais() {
		return cidade.getPais();
	}

	/**
	 * Construtor padrão de endereço.
	 */
	public Endereco() {
	}

	/**
	 * Construtor completo de endereço.
	 * 
	 * @param rua
	 * @param numero
	 * @param complemento
	 * @param bairro
	 * @param cidade
	 * @param cep
	 */
	public Endereco(String rua, Integer numero, String complemento,
			String bairro, Cidade cidade, String cep) {
		this.logradouro = rua;
		this.bairro = bairro;
		this.complemento = complemento;
		this.numero = numero;
		this.cidade = cidade;
		this.cep = cep;
	}

	/**
	 * Formata o endereço
	 * 
	 * @return String com o endereço formatado
	 */
	public String formatado() {
		if (complemento.equals(""))
			return logradouro + ", N.°" + numero + " - " + "Bairro " + bairro
					+ " " + cidade.getNome() + "/" + getEstado().getUf()
					+ " CEP: " + cep;
		else
			return logradouro + ", N.°" + numero + " - " + complemento + " - "
					+ "Bairro " + bairro + " " + cidade.getNome() + "/"
					+ getEstado().getUf() + " CEP: " + cep;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result
				+ ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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