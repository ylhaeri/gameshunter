package br.com.gameshunter.dependency.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.PaisDAO;
import br.com.gameshunter.model.Pais;

public class DropDownPaisesAction {

	private List<Pais> paises;

	@Action(value = "pegaPaises", results = {

	@Result(name = "ok", type = "json") })
	public String execute() {
		adicionaPaises();
		System.out.println("Eu");
		return "ok";
	}

	private void adicionaPaises() {
		PaisDAO pDao = new PaisDAO(new JPAUtil().getEntityManager());
		paises = pDao.pegaTodos();
		pDao.close();
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}
}