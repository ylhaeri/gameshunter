package br.com.gameshunter.model;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

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
	public void deveCadastrarDadosCorretamente() {

		String nome = "João da Silva Machado";
		String apelido = "PikachuIluminado";
		String senha = "ararinhaPumbapulma";
		Sexo sexo = Sexo.Masculino;
		Calendar dataNasc = Calendar.getInstance();
		dataNasc.set(1990, 1, 1, 12, 0, 0);
		String email = "joaomachado@gmail.com";
		String telefone = "(11) 1111-1111";
		String cpf = "000.000.000-00";
		String rg = "1234567-890";
		Endereco endereco = enderecoFactory.repetido();

		joao.setNome(nome);
		joao.setApelido(apelido);
		joao.setSenha(senha);
		joao.setSexo(sexo);
		joao.setDataNascimento(dataNasc);
		joao.setEmail(email);
		joao.setTelefone(telefone);
		joao.setCpf(cpf);
		joao.setRg(rg);
		joao.adicionaEndereco(endereco);

		assertThat(joao.getSexo(), equalTo(sexo));
		assertThat(joao.getNome(), equalTo(nome));
		assertThat(joao.getApelido(), equalTo(apelido));
		assertThat(joao.getSenha(), equalTo(senha));
		assertThat(joao.getDataNascimento().getTime(),
				equalTo(dataNasc.getTime()));
		assertThat(joao.getEmail(), equalTo(email));
		assertThat(joao.getTelefone(), equalTo(telefone));
		assertThat(joao.getCpf(), equalTo(cpf));
		assertThat(joao.getRg(), equalTo(rg));
		assertThat(enderecos, hasItem(endereco));
	}

	@Test
	public void deveAlterarAListaAtual() {

		joao.adicionaEndereco(new Endereco());

		List<Endereco> antigo = joao.getEnderecos();
		List<Endereco> novo = new ArrayList<>();

		joao.setEnderecos(novo);

		assertThat(joao.getEnderecos(), not(equalTo(antigo)));
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

		Endereco endereco = enderecoFactory.comLogradouro("Rua Aranha Pomba");
		Endereco alterado = enderecoFactory.repetido();

		joao.adicionaEndereco(endereco);
		joao.alteraEndereco(0, alterado);

		assertThat(joao.pegaEndereco(0), equalTo(alterado));
	}
}