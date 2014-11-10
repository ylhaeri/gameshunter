package br.com.gameshunter.util;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import com.thoughtworks.xstream.XStream;

/**
 * Responsável por escrever XML
 * 
 * Pode ser utilizado através das ordens:
 * .comAnotacoesDa(classe).from(objeto).grava()
 * .comAlias(Alias).from(objeto).grava()
 * .comAlias(Alias).comAnotacoesDa(Classe).comModo(2).from(objeto).grava() Ou
 * derivados, desde que possua um objeto para trabalhar e seja invocado o método
 * grava no fim.
 * 
 * Importante lembrar que o método .from(objeto) deve ser usado antes do método
 * grava somente.
 * 
 * @author Myho
 */
public class EscritorXML {
	public XStream xstream = new XStream();
	private PrintStream ps;
	private String xml;
	private String rootTag;

	/**
	 * Contructor principal da classe
	 * 
	 * @param arquivo
	 *            nome do arquivo que será escrito
	 * @param rootTag
	 *            nome da tag principal do arquivo
	 */
	public EscritorXML(String arquivo, String rootTag) {
		criaPs(arquivo);
		this.rootTag = rootTag;
	}

	/**
	 * Método opcional, deve ser usado caso a classe possua Alias ou campos que
	 * devem ser omitidos do processo
	 * 
	 * @param classe
	 *            classe que contém as anotações
	 * 
	 * @return ele mesmo
	 */
	public EscritorXML comAnotacoesDa(Class<?> classe) {
		xstream.processAnnotations(classe);
		System.out.println(classe);
		return this;
	}

	/**
	 * Método opcional. Deve ser usado caso seja necessário algum Alias mas a
	 * classe não possua anotações
	 * 
	 * @param alias
	 *            Alias que deve ser utilizado
	 * @param classe
	 *            classe que vai receber o Alias
	 * 
	 * @return ele mesmo
	 */
	public EscritorXML comAlias(String alias, Class<?> classe) {
		xstream.alias(alias, classe);
		return this;
	}

	/**
	 * Método opcional. Deve ser usado caso seja necessário algum Alias mas a
	 * classe não possua anotações
	 * 
	 * @param alias
	 *            Alias que deve ser utilizado
	 * @param classe
	 *            Classe que vai receber o Alias
	 * @param campo
	 *            Campo da classe a qual o Alias deve ser atribuido
	 * 
	 * @return ele mesmo
	 */
	public EscritorXML comAlias(String alias, Class<?> classe, String campo) {
		xstream.aliasField(alias, classe, campo);
		return this;
	}

	/**
	 * Método opcional, deve ser usado caso o modo default do escritor não seja
	 * o desejado
	 * 
	 * @param mode
	 *            modo que deve ser gerado
	 * 
	 * @return ele mesmo
	 */
	public EscritorXML comModo(int mode) {
		xstream.setMode(mode);
		return this;
	}

	/**
	 * Cria a representação XML do objeto desejado
	 * 
	 * Só utilize antes do método grava() para evitar resultado fora do esperado
	 * 
	 * @param objeto
	 *            objeto que contém o conteúdo
	 * 
	 * @return ele mesmo
	 */
	public EscritorXML from(Object objeto) {
		xml = xstream.toXML(objeto);
		return this;
	}

	/**
	 * Realiza o processo de gravar o objeto para o seu formato xml serializado
	 */
	public void grava() {
		ps.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		ps.println("<" + rootTag + ">");
		ps.println(xml);
		ps.print("</" + rootTag + ">");
		ps.close();
	}

	/**
	 * Cria o PrintStream para o arquivo
	 * 
	 * @param arquivo
	 *            nome do arquivo
	 */
	private void criaPs(String arquivo) {
		try {
			ps = new PrintStream(arquivo);
		} catch (FileNotFoundException e) {
			System.out.println("Não foi possível encontrar o arquivo: "
					+ arquivo);
			e.printStackTrace();
		}
	}
}