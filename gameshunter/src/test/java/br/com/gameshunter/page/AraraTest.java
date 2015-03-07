package br.com.gameshunter.page;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AraraTest {

	@Test
	public void checaSeTutaninTaOn() {
		WebDriver driver = new FirefoxDriver();

		driver.get("google.com.br");
	}
}