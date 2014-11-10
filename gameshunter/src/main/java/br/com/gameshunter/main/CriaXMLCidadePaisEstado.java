package br.com.gameshunter.main;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gameshunter.DAO.CidadeDAO;
import br.com.gameshunter.DAO.EstadoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.PaisDAO;
import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;
import br.com.gameshunter.util.EscritorXML;

public class CriaXMLCidadePaisEstado {

	public static void main(String[] args) {

		EntityManager manager = JPAUtil.getEntityManager();

		List<Pais> paises = new PaisDAO(manager).pegaTodos();
		List<Estado> estados = new EstadoDAO(manager).pegaTodos();
		List<Cidade> cidades = new CidadeDAO(manager).pegaTodos();

		new EscritorXML("paises.xml", "paises").comAnotacoesDa(Pais.class)
				.from(paises).grava();
		new EscritorXML("estados.xml", "estados").from(estados)
				.comAnotacoesDa(Estado.class).grava();
		new EscritorXML("cidades.xml", "cidades").comAnotacoesDa(Cidade.class)
				.from(cidades).grava();

		manager.close();
		JPAUtil.closeFactory();
	}
}