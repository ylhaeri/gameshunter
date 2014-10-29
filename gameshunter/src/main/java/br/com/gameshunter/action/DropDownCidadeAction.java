package br.com.gameshunter.action;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.CidadeDAO;
import br.com.gameshunter.DAO.EstadoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Estado;

@ParentPackage("json-default")
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
		EstadoDAO eDao = new EstadoDAO(manager);
		Estado estado = eDao.pega(idE);
		CidadeDAO cDao = new CidadeDAO(manager);
		cidades = cDao.pegaTodos(estado);
		manager.close();
	}

	public void setIdE(Integer idE) {
		this.idE = idE;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}
}