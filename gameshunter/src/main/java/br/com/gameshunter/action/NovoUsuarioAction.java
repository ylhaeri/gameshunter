package br.com.gameshunter.action;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.CidadeDAO;
import br.com.gameshunter.DAO.EnderecoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.UsuarioDAO;
import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.Usuario;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@Validations
public class NovoUsuarioAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Endereco endereco;
	private Integer nascDia;
	private Integer nascMes;
	private Integer nascAno;
	private Integer idPais;
	private Integer idEstado;
	private Integer idCidade;

	@Action(value = "novoUsuario", results = {

	@Result(name = "ok", location = "usuario-adicionado.jsp"),
			@Result(name = "input", location = "cadastrar-usuario.jsp") })
	public String execute() {
		dataNasc();
		criaSenha();
		adicionaEndereco();

		new UsuarioDAO(new JPAUtil().getEntityManager()).iniciaTransaction()
				.salva(usuario).commit().close();
		return "ok";
	}

	private void adicionaEndereco() {
		EntityManager manager = new JPAUtil().getEntityManager();
		CidadeDAO cDao = new CidadeDAO(manager);
		EnderecoDAO eDao = new EnderecoDAO(manager);

		Cidade cidade = cDao.pega(idCidade);

		endereco.setCidade(cidade);
		endereco.setEstado(cidade.getEstado());
		endereco.setPais(cidade.getEstado().getPais());
		usuario.adicionaEndereco(endereco);

		eDao.iniciaTransaction().salva(endereco).commit();
		manager.close();
	}

	private void criaSenha() {
		usuario.geraHashedSenha();
	}

	private void dataNasc() {
		Calendar dataNasc = Calendar.getInstance();
		dataNasc.set(nascAno, nascMes, nascDia, 0, 0, 0);
		usuario.setDataNascimento(dataNasc);
	}

	@VisitorFieldValidator
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getNascDia() {
		return nascDia;
	}

	public void setNascDia(Integer nascDia) {
		this.nascDia = nascDia;
	}

	public Integer getNascMes() {
		return nascMes;
	}

	public void setNascMes(Integer nascMes) {
		this.nascMes = nascMes;
	}

	public Integer getNascAno() {
		return nascAno;
	}

	public void setNascAno(Integer nascAno) {
		this.nascAno = nascAno;
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
}