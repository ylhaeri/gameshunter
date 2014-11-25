package br.com.gameshunter.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.gameshunter.model.Usuario;

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

	@PersistenceContext(unitName = "GamesHunter")
	private EntityManager manager;

	public void add(Usuario usuario) {
		manager.persist(usuario);
	}

	public Usuario find(String email) {
		return manager.find(Usuario.class, email);
	}
}