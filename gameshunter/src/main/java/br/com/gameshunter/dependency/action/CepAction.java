package br.com.gameshunter.dependency.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

import br.com.gameshunter.model.Logradouro;

public class CepAction {

	private String cep;
	private Logradouro logradouro;
	@PersistenceContext(unitName = "GamesHunter")
	private EntityManager manager;
	private boolean existe;

	@Action(value = "buscaCep", results = {

	@Result(name = "ok", type = "json") })
	public String execute() {
		this.logradouro = pegaCep();
		manager.close();
		return "ok";
	}

	private Logradouro pegaCep() {
		ActionContext.getContext().getSession().remove("cep");
		TypedQuery<Logradouro> query = manager.createQuery(
				"select l from Logradouro l where l.cep like :pCep",
				Logradouro.class);
		query.setParameter("pCep", cep);
		List<Logradouro> pesquisa = query.getResultList();
		if (!pesquisa.isEmpty()) {
			existe = true;
			ActionContext.getContext().getSession().put("cep", pesquisa.get(0));
			return pesquisa.get(0);
		} else {
			existe = false;
			return null;
		}
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public boolean isExiste() {
		return existe;
	}
}