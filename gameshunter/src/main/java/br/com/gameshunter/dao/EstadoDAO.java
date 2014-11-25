package br.com.gameshunter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;

public class EstadoDAO implements BasicDbDAO {

	private EntityManager manager;

	public EstadoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public List<Estado> pegaTodos() {
		TypedQuery<Estado> query = manager.createQuery(
				"select e from Estado e", Estado.class);
		return query.getResultList();
	}

	public List<Estado> pegaTodosDo(Pais pais) {
		TypedQuery<Estado> query = manager.createQuery(
				"select e from Estado as e " + "where e.pais= :pPais",
				Estado.class);
		query.setParameter("pPais", pais);
		return query.getResultList();
	}

	public Estado pega(Integer id) {
		return manager.find(Estado.class, id);
	}

	@Override
	public BasicDbDAO iniciaTransaction() {
		manager.getTransaction().begin();
		return this;
	}

	@Override
	public BasicDbDAO commit() {
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
				"select count(e) from Estado e", Long.class);
		return query.getSingleResult();
	}
}
