package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gameshunter.model.Endereco;

public class EnderecoDAO implements DatabaseDAO<Endereco, Integer> {

	private EntityManager manager;

	public EnderecoDAO() {
		manager = new JPAUtil().getEntityManager();
	}

	@Override
	public void salva(Endereco endereco) {
		manager.getTransaction().begin();
		manager.persist(endereco);
		manager.getTransaction().commit();
	}

	@Override
	public Long conta() {
		Query query = manager.createQuery("select count(u) from Usuario u");
		return (Long) query.getSingleResult();
	}

	@Override
	public Endereco pega(Integer id) {
		return manager.find(Endereco.class, id);
	}

	@Override
	public void remove(Endereco endereco) {
		manager.remove(endereco);
	}

	@Override
	public void atualiza(Endereco endereco) {
		manager.merge(endereco);
	}
}