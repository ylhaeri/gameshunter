package br.com.gameshunter.DAO;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gameshunter.factory.EnderecoFactory;
import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.Usuario;

public class UsuarioDAOTest {

	private final String email = "joao@gmail.com";
	private Usuario joao;
	private EntityManager manager;
	private UsuarioDAO uDao;

	@BeforeClass
	public static void globalSetUp() {
		new JPAUtil();
	}

	@Before
	public void inicia() {
		joao = new Usuario();
		joao.setEmail(email);
		manager = new JPAUtil().getEntityManager();
		uDao = new UsuarioDAO(manager);
		manager.getTransaction().begin();
	}

	@After
	public void finaliza() {
		manager.getTransaction().rollback();
		manager.close();
	}

	@AfterClass
	public static void encerra() {
		new JPAUtil().closeFactory();
	}

	/**
	 * Solução temporária
	 */
	private void limpa() {
		Query query = manager.createQuery("delete from Usuario u");
		query.executeUpdate();
		query = manager.createQuery("delete from Endereco e");
		query.executeUpdate();
		commitENovaTransaction();
	}

	/**
	 * Solução temporária
	 */
	private void commitENovaTransaction() {
		manager.getTransaction().commit();
		manager.close();
		manager = new JPAUtil().getEntityManager();
		uDao = new UsuarioDAO(manager);
		manager.getTransaction().begin();
	}

	@Test
	public void deveConterUsuarioComNomeCorreto() {

		String enviado = "João da Silva Machado";
		String esperado = "João da Silva Machado";

		joao.setNome(enviado);

		uDao.salva(joao);

		Usuario joao = uDao.pega(email);

		assertThat(joao.getNome(), equalTo(esperado));
	}

	@Test
	public void tabelaDeveConterSomenteUmaLinha() {

		uDao.salva(joao);

		Query query = manager.createQuery("select count(u) from Usuario u");
		Long contagem = (long) query.getFirstResult();

		assertThat(contagem, equalTo(0l));
		// Faz a contagem do número de linhas na tabela de Usuarios
	}

	@Test
	public void deveConterUsuarioComApelidoCorreto() {

		String enviado = "Pikachu Iluminado";
		String esperado = "Pikachu Iluminado";

		joao.setApelido(enviado);

		uDao.salva(joao);

		Usuario joao = uDao.pega(email);

		assertThat(joao.getApelido(), equalTo(esperado));
	}

	/**
	 * SÉRIOS PROBLEMAS NO CALENDAR, O VALOR É MUITO INCONSTANTE, O TEMPO
	 * INTEIRO PEGA ERROS AQUI POR DIFERENÇA DE 1 MILÉSIMO
	 */
	@Test
	public void deveConterUsuarioComDataDeNascimentoCorreta() {

		Calendar enviado = Calendar.getInstance();
		enviado.set(1990, 1, 12, 12, 0, 0);
		Calendar esperado = Calendar.getInstance();
		esperado.set(1990, 1, 12, 12, 0, 0);

		joao.setDataNascimento(enviado);

		uDao.salva(joao);

		Usuario joao = uDao.pega(email);

		assertThat(joao.getDataNascimento().getTime(),
				equalTo(esperado.getTime()));
	}

	@Test
	public void deveConterUsuarioComEmailCorreto() {

		String enviado = "joao@gmail.com";
		String esperado = "joao@gmail.com";

		joao.setEmail(enviado);
		uDao.salva(joao);

		Usuario joao = uDao.pega(email);

		assertThat(joao.getEmail(), equalTo(esperado));
	}

	@Test
	public void deveConterUsuarioComTelefoneCorreto() {

		String enviado = "(11) 1111-1111";
		String esperado = "(11) 1111-1111";

		joao.setTelefone(enviado);

		uDao.salva(joao);

		Usuario joao = uDao.pega(email);

		assertThat(joao.getTelefone(), equalTo(esperado));
	}

	@Test
	public void deveConterUsuarioComCpfCorreto() {

		String enviado = "000.000.000-00";
		String esperado = "000.000.000-00";

		joao.setCpf(enviado);

		uDao.salva(joao);

		Usuario joao = uDao.pega(email);

		assertThat(joao.getCpf(), equalTo(esperado));
	}

	@Test
	public void deveConterUsuarioComRgCorrreto() {

		String enviado = "1234567-890";
		String esperado = "1234567-890";

		joao.setRg(enviado);

		uDao.salva(joao);

		Usuario joao = uDao.pega(email);

		assertThat(joao.getRg(), equalTo(esperado));
	}

	@Test
	public void deveConterUsuarioComEnderecoCorreto() {

		Endereco enviado = new EnderecoFactory().repetido();
		Endereco esperado = new EnderecoFactory().repetido();

		joao.adicionaEndereco(enviado);
		uDao.salva(joao);

		joao = uDao.pega(email);

		assertThat(joao.pegaEndereco(0), equalTo(esperado));
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

		uDao.salva(joao);

		assertThat(joao.getEnderecos().size(), equalTo(3));
		assertThat(joao.getEnderecos(),
				hasItems(esperado1, esperado2, esperado3));
	}

	/**
	 * Precisa resolver essa bosta, tá gigantesco e nada legível
	 */
	@Test
	public void deveAtualizarUsuariosDoBanco() {

		Endereco eEnviado = new EnderecoFactory().repetido();
		Endereco eAlterado = new EnderecoFactory()
				.comLogradouro("Rua Chasplim");
		Endereco eEsperado = new EnderecoFactory()
				.comLogradouro("Rua Chasplim");
		String nEnviado = "Dedinho Osvaldo";
		String nAlterado = "Osvaldo Patricio";
		String nEsperado = "Osvaldo Patricio";

		joao.adicionaEndereco(eEnviado);
		joao.setNome(nEnviado);

		manager.persist(eEnviado);
		uDao.salva(joao);

		commitENovaTransaction();

		joao = uDao.pega(email);
		joao.setNome(nAlterado);
		joao.alteraEndereco(0, eAlterado);

		eEnviado = manager.merge(eEnviado);
		manager.remove(eEnviado);
		manager.persist(eAlterado);
		manager.merge(joao);

		commitENovaTransaction();

		joao = uDao.pega(email);

		assertThat(joao.pegaEndereco(0), equalTo(eEsperado));
		assertThat(joao.getNome(), equalTo(nEsperado));

		limpa();
	}

	@Test
	public void deveRemoverUsuarioDoBanco() {
		Endereco enviado = new EnderecoFactory().repetido();

		joao.adicionaEndereco(enviado);
		manager.persist(enviado);
		uDao.salva(joao);

		joao = uDao.pega(email);
		joao = uDao.remove(joao);

		assertNull(joao);
	}
}