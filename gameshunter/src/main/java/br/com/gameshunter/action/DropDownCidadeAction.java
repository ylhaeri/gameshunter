package br.com.gameshunter.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class DropDownCidadeAction {

	private Integer idE;
	
	@Action(value = "carregaCidade", results = {

	@Result(name = "ok", type = "httpheader", params = { "status", "200" }) })
	public String cidades() {

		carregaCidades();
		return "ok";
	}

	private void carregaCidades() {
		System.out.println("Carregando " + idE);
	}

	public Integer getIdE() {
		return idE;
	}

	public void setIdE(Integer idE) {
		this.idE = idE;
	}
}