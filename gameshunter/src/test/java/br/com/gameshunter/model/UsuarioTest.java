package br.com.gameshunter.model;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.hasItem;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private Usuario joao;

	@Before
	public void criaUsuarios() {

		joao = new Usuario();
	}

	@Test
	public void deveCadastrarNomeCorretamente() {

		joao.setNome("João da Silva Machado");
		assertEquals("João da Silva Machado", joao.getNome());
	}

	@Test
	public void deveCadastrarApelidoCorretamente() {

		joao.setApelido("Pikachu Iluminado");
		assertEquals("Pikachu Iluminado", joao.getApelido());
	}

	@Test
	public void deveCadastrarDataCorreta() {

		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(1990, 1, 12);
		joao.setDataNascimento(dataNascimento);
		assertThat(joao.getDataNascimento().getTime().toString(),
				containsString("Mon Feb 12"));
		assertThat(joao.getDataNascimento().getTime().toString(),
				containsString("1990"));
	}

	@Test
	public void deveCadastrarEmailCorretamente() {

		joao.setEmail("joaomachado@silva.com");
		assertEquals("joaomachado@silva.com", joao.getEmail());
	}

	@Test
	public void deveCadastrarTelefoneCorretamente() {

		joao.setTelefone("(11) 1111-1111");
		assertEquals("(11) 1111-1111", joao.getTelefone());
	}

	@Test
	public void deveCadastrarCpfCorretamente() {

		joao.setCpf("000.000.000-00");
		assertEquals("000.000.000-00", joao.getCpf());
	}

	@Test
	public void deveCadastrarRgCorretamente() {

		joao.setRg("1234567-890");
		assertEquals("1234567-890", joao.getRg());
	}

	@Test
	public void deveCompararEnderecosCorretamente() {

		joao.setEndereco(new Endereco());
		assertThat(joao.getEndereco(), equalTo(new Endereco()));
	}

	@Test
	public void deveCadastrarEnderecosCorretamente() {

		joao.setEndereco(new Endereco("Rua Vergueiro", 18, "Jazui",
				"São Paulo", "SP", "11111-111", "Brasil"));
		assertThat(
				joao.getEndereco().formatado(),
				equalTo("Rua Vergueiro, 18 - Jazui - 11111-111 - São Paulo, SP - Brasil"));
	}

	@Test
	public void deveCadastrar2Enderecos() {

		joao.adicionaEndereco(new Endereco("Rua Vergueiro", 18, "Jazui",
				"São Paulo", "SP", "11111-111", "Brasil"));
		joao.adicionaEndereco(new Endereco("Avenida Zambreta", 180, "Jazui",
				"São Paulo", "SP", "11111-151", "Brasil"));
		assertThat(joao.getEnderecos().size(), equalTo(2));
		assertThat(
				joao.getEnderecos().get(0).formatado(),
				equalTo("Rua Vergueiro, 18 - Jazui - 11111-111 - São Paulo, SP - Brasil"));
		assertThat(
				joao.getEnderecos().get(1).formatado(),
				equalTo("Avenida Zambreta, 180 - Jazui - 11111-151 - São Paulo, SP - Brasil"));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void naoDeveCadastrarMaisQue3Enderecos() {

		joao.adicionaEndereco(new Endereco("Rua Vergueiro", 18, "Jazui",
				"São Paulo", "SP", "11111-111", "Brasil"));
		joao.adicionaEndereco(new Endereco("Rue Vergueiro", 18, "Jazui",
				"São Paulo", "SP", "11111-111", "Brasil"));
		joao.adicionaEndereco(new Endereco("Rui Vergueiro", 18, "Jazui",
				"São Paulo", "SP", "11111-111", "Brasil"));
		joao.adicionaEndereco(new Endereco("Ruo Vergueiro", 18, "Jazui",
				"São Paulo", "SP", "11111-111", "Brasil"));
		List<Endereco> enderecos = joao.getEnderecos();
		assertThat(enderecos.size(), equalTo(3));

		assertThat(enderecos, not(hasItem(new Endereco("Ruo Vergueiro", 18,
				"Jazui", "São Paulo", "SP", "11111-111", "Brasil"))));

		// Não existe, deve lançar exceção
		enderecos.get(3);
	}

	@Test
	public void naoDeveCadastrarEnderecosRepetidos() {

		joao.adicionaEndereco(new Endereco("Rua Vergueiro", 18, "Jazui",
				"São Paulo", "SP", "11111-111", "Brasil"));
		joao.adicionaEndereco(new Endereco("Rua Vergueiro", 18, "Jazui",
				"São Paulo", "SP", "11111-111", "Brasil"));
		assertThat(joao.getEnderecos().size(), equalTo(1));
		assertThat(
				joao.getEnderecos().get(0).formatado(),
				equalTo("Rua Vergueiro, 18 - Jazui - 11111-111 - São Paulo, SP - Brasil"));
	}
}