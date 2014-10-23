package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gameshunter.model.Endereco;

/**
 * Representa todo tipo de conexão relacionada a Endereços.
 * 
 * @author Myho
 * @author Alex
 *
 * @since 0.0.1
 */
public class EnderecoDAO implements DatabaseDAO<Endereco, Integer> {

	private EntityManager manager;

	public EnderecoDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Long conta() {
		Query query = manager.createQuery("select count(e) from Endereco e");
		return (Long) query.getSingleResult();
	}

	@Override
	public void salva(Endereco endereco) {
		manager.persist(endereco);
	}

	@Override
	public Endereco pega(Integer id) {
		return manager.find(Endereco.class, id);
	}

	@Override
	public void remove(Endereco endereco) {
		manager.merge(endereco);
		manager.remove(endereco);
	}

	@Override
	public void atualiza(Endereco endereco) {
		manager.merge(endereco);
	}

	@Override
	public void iniciaTransaction() {
		manager.getTransaction().begin();
	}

	@Override
	public void commit() {
		manager.getTransaction().commit();
	}
}