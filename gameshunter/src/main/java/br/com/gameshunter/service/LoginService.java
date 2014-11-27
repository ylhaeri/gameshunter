package br.com.gameshunter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gameshunter.dao.LoginDAO;
import br.com.gameshunter.model.Login;

@Service
public class LoginService {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private LoginDAO dao;

	@Transactional
	public void add(Login login) {
		usuarioService.add(login.getUsuario());
		login.geraCod();
		login.geraSenha();
		dao.add(login);
	}
}