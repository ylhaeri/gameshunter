package br.com.gameshunter.model;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CidadeTest {

	private Cidade cidade;

	@Before
	public void setUp() {
		cidade = new Cidade();
	}

	@Test
	public void deveCadastrarDadosCorretamente() {
		Integer id = 1;
		String nome = "São Paulo";
		Estado estado = new Estado();

		cidade.setId(id);
		cidade.setNome(nome);
		cidade.setEstado(estado);

		assertThat(cidade.getEstado(), equalTo(estado));
		assertThat(cidade.getId(), equalTo(id));
		assertThat(cidade.getNome(), equalTo(nome));
	}

	@Test
	public void deveCompararCidadesCorretamente() {
		Cidade primeira = new Cidade();
		Cidade segunda = new Cidade();
		String nome = "São Paulo";

		primeira.setId(1);
		primeira.setNome(nome);
		primeira.setEstado(new Estado());

		segunda.setId(8);
		segunda.setNome(nome);
		segunda.setEstado(new Estado());

		assertThat(primeira, equalTo(segunda));
	}
}