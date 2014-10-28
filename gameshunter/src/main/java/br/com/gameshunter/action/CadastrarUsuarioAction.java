package br.com.gameshunter.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.PaisDAO;
import br.com.gameshunter.model.Pais;
import br.com.gameshunter.model.Sexo;

public class CadastrarUsuarioAction {

	private Sexo[] sexo = Sexo.values();
	private List<String> meses = new ArrayList<>();
	private List<Integer> anos = new ArrayList<>();
	private List<Pais> paises = new ArrayList<>();

	@Action(value = "cadastrar-usuario", results = {

	@Result(name = "ok", location = "cadastrar-usuario.jsp") })
	public String execute() {
		adicionaMeses();
		adicionaAnos();
		adicionaPaises();
		return "ok";
	}

	private void adicionaPaises() {
		PaisDAO pDao = new PaisDAO(new JPAUtil().getEntityManager());
		this.paises = pDao.pegaTodos();
		pDao.close();
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

	private void adicionaAnos() {
		for (int a = 2004; a >= 1900; a--)
			anos.add(a);
	}

	private void adicionaMeses() {
		meses.add("Janeiro");
		meses.add("Fevereiro");
		meses.add("Março");
		meses.add("Abril");
		meses.add("Maio");
		meses.add("Junho");
		meses.add("Julho");
		meses.add("Agosto");
		meses.add("Setembro");
		meses.add("Outubro");
		meses.add("Novembro");
		meses.add("Dezembro");
	}

	private Integer itens;

	public Integer getItens() {
		return itens;
	}

	public void setItens(Integer itens) {
		this.itens = itens;
	}

	public List<Integer> getArara() {
		List<Integer> lista1 = Arrays.asList(1, 2, 3);
		List<Integer> lista2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(itens);
		if (itens < 10)
			return lista1;
		else
			return lista2;
	}
}