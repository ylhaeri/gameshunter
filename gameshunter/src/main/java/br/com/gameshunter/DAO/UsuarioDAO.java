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

	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Long conta() {
		Query query = manager.createQuery("select count(u) from Usuario u");
		Long contagem = (Long) query.getSingleResult();
		return contagem;
	}

	@Override
	public UsuarioDAO salva(Usuario usuario) {
		manager.persist(usuario);
		return this;
	}

	@Override
	public Usuario pega(String email) {
		Usuario usuario = manager.find(Usuario.class, email);
		return usuario;
	}

	@Override
	public UsuarioDAO atualiza(Usuario usuario) {
		manager.merge(usuario);
		return this;
	}

	@Override
	public UsuarioDAO remove(Usuario usuario) {
		if (usuario.getEnderecos() != null)
			usuario.getEnderecos().forEach(
					e -> new EnderecoDAO(manager).remove(e));
		manager.merge(usuario);
		manager.remove(usuario);
		return this;
	}

	@Override
	public UsuarioDAO iniciaTransaction() {
		manager.getTransaction().begin();
		return this;
	}

	@Override
	public UsuarioDAO commit() {
		manager.getTransaction().commit();
		return this;
	}

	@Override
	public void close() {
		manager.close();
	}
}