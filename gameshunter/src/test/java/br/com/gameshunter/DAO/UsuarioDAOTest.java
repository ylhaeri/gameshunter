package br.com.gameshunter.DAO;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gameshunter.factory.EnderecoFactory;
import br.com.gameshunter.model.Usuario;

public class UsuarioDAOTest {

	private Usuario joao;
	private EntityManager manager;

	@BeforeClass
	public static void globalSetUp() {
		new JPAUtil();
	}

	@Before
	public void inicia() {
		joao = new Usuario();
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
		new JPAUtil().closeFactory();
	}

	@Test
	public void deveConterUsuarioComNomeCorreto() {

		joao.setNome("João da Silva Machado");
		joao.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(joao);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertEquals("João da Silva Machado", joao.getNome());
	}

	@Test
	public void tabelaDeveConterSomenteUmaLinha() {
		joao.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(joao);
		Session session = (Session) manager.getDelegate();
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.setProjection(Projections.rowCount());
		criteria.uniqueResult();
		int numeroDeLinhas = Integer.parseInt(criteria.list().toString()
				.replaceAll("[^0-9]", ""));
		assertEquals(1, numeroDeLinhas);
	}

	@Test
	public void deveConterUsuarioComApelidoCorreto() {

		joao.setApelido("Pikachu Iluminado");
		joao.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(joao);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertEquals("Pikachu Iluminado", joao.getApelido());
	}

	@Test
	public void deveConterUsuarioComDataDeNascimentoCorreta() {

		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(1990, 1, 12);
		joao.setDataNascimento(dataNascimento);
		joao.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(joao);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertThat(joao.getDataNascimento().getTime().toString(),
				containsString("Mon Feb 12"));
		assertThat(joao.getDataNascimento().getTime().toString(),
				containsString("1990"));
	}

	@Test
	public void deveConterUsuarioComEmailCorreto() {

		joao.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(joao);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertEquals("joao@gmail.com", joao.getEmail());
	}

	@Test
	public void deveConterUsuarioComTelefoneCorreto() {

		joao.setTelefone("(11) 1111-1111");
		joao.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(joao);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertEquals("(11) 1111-1111", joao.getTelefone());
	}

	@Test
	public void deveConterUsuarioComCpfCorreto() {

		joao.setCpf("000.000.000-00");
		joao.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(joao);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertEquals("000.000.000-00", joao.getCpf());
	}

	@Test
	public void deveConterUsuarioComRgCorrreto() {

		joao.setRg("1234567-890");
		joao.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(joao);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertEquals("1234567-890", joao.getRg());
	}

	@Test
	public void deveConterUsuarioComEnderecoCorreto() {

		joao.setEndereco(new EnderecoFactory().comLogradouro("Rua Jesompla"));
		joao.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(joao);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertEquals(new EnderecoFactory().comLogradouro("Rua Jesompla"),
				joao.getEndereco());
	}
}