package br.com.gameshunter.action;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.EstadoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.PaisDAO;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;

public class DropDownEstadoCidadeAction {

	private Integer estadoId;
	private List<Integer> estados = Arrays.asList(1,2,3,4,5);

	@Action(value = "pegaEstados", results = {

	@Result(name = "ok", type="redirect", location="cadastrar-usuario") })
	public String execute() {
		System.out.println(estadoId+"arara");
//		populaEstados();
		return "ok";
	}

	private List<Estado> populaEstados() {
		EntityManager manager = new JPAUtil().getEntityManager();
		Pais pais = new PaisDAO(manager).pega(1);
		return new EstadoDAO(manager).pegaTodos(pais);
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	public List<Integer> getEstados() {
		return estados;
	}

	public void setEstados(List<Integer> estados) {
		this.estados = estados;
	}
}