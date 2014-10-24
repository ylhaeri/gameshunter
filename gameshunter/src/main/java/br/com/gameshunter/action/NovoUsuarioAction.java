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

		Calendar dataNasc = Calendar.getInstance();
		System.out.println(nascMes);
		dataNasc.set(nascAno, nascMes, nascDia, 0, 0, 0);
		usuario.setDataNascimento(dataNasc);
		System.out.println(usuario.getDataNascimento().getTime());
		System.out.println(usuario.getNome());
		System.out.println(usuario.getApelido());
		System.out.println(usuario.getSexo());
		System.out.println(usuario.getCpf());
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getRg());
		System.out.println(usuario.getTelefone());
		System.out.println(endereco.formatado());
		return "ok";
	}

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
}