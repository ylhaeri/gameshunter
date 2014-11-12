package br.com.gameshunter.util;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.gameshunter.model.Estado;
import br.com.gameshunter.system.Arquivo;

/**
 * Realiza ações complementares para a classe Estado
 * 
 * @author Alex
 */
public class EstadoUtil {

	private EntityManager manager;

	/**
	 * Constructor padrão
	 * 
	 * @param manager
	 *            EntityManager
	 */
	public EstadoUtil(EntityManager manager) {
		this.manager = manager;
	}

	/** Popula o banco com todos os Estados */
	public void populaEstado() {

		File arqEstados = Arquivo.noDiretorioPadrao("\\xml\\estados.xml");
		@SuppressWarnings("unchecked")
		List<Estado> estados = (List<Estado>) new LeitorXML(arqEstados)
				.comAlias("estado", Estado.class)
				.omitindoCampo(Estado.class, "id").processa();

		manager.getTransaction().begin();
		for (Estado estado : estados) {
			manager.persist(estado);
		}
		manager.getTransaction().commit();
	}
}