package br.com.gameshunter.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.RandomStringUtils;

import br.com.gameshunter.util.HashFactory;

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
	private String salt;
	private boolean confirmado = false;

	/** Gera a senha do usuário. */
	public void geraSenha() {
		this.salt = RandomStringUtils.randomAscii(20);
		String hash = HashFactory.sha384(this.senha);
		this.senha = HashFactory.sha512(hash + this.salt);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	@Override
	public String toString() {
		return "LogIn [usuario = " + usuario + ", senha = " + senha + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
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
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!salt.equals(other.salt))
			return false;
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
}