package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gameshunter.DAO.EnderecoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.factory.EnderecoFactory;
import br.com.gameshunter.model.Endereco;

public class EnderecoDAOTest {

	private EntityManager manager;
	private static EnderecoDAO eDao;
	private Endereco endereco;
	private static int id = 0;
	private static EnderecoFactory eFactory;

	@BeforeClass
	public static void globalSetUp() {
		new JPAUtil();
		eDao = new EnderecoDAO();
		eFactory = new EnderecoFactory();
	}

	@Before
	public void inicia() {
		endereco = eFactory.repetido();
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
	public void adicionaUmEndereco() {

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

		Endereco esperado = pega(id);

		assertThat(endereco, equalTo(esperado));

	}

	@Test
	public void atualizaEndereco() {

		salva(endereco);

		endereco.setLogradouro("Rua Nova Lua");

		atualiza(endereco);

		Endereco resultado = pega(id);

		assertThat(resultado, equalTo(endereco));

	}

	@Test
	public void removeEndereco() {

		endereco.setCidade("Osasco");

		salva(endereco);

		remove(endereco);

		Endereco resultado = pega(id);

		assertNull(resultado);
	}

	@Test
	public void quantidadeDeEnderecos() {

		salva(endereco);

		Endereco end2 = new Endereco();
		end2.setBairro("paranaue");
		salva(end2);

		assertThat(conta("Endereco"), equalTo(2L));
	}
	
	

	private void salva(Endereco end) {
		id++;
		eDao.salva(manager, end);
	}

	private void remove(Endereco end) {
		eDao.remove(manager, end);
	}

	private Long conta(String tabela) {
		return eDao.conta(manager, tabela);
	}

	private void atualiza(Endereco end) {
		eDao.atualiza(manager, end);
	}

	private Endereco pega(Integer id) {
		return eDao.pega(manager, Endereco.class, id);
	}
}
