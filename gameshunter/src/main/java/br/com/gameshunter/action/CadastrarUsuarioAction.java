package br.com.gameshunter.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.PaisDAO;
import br.com.gameshunter.model.Pais;
import br.com.gameshunter.model.Sexo;

public class CadastrarUsuarioAction {

	private Sexo[] sexo = Sexo.values();
	private List<Integer> dias = new ArrayList<>();
	private List<String> meses = new ArrayList<>();
	private List<Integer> anos = new ArrayList<>();
	private List<Pais> paises = new ArrayList<>();

	@Action(value = "cadastrar-usuario", results = {

	@Result(name = "ok", location = "../../cadastrar-usuario.jsp") })
	public String execute() {
		adicionaDias();
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

	public List<Integer> getDias() {
		return dias;
	}

	public void setDias(List<Integer> dias) {
		this.dias = dias;
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

	public void adicionaDias() {
		for (int a = 1; a <= 31; a++)
			dias.add(a);
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

	public static void main(String[] args) {
		CadastrarUsuarioAction teste = new CadastrarUsuarioAction();
		teste.adicionaPaises();
		List<Pais> paises = teste.getPaises();
		System.out.println(paises.size() + "      " + paises.get(0).getNome());
	}
}