package br.com.gameshunter.dependency.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.model.Logradouro;

public class TesteAction {

	private String cep;
	private Logradouro logradouro;
	private EntityManager manager = JPAUtil.getEntityManager();
	private boolean existe;

	@Action(value = "teste", results = {

	@Result(name = "ok", type = "json") })
	public String execute() {
		this.logradouro = pegaCep();
		manager.close();
		return "ok";
	}

	private Logradouro pegaCep() {
		TypedQuery<Logradouro> query = manager.createQuery(
				"select l from Logradouro l where l.cep like :pCep",
				Logradouro.class);
		query.setParameter("pCep", cep);
		List<Logradouro> pesquisa = query.getResultList();
		if (!pesquisa.isEmpty()) {
			existe = true;
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