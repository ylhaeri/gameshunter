package br.com.gameshunter.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.gameshunter.model.Estado;

/**
 * Métodos de utilização da class Estado
 * 
 * @author Alex
 *
 */
public class EstadoUtil {

	private final String txtEstado = "Estado.txt";

	public static void main (String[] args) throws IOException{
		System.out.println(new EstadoUtil().lerEstado());
	}
	
	/**
	 * lê todos os estados de um arquivo .txt
	 * 
	 * @return lista de todas os estados
	 * 
	 * @throws IOException
	 *             caso não houver o arquivo .txt
	 */
	public List<Estado> lerEstado() throws IOException {

		List<Estado> estados = new ArrayList<Estado>();
		Estado estado;
		List<String> texto = new Arquivo().pega(txtEstado);
		String[] informacoes = new String[3];

		for (String linha : texto) {

			estado = new Estado();

			informacoes = linha.split(",");
			
			//extrai e atribui a informação que contém o nome do estado
			estado.setNome(informacoes[1].replace("\'", "").replace(";", "")
					.replace("(", "").replace(")", "").trim());
			
			//extrai e atribui a informação que contém o UF do estado
			estado.setUf(informacoes[2].replace("\'", "").replace(";", "")
					.replace("(", "").replace(")", "").trim());

			estados.add(estado);
		}

		return estados;
	}
}
