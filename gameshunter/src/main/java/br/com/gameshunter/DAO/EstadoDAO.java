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

	public List<Estado> pegaTodos(Pais pais){
		Query query = this.manager.createQuery("select e from Estado as e "
				+ "where e.pais= :pPais");
		query.setParameter("pPais", pais);
		@SuppressWarnings("unchecked")
		List<Estado> estados = query.getResultList();
		return estados;
	}

	public void fechaConexao() {
		this.manager.close();
	}

	public Estado pega(Integer id) {
		return manager.find(Estado.class, id);
	}
}
