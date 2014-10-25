package br.com.gameshunter.factory;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

import br.com.gameshunter.model.Usuario;

public class UsuarioFactoryTest {

	private UsuarioFactory uFac = new UsuarioFactory();

	@Test
	public void deveFazerUsuariosIguais() {

		Usuario primeiro = uFac.repetidoSemEnderecos();
		Usuario segundo = uFac.repetidoSemEnderecos();

		assertTrue(uFac.saoIguais(primeiro, segundo));
	}

	@Test
	public void deveFazerUsuariosDiferentes() {
		Usuario primeiro = uFac.comEmailSemEndereco("ronaldo@silva.com");
		Usuario segundo = uFac.comEmailSemEndereco("jose@paulista.com");

		assertFalse(uFac.saoIguais(primeiro, segundo));
	}

	@Test
	public void deveFazerUsuarioIgualComEnderecos() {
		Usuario primeiro = uFac.repetidoComEnderecos();
		Usuario segundo = uFac.repetidoComEnderecos();

		Integer contagem = primeiro.getEnderecos().size();

		assertTrue(uFac.saoIguais(primeiro, segundo));
		assertThat(contagem, equalTo(3));
	}

	@Test
	public void deveFazerUsuarioDiferenteComEnderecos() {
		Usuario primeiro = uFac.comEmailEEnderecos("ronaldinho@dasilva.com.br");
		Usuario segundo = uFac.comEmailEEnderecos("perna.pereira@oi.com.br");

		Integer contagem = primeiro.getEnderecos().size();

		assertFalse(uFac.saoIguais(primeiro, segundo));
		assertThat(contagem, equalTo(3));
	}
}