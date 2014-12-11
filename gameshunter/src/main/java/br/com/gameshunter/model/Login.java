package br.com.gameshunter.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.RandomStringUtils;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

import br.com.gameshunter.util.HashFactory;

@Validations
@Entity
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	public void init() {
		System.out.println("Novo login");
	}

	@Id
	@OneToOne
	private Usuario usuario;
	private String senha;
	private String code;
	private String salt;
	private boolean confirmado = false;

	public String getSenha() {
		return senha;
	}

	@Deprecated
	@RequiredStringValidator(key = "login.senha.vazia")
	@StringLengthFieldValidator(minLength = "6", maxLength = "60", key = "login.senha.invalida")
	public void setSenha(String senha) {
		System.out.println(senha == null);
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Gera a senha do usuário.
	 * 
	 * @param senha
	 */
	public void geraSenha() {
		this.salt = RandomStringUtils.randomAscii(20);
		String hash = HashFactory.sha384(this.senha);
		this.senha = HashFactory.sha512(hash + this.salt);
	}

	/** Gera o código do usuário */
	public void geraCod() {
		this.code = HashFactory.sha384(this.usuario.getNome()
				+ this.usuario.getEmail());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Login other = (Login) obj;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LogIn [usuario = " + usuario + ", senha = " + senha + "]";
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
}