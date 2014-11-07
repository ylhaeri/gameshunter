package br.com.gameshunter.dependency.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.UsuarioDAO;
import br.com.gameshunter.model.Usuario;

public class VerificaEmailAction {

	private String email;
	private boolean disponivel;

	@Action(value = "verificaEmail", results = { @Result(name = "ok", type = "json") })
	public String execute() {

		estaDisponivel();
		return "ok";
	}

	private void estaDisponivel() {
		UsuarioDAO uDao = new UsuarioDAO(JPAUtil.getEntityManager());
		Usuario usuario = uDao.pega(email);
		uDao.close();
		if (usuario == null)
			this.disponivel = true;
		else
			this.disponivel = false;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

}