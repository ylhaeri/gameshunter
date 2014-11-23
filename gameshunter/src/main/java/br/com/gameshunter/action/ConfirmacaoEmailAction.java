package br.com.gameshunter.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.model.LogIn;
import br.com.gameshunter.model.Usuario;

public class ConfirmacaoEmailAction {

	private String cod;
	private Usuario usuario;
	private LogIn login;

	@Action(value = "confirma-email", results = {
			@Result(name = "ok", location = "confirma.jsp"),
			@Result(name = "erro", location = "/", type = "redirect") })
	public String execute() {
		System.out.println(cod == null);
		if (cod != null) {
			EntityManager manager = JPAUtil.getEntityManager();
			TypedQuery<Usuario> query1 = manager.createQuery(
					"select u from Usuario u where u.cod = :pCod",
					Usuario.class);
			query1.setParameter("pCod", cod);

			List<Usuario> lista1 = query1.getResultList();
			if (!lista1.isEmpty()) {
				this.usuario = lista1.get(0);

				TypedQuery<LogIn> query2 = manager.createQuery(
						"select l from LogIn l where l.usuario = :pUser",
						LogIn.class);
				query2.setParameter("pUser", usuario);

				List<LogIn> lista2 = query2.getResultList();
				if (!lista2.isEmpty()) {
					this.login = lista2.get(0);
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
		} else
			return "erro";
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}