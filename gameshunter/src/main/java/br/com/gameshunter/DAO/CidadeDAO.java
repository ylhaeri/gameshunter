package br.com.gameshunter.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Estado;

public class CidadeDAO implements BasicDbDAO {

	EntityManager manager;

	public CidadeDAO(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * Pega todas as cidades cadastradas
	 * 
	 * @return As cidades cadastradas
	 */
	public List<Cidade> pegaTodos() {
		TypedQuery<Cidade> query = manager.createQuery(
				"Select c from Cidade c", Cidade.class);
		return query.getResultList();
	}

	/**
	 * Pega todas as cidades de um estado
	 * 
	 * @param estado
	 * @return As cidades do estado
	 */
	public List<Cidade> pegaTodosDo(Estado estado) {
		TypedQuery<Cidade> query = manager.createQuery(
				"Select c from Cidade c " + "where c.estado= :pEstado",
				Cidade.class);
		query.setParameter("pEstado", estado);
		return query.getResultList();
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

	@Override
	public Long conta() {
		TypedQuery<Long> query = manager.createQuery(
				"select count(c) from Cidade c", Long.class);
		return query.getSingleResult();
	}
}