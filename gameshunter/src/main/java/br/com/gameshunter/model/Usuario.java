package br.com.gameshunter.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	/** Chave principal do banco */
	@Id
	private String email;

	private String nome;
	private String apelido;
	private String cpf;
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	@OneToMany
	private List<Endereco> enderecos = new ArrayList<>(3);

	private String telefone;
	private String rg;

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
	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	/** @param dataNascimento */
	public void setDataNascimento(Calendar dataNascimento) {
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

	/** @return o RG */
	public String getRg() {
		return rg;
	}

	/** @param rg */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/** @return Lista de endereços */
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	/** @param enderecos */
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	/**
	 * Responsável por adicionar novos endereços.
	 * 
	 * @param endereco
	 *            O endereço que deve ser adicionado
	 */
	public void adicionaEndereco(Endereco endereco) {

		if (podeAdicionarEndereco(endereco))
			this.enderecos.add(endereco);
	}

	/**
	 * Responsável por pegar o endereço desejado da lista
	 * 
	 * @param numero
	 *            Indice do endereço na lista
	 * @return Endereço
	 */
	public Endereco pegaEndereco(Integer numero) {

		return enderecos.get(numero);
	}

	/**
	 * Remove o endereço desejado da lista
	 * 
	 * @param enviado
	 *            Indice do endereço na lista
	 */
	public void removeEndereco(Endereco enviado) {

		enderecos.remove(enviado);
	}

	/**
	 * Altera o endereço desejado pelo endereço passado como argumento
	 * 
	 * @param numero
	 *            Indice do endereço na lista
	 * @param alterado
	 *            Endereço alterado para que a troca seja feita
	 */
	public void alteraEndereco(Integer numero, Endereco alterado) {

		removeEndereco(pegaEndereco(numero));
		adicionaEndereco(alterado);
	}

	/**
	 * Verifica se o endereço pode ou não ser adicionado
	 * 
	 * @param endereco
	 *            Endereço que deve passar pela verificação.
	 * 
	 * @return verdadeiro caso possa ser adicionado, falso caso não.
	 */
	private boolean podeAdicionarEndereco(Endereco endereco) {
		return enderecos.isEmpty()
				|| (enderecos.size() < 3 && !enderecos.contains(endereco));
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
	 * @param cpf
	 * @param dataNascimento
	 * @param enderecos
	 * @param telefone
	 */
	public Usuario(String email, String nome, String apelido, String cpf,
			Calendar dataNascimento, List<Endereco> enderecos, String telefone) {
		this.email = email;
		this.nome = nome;
		this.apelido = apelido;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.enderecos = enderecos;
		this.telefone = telefone;
	}

}