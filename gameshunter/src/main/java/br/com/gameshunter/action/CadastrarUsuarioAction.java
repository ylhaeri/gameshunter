package br.com.gameshunter.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.gameshunter.model.Sexo;
import br.com.gameshunter.service.UsuarioService;

@Controller
@InterceptorRef("GHDefault")
public class CadastrarUsuarioAction {

	@Autowired
	private UsuarioService service;

	@Action(value = "cadastrar-usuario", results = {

	@Result(name = "ok", location = "cadastrar-usuario.jsp") })
	public String execute() {

		return "ok";
	}

	public Sexo[] getSexo() {
		return Sexo.values();
	}
}