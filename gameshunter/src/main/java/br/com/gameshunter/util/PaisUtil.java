package br.com.gameshunter.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.gameshunter.model.Pais;

/**
 * Métodos de utilização da class Pais
 * 
 * @author Alex
 *
 */
public class PaisUtil {

	private final String txtPais = "Pais.txt";

	public static void main(String[] args) throws IOException {
		System.out.println(new PaisUtil().lerPais());
	}

	/**
	 * lê todos os países de um arquivo .txt
	 * 
	 * @return lista de todos os países
	 * 
	 * @throws IOException
	 *             caso não houver o arquivo .txt
	 */
	public List<Pais> lerPais() throws IOException {

		List<Pais> paises = new ArrayList<Pais>();
		Pais pais;
		List<String> texto = new Arquivo().pega(txtPais);
		String[] informacoes = new String[3];

		for (String linha : texto) {

			pais = new Pais();

			informacoes = linha.split(",");

			// extrai e atribui a informação que contém o nome do país
			pais.setNome(informacoes[1].replace("\'", "").replace(";", "")
					.replace("(", "").replace(")", "").trim());

			// extrai e atribui a informação que contém a sigla do país
			pais.setSigla(informacoes[2].replace("\'", "").replace(";", "")
					.replace("(", "").replace(")", "").trim());

			paises.add(pais);

		}

		return paises;
	}

}
