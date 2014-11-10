package br.com.gameshunter.util;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gameshunter.model.Cidade;

/**
 * Realiza ações complementares para a classe Cidade
 * 
 * @author Alex
 */
public class CidadeUtil {

	private EntityManager manager;

	/**
	 * @param manager
	 *            EntityManager
	 */
	public CidadeUtil(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * Popula o banco com todos as Cidades através de um arquivo .xml
	 */
	public void populaCidade() {

		@SuppressWarnings("unchecked")
		List<Cidade> cidades = (List<Cidade>) new LeitorDeXML().pega(
				"cidades.xml").criaObjetos();

		manager.getTransaction().begin();
		for (Cidade cidade : cidades) {
			manager.persist(cidade);
		}
		manager.getTransaction().commit();

		manager.close();
	}
}