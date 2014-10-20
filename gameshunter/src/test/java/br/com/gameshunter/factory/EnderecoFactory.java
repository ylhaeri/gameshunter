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
		return new Endereco(logradouro, 18,
				"Apto 598, Bloco 367, Praça do Geraldo", "Jazui", "São Paulo",
				"SP", "11111-111", "Brasil");
	}

	/**
	 * Retorna uma nova instância de objeto sempre com o mesmo valor. Utilize
	 * quando não precisar de instâncias diferentes.
	 * 
	 * @return Novo endereço
	 */
	public Endereco repetido() {
		return new Endereco("Rua Amaricano Chamumblenho", 18,
				"Apto 598, Bloco 367, Praça do Geraldo", "Jazui", "São Paulo",
				"SP", "11111-111", "Brasil");
	}
}