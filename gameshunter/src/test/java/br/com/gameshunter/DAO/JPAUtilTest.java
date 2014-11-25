package br.com.gameshunter.DAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.gameshunter.dao.JPAUtil;

public class JPAUtilTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void deveCriarEntityManagerCorretamente() {

		JPAUtil.restartFactory();

		EntityManager manager = JPAUtil.getEntityManager();

		assertNotNull(manager);
		assertTrue(manager.isOpen());

		JPAUtil.closeFactory();
	}

	@Test
	public void deveSaberFecharConexao() {

		JPAUtil.restartFactory();

		exception.expect(IllegalStateException.class);
		exception.expectMessage("EntityManagerFactory is closed");

		JPAUtil.closeFactory();
		JPAUtil.getEntityManager();
	}

	@Test
	public void deveSaberReiniciarConexao() {

		JPAUtil.restartFactory();

		JPAUtil.closeFactory();
		JPAUtil.restartFactory();

		EntityManager manager = JPAUtil.getEntityManager();

		assertNotNull(manager);
		assertTrue(manager.isOpen());

		JPAUtil.closeFactory();
	}
}