package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gameshunter.JPAUtil.JPAUtil;
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
	 * @param usuario
	 *            Usuário que será adicionado ao banco
	 * 
	 * @since 0.0.1
	 */
	public void salva(Usuario usuario) {

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();

		manager.close();
	}

	/**
	 * Retorna um usuário desejado
	 * 
	 * @param email
	 *            identifica o usuário no banco
	 * 
	 * @return usuario Object de Usuario
	 */
	public Usuario pega(String email) {

		EntityManager manager = new JPAUtil().getEntityManager();

		Usuario usuario = manager.find(Usuario.class, email);
		return usuario;

	}
}