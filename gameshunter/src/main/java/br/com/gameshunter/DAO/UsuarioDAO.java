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
	public void salva(Usuario usuario) {
		manager.persist(usuario);
	}

	@Override
	public Usuario pega(String email) {
		Usuario usuario = manager.find(Usuario.class, email);
		return usuario;
	}

	@Override
	public void atualiza(Usuario usuario) {
		manager.merge(usuario);
	}

	@Override
	public void remove(Usuario usuario) {
		if (usuario.getEnderecos() != null)
			usuario.getEnderecos().forEach(
					e -> new EnderecoDAO(manager).remove(e));
		manager.merge(usuario);
		manager.remove(usuario);
	}

	@Override
	public void iniciaTransaction() {
		this.manager.getTransaction().begin();
	}

	@Override
	public void commit() {
		this.manager.getTransaction().commit();
		this.manager.close();
	}

	@Override
	public void fechaConexao() {
		this.manager.close();

	}
}