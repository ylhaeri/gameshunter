package br.com.gameshunter.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.EstadoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.PaisDAO;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;
import br.com.gameshunter.model.Sexo;

public class EstadoAction {

	private Sexo[] sexo = Sexo.values();
	private List<String> meses = new ArrayList<>();
	private List<Integer> anos = new ArrayList<>();
	private List<Pais> paises = new ArrayList<>();
	private List<Estado> estados = new ArrayList<>();

	@Action(value = "carregaEstado", results = {

	@Result(name = "ok", location = "cadastrar-usuario.jsp") })
	public String execute() {

		adicionaEstado();

		return "ok";
	}

	private void adicionaEstado() {
		Pais p = new Pais();
		p.setId(1);
		EstadoDAO pDao = new EstadoDAO(new JPAUtil().getEntityManager());
		this.estados = pDao.pegaTodos(p);
		pDao.fechaConexao();
	}

	public Sexo[] getSexo() {
		return sexo;
	}

	public void setSexo(Sexo[] sexo) {
		this.sexo = sexo;
	}

	public List<String> getMeses() {
		return meses;
	}

	public void setMeses(List<String> meses) {
		this.meses = meses;
	}

	public List<Integer> getAnos() {
		return anos;
	}

	public void setAnos(List<Integer> anos) {
		this.anos = anos;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

}
