package br.com.gameshunter.util;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import com.thoughtworks.xstream.XStream;

/**
 * Responsável por escrever XML
 * 
 * 
 * Pode ser utilizado através das ordens:<br>
 * .comAnotacoesDa(classe).from(objeto).grava()<br>
 * .comAlias(Alias).from(objeto).grava()<br>
 * .comAlias(Alias).comModo(2).from(objeto).grava()<br>
 * Ou derivados, desde que possua um objeto para trabalhar e seja invocado o
 * método grava no fim.
 * 
 * @author Myho
 */
public class EscritorXML {
	public XStream xStream = new XStream();
	private PrintStream ps;
	private Object objeto;

	/**
	 * Contructor principal da classe
	 * 
	 * @param arquivo
	 *            nome do arquivo que será escrito
	 * @param rootTag
	 *            nome da tag principal do arquivo
	 */
	public EscritorXML(String arquivo) {
		criaPs(arquivo);
	}

	/**
	 * Método opcional. Deve ser usado caso seja necessário algum Alias de
	 * Classe
	 * 
	 * @param alias
	 *            Alias que deve ser utilizado
	 * @param classe
	 *            classe que vai receber o Alias
	 * 
	 * @return ele mesmo
	 */
	public EscritorXML comAlias(String alias, Class<?> classe) {
		xStream.alias(alias, classe);
		return this;
	}

	/**
	 * Método opcional. Deve ser usado caso seja necessário algum Alias de
	 * campos da Classe
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
		xStream.aliasField(alias, classe, campo);
		return this;
	}

	/**
	 * Método opcional. Deve ser usado caso seja necessário omitir algum campo
	 * no xml
	 * 
	 * @param classe
	 *            Classe que possui o campo
	 * @param campo
	 *            Campo que deve ser omitido
	 * 
	 * @return ele mesmo
	 */
	public EscritorXML omitindoCampo(Class<?> classe, String campo) {
		xStream.omitField(classe, campo);
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
		xStream.setMode(mode);
		return this;
	}

	/**
	 * Cria a representação XML do objeto desejado
	 * 
	 * @param objeto
	 *            objeto que contém o conteúdo
	 * 
	 * @return ele mesmo
	 */
	public EscritorXML from(Object objeto) {
		this.objeto = objeto;
		return this;
	}

	/**
	 * Realiza o processo de gravar o objeto para o seu formato xml serializado
	 * 
	 * @return ele mesmo
	 */
	public void grava() {
		xStream.toXML(objeto, ps);
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
			ps.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		} catch (FileNotFoundException e) {
			System.out.println("Não foi possível encontrar o arquivo: "
					+ arquivo);
			e.printStackTrace();
		}
	}
}