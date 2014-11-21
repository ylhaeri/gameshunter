package br.com.gameshunter.dependency.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class TesteAction {

	@Action(value = "teste", results = {

	@Result(name = "ok", type = "json") })
	public String execute() {
		// FIXME
		return "ok";
	}

	public String getNome() {
		return "OsvaldoxD";
	}
}