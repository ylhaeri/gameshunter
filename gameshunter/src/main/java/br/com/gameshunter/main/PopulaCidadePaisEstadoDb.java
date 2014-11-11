package br.com.gameshunter.main;

import javax.persistence.EntityManager;

import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.util.CidadeUtil;
import br.com.gameshunter.util.EstadoUtil;
import br.com.gameshunter.util.PaisUtil;

public class PopulaCidadePaisEstadoDb {

	public static void main(String[] args) {
		double inicio = System.currentTimeMillis();
		EntityManager manager = JPAUtil.getEntityManager();
		new PaisUtil(manager).populaPais();
		new EstadoUtil(manager).populaEstado();
		new CidadeUtil(manager).populaCidade();
		manager.close();
		JPAUtil.closeFactory();
		double fim = System.currentTimeMillis();
		System.out.println(fim - inicio);
	}
}