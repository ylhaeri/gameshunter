package br.com.gameshunter.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.main.CriaXMLCidadePaisEstado;
import br.com.gameshunter.main.PopulaCidadePaisEstadoDb;

public class CriaXMLAction {

	@Action(value = "criaXmlLugares", results = {

	@Result(name = "ok", type = "httpheader", params = { "status", "200" }) })
	public String execute() {
		CriaXMLCidadePaisEstado.criaArquivos();

		return "ok";
	}

	@Action(value = "populaBancoLugares", results = {

	@Result(name = "ok", type = "httpheader", params = { "status", "200" }) })
	public String bancococo() {
		PopulaCidadePaisEstadoDb.popula();
		return "ok";
	}
}