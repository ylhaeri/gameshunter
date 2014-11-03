package br.com.gameshunter.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.persistence.EntityManager;

import br.com.gameshunter.DAO.CidadeDAO;
import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Pais;

public class Arquivo {

	private final String txtCidade = "Cidade.txt";
	private final String txtEstado = "Estado.txt";
	private final String txtPais = "Pais.txt";
	private CidadeDAO cDAO;
	private EntityManager manager;

	public static void main(String[] args) {
	}

	private void lerCidade() throws IOException {

		BufferedReader br = new Arquivo().lerArquivo(txtCidade);

		String linha = br.readLine();

		while (br != null) {

			Cidade cidade = new Cidade();

			String[] informacoes = new String[3];

			informacoes = linha.split(",");

			cidade.setId(Integer.parseInt(informacoes[0].replace("\'", "")
					.replace(";", "").trim()));
			cidade.setNome(informacoes[1].replace("\'", "").replace(";", "")
					.trim());
		}

	}

	private void lerPais() throws IOException {

		BufferedReader br = new Arquivo().lerArquivo(txtPais);

		String linha = br.readLine();

		while (br != null) {
			
			Pais pais = new Pais();
			
			String[] informacoes = new String[3];
			
			informacoes = linha.split(",");
			
			pais.setId(Integer.parseInt(informacoes[0].replace("\'", "")
					.replace(";", "").trim()));
			pais.setNome(informacoes[1].replace("\'", "")
					.replace(";", "").trim()));
			
		}
	}

	@SuppressWarnings("unused")
	private BufferedReader lerArquivo(String arquivo) throws IOException {
		InputStream is = new FileInputStream(arquivo);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}

}
