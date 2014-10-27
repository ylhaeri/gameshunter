package br.com.gameshunter.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

	public void fechaConexao() {
		this.manager.close();

	}

	public Pais pega(Integer id) {
		return manager.find(Pais.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Pais> pegaTodos() {
		return manager.createQuery("select p from Pais p").getResultList();
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
}