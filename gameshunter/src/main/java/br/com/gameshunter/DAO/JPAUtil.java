package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory EMF;

	static {
		EMF = Persistence.createEntityManagerFactory("gameshunter");
	}

	public EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}

	public void closeFactory() {
		EMF.close();
	}

	public static void main(String[] args) {

		new JPAUtil();
	}
}