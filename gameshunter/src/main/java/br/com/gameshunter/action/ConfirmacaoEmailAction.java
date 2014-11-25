package br.com.gameshunter.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.dao.JPAUtil;
import br.com.gameshunter.model.Login;

public class ConfirmacaoEmailAction {

	private String code;
	private Login login;

	@Action(value = "confirma-email", results = {
			@Result(name = "ok", location = "confirma.jsp"),
			@Result(name = "erro", location = "/", type = "redirect") })
	public String execute() {
		if (code != null) {
			EntityManager manager = JPAUtil.getEntityManager();
			TypedQuery<Login> query1 = manager.createQuery(
					"select l from LogIn l where l.code = :pCode", Login.class);
			query1.setParameter("pCode", code);

			List<Login> lista1 = query1.getResultList();
			if (!lista1.isEmpty()) {
				this.login = lista1.get(0);

				if (!login.isConfirmado()) {
					login.setConfirmado(true);
					manager.getTransaction().begin();
					manager.merge(login);
					manager.getTransaction().commit();
					return "ok";
				} else
					return "erro";
			} else
				return "erro";
		} else
			return "erro";
	}

	public String getCod() {
		return code;
	}

	public void setCod(String cod) {
		this.code = cod;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
}