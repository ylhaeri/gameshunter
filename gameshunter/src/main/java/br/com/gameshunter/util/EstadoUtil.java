package br.com.gameshunter.util;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gameshunter.model.Estado;

/**
 * Realiza ações complementares para a classe Estado
 * 
 * @author Alex
 */
public class EstadoUtil {

	private EntityManager manager;

	/**
	 * @param manager
	 *            EntityManager
	 */
	public EstadoUtil(EntityManager manager) {
		this.manager = manager;
	}

	/** Popula o banco com todos os Estados através de um arquivo .xml */
	public void populaEstado() {

		@SuppressWarnings("unchecked")
		List<Estado> estados = (List<Estado>) new LeitorDeXML().pega(
				"estados.xml").criaObjetos();

		manager.getTransaction().begin();
		for (Estado estado : estados) {
			manager.persist(estado);
		}
		manager.getTransaction().commit();
		
		manager.close();
	}
}