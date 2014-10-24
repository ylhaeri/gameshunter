package br.com.gameshunter.model;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Before;
import org.junit.Test;

public class EstadoTest {

	private Estado estado;

	@Before
	public void setUp() {
		estado = new Estado();
	}

	@Test
	public void deveCadastrarDadosCorretamente() {
		Integer id = 1;
		String nome = "São Paulo";
		String uf = "SP";
		Pais pais = new Pais();

		estado.setId(id);
		estado.setNome(nome);
		estado.setUf(uf);
		estado.setPais(pais);

		assertThat(estado.getPais(), equalTo(pais));
		assertThat(estado.getId(), equalTo(id));
		assertThat(estado.getNome(), equalTo(nome));
		assertThat(estado.getUf(), equalTo(uf));
	}
}