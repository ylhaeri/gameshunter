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

/**
 * @author Myho
 *
 */
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Email
	@NotEmpty(message = "{user.email.empty}")
	private String email;
	@Column(length = 136)
	@NotEmpty(message = "{user.password.empty}")
	// TODO Tamanho da senha não está sendo validado, precisa resolver
	private String password;
	@NotEmpty(message = "{user.firstName.empty}")
	@Size(max = 50, message = "{user.firstName.size}")
	private String firstName;
	@NotEmpty(message = "{user.lastName.empty}")
	@Size(max = 50, message = "{user.lastName.size}")
	private String lastName;
	@NotEmpty(message = "{user.nickname.empty}")
	@Size(min = 4, max = 20, message = "{user.nickname.size}")
	private String nickname;
	@NotNull(message = "{user.gender.null}")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	// TODO deve ser uma classe e erros de internacionalização.
	@CPF(message = "{user.cpf.invalid}")
	@NotEmpty(message = "{user.cpf.empty}")
	@Size(min = 14, max = 14, message = "{user.cpf.size}")
	private String cpf;
	@NotNull(message = "{user.bday.null}")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Convert(converter = LocalDateDBConverter.class)
	private LocalDate birthDay;
	// TODO deve ser uma classe, provavelmente usaremos uma lista para tel e cel
	@NotEmpty(message = "{user.phone.empty}")
	@Size(min = 13, max = 13, message = "{user.phone.size}")
	private String phone;
	// TODO deve ser uma classe, provavelmente usaremos uma lista para tel e cel
	@Size(min = 13, max = 14, message = "{user.mobile.size}")
	private String mobile;
	@Size(max = 3)
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE })
	private List<Address> addresses;
	private boolean newsLetterEmail = true;
	@AssertTrue(message = "{user.terms_of_service.agreement}")
	private boolean agreeTermsOfService;
	@Lob
	private byte[] profilePicture;

	/** Construtor padrão */
	public User() {
		addresses = new ArrayList<>(3);
	}

	/** @return */
	public String getEmail() {
		return email;
	}

	/** @param email */
	public void setEmail(String email) {
		this.email = email;
	}

	/** @return */
	public String getPassword() {
		return password;
	}

	/**
	 * JPA/Spring's exclusive use. If it is necessary to set a new password, use
	 * the UserService.
	 * 
	 * @param password
	 */
	@Deprecated
	public void setPassword(String password) {
		this.password = password;
	}

	/** @return */
	public String getFirstName() {
		return firstName;
	}

	/** @param firstName */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** @return */
	public String getLastName() {
		return lastName;
	}

	/** @param lastName */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/** @return */
	public String getNickname() {
		return nickname;
	}

	/** @param nickname */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/** @return */
	public Gender getGender() {
		return gender;
	}

	/** @param gender */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/** @return */
	public String getCpf() {
		// FIXME mesmo problema do campo
		return cpf;
	}

	/** @param cpf */
	public void setCpf(String cpf) {
		// FIXME mesmo problema do campo
		this.cpf = cpf;
	}

	/** @return */
	public LocalDate getBirthDay() {
		return birthDay;
	}

	/** @param birthDay */
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	/** @return */
	public String getPhone() {
		return phone;
	}

	/** @param phone */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/** @return */
	public String getMobile() {
		return mobile;
	}

	/** @param celular */
	public void setMobile(String celular) {
		this.mobile = celular;
	}

	/**
	 * JPA's exclusive use. User addresses can only be changed through adding,
	 * changing or removing addresses.
	 * 
	 * @param addresses
	 */
	@Deprecated
	@SuppressWarnings("unused")
	private void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	/** @return */
	public boolean isNewsletterEmail() {
		// FIXME O nome tá péssimo, precisamos mudar o nome desse método, não
		// faz sentido verificar se o cara quer receber e-mail de newsletter
		// nessa bosta
		return newsLetterEmail;
	}

	/** @param bool */
	public void setNewsletterEmail(boolean bool) {
		// FIXME nome
		this.newsLetterEmail = bool;
	}

	public boolean isAgreeTermsOfService() {
		// FIXME O nome tá péssimo, precisamos mudar o nome desse método, não
		// faz sentido verificar se o cara concordou com os termos
		// nessa bosta
		return agreeTermsOfService;
	}

	/** @param bool */
	public void setAgreeTermsOfService(boolean bool) {
		// FIXME nome
		this.agreeTermsOfService = bool;
	}

	/** @return */
	public byte[] getProfilePicture() {
		// TODO Acoplamento muito alto.
		if (this.profilePicture != null)
			return this.profilePicture;
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

	/** @param profilePicture */
	public void setProfilePicture(byte[] profilePicture) {
		// TODO Precisamos de uma lista com toda imagem que é adicionada.
		this.profilePicture = profilePicture;
	}

	/**
	 * Add a new address to user address list
	 * 
	 * @param address
	 */
	public void addAddress(Address address) {
		if (canAdd(address))
			this.addresses.add(address);
	}

	/**
	 * Verify if the address can be added
	 * 
	 * @param address
	 * 
	 * @return True if can be added, false if not
	 */
	private boolean canAdd(Address address) {
		// FIXME Número de endereços hardcoded
		return addresses.isEmpty()
				|| (addresses.size() < 3 && !addresses.contains(address));
	}

	/**
	 * Get the address in the list
	 * 
	 * @param index
	 * 
	 * @return Endereço
	 */
	public Address pegaEndereco(Integer index) {
		return addresses.get(index);
	}

	/**
	 * Remove address from list
	 * 
	 * @param index
	 */
	public void removeAddress(Integer index) {
		addresses.remove(index);
	}

	/**
	 * Update an address. Address is identified by its index
	 * 
	 * @param address
	 *            Address with updated values
	 */
	public void updateAddress(Integer index, Address address) {
		addresses.set(index, address);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (agreeTermsOfService ? 1231 : 1237);
		result = prime * result
				+ ((birthDay == null) ? 0 : birthDay.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + (newsLetterEmail ? 1231 : 1237);
		result = prime * result
				+ ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + Arrays.hashCode(profilePicture);
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
		User other = (User) obj;
		if (agreeTermsOfService != other.agreeTermsOfService)
			return false;
		if (birthDay == null) {
			if (other.birthDay != null)
				return false;
		} else if (!birthDay.equals(other.birthDay))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (gender != other.gender)
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (newsLetterEmail != other.newsLetterEmail)
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (!Arrays.equals(profilePicture, other.profilePicture))
			return false;
		return true;
	}

	public void init() {
		System.out.println("Novo usuario");
	}
}