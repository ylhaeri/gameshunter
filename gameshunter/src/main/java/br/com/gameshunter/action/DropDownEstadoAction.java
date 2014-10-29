package br.com.gameshunter.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.EstadoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;

@ParentPackage("json-default")
public class DropDownEstadoAction {

	private List<Estado> estados;
	private Integer idP;

	@Action(value = "pegaEstados", results = {

	@Result(name = "ok", type = "json") })
	public String execute() {

		Pais pais = new Pais();
		pais.setId(idP);

		estados = new EstadoDAO(new JPAUtil().getEntityManager())
				.pegaTodos(pais);
		return "ok";
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setIdP(Integer idP) {
		this.idP = idP;
	}
}