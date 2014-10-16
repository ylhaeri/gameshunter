package br.com.gameshunter.model;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private Usuario joao;
	private Calendar c;

	@Before
	public void criaUsuarios() {

		c = Calendar.getInstance();
		c.set(1990, 1, 12);
		joao = new Usuario("João da Silva Machado")
				.setEmail("joaomachado@silva.com")
				.setApelido("Pikachu Iluminado").setCpf("000.000.000-00")
				.setDataNascimento(c)
				.setEndereco("Rua Vergueiro, 18, São Paulo, SP")
				.setTelefone("(11) 1111-1111").setRg("1234567-890");

	}

	@Test
	public void deveRetornarEmailCorreto() {

		assertEquals("joaomachado@silva.com", joao.getEmail());
	}

	@Test
	public void deveRetornarNomeCorreto() {

		assertEquals("João da Silva Machado", joao.getNome());
	}

	@Test
	public void deveRetornarApelidoCorreto() {

		assertEquals("Pikachu Iluminado", joao.getApelido());
	}

	@Test
	public void deveRetornarCpfCorreto() {

		assertEquals("000.000.000-00", joao.getCpf());
	}

	@Test
	public void deveRetornarDataCorreta() {

		assertThat(joao.getDataNascimento().getTime().toString(),
				containsString("Mon Feb 12"));
		assertThat(joao.getDataNascimento().getTime().toString(),
				containsString("1990"));
	}

	@Test
	public void deveRetornarEnderecoCorreto() {

		assertEquals("Rua Vergueiro, 18, São Paulo, SP", joao.getEndereco());
	}

	@Test
	public void deveRetornarTelefoneCorreto() {

		assertEquals("(11) 1111-1111", joao.getTelefone());
	}

	@Test
	public void deveRetornarRgCorrreto() {

		assertEquals("1234567-890", joao.getRg());
	}
}