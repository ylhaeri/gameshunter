package br.com.gameshunter.dependency.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.UsuarioDAO;
import br.com.gameshunter.model.Usuario;

public class VerificaEmailAction {

	private String email;
	private String mensagem;

	@Action(value = "verificaEmail", results = { @Result(name = "ok", type = "json") })
	public String execute() {

		existeEmail();
		return "ok";
	}

	private void existeEmail() {
		UsuarioDAO uDao = new UsuarioDAO(JPAUtil.getEntityManager());
		Usuario usuario = uDao.pega(email);
		uDao.close();
		if (usuario == null)
			setMensagem("E-mail disponível", "positivo");
		else
			setMensagem("E-mail já cadastrado", "negativo");
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem, String classe) {
		// FIXME
		this.mensagem = "<span id='mailfeed' class=" + classe + ">" + mensagem
				+ "</span>";
	}

	public static void main(String[] args) {

		VerificaEmailAction verifica = new VerificaEmailAction();
		verifica.setMensagem("Osvaldo", "Pinto");
		System.out.println(verifica.getMensagem());
	}
}