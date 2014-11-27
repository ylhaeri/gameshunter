package br.com.gameshunter.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.gameshunter.model.Endereco;

/**
 * Representa todo tipo de conexão relacionada a Endereços.
 * 
 * @author Myho
 * @author Alex
 *
 * @since 0.0.1
 */
@Repository
public class EnderecoDAO {

	@PersistenceContext
	private EntityManager manager;

	public EntityManager getManager() {
		return manager;
	}

	public void add(Endereco endereco) {
		manager.persist(endereco);
	}
}