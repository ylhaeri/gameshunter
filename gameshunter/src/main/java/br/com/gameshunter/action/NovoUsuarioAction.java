package br.com.gameshunter.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.Login;
import br.com.gameshunter.model.Logradouro;
import br.com.gameshunter.model.Sexo;
import br.com.gameshunter.model.Usuario;
import br.com.gameshunter.service.LoginService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@Validations
@Controller
@Namespace(value = "/usuario")
public class NovoUsuarioAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Endereco endereco;
	private Login login;
	@Autowired
	private LoginService loginService;
	private String dataNascimento;
	private Logradouro logradouro;
	private String cep;

	@Action(value = "novo", results = {

	@Result(name = "ok", location = "usuario-adicionado.jsp"),
			@Result(name = "input", location = "cadastrar-usuario.jsp") })
	public String execute() {
		criaDataNasc();
		adicionaEndereco();
		System.out.println(usuario.getSexo());

		login.setUsuario(usuario);

		loginService.add(login);
		return "ok";
	}

	private void adicionaEndereco() {
		Logradouro logradouro = (Logradouro) ActionContext.getContext()
				.getSession().get("cep");
		ActionContext.getContext().getSession().remove("cep");

		endereco.setLogradouro(logradouro);
		usuario.adicionaEndereco(endereco);
	}

	private void criaDataNasc() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		TemporalAccessor temporal = fmt.parse(dataNascimento);
		LocalDate data = LocalDate.from(temporal);
		usuario.setDataNascimento(data);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	@VisitorFieldValidator
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	@VisitorFieldValidator
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Login getLogin() {
		return login;
	}

	@VisitorFieldValidator
	public void setLogin(Login login) {
		this.login = login;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNasc) {
		this.dataNascimento = dataNasc;
	}

	public Sexo[] getSexo() {
		return Sexo.values();
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}