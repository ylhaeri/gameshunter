package br.com.gameshunter.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Estado;

public class CidadeDAO {

	EntityManager manager;

	public CidadeDAO(EntityManager manager) {
		this.manager = manager;
	}

	public List<Cidade> pega(Estado estado) {
		Query query = manager.createQuery("Select c from Cidade as c "
				+ "where c.estado= :pEstado");
		query.setParameter("pEstado", estado);
		@SuppressWarnings("unchecked")
		List<Cidade> cidades = query.getResultList();
		return cidades;
	}

	public void fechaConexao() {
		this.manager.close();
	}

}
