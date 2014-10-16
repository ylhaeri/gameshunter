package br.com.gameshunter.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * A classe {@code Usuario} representa os usuários do sistema.
 * 
 * @author Myho
 * 
 * @since 0.0.1
 */
@Entity
public class Usuario {

	/**
	 * Valor usado para armazenar o email do usuário. {@code email} deve ser a
	 * chave principal no banco de dados.
	 */
	@Id
	private String email;

	/** Valor usado para armazenar o nome completo do usuário. */
	private String nome;

	/** Valor usado para armazenar o apelido usuário. */
	private String apelido;

	/**
	 * Valor usado para armazenar o cpf do usuário . {@code cpf} deve ser um
	 * valor único no banco de dados.
	 */
	@Column(unique = true)
	private String cpf;

	/** Valor usado para armazenar a data de nascimento do usuário */
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	/** Valor usado para armazenar o endereço do usuário */
	private String endereco;

	/** Valor usado para armazenar o telefone do usuário */
	private String telefone;

	/** Valor usado para armazenar o rf do usuário */
	private String rg;

	public String getEmail() {
		return email;
	}

	/**
	 * Define o e-mail do usuário.
	 * 
	 * @param email
	 *            O e-mail que deve ser definido para o usuário
	 * 
	 * @since 0.0.1
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	/**
	 * Define o nome do usuário.
	 * 
	 * @param nome
	 *            O nome que deve ser definido para o usuário
	 * 
	 * @since 0.0.1
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	/**
	 * Define o apelido do usuário.
	 * 
	 * @param apelido
	 *            O apelido que deve ser definido para o usuário
	 * 
	 * @since 0.0.1
	 */
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getCpf() {
		return cpf;
	}

	/**
	 * Define o CPF do usuário.
	 * 
	 * @param cpf
	 *            O cpf que deve ser definido para o usuário
	 * 
	 * @since 0.0.1
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * Define a data de nascimento do usuário.
	 * 
	 * @param dataNascimento
	 *            A data de nascimento que deve ser definida para o usuário
	 * 
	 * @since 0.0.1
	 */
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	/**
	 * Define o endereço do usuário.
	 * 
	 * @param endereco
	 *            O endereço que deve ser definido para o usuário
	 * 
	 * @since 0.0.1
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	/**
	 * Define o telefone do usuário.
	 * 
	 * @param telefone
	 *            O telefone que deve ser definido para o usuário
	 * 
	 * @since 0.0.1
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRg() {
		return rg;
	}

	/**
	 * Define o RG do usuário.
	 * 
	 * @param rg
	 *            O RG que deve ser definido para o usuário
	 * 
	 * @since 0.0.1
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/**
	 * Constructor que deve ser utilizado somente pelas API's do projeto. Use o
	 * constructor que recebe um nome ou todos os atributos.
	 *
	 * @since 0.0.1
	 */
	@Deprecated
	public Usuario() {
	}

	/**
	 * @param nome
	 *            Nome que deve ser definido para o usuário.
	 * 
	 * @since 0.0.1
	 */
	public Usuario(String nome) {

		this.nome = nome;
	}

	/**
	 * @param email
	 *            Email que deve ser definido para o usuário.
	 * @param nome
	 *            Nome que deve ser definido para o usuário.
	 * @param apelido
	 *            Apelido que deve ser definido para o usuário.
	 * @param cpf
	 *            CPF que deve ser definido para o usuário.
	 * @param dataNascimento
	 *            Data de nascimento que deve ser definida para o usuário.
	 * @param endereco
	 *            Endereço que deve ser definido para o usuário.
	 * @param telefone
	 *            Telefone que deve ser definido para o usuário.
	 * 
	 * @since 0.0.1
	 */
	public Usuario(String email, String nome, String apelido, String cpf,
			Calendar dataNascimento, String endereco, String telefone) {

		this.email = email;
		this.nome = nome;
		this.apelido = apelido;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
	}
}