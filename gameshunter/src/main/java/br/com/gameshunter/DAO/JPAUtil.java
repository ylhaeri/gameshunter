package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory EMF;

	static {
		EMF = Persistence.createEntityManagerFactory("gameshunter");
	}

	public static void restartFactory(){
		EMF = Persistence.createEntityManagerFactory("gameshunter");
	}
	
	public static EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}

	public static void closeFactory() {
		EMF.close();
	}

}