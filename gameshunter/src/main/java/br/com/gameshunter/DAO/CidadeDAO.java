package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gameshunter.model.Cidade;

public class CidadeDAO implements DatabaseDAO<Cidade, Integer> {

	private EntityManager manager;

	public CidadeDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void atualiza(Cidade cidade) {
		this.manager.merge(cidade);
	};

	@Override
	public void salva(Cidade cidade) {
		this.manager.persist(cidade);
	}

	@Override
	public Cidade pega(Integer id) {
		return this.manager.find(Cidade.class, id);
	}

	@Override
	public void remove(Cidade cidade) {
		this.manager.merge(cidade);
		this.manager.remove(cidade);
	}

	@Override
	public Long conta() {
		Query query = manager.createQuery("select count(c) from Cidade c");
		return (Long) query.getSingleResult();
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
