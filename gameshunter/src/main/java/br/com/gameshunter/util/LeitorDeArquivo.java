package br.com.gameshunter.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * leitura de arquivos .txt
 * 
 * @author Alex
 */
public class LeitorDeArquivo {

	/**
	 * pega o conteúdo de um arquivo
	 * 
	 * @param arquivo
	 *            diretório do arquivo que deve ser lido
	 * 
	 * @return lista de string contedo o texto enviado
	 * 
	 * @throws IOException
	 *             caso não houver o arquivo .txt
	 */
	public List<String> pega(File arquivo) {
		List<String> texto = new ArrayList<String>();
		try {
			BufferedReader br = lerArquivo(arquivo);
			String linha = br.readLine();

			while (linha != null) {
				texto.add(linha);
				linha = br.readLine();
			}
			br.close();
			return texto;
		} catch (IOException e) {
			System.out.println("Não foi possível encontrar o arquivo: "
					+ arquivo);
			e.printStackTrace();
		}
		return texto;
	}

	/**
	 * Faz a leitura de um arquivo
	 * 
	 * @param arquivo
	 *            diretório do arquivo que deve ser lido
	 * 
	 * @return buffer que contem todo o texto
	 * 
	 * @throws IOException
	 *             caso não houver o arquivo .txt
	 */
	private BufferedReader lerArquivo(File arquivo) throws IOException {
		InputStream is = new FileInputStream(arquivo);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}
}