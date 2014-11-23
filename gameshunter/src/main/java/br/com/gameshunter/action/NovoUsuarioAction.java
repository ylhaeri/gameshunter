package br.com.gameshunter.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.EnderecoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.UsuarioDAO;
import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.LogIn;
import br.com.gameshunter.model.Logradouro;
import br.com.gameshunter.model.Sexo;
import br.com.gameshunter.model.Usuario;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@Validations
public class NovoUsuarioAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Endereco endereco;
	private LogIn login;
	private String dataNasc;
	private String cep;
	private Logradouro logradouro;
	private String senha;

	@Action(value = "novoUsuario", results = {

	@Result(name = "ok", location = "usuario-adicionado.jsp"),
			@Result(name = "input", location = "cadastrar-usuario.jsp") })
	public String execute() {
		login = new LogIn();

		criaDataNasc();
		adicionaEndereco();

		usuario.geraCod();
		System.out.println(senha == null);
		login.geraSenha(senha);

		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		login.setUsuario(usuario);
		new UsuarioDAO(manager).salva(usuario);
		manager.persist(login);
		manager.getTransaction().commit();
		manager.close();
		return "ok";
	}

	private void adicionaEndereco() {
		EntityManager manager = JPAUtil.getEntityManager();
		TypedQuery<Logradouro> query = manager.createQuery(
				"select l from Logradouro l where l.cep like :pCep",
				Logradouro.class);
		query.setParameter("pCep", cep);
		EnderecoDAO eDao = new EnderecoDAO(manager);

		logradouro = query.getSingleResult();
		endereco.setLogradouro(logradouro);
		usuario.adicionaEndereco(endereco);

		eDao.iniciaTransaction().salva(endereco).commit();
		manager.close();
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