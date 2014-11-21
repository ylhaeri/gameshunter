package br.com.gameshunter.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.gameshunter.model.Pais;

public class PaisDAO implements BasicDbDAO {

	private EntityManager manager;

	public PaisDAO(EntityManager manager) {
		this.manager = manager;
	}

	public List<Pais> pega() {
		Query query = manager.createQuery("select from Pais");
		@SuppressWarnings("unchecked")
		List<Pais> paises = query.getResultList();
		return paises;
	}

	public Pais pega(Integer id) {
		return manager.find(Pais.class, id);
	}

	public List<Pais> pegaTodos() {
		return manager.createQuery("select p from Pais p", Pais.class).getResultList();
	}

	@Override
	public PaisDAO iniciaTransaction() {
		manager.getTransaction().begin();
		return this;
	}

	@Override
	public PaisDAO commit() {
		manager.getTransaction().commit();
		return this;
	}

	@Override
	public void close() {
		manager.close();
	}

	@Override
	public Long conta() {
		TypedQuery<Long> query = manager.createQuery(
				"select count (p) from Pais p", Long.class);
		return query.getSingleResult();
	}
}