package br.com.gameshunter.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.gameshunter.model.User;

/**
 * Representa todo tipo de conexão relacionado ao Usuário.
 * 
 * @author Alex
 * @author Myho
 *
 * @since 0.0.1
 */
@Repository
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;

	public void add(User usuario) {
		manager.persist(usuario);
	}

	public User find(String email) {
		return manager.find(User.class, email);
	}

	public void update(User usuario) {
		manager.merge(usuario);
	}
}