package br.com.gameshunter.factory;

import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;

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
		Cidade cidade;
		Estado estado;
		Pais pais;

		cidade = new Cidade();
		estado = new Estado();
		pais = new Pais();

		pais.setNome("Brasil");
		pais.setSigla("BR");

		estado.setNome("São Paulo");
		estado.setUf("SP");
		estado.setPais(pais);

		cidade.setNome("São Paulo");
		cidade.setEstado(estado);

		return new Endereco(logradouro, 18,
				"Apto 598, Bloco 367, Praça do Geraldo", "Jazui", cidade,
				"11111-111");
	}

	/**
	 * Retorna uma nova instância de objeto sempre com o mesmo valor. Utilize
	 * quando não precisar de instâncias diferentes.
	 * 
	 * @return Novo endereço
	 */
	public Endereco repetido() {
		Cidade cidade;
		Estado estado;
		Pais pais;

		cidade = new Cidade();
		estado = new Estado();
		pais = new Pais();

		pais.setNome("Brasil");
		pais.setSigla("BR");

		estado.setNome("São Paulo");
		estado.setUf("SP");
		estado.setPais(pais);

		cidade.setNome("São Paulo");
		cidade.setEstado(estado);

		return new Endereco("Rua Amaricano Chamumblenho", 18,
				"Apto 598, Bloco 367, Praça do Geraldo", "Jazui", cidade,
				"11111-111");
	}
}