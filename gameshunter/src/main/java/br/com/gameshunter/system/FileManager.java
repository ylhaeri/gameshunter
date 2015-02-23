package br.com.gameshunter.system;

public class FileManager {

	public static String defaultPath() {
		return System.getProperty("user.home") + "/gameshunter";
	}
}