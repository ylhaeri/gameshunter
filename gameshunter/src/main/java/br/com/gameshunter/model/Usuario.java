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
import javax.persistence.Column;
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
import br.com.gameshunter.util.SaltFactory;
import br.com.gameshunter.util.HashFactory;

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
	@Column(length = 128)
	@NotEmpty(message = "{user.password.empty}")
	@Size(min = 6, message = "{user.password.size}")
	private String password;
	private String salt;
	@NotEmpty(message = "{user.name.empty}")
	@Size(min = 3, max = 50, message = "{user.name.size}")
	private String nome;
	@NotEmpty(message = "{user.nickname.empty}")
	@Size(min = 4, max = 20, message = "{user.nickname.size}")
	private String nickname;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender;
	// TODO deve ser uma classe
	@NotEmpty(message = "{user.cpf.empty}")
	@Size(min = 14, max = 14, message = "{user.cpf.size}")
	@CPF
	private String cpf;
	@NotNull(message = "{user.birth.null}")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Convert(converter = LocalDateDBConverter.class)
	private LocalDate birthDay;
	// TODO deve ser uma classe
	@NotEmpty(message = "{user.phone.empty}")
	@Size(min = 13, max = 13, message = "{user.phone.size}")
	private String phone;
	// TODO deve ser uma classe
	@Size(min = 13, max = 14, message = "{user.mobile.size}")
	private String mobile;
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
	private List<Endereco> enderecos = new ArrayList<>(3);
	private boolean newsLetterEmail = true;
	@AssertTrue(message = "{user.terms_of_service.agreement}")
	private boolean agreeTermsOfService;
	@Lob
	private byte[] picture;

	/**
	 * @return email do usuário
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            email do usuário
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return senha do usuário
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter para uso exclusivo da JPA
	 * 
	 * @deprecated Para settar a senha do usuário, deve-se usar o método
	 *             {@link #generatePassword}
	 * 
	 * @param senha
	 *            senha do usuário
	 */
	public void setPassword(String senha) {
		this.password = senha;
	}

	public String getSalt() {
		return salt;
	}

	@SuppressWarnings("unused")
	private void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * Realiza todo o procedimento necessário para garantir maior segurança à
	 * senha do usuário.
	 */
	public void generatePassword() {

		this.salt = SaltFactory.generateSalt();
		this.password = saltedPasswordHash(this.password);
	}

	/**
	 * Confere se a senha informa é igual a senha do usuário
	 * 
	 * @param password
	 *            Senha que vai ser comparada
	 * @return true se for igual, false se for diferente
	 */
	public boolean isPasswordEqual(String password) {

		if (saltedPasswordHash(password).equals(this.password))
			return true;
		else
			return false;
	}

	/**
	 * Gera a senha com o salt
	 * 
	 * @param password
	 * @return
	 */
	private String saltedPasswordHash(String password) {
		String passwordHash = HashFactory.sha512(password);
		return HashFactory.sha512(passwordHash + this.salt);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String apelido) {
		this.nickname = apelido;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender sexo) {
		this.gender = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String telefone) {
		this.phone = telefone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String celular) {
		this.mobile = celular;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public boolean isNewsLetterEmail() {
		return newsLetterEmail;
	}

	public void setNewsLetterEmail(boolean bool) {
		this.newsLetterEmail = bool;
	}

	public boolean isAgreeTermsOfService() {
		return agreeTermsOfService;
	}

	public void setAgreeTermsOfService(boolean bool) {
		this.agreeTermsOfService = bool;
	}

	public byte[] getImage() {

		if (this.picture != null)
			return this.picture;
		else {
			try {
				File file = new File(FileManager.defaultPath() + "/img/default-profile-picture.jpg");
				InputStream is = new FileInputStream(file);
				return IOUtils.toByteArray(is);
			} catch (IOException e) {
				// TODO Não sei
				e.printStackTrace();
			}
			return null;
		}
	}

	public void setImage(byte[] imagem) {
		// TODO Precisamos de uma lista com toda imagem que é adicionada.
		this.picture = imagem;
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
	 * Pega o endereço na lista
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
	 * Remove o endereço da lista
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
	 * Altera o endereço desejado
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
	public Usuario(String email, String nome, String apelido, Gender sexo, String cpf, LocalDate dataNascimento,
			String telefone, String celular, Endereco... enderecos) {
		this.email = email;
		this.nome = nome;
		this.nickname = apelido;
		this.gender = sexo;
		this.cpf = cpf;
		this.birthDay = dataNascimento;
		this.phone = telefone;
		this.mobile = celular;
		this.enderecos = Arrays.asList(enderecos);
	}

	@Override
	public int hashCode() {
		// FIXME incompleto
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((birthDay == null) ? 0 : birthDay.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enderecos == null) ? 0 : enderecos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (birthDay == null) {
			if (other.birthDay != null)
				return false;
		} else if (!birthDay.equals(other.birthDay))
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
		if (gender != other.gender)
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
}