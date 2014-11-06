package br.com.gameshunter.DAO;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;
import br.com.gameshunter.util.CidadeUtil;
import br.com.gameshunter.util.EstadoUtil;
import br.com.gameshunter.util.PaisUtil;

public class InsercaoEnderecoDAOTest {

	private static EntityManager manager;
	private static CidadeDAO cDao;
	private EstadoDAO eDao;
	private PaisDAO pDao;

	@BeforeClass
	public static void globalSetUp() throws IOException {

		JPAUtil.restartFactory();

		manager = JPAUtil.getEntityManager();

		manager.getTransaction().begin();

		for (Pais pais : new PaisUtil().lerPais()) {
			manager.persist(pais);
		}

		for (Estado estado : new EstadoUtil().lerEstado()) {
			estado.setPais(manager.find(Pais.class, 1));
			manager.persist(estado);
		}

		for (Cidade cidade : new CidadeUtil().lerCidade()) {
			manager.persist(cidade);
		}

		manager.getTransaction().commit();

		manager.close();

	}

	@Before
	public void inicia() {
		manager = JPAUtil.getEntityManager();
		cDao = new CidadeDAO(manager);
		eDao = new EstadoDAO(manager);
		pDao = new PaisDAO(manager);
		manager.getTransaction().begin();
	}

	@After
	public void finaliza() {
		manager.getTransaction().rollback();
	}

	@AfterClass
	public static void encerraBanco() {
		JPAUtil.closeFactory();
	}

	@Test
	public void pegaPaises() {

		List<Pais> paises = pDao.pegaTodos();

		assertThat(paises.size(), equalTo(1));
	}

	@Test
	public void pegaEstado() {

		List<Estado> estados = eDao.pegaTodos(pDao.pega(1));

		assertThat(estados.size(), equalTo(27));
	}

	@Test
	public void devePegarTodasAsCidades() {

		List<Cidade> cidades = cDao.pegaTodos(eDao.pega(8));

		assertThat(cidades.size(), equalTo(78));

	}

	@Test
	public void verificaPrimeiroUltimoEstado() {

		Estado primeiro = eDao.pega(1);

		Estado esperadoPrimeiro = new Estado();
		esperadoPrimeiro.setNome("Acre");
		esperadoPrimeiro.setId(1);
		esperadoPrimeiro.setUf("AC");
		esperadoPrimeiro.setPais(pDao.pega(1));

		assertThat(primeiro, equalTo(esperadoPrimeiro));

		Estado ultimo = eDao.pega(27);

		Estado esperadoUltimo = new Estado();
		esperadoUltimo.setNome("Tocantins");
		esperadoUltimo.setId(27);
		esperadoUltimo.setUf("TO");
		esperadoUltimo.setPais(pDao.pega(1));

		assertThat(ultimo, equalTo(esperadoUltimo));

	}

	@Test
	public void verificaPrimeraUltimaCidade() {

		Cidade primeira = cDao.pega(1);

		Cidade esperadaPrimeira = new Cidade();

		esperadaPrimeira.setNome("Afonso Cláudio");
		esperadaPrimeira.setId(1);
		esperadaPrimeira.setEstado(eDao.pega(8));

		assertThat(primeira, equalTo(esperadaPrimeira));

		Cidade ultima = cDao.pega(5564);

		Cidade esperadaUltima = new Cidade();
		esperadaUltima.setNome("Xambioá");
		esperadaUltima.setId(5564);
		esperadaUltima.setEstado(eDao.pega(27));

		assertThat(ultima, equalTo(esperadaUltima));
	}

}