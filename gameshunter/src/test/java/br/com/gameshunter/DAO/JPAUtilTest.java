package br.com.gameshunter.DAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.opensymphony.xwork2.interceptor.annotations.Before;

public class JPAUtilTest {

	@Before
	public void reiniciaConexao(){
		JPAUtil.restartFactory();
	}
	
	@Test (expected = IllegalStateException.class)
	public void verificaConexao() {

		EntityManager manager = JPAUtil.getEntityManager();

		assertNotNull(manager);
		
		JPAUtil.closeFactory();
		
		EntityManager manager2 = JPAUtil.getEntityManager();
		
	}

	@Test
	public void verificaPermanenciaConexao() {

		JPAUtil.closeFactory();

		JPAUtil.restartFactory();
		
		EntityManager manager = JPAUtil.getEntityManager();

		assertTrue(manager.isOpen());

	}
}
