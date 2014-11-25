package br.com.gameshunter.dependency.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.gameshunter.model.Usuario;
import br.com.gameshunter.service.UsuarioService;

public class VerificaEmailAction {

	private String email;
	private boolean disponivel;
	@Autowired
	UsuarioService usuarioService;

	@Action(value = "verificaEmail", results = { @Result(name = "ok", type = "json") })
	public String execute() {

		estaDisponivel();
		return "ok";
	}

	private void estaDisponivel() {
		Usuario usuario = usuarioService.find(email);
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