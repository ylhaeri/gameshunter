package br.com.gameshunter.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class DropDownEstadoCidadeAction {

	private Integer estadoId;

	@Action(value = "pegaEstados", results = {

	@Result(name = "ok", type = "httpheader", params = { "status", "200" }) })
	public String execute() {
		System.out.println(estadoId);
		return "ok";
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}
}