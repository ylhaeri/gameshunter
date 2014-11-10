package br.com.gameshunter.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import br.com.gameshunter.DAO.CidadeDAO;
import br.com.gameshunter.DAO.EstadoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.PaisDAO;
import br.com.gameshunter.util.LeitorDeArquivo;

import com.thoughtworks.xstream.XStream;

public class Teste {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		XStream xstream = new XStream();
		// List<Pais> paises = new
		// PaisDAO(JPAUtil.getEntityManager()).pegaTodos();
		//
		// try {
		// PrintStream xmlPaises = new PrintStream("paises.xml");
		// PrintStream xmlEstados = new PrintStream("estados.xml");
		// PrintStream xmlCidades = new PrintStream("cidades.xml");
		// xmlPaises.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		// xmlPaises.println("<paises>");
		// xmlEstados.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		// xmlEstados.println("<estados>");
		// xmlCidades.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		// xmlCidades.println("<cidades>");
		// for (Pais pais : paises) {
		// List<Estado> estados = new EstadoDAO(JPAUtil.getEntityManager())
		// .pegaTodos(pais);
		// for (Estado estado : estados) {
		// List<Cidade> cidades = new CidadeDAO(
		// JPAUtil.getEntityManager()).pegaTodos(estado);
		// String cidadeXml = xstream.toXML(cidades);
		// }
		// String estadoXml = xstream.toXML(estados);
		// xmlEstados.println(estadoXml);
		//
		// }
		// String paisXml = xstream.toXML(paises);
		// xmlPaises.println(paisXml);
		// xmlPaises.println("</paises>");
		// xmlEstados.println("</estados>");
		// xmlCidades.println("</cidades>");
		//
		// xmlPaises.close();
		// xmlEstados.close();
		// xmlCidades.close();
		// JPAUtil.closeFactory();
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		List<String> leitura = new LeitorDeArquivo().pega("estados.xml");
		leitura.remove(0);
		leitura.remove(0);
		leitura.remove(leitura.size() - 1);
		StringBuffer buffer = new StringBuffer();
		leitura.forEach(linha -> buffer.append(linha));
		List<Estado> pais = (List<Estado>) xstream.fromXML(buffer.toString());
		System.out.println(pais.size());
	}
}