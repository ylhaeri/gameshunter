package br.com.gameshunter.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.main.CriaXMLCidadePaisEstado;

public class TesteAction {

	@Action(value = "criaXmlLugares", results = {

	@Result(name = "ok", type = "httpheader", params = { "status", "200" }) })
	public String execute() {
		CriaXMLCidadePaisEstado.criaArquivos();

		return "ok";
	}
}