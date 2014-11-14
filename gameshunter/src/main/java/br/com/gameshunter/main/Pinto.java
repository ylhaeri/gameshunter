package br.com.gameshunter.main;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gameshunter.DAO.CidadeDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.model.Cidade;

public class Pinto {

	public static void main(String[] args) throws InterruptedException {

		EntityManager manager = JPAUtil.getEntityManager();
		List<Cidade> lista = new CidadeDAO(manager).pegaTodos();
		manager.close();
		JPAUtil.closeFactory();
		System.out.println(lista.get(0).getEstado().getPais().getNome());
	}
}