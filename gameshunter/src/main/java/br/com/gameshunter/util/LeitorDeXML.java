package br.com.gameshunter.util;

import java.util.List;

import com.thoughtworks.xstream.XStream;

/**
 * Leitor de arquivos .xml
 * 
 * @author Myho
 */
public class LeitorDeXML {

	private XStream xstream = new XStream();
	private StringBuffer buffer = new StringBuffer();

	/**
	 * @return
	 */
	public Object criaObjetos() {
		return xstream.fromXML(buffer.toString());
	}

	/**
	 * Faz a leitura de um arquivo xml. É necessário que o arquivo esteja
	 * formatado corretamente.
	 * 
	 * @param arquivo
	 *            arquivo que será lido
	 * @return ele mesmo
	 */
	public LeitorDeXML pega(String arquivo) {
		List<String> leitura = new LeitorDeArquivo().pega(arquivo);
		leitura.remove(0);
		leitura.remove(0);
		leitura.remove(leitura.size() - 1);
		for (String linha : leitura) {
			buffer.append(linha);
		}

		return this;
	}
}