package br.com.gameshunter.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gameshunter.model.Pais;

public class PaisDAO {

	private EntityManager manager;

	public PaisDAO(EntityManager manager) {
		this.manager = manager;
	}

	public List<Pais> pega(){
		Query query = manager.createQuery("select from Pais");
		@SuppressWarnings("unchecked")
		List<Pais> paises = query.getResultList();
		return paises;
	}
	
	public void fechaConexao() {
		this.manager.close();

	}
}
