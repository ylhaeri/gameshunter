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
public class EnderecoDAO implements DbDAO<Endereco, Integer> {

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
	public EnderecoDAO salva(Endereco endereco) {
		manager.persist(endereco);
		return this;
	}

	@Override
	public Endereco pega(Integer id) {
		return manager.find(Endereco.class, id);
	}

	@Override
	public EnderecoDAO remove(Endereco endereco) {
		manager.merge(endereco);
		manager.remove(endereco);
		return this;
	}

	@Override
	public EnderecoDAO atualiza(Endereco endereco) {
		manager.merge(endereco);
		return this;
	}

	@Override
	public EnderecoDAO iniciaTransaction() {
		manager.getTransaction().begin();
		return this;
	}

	@Override
	public EnderecoDAO commit() {
		manager.getTransaction().commit();
		return this;
	}

	@Override
	public void close() {
		this.manager.close();
	}
}