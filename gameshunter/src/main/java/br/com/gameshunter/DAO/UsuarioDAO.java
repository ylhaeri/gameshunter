package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gameshunter.model.Usuario;

/**
 * Representa todo tipo de conexão relacionado ao Usuário.
 * 
 * @author Alex
 * @author Myho
 *
 * @since 0.0.1
 */
public class UsuarioDAO implements DatabaseDAO<Usuario, String> {

	private EntityManager manager;

	@Override
	public Long conta() {
		criaManager();
		Query query = manager.createQuery("select count(u) from Usuario u");
		Long contagem = (Long) query.getSingleResult();
		manager.close();
		return contagem;
	}

	@Override
	public void salva(Usuario usuario) {
		criaManager();
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public Usuario pega(String email) {
		criaManager();
		Usuario usuario = manager.find(Usuario.class, email);
		manager.close();
		return usuario;
	}

	@Override
	public void atualiza(Usuario usuario) {
		criaManager();
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void remove(Usuario usuario) {
		criaManager();
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.remove(usuario);
		manager.getTransaction().commit();
		manager.close();
	}

	private void criaManager() {
		this.manager = new JPAUtil().getEntityManager();
	}

	/*
	 * Método deve ser usado somente para testes. Deve ser colocada como default
	 * method assim que possível.
	 */
	@Override
	public Long conta(EntityManager manager) {
		Query query = manager.createQuery("select count(u) from Usuario u");
		return (Long) query.getSingleResult();
	}

	/*
	 * Método deve ser usado somente para testes. Deve ser colocado como default
	 * method assim que possível.
	 */
	@Override
	public Usuario pega(EntityManager manager, String email) {
		return manager.find(Usuario.class, email);
	}
}