package br.com.gameshunter.DAO;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gameshunter.factory.EnderecoFactory;
import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;

public class EnderecoDAOTest {

	private EntityManager manager;
	private static EnderecoDAO eDao;
	private Endereco endereco;
	private static int id;
	private static EnderecoFactory eFactory;
	private static Pais pais;
	private static Estado estado;
	private static Cidade cidade;

	@BeforeClass
	public static void globalSetUp() {
		new JPAUtil();
		id = Indice.pegaEndereco();
		eFactory = new EnderecoFactory();
		cidade = new Cidade();
		estado = new Estado();
		pais = new Pais();

		pais.setId(30);
		pais.setNome("Brasil");
		pais.setSigla("BR");

		estado.setId(66);
		estado.setNome("São Paulo");
		estado.setUf("SP");
		estado.setPais(pais);

		cidade.setId(7270);
		cidade.setNome("São Paulo");
		cidade.setEstado(estado);
	}

	@Before
	public void inicia() {
		endereco = eFactory.repetido();
		manager = new JPAUtil().getEntityManager();
		eDao = new EnderecoDAO(manager);
		manager.getTransaction().begin();
	}

	@After
	public void finaliza() {
		manager.getTransaction().rollback();
		manager.close();
	}

	@Test
	public void deveAdicionarUmEndereco() {

		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua paranaue");
		endereco.setNumero(123);
		endereco.setBairro("Parque Br");
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setCep("31456892");
		endereco.setComplemento("Conj B");
		endereco.setPais(pais);

		manager.persist(pais);
		manager.persist(estado);
		manager.persist(cidade);
		salva(endereco);

		Endereco resultado = eDao.pega(id);
		Long contagem = eDao.conta();

		assertThat(contagem, equalTo(1l));
		assertThat(resultado, equalTo(endereco));
	}

	@Test
	public void deveAtualizaEndereco() {

		salva(endereco);

		endereco.setLogradouro("Rua Nova Lua");

		eDao.atualiza(endereco);

		Endereco resultado = eDao.pega(id);
		Long contagem = eDao.conta();

		assertThat(contagem, equalTo(1l));
		assertThat(resultado, equalTo(endereco));

	}

	@Test
	public void deveRemoverEndereco() {

		endereco.setCidade("Osasco");

		salva(endereco);

		assertThat(eDao.pega(id), equalTo(endereco));

		eDao.remove(endereco);

		Endereco resultado = eDao.pega(id);
		Long contagem = eDao.conta();

		assertThat(contagem, equalTo(0l));
		assertNull(resultado);
	}

	@Test
	public void deveConterAQuantidadeCorretaDeEnderecos() {

		salva(endereco);

		Endereco end2 = new Endereco();
		end2.setBairro("paranaue");
		salva(end2);

		assertThat(eDao.conta(), equalTo(2L));
	}

	@Test
	public void deveSaberIniciarTransactionECommitarCorretamente() {

		this.manager.close();
		manager = new JPAUtil().getEntityManager();

		eDao = new EnderecoDAO(manager);

		eDao.iniciaTransaction().salva(endereco).commit().close();
		id++;
		Indice.contaEndereco();

		manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		eDao = new EnderecoDAO(manager);

		Long contagem = eDao.conta();
		Endereco encontrado = eDao.pega(id);

		eDao.remove(encontrado).commit().close();

		manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		eDao = new EnderecoDAO(manager);

		assertThat(contagem, equalTo(1l));
		assertThat(encontrado, equalTo(endereco));
	}

	private void salva(Endereco end) {
		id++;
		eDao.salva(end);
		Indice.contaEndereco();
	}
}