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

		new EscritorXML("paises.xml").comAlias("país", Pais.class)
				.omitindoCampo(Pais.class, "id").from(paises).grava();
		new EscritorXML("estados.xml").comAlias("estado", Estado.class)
				.omitindoCampo(Estado.class, "id").from(estados).grava();
		new EscritorXML("cidades.xml").from(cidades)
				.comAlias("cidade", Cidade.class)
				.omitindoCampo(Cidade.class, "id").grava();
		manager.close();
		JPAUtil.closeFactory();
	}
}