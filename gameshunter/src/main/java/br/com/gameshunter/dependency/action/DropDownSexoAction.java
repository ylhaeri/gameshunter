package br.com.gameshunter.dependency.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.model.Sexo;

public class DropDownSexoAction {

	private Sexo[] sexo = Sexo.values();

	@Action(value = "getGender", results = { @Result(name = "ok", type = "json") })
	public String execute() {
		return "ok";
	}

	public Sexo[] getSexo() {
		return sexo;
	}

	public void setSexo(Sexo[] sexo) {
		this.sexo = sexo;
	}
}