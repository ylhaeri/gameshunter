package br.com.gameshunter.service;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.gameshunter.dao.UsuarioDAO;
import br.com.gameshunter.model.User;
import br.com.gameshunter.system.AppConfig;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService {

	private UsuarioDAO dao;
	private SimpleEmail mail;
	private DefaultPasswordService service;

	@Autowired
	public UserService(UsuarioDAO dao, SimpleEmail mail,
			DefaultPasswordService service) {
		this.dao = dao;
		this.mail = mail;
		this.service = service;
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public void add(User user) {
		// FIXME Precisa fazer a classe para enviar os e-mails
		user.setPassword(service.encryptPassword(user.getPassword()));
		if (AppConfig.isSendconfirmation()) {
			try {
				mail.addTo(user.getEmail(), user.getFirstName());
				mail.setSubject("Cadastro GamesHunter, sei la");
				mail.setMsg("Oi, ainda não tem mensagem, sorry");
				mail.send();
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}

		dao.add(user);
	}

	@Transactional(readOnly = true, propagation = Propagation.NEVER)
	public User find(Object email) {
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