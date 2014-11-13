package br.com.gameshunter.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.gameshunter.util.ConversorLocalDateDB;
import br.com.gameshunter.util.HashFactory;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * Representa um usário
 * 
 * @author Myho
 */
@Validations
@Entity
public class Usuario {

	@Id
	private String email;
	private String nome;
	private String apelido;
	private String senhaaaawe;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	private String cpf;
	@Convert(converter = ConversorLocalDateDB.class)
	private LocalDate dataNascimento;
	@OneToMany
	private List<Endereco> enderecos = new ArrayList<>(3);
	private String telefone;

	/** @return O e-mail */
	public String getEmail() {
		return email;
	}

	/** @param email */
	@RequiredStringValidator(key = "usuario.email.vazio")
	public void setEmail(String email) {
		this.email = email;
	}

	/** @return O nome */
	public String getNome() {
		return nome;
	}

	/** @param nome */
	@RequiredStringValidator(key = "usuario.nome.vazio")
	public void setNome(String nome) {
		this.nome = nome;
	}

	/** @return O apelido */
	public String getApelido() {
		return apelido;
	}

	/** @param apelido */
	@RequiredStringValidator(key = "usuario.apelido.vazio")
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	/** @return o CPF */
	public String getCpf() {
		return cpf;
	}

	/** @param cpf */
	@RequiredStringValidator(key = "usuario.cpf.vazio")
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
	@RequiredStringValidator(key = "usuario.telefone.vazio")
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/** @return Lista de endereços */
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	/** @param enderecos */
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	/** @return O sexo */
	public Sexo getSexo() {
		return sexo;
	}

	/** @param sexo */
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	/** @return A senha */
	public String getSenha() {
		return senhaaaawe;
	}

	/** @param senha */
	@RequiredStringValidator(key = "usuario.senha.vazia")
	public void setSenha(String senha) {
		this.senhaaaawe = senha;
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
		return enderecos.isEmpty()
				|| (enderecos.size() < 3 && !enderecos.contains(endereco));
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
			throw new IllegalArgumentException(
					"Informe o valor real do elemento");
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
			throw new IllegalArgumentException(
					"Informe o valor real do elemento");
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

	/** Gera o Hash da senha do usuário. */
	public void geraHashDeSenha() {
		this.senhaaaawe = new HashFactory().geraHashedString(this.senhaaaawe);
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
	public Usuario(String email, String nome, String apelido, String senha,
			Sexo sexo, String cpf, LocalDate dataNascimento,
			List<Endereco> enderecos, String telefone) {
		this.email = email;
		this.nome = nome;
		this.apelido = apelido;
		this.senhaaaawe = senha;
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
		result = prime * result
				+ ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((enderecos == null) ? 0 : enderecos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((senhaaaawe == null) ? 0 : senhaaaawe.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
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
		if (senhaaaawe == null) {
			if (other.senhaaaawe != null)
				return false;
		} else if (!senhaaaawe.equals(other.senhaaaawe))
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