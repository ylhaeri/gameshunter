package br.com.gameshunter.action;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.EstadoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.PaisDAO;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;

import com.opensymphony.xwork2.ActionContext;

public class DropDownEstadoAction {

	private Integer idP;

	@Action(value = "carregaEstado", results = {

	@Result(name = "ok", type = "httpheader", params = { "status", "200" }) })
	public String estados() {

		carregaEstados();
		return "ok";
	}

	private void carregaEstados() {
		EntityManager manager = new JPAUtil().getEntityManager();
		PaisDAO pDao = new PaisDAO(manager);
		Pais pais = pDao.pega(idP);
		List<Estado> estados = new EstadoDAO(manager).pegaTodos(pais);
		ActionContext.getContext().getSession().put("estDP", estados);
		manager.close();
	}

	public Integer getIdP() {
		return idP;
	}

	public void setIdP(Integer idP) {
		this.idP = idP;
	}
}