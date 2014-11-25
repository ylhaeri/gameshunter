package br.com.gameshunter.action;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.Sexo;

@Controller
public class CadastrarUsuarioAction {

	@Action(value = "cadastrar-usuario", results = {

	@Result(name = "ok", location = "cadastrar-usuario.jsp") })
	public String execute() {
		return "ok";
	}

	public Sexo[] getSexo() {
		return Sexo.values();
	}

	public static void main(String[] args) {
		System.out.println(RandomStringUtils.randomAscii(30));
		EntityManager manager = Persistence.createEntityManagerFactory(
				"gameshunter").createEntityManager();
		manager.getTransaction().begin();
		manager.persist(new Endereco());
		manager.getTransaction().commit();
	}
}