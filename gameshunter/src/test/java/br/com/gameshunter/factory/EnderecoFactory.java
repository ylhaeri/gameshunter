package br.com.gameshunter.factory;

import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;

public class EnderecoFactory {

	private static Cidade cidade;
	private static Estado estado;
	private static Pais pais;

	static {
		cidade = new Cidade();
		estado = new Estado();
		pais = new Pais();

		pais.setId(1);
		pais.setNome("Brasil");
		pais.setSigla("BR");

		estado.setId(26);
		estado.setNome("São Paulo");
		estado.setUf("SP");
		estado.setPais(pais);

		cidade.setId(5270);
		cidade.setNome("São Paulo");
		cidade.setEstado(estado);
	}

	/**
	 * Retorna uma instância de endereco com a rua definida pelo usuário.
	 * Utilize quando precisar de instâncias diferentes.
	 * 
	 * @param Rua
	 *            para o novo endereço
	 * @return Novo endereço
	 */
	public Endereco comLogradouro(String logradouro) {
		return new Endereco(logradouro, 18,
				"Apto 598, Bloco 367, Praça do Geraldo", "Jazui", cidade,
				estado, "11111-111", pais);
	}

	/**
	 * Retorna uma nova instância de objeto sempre com o mesmo valor. Utilize
	 * quando não precisar de instâncias diferentes.
	 * 
	 * @return Novo endereço
	 */
	public Endereco repetido() {
		return new Endereco("Rua Amaricano Chamumblenho", 18,
				"Apto 598, Bloco 367, Praça do Geraldo", "Jazui", cidade,
				estado, "11111-111", pais);
	}

}