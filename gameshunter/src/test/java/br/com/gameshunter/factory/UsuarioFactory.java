package br.com.gameshunter.factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.Sexo;
import br.com.gameshunter.model.Usuario;

public class UsuarioFactory {

	private static Calendar c;

	static {
		c = Calendar.getInstance();
		c.set(1990, 1, 1, 12, 0, 0);
	}

	/**
	 * Método para criar um usuário repetido.
	 * 
	 * @return Endereço
	 */
	public Usuario repetidoSemEnderecos() {
		List<Endereco> enderecos = new ArrayList<>();
		return new Usuario("ronaldoplosra@hotmail.com", "Ronaldo Plosra Silva",
				"Rosnaldin", "senhadoronaldo", Sexo.Masculino,
				"111.111.111-11", c, enderecos, "(11) 1111-1111", "1234567-890");
	}

	/**
	 * Método para criar um usuário com e-mail único.
	 * 
	 * @return Endereço
	 */
	public Usuario comEmailSemEndereco(String email) {
		List<Endereco> enderecos = new ArrayList<>();
		return new Usuario(email, "Ronaldo Plosra Silva", "Rosnaldin",
				"senhadoronaldo", Sexo.Masculino, "111.111.111-11", c,
				enderecos, "(11) 1111-1111", "1234567-890");
	}

	/**
	 * Método para criar um usuário repetido com endereços.
	 * 
	 * @return Endereço
	 */
	public Usuario repetidoComEnderecos() {
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(new EnderecoFactory().comLogradouro("Rua Sergipe"));
		enderecos.add(new EnderecoFactory().comLogradouro("Rua Guadalupe"));
		enderecos.add(new EnderecoFactory().comLogradouro("Avenida Muranha"));
		return new Usuario("ronaldoplosra@hotmail.com", "Ronaldo Plosra Silva",
				"Rosnaldin", "senhadoronaldo", Sexo.Masculino,
				"111.111.111-11", c, enderecos, "(11) 1111-1111", "1234567-890");
	}

	/**
	 * Método para criar um usuário com e-mail único e com endereços.
	 * 
	 * @return Endereço
	 */
	public Usuario comEmailEEnderecos(String email) {
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(new EnderecoFactory().comLogradouro("Rua Sergipe"));
		enderecos.add(new EnderecoFactory().comLogradouro("Rua Guadalupe"));
		enderecos.add(new EnderecoFactory().comLogradouro("Avenida Muranha"));
		return new Usuario(email, "Ronaldo Plosra Silva", "Rosnaldin",
				"senhadoronaldo", Sexo.Masculino, "111.111.111-11", c,
				enderecos, "(11) 1111-1111", "1234567-890");
	}
}