package br.com.gameshunter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.gameshunter.dao.UsuarioDAO;
import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO dao;
	@Autowired
	private EnderecoService enderecoService;

	@Transactional(value = "GamesHunterManager")
	public void add(Usuario usuario) {
		// place holder do envio de e-mail
		for (Endereco endereco : usuario.getEnderecos()) {
			enderecoService.add(endereco);
		}
		dao.add(usuario);
	}

	@Transactional(readOnly = true, propagation = Propagation.NEVER, value = "GamesHunterManager")
	public Usuario find(String email) {
		return dao.find(email);
	}
}