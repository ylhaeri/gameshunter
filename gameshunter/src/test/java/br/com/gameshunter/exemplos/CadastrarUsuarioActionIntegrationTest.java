package br.com.gameshunter.exemplos;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastrarUsuarioActionIntegrationTest {

	private static EmbeddedServer embeddedServer;

	static ChromeDriverService service;
	@BeforeClass
	public static void tomcat() throws ServletException, InterruptedException, IOException {
		embeddedServer = new EmbeddedServer(9090, "/gameshunter");
		embeddedServer.start();
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("chromedriver.exe"))
				.usingAnyFreePort().build();
		service.start();
	}

	@AfterClass
	public static void naotomcat() {
		embeddedServer.stop();
	}

	@Test
	public void main() throws InterruptedException, FileNotFoundException {
		WebDriver driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		System.out.println(driver instanceof ChromeDriver);
		driver.get("http://localhost:9090/gameshunter/user/signup");
		WebElement nome = driver.findElement(By.id("nome-input"));
		WebElement sobrenome = driver.findElement(By.id("sobrenome-input"));
		WebElement apelido = driver.findElement(By.id("apelido-input"));
		List<WebElement> sexo = driver.findElements(By.name("gender"));
		WebElement cpf = driver.findElement(By.id("cpf-input"));
		WebElement telefone = driver.findElement(By.id("telefone-input"));
		WebElement celular = driver.findElement(By.id("celular-input"));
		WebElement nascimento = driver.findElement(By.id("nascimento-input"));
		WebElement email = driver.findElement(By.id("email-input"));
		WebElement senha = driver.findElement(By.id("senha-input"));
		WebElement conSenha = driver.findElement(By.id("confirma-senha-input"));
		WebElement termos = driver.findElement(By.id("termos-servico-input"));
		WebElement botaoEnviar = driver.findElement(By.id("cadastro-enviar"));

		nome.sendKeys("Gabriel");
		sobrenome.sendKeys("Diniz");
		apelido.sendKeys("Myho");
		sexo.get(0).click();
		cpf.click();
		cpf.sendKeys("115.905.106-23");
		telefone.click();
		telefone.sendKeys("(31)3424-6643");
		celular.click();
		celular.sendKeys("(31)9247-5931");
		nascimento.click();
		nascimento.sendKeys("16/04/1993");
		email.sendKeys("gabriel.dinizo@hotmail.com");
		senha.sendKeys("araramon");
		conSenha.sendKeys("araramon");
		termos.click();

		botaoEnviar.submit();
		Boolean foiCadastrado = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.textToBePresentInElementLocated(
						By.tagName("h1"), "Bem vindo"));
		assertTrue(foiCadastrado);
		driver.manage().deleteCookieNamed("JSESSIONID");
		driver.quit();
	}
}