package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("gameshunter");
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void closeFactory() {
		emf.close();
	}
}