package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.gameshunter.model.Usuario;

/**
 * A classe {@code UsuarioDAO} representa todo tipo de conexão relacionado à
 * classe {@code Usuario}
 * 
 * @author Alex
 *
 * @since 0.0.1
 */
public class UsuarioDAO {

	/**
	 * Cadastra um usuário no banco de dados
	 * 
	 * @param Usuário
	 *            *
	 * @since 0.0.1
	 */
	public void setUsuario(Usuario usuario) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("gameshunter");

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();

		manager.close();
	}

}
