package br.com.gameshunter.system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AppConfig {
	private static Properties props = new Properties();
	private static final boolean sendConfirmation = false;

	public static void main(String[] args) {

		List<String> nomes = new ArrayList<>();
		for (String nome : nomes) {
			FileInputStream arquivo;
			try {
				arquivo = new FileInputStream(FileManager.defaultPath() + "/config/" + nome);
				props.load(arquivo);
				arquivo.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean isSendconfirmation() {
		return sendConfirmation;
	}
}