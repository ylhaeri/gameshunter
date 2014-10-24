package br.com.gameshunter.action;

import java.util.Calendar;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.model.Usuario;

public class CadastrarUsuarioAction {

	private Usuario usuario;
	private Integer dia;
	private Integer mes;
	private Integer ano;

	@Action(value = "novoUsuario", results = {

	@Result(name = "ok", location = "usuario-adicionado.jsp") })
	public String execute() {

		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(ano, mes, dia, 0, 0, 0);
		usuario.setDataNascimento(dataNascimento);
		System.out.println(usuario.getNome());
		System.out.println(usuario.getApelido());
		System.out.println(usuario.getCpf());
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getRg());
		System.out.println(usuario.getTelefone());
		System.out.println(usuario.getDataNascimento().getTime());
		return "ok";
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
}