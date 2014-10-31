package br.com.gameshunter.dependency.action;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.CidadeDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Estado;

public class DropDownCidadeAction {

	private Integer idE;
	private List<Cidade> cidades;

	@Action(value = "carregaCidade", results = {

	@Result(name = "ok", type = "json") })
	public String cidades() {

		carregaCidades();
		return "ok";
	}

	private void carregaCidades() {
		EntityManager manager = new JPAUtil().getEntityManager();

		Estado estado = new Estado();
		estado.setId(idE);

		cidades = new CidadeDAO(manager).pegaTodos(estado);
		manager.close();
	}

	public void setIdE(Integer idE) {
		this.idE = idE;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}
}