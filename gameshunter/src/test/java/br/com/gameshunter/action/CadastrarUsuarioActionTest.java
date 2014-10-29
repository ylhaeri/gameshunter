package br.com.gameshunter.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CadastrarUsuarioActionTest {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:8080/gameshunter/cadastrar-usuario");
	}
}