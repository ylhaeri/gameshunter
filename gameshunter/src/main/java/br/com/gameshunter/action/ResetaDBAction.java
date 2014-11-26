package br.com.gameshunter.action;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.gameshunter.util.WindowsShell;

public class ResetaDBAction {

	@PersistenceUnit(unitName = "GamesHunter")
	private EntityManagerFactory gamesHunter;
	@PersistenceUnit(unitName = "Security")
	private EntityManagerFactory security;

	@Action(value = "reseta", results = { @Result(name = "ok", type = "httpheader", params = {
			"status", "200" }) })
	public String reseta() throws IOException {
		WindowsShell shell = new WindowsShell();
		gamesHunter.close();
		security.close();
		shell.executeCommand("mysql -u root -proot gameshunter < D:\\Users\\Myho\\gameshunter\\Dump\\gameshunter_pais.sql");
		shell.executeCommand("mysql -u root -proot gameshunter < D:\\Users\\Myho\\gameshunter\\Dump\\gameshunter_estado.sql");
		shell.executeCommand("mysql -u root -proot gameshunter < D:\\Users\\Myho\\gameshunter\\Dump\\gameshunter_cidade.sql");
		shell.executeCommand("mysql -u root -proot gameshunter < D:\\Users\\Myho\\gameshunter\\Dump\\gameshunter_bairro.sql");
		shell.executeCommand("mysql -u root -proot gameshunter < D:\\Users\\Myho\\gameshunter\\Dump\\gameshunter_logradouro.sql");
		return "ok";
	}
}