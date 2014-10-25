package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;

import br.com.gameshunter.model.Cidade;

public class CidadeDAO implements BasicDbDAO {

	private EntityManager manager;

	public CidadeDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public Cidade pega(Integer id) {
		return manager.find(Cidade.class, id);
	}

	@Override
	public CidadeDAO iniciaTransaction() {
		manager.getTransaction().begin();
		return this;
	}

	@Override
	public CidadeDAO commit() {
		manager.getTransaction().commit();
		return this;
	}

	@Override
	public void close() {
		manager.close();
	}

}