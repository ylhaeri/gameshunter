package br.com.gameshunter.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.CidadeDAO;
import br.com.gameshunter.DAO.EnderecoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.UsuarioDAO;
import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Endereco;
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
	private String dataNasc;
	private Integer idPais;
	private Integer idEstado;
	private Integer idCidade;

	@Action(value = "novoUsuario", results = {

	@Result(name = "ok", location = "usuario-adicionado.jsp"),
			@Result(name = "input", location = "cadastrar-usuario.jsp") })
	public String execute() {
		criaDataNasc();
		criaHashDaSenha();
		adicionaEndereco();

		new UsuarioDAO(JPAUtil.getEntityManager()).iniciaTransaction()
				.salva(usuario).commit().close();
		return "ok";
	}

	private void adicionaEndereco() {
		EntityManager manager = JPAUtil.getEntityManager();
		CidadeDAO cDao = new CidadeDAO(manager);
		EnderecoDAO eDao = new EnderecoDAO(manager);

		Cidade cidade = cDao.pega(idCidade);

		endereco.setCidade(cidade);
		usuario.adicionaEndereco(endereco);

		eDao.iniciaTransaction().salva(endereco).commit();
		manager.close();
	}

	private void criaHashDaSenha() {
		usuario.geraHashDeSenha();
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

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	public Sexo[] getSexo() {
		return Sexo.values();
	}
}