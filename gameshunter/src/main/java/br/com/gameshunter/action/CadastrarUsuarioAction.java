package br.com.gameshunter.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.model.Sexo;

public class CadastrarUsuarioAction {

	@Action(value = "cadastrar-usuario", results = {

	@Result(name = "ok", location = "cadastrar-usuario.jsp") })
	public String execute() {
		return "ok";
	}
	
	public Sexo[] getSexo() {
		return Sexo.values();
	}
}