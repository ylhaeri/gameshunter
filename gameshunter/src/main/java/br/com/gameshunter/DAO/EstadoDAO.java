package br.com.gameshunter.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;

public class EstadoDAO {

	private EntityManager manager;

	public EstadoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public List<Estado> pegaTodos() {
		TypedQuery<Estado> query = manager.createQuery("select e from Estado e",
				Estado.class);
		return query.getResultList();
	}

	public List<Estado> pegaTodosDo(Pais pais) {
		TypedQuery<Estado> query = manager.createQuery(
				"select e from Estado as e " + "where e.pais= :pPais",
				Estado.class);
		query.setParameter("pPais", pais);
		return query.getResultList();
	}

	public void fechaConexao() {
		this.manager.close();
	}

	public Estado pega(Integer id) {
		return manager.find(Estado.class, id);
	}
}
