package br.com.gameshunter.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.gameshunter.model.Login;

@Repository
public class LoginDAO {

	@PersistenceContext
	private EntityManager manager;

	public void add(Login login) {
		manager.persist(login);
	}
}