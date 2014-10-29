package br.com.gameshunter.action;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.CidadeDAO;
import br.com.gameshunter.DAO.EstadoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Estado;

import com.opensymphony.xwork2.ActionContext;

public class DropDownCidadeAction {

	private Integer idE;
	
	@Action(value = "carregaCidade", results = {

	@Result(name = "ok", type = "httpheader", params = { "status", "200" }) })
	public String cidades() {

		carregaCidades();
		return "ok";
	}

	private void carregaCidades() {
		EntityManager manager = new JPAUtil().getEntityManager();
		EstadoDAO eDao = new EstadoDAO(manager);
		Estado estado = eDao.pega(idE);
		CidadeDAO cDao = new CidadeDAO(manager);
		List<Cidade> cidades = cDao.pegaTodos(estado);
		ActionContext.getContext().getSession().put("cidDP", cidades);
		manager.close();
	}

	public Integer getIdE() {
		return idE;
	}

	public void setIdE(Integer idE) {
		this.idE = idE;
	}
}