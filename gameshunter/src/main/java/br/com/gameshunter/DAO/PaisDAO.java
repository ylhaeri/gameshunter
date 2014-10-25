package br.com.gameshunter.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gameshunter.model.Pais;

public class PaisDAO {

	private EntityManager manager;

	public PaisDAO(EntityManager manager) {
		this.manager = manager;
	}

	public Pais pega(Integer id) {
		return manager.find(Pais.class, id);
	}

	public PaisDAO iniciaTransaction() {
		manager.getTransaction().begin();
		return this;
	}

	public PaisDAO commit() {
		manager.getTransaction().commit();
		return this;
	}

	public void close() {
		manager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Pais> pegaTodos() {
		return manager.createQuery("select p from Pais p").getResultList();
	}
}