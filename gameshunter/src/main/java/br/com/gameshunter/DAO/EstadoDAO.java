package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gameshunter.model.Estado;

public class EstadoDAO implements DatabaseDAO<Estado, Integer> {

	private EntityManager manager;

	public EstadoDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void atualiza(Estado estado) {
		this.manager.merge(estado);
	}

	@Override
	public Long conta() {
		Query query = manager.createQuery("select count(e) from Estado e");
		return (Long) query.getSingleResult();
	}

	@Override
	public Estado pega(Integer id) {
		return this.manager.find(Estado.class, id);
	}

	@Override
	public void remove(Estado estado) {
		this.manager.merge(estado);
		this.manager.remove(estado);
	}

	@Override
	public void salva(Estado estado) {
		this.manager.persist(estado);
	}

	@Override
	public void commit() {
		this.manager.getTransaction().commit();
	}

	@Override
	public void iniciaTransaction() {
		this.manager.getTransaction().begin();
	}

}
