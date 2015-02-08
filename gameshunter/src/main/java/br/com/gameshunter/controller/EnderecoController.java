package br.com.gameshunter.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.gameshunter.model.Cep;

@Controller
@RequestMapping("endereco")
public class EnderecoController {

	@PersistenceContext
	private EntityManager manager;

	@RequestMapping(value = "cep/{cep}")
	public @ResponseBody Cep cep(@PathVariable("cep") String cep) {

		List<Cep> logradouro = manager.createQuery("select l from Logradouro l where l.cep = :cep", Cep.class)
				.setParameter("cep", cep).getResultList();

		if (!logradouro.isEmpty())
			return logradouro.get(0);

		List<Cep> cidade = manager.createQuery("select c from Cidade c where c.cep = :cep", Cep.class)
				.setParameter("cep", cep).getResultList();
		return !cidade.isEmpty() ? cidade.get(0) : null;
	}
}