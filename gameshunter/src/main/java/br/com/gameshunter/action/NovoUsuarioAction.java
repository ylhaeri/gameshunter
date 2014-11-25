package br.com.gameshunter.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import org.apache.struts2.convention.annotation.Action;
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
// @InterceptorRef(value = "GHDefault")
public class NovoUsuarioAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Endereco endereco;
	@Autowired
	private Login login;
	@Autowired
	private LoginService loginService;
	private String dataNasc;
	private String cep;
	private Logradouro logradouro;
	private String senha;

	@SuppressWarnings("deprecation")
	@Action(value = "novoUsuario", results = {

	@Result(name = "ok", location = "usuario-adicionado.jsp"),
			@Result(name = "input", location = "cadastrar-usuario.jsp") })
	public String execute() {
		criaDataNasc();
		adicionaEndereco();

		login.setUsuario(usuario);
		login.setSenha(senha);
		// enderecoService.add(usuario.getEnderecos());
		// usuarioService.add(usuario);
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
		TemporalAccessor temporal = fmt.parse(dataNasc);
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

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Sexo[] getSexo() {
		return Sexo.values();
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}