package br.com.gameshunter.action;

import java.util.Calendar;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.Usuario;

public class NovoUsuarioAction {

	private Usuario usuario;
	private Endereco endereco;
	private Integer nascDia;
	private Integer nascMes;
	private Integer nascAno;

	@Action(value = "novoUsuario", results = {

	@Result(name = "ok", location = "usuario-adicionado.jsp") })
	public String execute() {

		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(nascAno, nascMes, nascDia, 0, 0, 0);
		usuario.setDataNascimento(dataNascimento);
		System.out.println(usuario.getNome());
		System.out.println(usuario.getApelido());
		System.out.println(usuario.getSexo());
		System.out.println(usuario.getCpf());
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getRg());
		System.out.println(usuario.getTelefone());
		System.out.println(usuario.getDataNascimento().getTime());
		System.out.println(endereco.formatado());
		return "ok";
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setDia(int nascDia) {
		this.nascDia = nascDia;
	}

	public void setMes(Integer nascMes) {
		this.nascMes = nascMes;
	}

	public void setAno(Integer nascAno) {
		this.nascAno = nascAno;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}