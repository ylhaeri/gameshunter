package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gameshunter.model.Endereco;

public class EnderecoDAOTest {

	private static final String COMPLEMENTO = "Apto. 302, bloco 5";
	private static final String PAIS = "Brasil";
	private static final String CEP = "11111-111";
	private static final String ESTADO = "SP";
	private static final String CIDADE = "São Paulo";
	private static final String BAIRRO = "Gelado";
	private static final int NUMERO = 18;
	private static final String RUA = "Rua Vergueiro";
	private Endereco endereco;
	private EntityManager manager;
	private EnderecoDAO eDao;

	@BeforeClass
	public static void inicializa() {
		new JPAUtil();
	}

	@Before
	public void setUp() {
		endereco = new Endereco(RUA, NUMERO, COMPLEMENTO, BAIRRO, CIDADE,
				ESTADO, CEP, PAIS);
		manager = new JPAUtil().getEntityManager();
		eDao = new EnderecoDAO();
		manager.getTransaction().begin();
	}

	@After
	public void finaliza() {
		Query query = manager.createQuery("delete from Endereco e");
		query.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
	}

	@Test
	public void deveCadastrarNovoEndereco() {

		Endereco esperado = new Endereco(RUA, NUMERO, COMPLEMENTO, BAIRRO,
				CIDADE, ESTADO, CEP, PAIS);
		eDao.salva(endereco);
		assertThat(eDao.pega(endereco.getChave()), equalTo(esperado));
	}
}