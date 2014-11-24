package br.com.gameshunter.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.gameshunter.util.HashFactory;

@Entity
public class LogIn implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@OneToOne
	private Usuario usuario;
	private String senha;
	private boolean confirmado = false;

	public String getSenha() {
		return senha;
	}

	@SuppressWarnings("unused")
	private void setSenha(String senha) {
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
	public void geraSenha(String senha) {
		this.senha = new HashFactory().sha512(senha);
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
		LogIn other = (LogIn) obj;
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
}