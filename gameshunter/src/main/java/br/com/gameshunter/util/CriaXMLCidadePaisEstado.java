package br.com.gameshunter.util;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.gameshunter.DAO.CidadeDAO;
import br.com.gameshunter.DAO.EstadoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.PaisDAO;
import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;

import com.thoughtworks.xstream.XStream;

public class CriaXMLCidadePaisEstado {

	public static void main(String[] args) throws FileNotFoundException {

		XStream xstream = new XStream();
		PrintStream paisPS = new PrintStream("paises.xml");
		PrintStream estadoPS = new PrintStream("estados.xml");
		PrintStream cidadePS = new PrintStream("cidades.xml");
		EntityManager manager = JPAUtil.getEntityManager();
		List<Pais> paises = new PaisDAO(manager).pegaTodos();
		List<Cidade> todasCidades = new ArrayList<>();
		List<Estado> todosEstados = new ArrayList<>();

		paisPS.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		paisPS.println("<paises>");
		estadoPS.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		estadoPS.println("<estados>");
		cidadePS.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		cidadePS.println("<cidades>");

		xstream.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		xstream.processAnnotations(Pais.class);
		xstream.processAnnotations(Estado.class);
		xstream.processAnnotations(Cidade.class);

		for (Pais pais : paises) {
			List<Estado> estados = new EstadoDAO(manager).pegaTodos(pais);
			for (Estado estado : estados) {
				List<Cidade> cidades = new CidadeDAO(manager).pegaTodos(estado);
				for (Cidade cidade : cidades) {
					todasCidades.add(cidade);
				}
				todosEstados.add(estado);
			}
		}

		paisPS.println(xstream.toXML(paises));
		estadoPS.println(xstream.toXML(todosEstados));
		cidadePS.println(xstream.toXML(todasCidades));

		paisPS.println("</paises>");
		estadoPS.println("</estados>");
		cidadePS.println("</cidades>");

		paisPS.close();
		estadoPS.close();
		cidadePS.close();
		manager.close();
		JPAUtil.closeFactory();
	}
}