package br.com.gameshunter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gameshunter.dao.EnderecoDAO;
import br.com.gameshunter.model.Endereco;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoDAO dao;

	@Transactional
	public void add(Endereco endereco) {
		dao.add(endereco);
	}
}