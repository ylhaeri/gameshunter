package br.com.gameshunter.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.gameshunter.DAO.CidadeDAO;
import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;

public class Arquivo {

	private final String txtCidade = "Cidade.txt";
	private final String txtEstado = "Estado.txt";
	private final String txtPais = "Pais.txt";
	private CidadeDAO cDAO;
	private EntityManager manager;

	public static void main(String[] args) throws IOException {
		System.out.println(new Arquivo().lerCidade().get(5564));
	}

	public List<Cidade> lerCidade() throws IOException {

		List<Cidade> cidades = new ArrayList<Cidade>();
		Cidade cidade;
		BufferedReader br = new Arquivo().lerArquivo(txtCidade);
		String linha = br.readLine();
		String[] informacoes = new String[3];

		while (linha != null) {

			cidade = new Cidade();

			informacoes = linha.split(",");
			
			cidade.setNome(informacoes[1].replace("\'", "").replace(";", "")
					.replace("(", "").replace(")", "").trim());

			cidades.add(cidade);

			linha = br.readLine();
		}
		return cidades;
	}

	public List<Estado> lerEstado() throws IOException {

		List<Estado> estados = new ArrayList<Estado>();
		Estado estado;
		BufferedReader br = new Arquivo().lerArquivo(txtEstado);
		String linha = br.readLine();
		String[] informacoes = new String[3];

		while (linha != null) {

			estado = new Estado();

			informacoes = linha.split(",");

			estado.setNome(informacoes[1].replace("\'", "").replace(";", "")
					.replace("(", "").replace(")", "").trim());
			estado.setUf(informacoes[2].replace("\'", "").replace(";", "")
					.replace("(", "").replace(")", "").trim());

			estados.add(estado);

			linha = br.readLine();
		}
		return estados;
	}

	public List<Pais> lerPais() throws IOException {

		List<Pais> paises = new ArrayList<Pais>();
		Pais pais;
		BufferedReader br = new Arquivo().lerArquivo(txtPais);
		String linha = br.readLine();
		String[] informacoes = new String[3];

		while (linha != null) {

			pais = new Pais();

			informacoes = linha.split(",");

			pais.setNome(informacoes[1].replace("\'", "").replace(";", "")
					.replace("(", "").replace(")", "").trim());
			pais.setSigla(informacoes[2].replace("\'", "").replace(";", "")
					.replace("(", "").replace(")", "").trim());

			paises.add(pais);

			linha = br.readLine();
		}

		return paises;
	}

	@SuppressWarnings("unused")
	private BufferedReader lerArquivo(String arquivo) throws IOException {
		InputStream is = new FileInputStream(arquivo);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}

}
