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
import br.com.gameshunter.model.Endereco;

public class EnderecoDAOTest {

	private EntityManager manager;
	private static EnderecoDAO eDao;
	private Endereco endereco;
	private static int id;
	private static EnderecoFactory eFactory;
	

	@BeforeClass
	public static void globalSetUp() {
		new JPAUtil();
		id = Indice.pegaEndereco();
		eFactory = new EnderecoFactory();
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
		endereco.setCidade("São Paulo");
		endereco.setEstado("SP");
		endereco.setCep("31456892");
		endereco.setComplemento("Conj B");
		endereco.setPais("Brasil");

		salva(endereco);

		Endereco resultado = eDao.pega(id);
		Long contagem = eDao.conta();

		assertThat(contagem, equalTo(1l));
		assertThat(resultado, equalTo(endereco));
	}

	@Test
	public void atualizaEndereco() {

		salva(endereco);

		endereco.setLogradouro("Rua Nova Lua");

		eDao.atualiza(endereco);

		Endereco resultado = eDao.pega(id);
		Long contagem = eDao.conta();

		assertThat(contagem, equalTo(1l));
		assertThat(resultado, equalTo(endereco));

	}

	@Test
	public void removeEndereco() {

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
	public void quantidadeDeEnderecos() {

		salva(endereco);

		Endereco end2 = new Endereco();
		end2.setBairro("paranaue");
		salva(end2);

		assertThat(eDao.conta(), equalTo(2L));
	}

	private void salva(Endereco end) {
		id++;
		eDao.salva(end);
		Indice.contaEndereco();
	}
}