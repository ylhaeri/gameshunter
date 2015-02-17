package br.com.gameshunter.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.gameshunter.conversor.ConversorLocalDateDB;

/**
 * Representa um usuário
 * 
 * @author Myho
 */
@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public void init() {
		System.out.println("Novo usuario");
	}

	@Id
	@Email
	@NotEmpty
	private String email;
	@Size(min = 7, max = 50)
	@NotEmpty
	private String nome;
	@NotEmpty
	private String apelido;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@NotEmpty
	private String cpf;
	@NotNull
	@Convert(converter = ConversorLocalDateDB.class)
	private LocalDate dataNascimento;
	@NotEmpty
	@Size(min = 13, max = 13)
	private String telefone;
	@OneToMany
	private List<Endereco> enderecos = new ArrayList<>(3);

	/** @return O e-mail */
	public String getEmail() {
		return email;
	}

	/** @param email */
	public void setEmail(String email) {
		this.email = email;
	}

	/** @return O nome */
	public String getNome() {
		return nome;
	}

	/** @param nome */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/** @return O apelido */
	public String getApelido() {
		return apelido;
	}

	/** @param apelido */
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	/** @return o CPF */
	public String getCpf() {
		return cpf;
	}

	/** @param cpf */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/** @return A data de nascimento */
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	/** @param dataNascimento */
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/** @return O telefone */
	public String getTelefone() {
		return telefone;
	}

	/** @param telefone */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/** @return Lista de endereços */
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	/** @return O sexo */
	public Sexo getSexo() {
		return sexo;
	}

	/** @param sexo */
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	/**
	 * Responsável por adicionar novos endereços.
	 * 
	 * @param endereco
	 *            O endereço que deve ser adicionado
	 */
	public void adicionaEndereco(Endereco endereco) {

		if (podeAdicionar(endereco))
			this.enderecos.add(endereco);
	}

	/**
	 * Verifica se o endereço pode ser adicionado
	 * 
	 * @param endereco
	 *            Endereço que que será analisado.
	 * 
	 * @return verdadeiro caso possa ser adicionado, falso caso não.
	 */
	private boolean podeAdicionar(Endereco endereco) {
		return enderecos.isEmpty() || (enderecos.size() < 3 && !enderecos.contains(endereco));
	}

	/**
	 * Responsável por pegar o endereço desejado da lista
	 * 
	 * @param numero
	 *            Indice real do endereço na lista
	 * @return Endereço
	 */
	public Endereco pegaEndereco(Integer numero) {

		if (numero < 1)
			throw new IllegalArgumentException("Informe o valor real do elemento");
		return enderecos.get(numero - 1);
	}

	/**
	 * Remove o endereço desejado da lista
	 * 
	 * @param enviado
	 *            Indice real do endereço na lista
	 */
	public void removeEndereco(Integer numero) {
		if (numero < 1)
			throw new IllegalArgumentException("Informe o valor real do elemento");
		enderecos.remove(numero - 1);
	}

	/**
	 * Altera um endereço pelo endereço passado
	 * 
	 * @param alterado
	 *            Endereço alterado para que a troca seja feita
	 */
	public void alteraEndereco(Integer numero, Endereco alterado) {
		// FIXME
		removeEndereco(numero);
		adicionaEndereco(alterado);
	}

	/** Construtor padrão */
	public Usuario() {
	}

	/**
	 * Construtor completo de usuário.
	 * 
	 * @param email
	 * @param nome
	 * @param apelido
	 * @param sexo
	 * @param cpf
	 * @param dataNascimento
	 * @param enderecos
	 * @param telefone
	 */
	public Usuario(String email, String nome, String apelido, Sexo sexo, String cpf, LocalDate dataNascimento,
			List<Endereco> enderecos, String telefone) {
		this.email = email;
		this.nome = nome;
		this.apelido = apelido;
		this.sexo = sexo;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.enderecos = enderecos;
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enderecos == null) ? 0 : enderecos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Usuario other = (Usuario) obj;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enderecos == null) {
			if (other.enderecos != null)
				return false;
		} else if (!enderecos.equals(other.enderecos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo != other.sexo)
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
}