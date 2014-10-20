package br.com.gameshunter.builder;

import java.util.Calendar;

import br.com.gameshunter.model.Usuario;

/**
 * Classe responsável por criar objetos do tipo Usuário sem expor totalmente ao
 * código, somente necessitando dos parâmetros
 * 
 * @author Myho
 *
 * @since 0.0.1
 */
public class UsuarioBuilder {

	/**
	 * Usuário que será retornado pelo Builder quando o método constroi for
	 * invocado.
	 */
	private Usuario usuario = new Usuario();

	/**
	 * Recebe os dados de identificação do usuário
	 * 
	 * @param nome
	 *            Nome do Usuário
	 * @param apelido
	 *            Apelido do Usuário
	 * @param dataDeNascimento
	 *            Data de nascimento do Usuário
	 * @return Ele mesmo
	 */
	public UsuarioBuilder comDados(String nome, String apelido,
			Calendar dataDeNascimento) {

		this.usuario.setNome(nome);
		this.usuario.setApelido(apelido);
		this.usuario.setDataNascimento(dataDeNascimento);
		return this;
	}

	/**
	 * Recebe as formas de contato do usuário
	 * 
	 * @param email
	 *            Email do usuário
	 * @param telefone
	 *            Telefone do usuário
	 * @return Ele mesmo
	 */
	public UsuarioBuilder comContato(String email, String telefone) {

		this.usuario.setEmail(email);
		this.usuario.setTelefone(telefone);
		return this;
	}

	/**
	 * Recebe os documentos do usuário
	 * 
	 * @param cpf
	 *            CPF do usuário
	 * @param rg
	 *            RG do usuário
	 * @return Ele mesmo
	 */
	public UsuarioBuilder comDocumentos(String cpf, String rg) {

		this.usuario.setCpf(cpf);
		this.usuario.setRg(rg);
		return this;
	}

	/**
	 * Recebe o endereço do usuário
	 * 
	 * @param endereco
	 *            Endereço do Usuário
	 * @return Ele mesmo
	 */
	public UsuarioBuilder comEndereco(String endereco) {

		// this.usuario.setEndereco(endereco);
		return this;
	}

	/**
	 * Retorna a instância do usuário
	 * 
	 * @return Objeto do tipo Usuário
	 */
	public Usuario constroi() {

		return this.usuario;
	}
}