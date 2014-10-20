package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;

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

	private EntityManager manager;

	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * Cadastra um usuário no banco de dados
	 * 
	 * @param usuario
	 *            Usuário que será adicionado ao banco
	 * 
	 */
	public UsuarioDAO salva(Usuario usuario) {
		manager.persist(usuario);
		return this;
	}

	/**
	 * Retorna o usuário desejado
	 * 
	 * @param email
	 *            Identifica o usuário no banco
	 * 
	 * @return usuario Object de Usuario
	 */
	public Usuario pega(String email) {

		return manager.find(Usuario.class, email);
	}

	/**
	 * Responsável por atualizar as informações do usuário no banco.
	 * 
	 * @param usuario
	 *            Usuário que será atualizado
	 * @return
	 * @return
	 */
	public Usuario atualiza(Usuario usuario) {
		return manager.merge(usuario);
	}

	/**
	 * Responsável por remover usuários do banco de dados.
	 * 
	 * @param usuario
	 *            Usuário que será removido.
	 * @return
	 */
	public Usuario remove(Usuario usuario) {
		manager.merge(usuario);
		manager.remove(usuario);

		return pega(usuario.getEmail());
	}

	/**
	 * Responsável por iniciar as transactions. Deve ser usado antes de qualquer
	 * ação com o banco de dados ser invocada.
	 * 
	 * @return Ele mesmo
	 */
	public UsuarioDAO inicia() {
		manager.getTransaction().begin();
		return this;
	}

	/**
	 * Responsável por fazer o commit e encerrar a transaction. Deve ser usado
	 * após iterações com o banco de dados, caso seja o efeito desejado.
	 */
	public void submete() {
		manager.getTransaction().commit();
		manager.close();
	}

	/**
	 * Responsável por reverter qualquer ação que ainda não tenha sido
	 * commitada. Deve ser usado após iterações com o banco de dados, caso seja
	 * o efeito desejado.
	 * 
	 * @return Ele mesmo
	 */
	public UsuarioDAO rollback() {

		manager.getTransaction().rollback();
		manager.close();
		return this;
	}
}
