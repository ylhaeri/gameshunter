package br.com.gameshunter.DAO;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gameshunter.factory.EnderecoFactory;
import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;

/**
 * Precisa dar um jeito aqui, tá esquisito terem 2 métodos para salvar.
 *
 */
public class EnderecoDAOTest {

	private EntityManager manager;
	private static EnderecoDAO enDao;
	private Endereco endereco;
	private static int id;
	private static EnderecoFactory eFactory;
	private Pais pais;
	private Estado estado;
	private Cidade cidade;

	@BeforeClass
	public static void globalSetUp() {
		JPAUtil.restartFactory();

		id = Indice.pegaEndereco();
		eFactory = new EnderecoFactory();
	}

	@Before
	public void inicia() {
		endereco = eFactory.repetido();
		manager = JPAUtil.getEntityManager();
		enDao = new EnderecoDAO(manager);
		manager.getTransaction().begin();

		pais = endereco.getPais();
		estado = endereco.getEstado();
		cidade = endereco.getCidade();
	}

	@After
	public void finaliza() {
		manager.getTransaction().rollback();
		manager.close();
	}

	@AfterClass
	public static void encerraBanco() {
		JPAUtil.closeFactory();
	}

	@Test
	public void deveAdicionarUmEnderecoComCidadePaisEEstado() {

		Pais pais = new Pais();
		pais.setNome("Brasil");
		pais.setSigla("BR");

		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setUf("SP");
		estado.setPais(pais);

		Cidade cidade = new Cidade();
		cidade.setNome("São Paulo");
		cidade.setEstado(estado);

		Endereco endereco = new Endereco();

		endereco.setCidade(cidade);

		persist(pais);
		persist(estado);
		persist(cidade);
		salva(endereco);

		Endereco resultado = enDao.pega(id);

		assertThat(enDao.conta(), equalTo(1l));
		assertThat(resultado, equalTo(endereco));
		assertThat(resultado.getPais(), equalTo(pais));
		assertThat(resultado.getEstado(), equalTo(estado));
		assertThat(resultado.getCidade(), equalTo(cidade));
	}

	@Test
	public void deveAdicionarUmEndereco() {

		pais = new Pais();
		pais.setNome("Brasil");
		pais.setSigla("BR");

		estado = new Estado();
		estado.setNome("São Paulo");
		estado.setUf("SP");
		estado.setPais(pais);

		cidade = new Cidade();
		cidade.setNome("São Paulo");
		cidade.setEstado(estado);

		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua paranaue");
		endereco.setNumero(123);
		endereco.setBairro("Parque Br");
		endereco.setCidade(cidade);
		endereco.setCep("31456892");
		endereco.setComplemento("Conj B");

		persist(pais);
		persist(estado);
		persist(cidade);
		salva(endereco);

		Endereco resultado = enDao.pega(id);

		assertThat(enDao.conta(), equalTo(1l));
		assertThat(resultado, equalTo(endereco));
		assertNotNull(resultado.getPais());
	}

	@Test
	public void deveAtualizarEndereco() {

		salva(endereco);

		assertThat(enDao.pega(id), equalTo(endereco));

		endereco.setLogradouro("Rua Nova Lua");

		persist(pais);
		persist(estado);
		persist(cidade);
		enDao.atualiza(endereco);

		Endereco resultado = enDao.pega(id);

		assertThat(enDao.conta(), equalTo(1l));
		assertThat(resultado, equalTo(endereco));
	}

	@Test
	public void deveRemoverEndereco() {

		persist(pais);
		persist(estado);
		persist(cidade);
		salva(endereco);

		assertThat(enDao.pega(id), equalTo(endereco));

		enDao.remove(endereco);

		Endereco resultado = enDao.pega(id);

		assertThat(enDao.conta(), equalTo(0l));
		assertNull(resultado);
	}

	@Test
	public void deveConterAQuantidadeCorretaDeEnderecos() {

		persist(pais);
		persist(estado);
		persist(cidade);
		salva(endereco);

		Endereco end2 = new Endereco();
		end2.setBairro("paranaue");
		salva(end2);

		assertThat(enDao.conta(), equalTo(2L));
	}

	@Test
	public void deveSaberIniciarTransactionECommitarCorretamente() {

		this.manager.close();
		manager = JPAUtil.getEntityManager();

		enDao = new EnderecoDAO(manager);

		persist(pais);
		persist(estado);
		persist(cidade);
		enDao.iniciaTransaction().salva(endereco).commit().close();
		id++;
		Indice.contaEndereco();

		manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		enDao = new EnderecoDAO(manager);

		Endereco encontrado = enDao.pega(id);
		Long contagem = enDao.conta();

		enDao.remove(encontrado).commit().close();

		manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		enDao = new EnderecoDAO(manager);

		assertThat(contagem, equalTo(1l));
		assertThat(encontrado, equalTo(endereco));
	}

	private void salva(Endereco end) {
		id++;
		enDao.salva(end);
		Indice.contaEndereco();
	}

	private void persist(Object o) {
		manager.persist(o);
	}
}