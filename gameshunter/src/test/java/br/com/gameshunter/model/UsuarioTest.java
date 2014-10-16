package br.com.gameshunter.model;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;


public class UsuarioTest {

	private Usuario joao;
	private Calendar dataNascimento;

	@Before
	public void criaUsuarios() {

		joao = new Usuario("");
	}

	@Test
	public void deveRetornarNomeCorreto() {

		joao.setNome("João da Silva Machado");
		assertEquals("João da Silva Machado", joao.getNome());
	}

	@Test
	public void deveRetornarApelidoCorreto() {

		joao.setApelido("Pikachu Iluminado");
		assertEquals("Pikachu Iluminado", joao.getApelido());
	}

	@Test
	public void deveRetornarDataCorreta() {

		dataNascimento = Calendar.getInstance();
		dataNascimento.set(1990, 1, 12);
		joao.setDataNascimento(dataNascimento);
		assertThat(joao.getDataNascimento().getTime().toString(),
				containsString("Mon Feb 12"));
		assertThat(joao.getDataNascimento().getTime().toString(),
				containsString("1990"));
	}

	@Test
	public void deveRetornarEmailCorreto() {

		joao.setEmail("joaomachado@silva.com");
		assertEquals("joaomachado@silva.com", joao.getEmail());
	}

	@Test
	public void deveRetornarTelefoneCorreto() {

		joao.setTelefone("(11) 1111-1111");
		assertEquals("(11) 1111-1111", joao.getTelefone());
	}

	@Test
	public void deveRetornarCpfCorreto() {

		joao.setCpf("000.000.000-00");
		assertEquals("000.000.000-00", joao.getCpf());
	}

	@Test
	public void deveRetornarRgCorrreto() {

		joao.setRg("1234567-890");
		assertEquals("1234567-890", joao.getRg());
	}

	@Test
	public void deveRetornarEnderecoCorreto() {

		joao.setEndereco("Rua Vergueiro, 18, São Paulo, SP");
		assertEquals("Rua Vergueiro, 18, São Paulo, SP", joao.getEndereco());
	}
}