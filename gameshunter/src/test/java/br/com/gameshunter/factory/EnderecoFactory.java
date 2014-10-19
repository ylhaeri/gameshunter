package br.com.gameshunter.factory;

import br.com.gameshunter.model.Endereco;

public class EnderecoFactory {

	/**
	 * Retorna uma instância de endereco com a rua definida pelo usuário.
	 * Utilize quando precisar de instâncias diferentes.
	 * 
	 * @param Rua
	 *            para o novo endereço
	 * @return Novo endereço
	 */
	public Endereco comLogradouro(String logradouro) {
		return new Endereco(logradouro, 18, "Jazui", "São Paulo", "SP",
				"11111-111", "Brasil");
	}

	/**
	 * Retorna uma nova instância de objeto sempre com o mesmo valor. Utilize
	 * quando não precisar de instâncias diferentes.
	 * 
	 * @return Novo endereço
	 */
	public Endereco repetido() {
		return new Endereco("Rua Vergueiro", 18, "Jazui", "São Paulo", "SP",
				"11111-111", "Brasil");
	}
}