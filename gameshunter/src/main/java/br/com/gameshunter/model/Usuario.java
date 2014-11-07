package br.com.gameshunter.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * A classe {@code Usuario} representa os usuários do sistema.
 * 
 * @author Myho
 * 
 * @since 0.0.1
 */
@Validations
@Entity
public class Usuario {

	/** Chave principal do banco */
	@Id
	private String email;
	private String nome;
	private String apelido;
	private String senha;
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
		return senha;
	}

	/** @param senha */
	@RequiredStringValidator(key = "usuario.senha.vazia")
	public void setSenha(String senha) {
		this.senha = senha;
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
	public void removeEndereco(Integer numero) {

		enderecos.remove(pegaEndereco(numero));
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

		removeEndereco(numero);
		adicionaEndereco(alterado);
	}

	/**
	 * Gera hash da senha do usuário
	 */
	public void geraHashedSenha() {
		// FIXME
		this.senha = encrypt(this.senha);
	}

	/**
	 * Gera o hash code e criptografa uma String
	 * 
	 * @param string
	 *            string que deve ser ser criptografada
	 * @return string criptografada
	 */
	private String encrypt(String string) {
		// FIXME
		MessageDigest digester;
		try {
			digester = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException();
		}
		digester.update(string.getBytes());
		byte[] hash = digester.digest();
		return codificador(hash);
	}

	/**
	 * Realiza a criptografia dos bytes recebidos
	 * 
	 * @param hash
	 *            bytes que defem ser codificados.
	 * @return string codificada.
	 */
	private String codificador(byte[] hash) {
		// FIXME
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			if ((0xff & hash[i]) < 0x10) {
				hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
			} else {
				hexString.append(Integer.toHexString(0xFF & hash[i]));
			}
		}
		return hexString.toString();
	}

	/**
	 * Verifica se o endereço pode ou não ser adicionado
	 * 
	 * @param endereco
	 *            Endereço que que será analisado.
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
		this.senha = senha;
		this.sexo = sexo;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.enderecos = enderecos;
		this.telefone = telefone;
	}
}