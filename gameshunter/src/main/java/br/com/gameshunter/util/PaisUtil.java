package br.com.gameshunter.util;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gameshunter.model.Pais;

/**
 * Realiza ações complementares para a classe Pais
 * 
 * @author Alex
 */
public class PaisUtil {

	private EntityManager manager;

	/**
	 * @param manager
	 *            EntityManager
	 */
	public PaisUtil(EntityManager manager) {
		this.manager = manager;
	}

	/** Popula o banco com todos os Países através de um arquivo .xml */
	public void populaPais() {

		@SuppressWarnings("unchecked")
		List<Pais> paises = (List<Pais>) new LeitorDeXML().pega("paises.xml")
				.criaObjetos();

		manager.getTransaction().begin();
		paises.forEach(p -> manager.persist(p));
		manager.getTransaction().commit();

		manager.close();
	}
}