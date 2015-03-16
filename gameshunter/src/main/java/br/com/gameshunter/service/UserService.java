package br.com.gameshunter.service;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.gameshunter.dao.UsuarioDAO;
import br.com.gameshunter.model.User;
import br.com.gameshunter.system.AppConfig;

@Service
public class UserService {

	private UsuarioDAO dao;
	private SimpleEmail mail;

	@Autowired
	public UserService(UsuarioDAO dao, SimpleEmail mail) {
		this.dao = dao;
		this.mail = mail;
	}

	@Transactional
	public void add(User usuario) {
		// TODO placeholder do envio de e-mail
		// FIXME Precisa fazer a classe para enviar os e-mails
		if (AppConfig.isSendconfirmation()) {
			try {
				mail.addTo(usuario.getEmail(), usuario.getFirstName());
				mail.setSubject("Cadastro GamesHunter, sei la");
				mail.setMsg("Oi, ainda não tem mensagem, sorry");
				mail.send();
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}

		dao.add(usuario);
	}

	@Transactional(readOnly = true, propagation = Propagation.NEVER)
	public User find(String email) {
		User usuario = dao.find(email);
		if (usuario != null)
			return usuario;
		return null;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(User usuario) {
		dao.update(usuario);
	}
}