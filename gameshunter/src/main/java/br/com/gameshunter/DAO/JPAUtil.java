package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory gamesHunter;

	static {
		gamesHunter = Persistence.createEntityManagerFactory("tarefa");
	}

	public EntityManager getEntityManager() {
		return gamesHunter.createEntityManager();
	}

	public void closeFactory() {
		gamesHunter.close();
	}

}
