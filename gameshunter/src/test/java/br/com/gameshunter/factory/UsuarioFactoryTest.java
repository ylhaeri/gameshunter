package br.com.gameshunter.factory;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

import br.com.gameshunter.model.Usuario;

public class UsuarioFactoryTest {

	private UsuarioFactory uFac = new UsuarioFactory();

	@Test
	public void deveCriarUsuariosIguais() {

		Usuario primeiro = uFac.repetidoSemEnderecos();
		Usuario segundo = uFac.repetidoSemEnderecos();

		Integer contagem = primeiro.getEnderecos().size();

		assertThat(contagem, equalTo(0));
		assertTrue(uFac.saoIguais(primeiro, segundo));
	}

	@Test
	public void deveCriarUsuariosDiferentes() {
		Usuario primeiro = uFac.comEmailSemEndereco("ronaldo@silva.com");
		Usuario segundo = uFac.comEmailSemEndereco("jose@paulista.com");

		Integer contagem = primeiro.getEnderecos().size();

		assertThat(contagem, equalTo(0));
		assertFalse(uFac.saoIguais(primeiro, segundo));
	}

	@Test
	public void deveCriarUsuarioIgualComEnderecos() {
		Usuario primeiro = uFac.repetidoComEnderecos();
		Usuario segundo = uFac.repetidoComEnderecos();

		Integer contagem = primeiro.getEnderecos().size();

		assertThat(contagem, equalTo(3));
		assertTrue(uFac.saoIguais(primeiro, segundo));
	}

	@Test
	public void deveCriarUsuarioDiferenteComEnderecos() {
		Usuario primeiro = uFac.comEmailEEnderecos("ronaldinho@dasilva.com.br");
		Usuario segundo = uFac.comEmailEEnderecos("perna.pereira@oi.com.br");

		Integer contagem = primeiro.getEnderecos().size();

		assertThat(contagem, equalTo(3));
		assertFalse(uFac.saoIguais(primeiro, segundo));
	}
}