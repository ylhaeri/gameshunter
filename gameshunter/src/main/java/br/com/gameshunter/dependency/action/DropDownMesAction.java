package br.com.gameshunter.dependency.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

public class DropDownMesAction {

	@Autowired
	private Email email;

	private List<String> meses = new ArrayList<>();

	@Action(value = "pegaMeses", results = { @Result(name = "ok", type = "json") })
	public String execute() throws EmailException {
		System.out.println(email == null);
		email.setSubject("Teste rápido");
		email.setMsg("Ois, mensagem básiquinha procê");
		email.addTo("gabriel.dinizo@hotmail.com");
		email.send();
		pegaMeses();
		return "ok";
	}

	private void pegaMeses() {
		meses.add("Janeiro");
		meses.add("Fevereiro");
		meses.add("Março");
		meses.add("Abril");
		meses.add("Maio");
		meses.add("Junho");
		meses.add("Julho");
		meses.add("Agosto");
		meses.add("Setembro");
		meses.add("Outubro");
		meses.add("Novembro");
		meses.add("Dezembro");
	}

	public List<String> getMeses() {
		return meses;
	}

	public void setMeses(List<String> meses) {
		this.meses = meses;
	}
}