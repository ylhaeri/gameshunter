package br.com.gameshunter.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.model.Sexo;

public class CadastrarUsuarioAction {

	private Sexo[] sexo = Sexo.values();
	private List<Integer> dias = new ArrayList<>();
	private List<String> meses = new ArrayList<>();
	private List<Integer> anos = new ArrayList<>();

	@Action(value = "cadastrar-usuario", results = {

	@Result(name = "ok", location = "../../cadastrar-usuario.jsp") })
	public String execute() {
		adicionaDias();
		adicionaMeses();
		adicionaAnos();
		return "ok";
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
}