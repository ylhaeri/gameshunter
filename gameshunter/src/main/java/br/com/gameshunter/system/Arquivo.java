package br.com.gameshunter.system;

import java.io.File;

public class Arquivo {

	public static File defaultPath(String string) {
		File arquivo = new File(System.getProperty("user.home") + "/gameshunter" + string);
		return arquivo;
	}
}