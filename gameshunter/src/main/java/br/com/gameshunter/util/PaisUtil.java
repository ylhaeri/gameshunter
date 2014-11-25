package br.com.gameshunter.util;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.gameshunter.model.Pais;
import br.com.gameshunter.system.Arquivo;

/**
 * Realiza ações complementares para a classe Pais
 * 
 * @author Alex
 */
public class PaisUtil {

	private EntityManager manager;

	/**
	 * Constructor padrão
	 * 
	 * @param manager
	 *            EntityManager
	 */
	public PaisUtil(EntityManager manager) {
		this.manager = manager;
	}

	/** Popula o banco com todos os Países */
	public void populaPais() {

		File arqPaises = Arquivo.defaultPath("\\xml\\paises.xml");
		@SuppressWarnings("unchecked")
		List<Pais> paises = (List<Pais>) new LeitorXML(arqPaises)
				.comAlias("país", Pais.class).omitindoCampo(Pais.class, "id")
				.processa();

		manager.getTransaction().begin();
		for (Pais pais : paises) {
			manager.persist(pais);
		}
		manager.getTransaction().commit();
	}
}