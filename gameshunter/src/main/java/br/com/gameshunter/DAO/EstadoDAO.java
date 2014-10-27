package br.com.gameshunter.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;

public class EstadoDAO {

	private EntityManager manager;

	public EstadoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public List<Estado> pega(Pais pais){
		Query query = this.manager.createQuery("select e from Estado e "
				+ "where e.pais= :pPais");
		query.setParameter("pPais", pais);
		@SuppressWarnings("unchecked")
		List<Estado> estados = query.getResultList();
		return estados;
	}

	public void fechaConexao() {
		this.manager.close();
	}
}