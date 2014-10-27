package br.com.gameshunter.model;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Before;
import org.junit.Test;

public class PaisTest {

	private Pais pais;

	@Before
	public void setUp() {
		pais = new Pais();
	}

	@Test
	public void deveCadastrarDadosCorretamente() {
		Integer id = 1;
		String nome = "Brasil";
		String sigla = "BR";

		pais.setId(id);
		pais.setNome(nome);
		pais.setSigla(sigla);

		assertThat(pais.getId(), equalTo(id));
		assertThat(pais.getNome(), equalTo(nome));
		assertThat(pais.getSigla(), equalTo(sigla));
	}

	@Test
	public void deveCompararPaisesCorretamente() {
		Pais primeiro = new Pais();
		Pais segundo = new Pais();
		String nome = "Brasil";
		String sigla = "BR";

		primeiro.setId(5);
		primeiro.setNome(nome);
		primeiro.setSigla(sigla);

		segundo.setId(1);
		segundo.setNome(nome);
		segundo.setSigla(sigla);

		assertThat(primeiro, equalTo(segundo));
	}
}