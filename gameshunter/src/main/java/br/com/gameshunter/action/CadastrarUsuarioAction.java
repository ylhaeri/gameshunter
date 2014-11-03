package br.com.gameshunter.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class CadastrarUsuarioAction {

	@Action(value = "cadastrar-usuario", results = {

	@Result(name = "ok", location = "cadastrar-usuario.jsp") })
	public String execute() {
		return "ok";
	}
}