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
import org.junit.Before;
import org.junit.Test;

import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.UsuarioDAO;
import br.com.gameshunter.model.Usuario;

public class UsuarioDAOTest {

	private Usuario usuario;
	private EntityManager manager;

	@Before
	public void inicia() {

		usuario = new Usuario();
		manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
	}

	@Test
	public void loopDeTestes() {

		for (int i = 0; i < 10000; i++) {
			deveConterUsuarioComNomeCorreto();
			finaliza();
			inicia();
			tabelaDeveConterSomenteUmaLinha();
			finaliza();
			inicia();
			deveConterUsuarioComApelidoCorreto();
			finaliza();
			inicia();
			deveConterUsuarioComDataDeNascimentoCorreta();
			finaliza();
			inicia();
			deveConterUsuarioComEmailCorreto();
			finaliza();
			inicia();
			deveConterUsuarioComTelefoneCorreto();
			finaliza();
			inicia();
			deveConterUsuarioComCpfCorreto();
			finaliza();
			inicia();
			deveConterUsuarioComRgCorrreto();
			finaliza();
			inicia();
			deveConterUsuarioComEnderecoCorreto();
			finaliza();
			inicia();
		}
	}

	/*
	 * Tive que alterar bastante coisa, os tempos não funcionam mais, mas
	 * mostram bem como é :x
	 * 
	 * mysql 5 loops - 1.231
	 * 
	 * hsql 5 loops - 1.271
	 * 
	 * db4free 5 loops - 15.578
	 * 
	 * mysql 100 loops - 1.313, 1321, 1436, 1331, 1294
	 * 
	 * hsql 100 loops - 1.337, 1283, 1305, 1341, 1337
	 * 
	 * db4free 100 loops - 99.666
	 * 
	 * 
	 * mysql 2000 loops - 2379, 2455, 2399, 2441, 2454
	 * 
	 * hsql 2000 loops - 2.024, 2.012, 2.042, 2.043, 2.026
	 * 
	 * 
	 * mysql 5000 loops - 3.393, 3.437, 3.450, 3.357, 3,402
	 * 
	 * hsql 5000 loops - 2.650, 2.624, 2.637, 2.621, 2.653
	 * 
	 * 
	 * mysql 10000 loops - 4.744, 4.762, 4.792, 4.781, 4.786
	 * 
	 * hsql 10000 loops - 3.458, 3.471, 3.412, 3.419, 3.376
	 * 
	 * 
	 * mysql 100000 loops - 24.498, 26.163, 26.623, 26.716, 25.719
	 * 
	 * hsql 100000 loops - 9.287, 9.571, 9.482, 9.511, 9.695
	 */

	@Test
	public void deveConterUsuarioComNomeCorreto() {

		usuario.setNome("João da Silva Machado");
		usuario.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(usuario);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertEquals("João da Silva Machado", joao.getNome());
	}

	@Test
	public void tabelaDeveConterSomenteUmaLinha() {
		usuario.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(usuario);
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

		usuario.setApelido("Pikachu Iluminado");
		usuario.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(usuario);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertEquals("Pikachu Iluminado", joao.getApelido());
	}

	@Test
	public void deveConterUsuarioComDataDeNascimentoCorreta() {

		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(1990, 1, 12);
		usuario.setDataNascimento(dataNascimento);
		usuario.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(usuario);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertThat(joao.getDataNascimento().getTime().toString(),
				containsString("Mon Feb 12"));
		assertThat(joao.getDataNascimento().getTime().toString(),
				containsString("1990"));
	}

	@Test
	public void deveConterUsuarioComEmailCorreto() {

		usuario.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(usuario);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertEquals("joao@gmail.com", joao.getEmail());
	}

	@Test
	public void deveConterUsuarioComTelefoneCorreto() {

		usuario.setTelefone("(11) 1111-1111");
		usuario.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(usuario);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertEquals("(11) 1111-1111", joao.getTelefone());
	}

	@Test
	public void deveConterUsuarioComCpfCorreto() {

		usuario.setCpf("000.000.000-00");
		usuario.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(usuario);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertEquals("000.000.000-00", joao.getCpf());
	}

	@Test
	public void deveConterUsuarioComRgCorrreto() {

		usuario.setRg("1234567-890");
		usuario.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(usuario);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertEquals("1234567-890", joao.getRg());
	}

	@Test
	public void deveConterUsuarioComEnderecoCorreto() {

		usuario.setEndereco("Rua Vergueiro, 18, São Paulo, SP");
		usuario.setEmail("joao@gmail.com");
		new UsuarioDAO(manager).salva(usuario);
		Usuario joao = new UsuarioDAO(manager).pega("joao@gmail.com");
		assertEquals("Rua Vergueiro, 18, São Paulo, SP", joao.getEndereco());
	}

	@After
	public void finaliza() {

		manager.getTransaction().rollback();
		manager.close();
	}
}