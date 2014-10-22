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

	@Override
	public Long conta() {
		criaManager();
		Query query = manager.createQuery("select count(e) from Endereco e");
		Long contagem = (Long) query.getSingleResult();
		manager.close();
		return contagem;
	}

	@Override
	public void salva(Endereco endereco) {
		criaManager();
		manager.getTransaction().begin();
		manager.persist(endereco);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public Endereco pega(Integer id) {
		return manager.find(Endereco.class, id);
	}

	@Override
	public void remove(Endereco endereco) {
		criaManager();
		manager.getTransaction().begin();
		manager.merge(endereco);
		manager.remove(endereco);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void atualiza(Endereco endereco) {
		criaManager();
		manager.merge(endereco);
		manager.close();
	}

	private void criaManager() {
		this.manager = new JPAUtil().getEntityManager();
	}
}