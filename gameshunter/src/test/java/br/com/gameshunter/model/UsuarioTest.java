package br.com.gameshunter.model;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gameshunter.factory.EnderecoFactory;

/**
 * Testes da classe Usuario
 * 
 * @author Myho
 */
public class UsuarioTest {

	private Usuario joao;
	private Collection<Endereco> enderecos;
	private static EnderecoFactory enderecoFactory;

	@BeforeClass
	public static void globalSetUp() {
		enderecoFactory = new EnderecoFactory();
	}

	@Before
	public void setUp() {

		joao = new Usuario();
		enderecos = joao.getEnderecos();
	}

	@Test
	public void deveCadastrarNomeCorretamente() {

		String enviado = "João da Silva Machado";
		String esperado = "João da Silva Machado";

		joao.setNome(enviado);

		assertThat(joao.getNome(), equalTo(esperado));
	}

	@Test
	public void deveCadastrarApelidoCorretamente() {

		String enviado = "PikachuIluminado";
		String esperado = "PikachuIluminado";

		joao.setApelido(enviado);

		assertThat(joao.getApelido(), equalTo(esperado));
	}

	@Test
	public void deveCadastrarDataCorreta() {

		Calendar enviado = Calendar.getInstance();
		enviado.set(1990, 1, 1, 12, 0, 0);

		Calendar esperado = Calendar.getInstance();
		esperado.set(1990, 1, 1, 12, 0, 0);

		joao.setDataNascimento(enviado);

		assertThat(joao.getDataNascimento().getTime().toString(),
				equalTo(esperado.getTime().toString()));
	}

	@Test
	public void deveCadastrarEmailCorretamente() {

		String enviado = "joaomachado@gmail.com";
		String esperado = "joaomachado@gmail.com";

		joao.setEmail(enviado);

		assertThat(joao.getEmail(), equalTo(esperado));
	}

	@Test
	public void deveCadastrarTelefoneCorretamente() {

		String enviado = "(11) 1111-1111";
		String esperado = "(11) 1111-1111";

		joao.setTelefone(enviado);

		assertThat(joao.getTelefone(), equalTo(esperado));
	}

	@Test
	public void deveCadastrarCpfCorretamente() {

		String enviado = "000.000.000-00";
		String esperado = "000.000.000-00";

		joao.setCpf(enviado);

		assertThat(joao.getCpf(), equalTo(esperado));
	}

	@Test
	public void deveCadastrarRgCorretamente() {

		String enviado = "1234567-890";
		String esperado = "1234567-890";

		joao.setRg(enviado);

		assertThat(joao.getRg(), equalTo(esperado));
	}

	@Test
	public void deveCadastrarEnderecosCorretamente() {

		Endereco enviado = enderecoFactory.repetido();
		Endereco esperado = enderecoFactory.repetido();

		joao.adicionaEndereco(enviado);

		assertThat(enderecos, hasItem(esperado));
	}

	@Test
	public void deveCadastrarVariosEnderecos() {

		Endereco enviado1 = enderecoFactory.comLogradouro("Avenida Zambreta");
		Endereco esperado1 = enderecoFactory.comLogradouro("Avenida Zambreta");
		Endereco enviado2 = enderecoFactory.comLogradouro("Rua Pentombla");
		Endereco esperado2 = enderecoFactory.comLogradouro("Rua Pentombla");

		joao.adicionaEndereco(enviado1);
		joao.adicionaEndereco(enviado2);

		assertThat(enderecos.size(), equalTo(2));
		assertThat(enderecos, hasItems(esperado1, esperado2));
	}

	@Test
	public void naoDeveCadastrarMaisQue3Enderecos() {

		Endereco enviado1 = enderecoFactory.comLogradouro("Rua Vergueiro");

		Endereco enviado2 = enderecoFactory.comLogradouro("Rua Manolia");

		Endereco enviado3 = enderecoFactory.comLogradouro("Rua Tamborim");

		Endereco enviado4 = enderecoFactory.comLogradouro("Rua Macarronada");
		Endereco esperado4 = enderecoFactory.comLogradouro("Rua Macarronada");

		joao.adicionaEndereco(enviado1);
		joao.adicionaEndereco(enviado2);
		joao.adicionaEndereco(enviado3);
		joao.adicionaEndereco(enviado4);

		assertThat(enderecos.size(), equalTo(3));
		assertThat(enderecos, not(hasItem(esperado4)));
	}

	@Test
	public void naoDeveCadastrarEnderecosRepetidos() {

		Endereco enviado1 = enderecoFactory.repetido();
		Endereco esperado = enderecoFactory.repetido();

		Endereco enviado2 = enderecoFactory.repetido();

		joao.adicionaEndereco(enviado1);
		joao.adicionaEndereco(enviado2);

		assertThat(enderecos.size(), equalTo(1));
		assertThat(enderecos, hasItem(esperado));
	}

	@Test
	public void devePegarOEnderecoCorretoDentroDaLista() {

		Endereco enviado1 = enderecoFactory.comLogradouro("Rua Malumarumba");
		Endereco esperado1 = enderecoFactory.comLogradouro("Rua Malumarumba");
		Endereco enviado2 = enderecoFactory
				.comLogradouro("Avenida João da Silva");
		Endereco esperado2 = enderecoFactory
				.comLogradouro("Avenida João da Silva");
		Endereco enviado3 = enderecoFactory
				.comLogradouro("Rua Marcilio Salomb");
		Endereco esperado3 = enderecoFactory
				.comLogradouro("Rua Marcilio Salomb");

		joao.adicionaEndereco(enviado1);
		joao.adicionaEndereco(enviado2);
		joao.adicionaEndereco(enviado3);

		assertThat(enderecos.size(), equalTo(3));
		assertThat(joao.pegaEndereco(0), equalTo(esperado1));
		assertThat(joao.pegaEndereco(1), equalTo(esperado2));
		assertThat(joao.pegaEndereco(2), equalTo(esperado3));
	}

	@Test
	public void deveRemoverOEndereco() {

		Endereco enviado = enderecoFactory
				.comLogradouro("Peninsula da Mabilia");

		joao.adicionaEndereco(enviado);

		joao.removeEndereco(0);

		assertThat(enderecos.size(), equalTo(0));
	}

	@Test
	public void deveAlterarOEndereco() {

		Endereco enviado = enderecoFactory.comLogradouro("Rua Aranha Pomba");
		Endereco alterado = enderecoFactory.repetido();
		Endereco esperado = enderecoFactory.repetido();

		joao.adicionaEndereco(enviado);
		joao.alteraEndereco(0, alterado);

		assertThat(joao.pegaEndereco(0), equalTo(esperado));
	}
}