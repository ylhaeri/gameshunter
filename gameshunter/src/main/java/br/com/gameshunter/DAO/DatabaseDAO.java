package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;

public interface DatabaseDAO<T, PK> {

	public Long conta();

	public void salva(T objeto);

	public T pega(PK chavePrimaria);

	public void remove(T objeto);

	public void atualiza(T objeto);

	default public void persist(EntityManager manager, T objeto) {
		manager.persist(objeto);
	}
}