package br.com.gameshunter.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("endereco")
public class EnderecoController {

	@PersistenceContext
	private EntityManager manager;

	@RequestMapping(value = "cep/{cep}")
	@ResponseBody
	public aa cep(@PathVariable("cep") String cep) {

		aa coisa = new aa();
		System.out.println(coisa.getCep());
		return coisa;
		// List<Cep> logradouro =
		// manager.createQuery("select l from Logradouro l where l.cep = :cep",
		// Cep.class)
		// .setParameter("cep", cep).getResultList();
		// if (!logradouro.isEmpty()) {
		// System.out.println(logradouro.get(0));
		// return logradouro.get(0);
		// }
		// List<Cep> cidade =
		// manager.createQuery("select c from Cidade c where c.cep = :cep",
		// Cep.class)
		// .setParameter("cep", cep).getResultList();
		// return !cidade.isEmpty() ? cidade.get(0) : null;
	}
}