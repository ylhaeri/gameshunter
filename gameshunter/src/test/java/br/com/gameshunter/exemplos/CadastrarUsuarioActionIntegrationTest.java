package br.com.gameshunter.exemplos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastrarUsuarioActionIntegrationTest {
	@Test
	public void main() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/gameshunter/user/signup");
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
//		WebElement botaoEnviar = driver.findElement(By.id("cadastro-enviar"));

		nome.sendKeys("asdasdasd");
		sobrenome.sendKeys("asdasdqwew");
		apelido.sendKeys("qwewqe");
		sexo.get(0).click();
		cpf.click();
		cpf.sendKeys("11111111111");
		telefone.click();
		telefone.sendKeys("1111111111");
		celular.click();
		celular.sendKeys("1111111111");
		nascimento.click();
		nascimento.sendKeys("11/11/1111");
		email.sendKeys("1111111@11111.111");
		senha.sendKeys("ararinha");
		conSenha.sendKeys("ararinha");
		termos.click();

//		botaoEnviar.submit();
		Boolean foiCadastrado = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.textToBePresentInElementLocated(
						By.tagName("h1"), "Adicionado com sucesso"));
		assertTrue(foiCadastrado);
	}
}