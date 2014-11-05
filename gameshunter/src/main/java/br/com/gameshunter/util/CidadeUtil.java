package br.com.gameshunter.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Estado;


/**
 * Métodos de utilização da class Cidade
 * 
 * @author Alex
 *
 */
public class CidadeUtil {

	private static final String txtCidade = "Cidade.txt";
	private Cidade cidade;
	private Estado estado;
	
	/**
	 * lê todas as cidade de um arquivo .txt
	 * 
	 * @return lista de todas as cidades 
	 * 
	 * @throws IOException caso não houver o arquivo .txt
	 */
	public List<Cidade> lerCidade() throws IOException {

		List<Cidade> cidades = new ArrayList<Cidade>();
		List<String> texto = new Arquivo().pega(txtCidade);
		String[] informacoes = new String[3];

		for (String linha : texto) {

			cidade = new Cidade();
			estado = new Estado();
			
			informacoes = linha.split(",");

			//extrai e atribui a informação que contém o nome da cidade
			String nomeCidade = informacoes[1].replace("\'", "")
					.replace(";", "").replace("(", "").replace(")", "").trim();
			
			//extrair e atribui a informação do id do estado
			Integer idEstado = Integer.parseInt(informacoes[2]
					.replace("\'", "").replace(";", "").replace("(", "")
					.replace(")", "").trim());

			cidade.setNome(nomeCidade);
			estado.setId(idEstado);
			cidade.setEstado(estado);

			cidades.add(cidade);

		}

		return cidades;
	}

}
