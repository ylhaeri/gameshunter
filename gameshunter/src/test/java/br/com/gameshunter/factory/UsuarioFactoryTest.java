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

		assertTrue(saoIguais(primeiro, segundo));
	}

	@Test
	public void deveFazerUsuariosDiferentes() {
		Usuario primeiro = uFac.comEmailSemEndereco("ronaldo@silva.com");
		Usuario segundo = uFac.comEmailSemEndereco("jose@paulista.com");

		assertFalse(saoIguais(primeiro, segundo));
	}

	@Test
	public void deveFazerUsuarioIgualComEnderecos() {
		Usuario primeiro = uFac.repetidoComEnderecos();
		Usuario segundo = uFac.repetidoComEnderecos();

		Integer contagem = primeiro.getEnderecos().size();

		assertTrue(saoIguais(primeiro, segundo));
		assertThat(contagem, equalTo(3));
	}

	@Test
	public void deveFazerUsuarioDiferenteComEnderecos() {
		Usuario primeiro = uFac.comEmailEEnderecos("ronaldinho@dasilva.com.br");
		Usuario segundo = uFac.comEmailEEnderecos("perna.pereira@oi.com.br");

		Integer contagem = primeiro.getEnderecos().size();

		assertFalse(saoIguais(primeiro, segundo));
		assertThat(contagem, equalTo(3));
	}

	private boolean saoIguais(Usuario primeiro, Usuario segundo) {

		if (primeiro.getApelido().equals(segundo.getApelido())
				&& primeiro.getCpf().equals(segundo.getCpf())
				&& primeiro.getDataNascimento().equals(
						segundo.getDataNascimento())
				&& primeiro.getEmail().equals(segundo.getEmail())
				&& primeiro.getEnderecos().equals(segundo.getEnderecos())
				&& primeiro.getNome().equals(segundo.getNome())
				&& primeiro.getRg().equals(segundo.getRg())
				&& primeiro.getSenha().equals(segundo.getSenha())
				&& primeiro.getSexo().equals(segundo.getSexo())
				&& primeiro.getTelefone().equals(segundo.getTelefone()))
			return true;
		else
			return false;
	}
}