package br.com.gameshunter.action;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gameshunter.DAO.EstadoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;

public class CatalogoDeEstados {

	public List<Estado> getEstados(Pais pais) {
		System.out.println(pais.getNome());
		EntityManager manager = new JPAUtil().getEntityManager();
		EstadoDAO eDao = new EstadoDAO(manager);
		List<Estado> estados = eDao.pegaTodos(pais);
		manager.close();
		return estados;
	}
}