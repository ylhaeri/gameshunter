package br.com.gameshunter.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.io.IOUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.stella.bean.validation.CPF;
import br.com.gameshunter.converter.LocalDateDBConverter;
import br.com.gameshunter.system.FileManager;

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
	@NotEmpty(message = "{user.email.empty}")
	private String email;
	@NotEmpty(message = "{user.password.empty}")
	@Size(min = 6, max = 50, message = "{user.password.size}")
	private String senha;
	@NotEmpty(message = "{user.name.empty}")
	@Size(min = 3, max = 50, message = "{user.name.size}")
	private String nome;
	@NotEmpty(message = "{user.nickname.empty}")
	@Size(min = 4, max = 20, message = "{user.nickname.size}")
	private String apelido;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	// TODO deve ser uma classe
	@NotEmpty(message = "{user.cpf.empty}")
	@Size(min = 14, max = 14, message = "{user.cpf.size}")
	@CPF
	private String cpf;
	@NotNull(message = "{user.birth.null}")
	@Convert(converter = LocalDateDBConverter.class)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	// TODO deve ser uma classe
	@NotEmpty(message = "{user.phone.empty}")
	@Size(min = 13, max = 13, message = "{user.phone.size}")
	private String telefone;
	// TODO deve ser uma classe
	@Size(min = 13, max = 14, message = "{user.mobile.size}")
	private String celular;
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE })
	private List<Endereco> enderecos = new ArrayList<>(3);
	private boolean novidadesEmail = true;
	@AssertTrue(message = "{user.terms_of_service.agreement}")
	private boolean concordaTermos;
	@Lob
	private byte[] imagem;

	public static void simNaoValues() {
		List<Boolean> asList = Arrays.asList(true, false);
		System.out.println(asList);
	}

	public static void main(String[] args) {
		Usuario.simNaoValues();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		// TODO Ainda não está sendo gerado o hash
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public boolean isNovidadesEmail() {
		return novidadesEmail;
	}

	public void setNovidadesEmail(boolean novidadesEmail) {
		this.novidadesEmail = novidadesEmail;
	}

	public boolean isConcordaTermos() {
		return concordaTermos;
	}

	public void setConcordaTermos(boolean concordaTermos) {
		this.concordaTermos = concordaTermos;
	}

	public byte[] getImagem() {

		if (this.imagem != null)
			return this.imagem;
		else {
			try {
				File file = new File(FileManager.defaultPath()
						+ "/img/default-profile-picture.jpg");
				InputStream is = new FileInputStream(file);
				return IOUtils.toByteArray(is);
			} catch (IOException e) {
				// TODO Não sei
				e.printStackTrace();
			}
			return null;
		}
	}

	public void setImagem(byte[] imagem) {
		// TODO Precisamos de uma lista com toda imagem que é adicionada.
		this.imagem = imagem;
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
	 * Pega o endereço na lista
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
	 * Remove o endereço da lista
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
		enderecos.set(numero - 1, alterado);
	}

	/** Construtor padrão */
	public Usuario() {
	}

	/**
	 * FIXME Construtor incompleto Construtor completo.
	 * 
	 * @param email
	 * @param nome
	 * @param apelido
	 * @param sexo
	 * @param cpf
	 * @param dataNascimento
	 * @param telefone
	 * @param celular
	 * @param enderecos
	 */
	public Usuario(String email, String nome, String apelido, Sexo sexo,
			String cpf, LocalDate dataNascimento, String telefone,
			String celular, Endereco... enderecos) {
		this.email = email;
		this.nome = nome;
		this.apelido = apelido;
		this.sexo = sexo;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.celular = celular;
		this.enderecos = Arrays.asList(enderecos);
	}

	@Override
	public int hashCode() {
		// FIXME incompleto
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
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// FIXME incompleto
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