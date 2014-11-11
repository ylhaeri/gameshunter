package br.com.gameshunter.util;

import java.io.File;

import com.thoughtworks.xstream.XStream;

/**
 * Leitor de arquivos .xml
 * 
 * @author Myho
 */
public class LeitorXML {

	private XStream xStream = new XStream();
	private File arquivo;

	/**
	 * Constructor padrão
	 * 
	 * @param arquivo
	 */
	public LeitorXML(String arquivo) {
		this.arquivo = new File(arquivo);
	}

	/**
	 * Realiza a leitura e devolve os objetos contidos no xml
	 * 
	 * @return objetos contidos no xml
	 */
	public Object processa() {
		return xStream.fromXML(arquivo);
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
	public LeitorXML comAlias(String alias, Class<?> classe) {
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
	public LeitorXML comAlias(String alias, Class<?> classe, String campo) {
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
	public LeitorXML omitindoCampo(Class<?> classe, String campo) {
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
	public LeitorXML comModo(int mode) {
		xStream.setMode(mode);
		return this;
	}
}