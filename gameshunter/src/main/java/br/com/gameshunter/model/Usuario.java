package br.com.gameshunter.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
	private String cpf;

	/** Valor usado para armazenar a data de nascimento do usuário */
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	/** Variável usada pelas API's para as API's */
	private Endereco endereco;

	private List<Endereco> enderecos = new ArrayList<>(3);

	/** Valor usado para armazenar o telefone do usuário */
	private String telefone;

	/** Valor usado para armazenar o rf do usuário */
	private String rg;

	/**
	 * @return O e-mail
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return O nome
	 */
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

	/**
	 * @return O apelido
	 */
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

	/**
	 * @return o CPF
	 */
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

	/**
	 * @return A data de nascimento
	 */
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

	/**
	 * @return O endereço
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * Usado pelo Hibernate para definir o endereço principal, método delegado
	 * somente
	 * 
	 * @param endereco
	 *            endereço que deve ser definido
	 */
	public void setEndereco(Endereco endereco) {
		enderecoPrincipal(endereco);
	}

	/**
	 * Define o endereço principal do usuário.
	 * 
	 * @param e
	 *            O endereço que deve ser definido para o usuário
	 * 
	 * @since 0.0.1
	 */
	public void enderecoPrincipal(Endereco e) {
		this.endereco = e;
	}

	/**
	 * @return O telefone
	 */
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

	/**
	 * @return o RG
	 */
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
	 * @return Lista de endereços
	 */
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	/**
	 * Método responsável por adicionar novos endereços.
	 * 
	 * @param endereco
	 *            O endereço que deve ser adicionado
	 */
	public void adicionaEndereco(Endereco endereco) {

		if (podeAdicionarEndereco(endereco))
			this.enderecos.add(endereco);
	}

	/**
	 * Método responsável por verificar se o endereço pode ou não ser adicionado
	 * 
	 * @param endereco
	 *            Endereço que deve passar pela verificação.
	 * @return verdadeiro caso possa ser adicionado, falso caso não.
	 */
	private boolean podeAdicionarEndereco(Endereco endereco) {
		return enderecos.isEmpty()
				|| (enderecos.size() < 3 && !enderecos.contains(endereco));
	}

	/**
	 * Constructor que deve ser utilizado somente pelas API's do projeto. Dê
	 * preferência para os constructores que recebem parâmetros.
	 *
	 * @since 0.0.1
	 */
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
			Calendar dataNascimento, Endereco endereco, String telefone) {

		this.email = email;
		this.nome = nome;
		this.apelido = apelido;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
	}
}