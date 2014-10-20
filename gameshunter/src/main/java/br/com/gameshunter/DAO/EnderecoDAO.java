package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;

import br.com.gameshunter.model.Endereco;

public class EnderecoDAO {

	private EntityManager manager;

	public EnderecoDAO() {
		manager = new JPAUtil().getEntityManager();
	}

	public void salva(Endereco endereco) {
		manager.getTransaction().begin();
		manager.persist(endereco);
		manager.getTransaction().commit();
	}

	public Endereco pega(String chave) {
		return manager.find(Endereco.class, chave);
	}
}