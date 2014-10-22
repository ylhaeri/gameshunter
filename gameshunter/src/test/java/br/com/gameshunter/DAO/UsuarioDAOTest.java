package br.com.gameshunter.DAO;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gameshunter.factory.EnderecoFactory;
import br.com.gameshunter.factory.UsuarioFactory;
import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.Usuario;

public class UsuarioDAOTest {

	private final String email = "joao@gmail.com";
	private Usuario joao;
	private EntityManager manager;
	private static UsuarioDAO uDao;

	@BeforeClass
	public static void globalSetUp() {
		new JPAUtil();
		uDao = new UsuarioDAO();
	}

	@Before
	public void inicia() {
		joao = new UsuarioFactory().comEmailSemEndereco(email);
		manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
	}

	@After
	public void finaliza() {
		manager.getTransaction().rollback();
		manager.close();
	}

	@AfterClass
	public static void encerra() {
		JPAUtil.closeFactory();
	}

	@Test
	public void tabelaDeveConterSomenteUmaLinha() {

		salva(joao);

		// Faz a contagem do número de linhas na tabela de Usuarios
		Long contagem = conta("Usuario");

		assertThat(contagem, equalTo(1l));
	}

	@Test
	public void deveConterUsuarioComCamposCorretos() {

		Usuario joao = new Usuario();
		String nome = "João da Silva Machado";
		String apelido = "Pikachu Iluminado";
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(1990, 1, 12, 12, 0, 0);
		String email = "joao@gmail.com";
		String telefone = "(11) 1111-1111";
		String cpf = "000.000.000-00";
		String rg = "1234567-890";
		Endereco endereco = new EnderecoFactory().repetido();

		joao.setApelido(apelido);
		joao.setNome(nome);
		joao.setDataNascimento(dataNascimento);
		joao.setEmail(email);
		joao.setTelefone(telefone);
		joao.setCpf(cpf);
		joao.setRg(rg);
		joao.adicionaEndereco(endereco);

		salva(joao);

		Usuario joana = pega(email);

		assertThat(joana.getNome(), equalTo(nome));
		assertThat(joana.getApelido(), equalTo(apelido));
		assertThat(joana.getDataNascimento().getTime(),
				equalTo(dataNascimento.getTime()));
		assertThat(joana.getEmail(), equalTo(email));
		assertThat(joana.getTelefone(), equalTo(telefone));
		assertThat(joana.getCpf(), equalTo(cpf));
		assertThat(joana.getRg(), equalTo(rg));
		assertThat(joana.pegaEndereco(0), equalTo(endereco));
	}

	@Test
	public void deveConterUsuarioComVariosEnderecos() {

		Endereco enviado1 = new EnderecoFactory()
				.comLogradouro("Rua Vergueiro");
		Endereco esperado1 = new EnderecoFactory()
				.comLogradouro("Rua Vergueiro");
		Endereco enviado2 = new EnderecoFactory()
				.comLogradouro("Avenida Tupabaram");
		Endereco esperado2 = new EnderecoFactory()
				.comLogradouro("Avenida Tupabaram");
		Endereco enviado3 = new EnderecoFactory().comLogradouro("Rua Tamborim");
		Endereco esperado3 = new EnderecoFactory()
				.comLogradouro("Rua Tamborim");

		joao.adicionaEndereco(enviado1);
		joao.adicionaEndereco(enviado2);
		joao.adicionaEndereco(enviado3);

		salva(joao);

		joao = pega(email);

		assertThat(joao.getEnderecos().size(), equalTo(3));
		assertThat(joao.getEnderecos(),
				hasItems(esperado1, esperado2, esperado3));
	}

	@Test
	public void deveConterVariosUsuariosComOMesmoEndereco() {

		Endereco endereco = new EnderecoFactory().repetido();

		Usuario ronaldo = new UsuarioFactory()
				.comEmailSemEndereco("ronaldo@gmail.com");
		Usuario usuario3 = new UsuarioFactory().repetidoSemEnderecos();

		joao.adicionaEndereco(endereco);
		ronaldo.adicionaEndereco(endereco);
		usuario3.adicionaEndereco(endereco);

		manager.persist(endereco);
		salva(joao);
		salva(ronaldo);
	}

	@Test
	public void deveAtualizarUsuariosDoBanco() {

		String nEnviado = "Dedinho Osvaldo";
		String nAlterado = "Osvaldo Patricio";
		String nEsperado = "Osvaldo Patricio";

		joao.setNome(nEnviado);
		salva(joao);

		joao = pega(email);
		joao.setNome(nAlterado);
		atualiza(joao);

		joao = pega(email);
		assertThat(joao.getNome(), equalTo(nEsperado));
	}

	@Test
	public void deveRemoverUsuarioDoBanco() {

		salva(joao);
		remove(joao);

		joao = pega(email);

		assertNull(joao);
	}

	private void salva(Usuario usuario) {
		uDao.salva(manager, usuario);
	}

	private void remove(Usuario usuario) {
		uDao.remove(manager, usuario);
	}

	private Long conta(String tabela) {
		return uDao.conta(manager, tabela);
	}

	private void atualiza(Usuario usuario) {
		uDao.atualiza(manager, usuario);
	}

	private Usuario pega(String email) {
		return uDao.pega(manager, Usuario.class, email);
	}
}