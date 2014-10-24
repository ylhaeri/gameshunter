package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gameshunter.model.Pais;

public class PaisDAO implements DatabaseDAO<Pais, Integer> {

	private EntityManager manager;

	public PaisDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void atualiza(Pais pais) {
		this.manager.merge(pais);
	};

	@Override
	public Long conta() {
		Query query = manager.createQuery("select Count(p) from Pais p");
		return (Long) query.getSingleResult();
	}

	@Override
	public Pais pega(Integer id) {

		return this.manager.find(Pais.class, id);
	}

	@Override
	public void salva(Pais pais) {
		this.manager.persist(pais);

	}

	@Override
	public void remove(Pais pais) {
		this.manager.merge(pais);
		this.manager.remove(pais);

	}

	@Override
	public void iniciaTransaction() {
		this.manager.getTransaction().begin();

	}

	@Override
	public void commit() {
		this.manager.getTransaction().commit();

	}
}
