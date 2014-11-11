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
	 * Constructor padrão
	 * 
	 * @param manager
	 *            EntityManager
	 */
	public CidadeUtil(EntityManager manager) {
		this.manager = manager;
	}

	/** Popula o banco com todas as Cidades */
	public void populaCidade() {

		@SuppressWarnings("unchecked")
		List<Cidade> cidades = (List<Cidade>) new LeitorXML("cidades.xml")
				.comAlias("cidade", Cidade.class)
				.omitindoCampo(Cidade.class, "id").processa();

		manager.getTransaction().begin();
		for (Cidade cidade : cidades) {
			manager.persist(cidade);
		}
		manager.getTransaction().commit();
	}
}