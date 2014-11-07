//package br.com.gameshunter.action;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class CadastrarUsuarioActionTest {
//	@Test
//	public void main() throws InterruptedException {
//		WebDriver driver = new FirefoxDriver();
//		driver.get("http://localhost:8080/gameshunter/cadastrar-usuario");
//		WebElement nome = driver.findElement(By.name("usuario.nome"));
//		WebElement apelido = driver.findElement(By.name("usuario.apelido"));
//		WebElement email = driver.findElement(By.name("usuario.email"));
//		WebElement senha = driver.findElement(By.id("senha"));
//		WebElement conSenha = driver.findElement(By.name("usuario.senha"));
//		WebElement cpf = driver.findElement(By.name("usuario.cpf"));
//		WebElement telefone = driver.findElement(By.name("usuario.telefone"));
//		WebElement rg = driver.findElement(By.name("usuario.rg"));
//		Select dpSexo = new Select(driver.findElement(By.name("usuario.sexo")));
//		Select dpDia = new Select(driver.findElement(By.name("nascDia")));
//		Select dpMes = new Select(driver.findElement(By.name("nascMes")));
//		Select dpAno = new Select(driver.findElement(By.name("nascAno")));
//		WebElement cep = driver.findElement(By.name("endereco.cep"));
//		WebElement logradouro = driver.findElement(By
//				.name("endereco.logradouro"));
//		WebElement numero = driver.findElement(By.name("endereco.numero"));
//		WebElement complemento = driver.findElement(By
//				.name("endereco.complemento"));
//		WebElement bairro = driver.findElement(By.name("endereco.bairro"));
//		Select dpPais = new Select(driver.findElement(By.name("idPais")));
//		Select dpEstado = new Select(driver.findElement(By.name("idEstado")));
//		Select dpCidade = new Select(driver.findElement(By.name("idCidade")));
//		WebElement botaoEnviar = driver.findElement(By.id("enviar"));
//		nome.sendKeys("Osvaldo Chaprau");
//		apelido.sendKeys("Osvaldin");
//		email.sendKeys("osvaldo@valdin.com");
//		senha.sendKeys("osvaldo");
//		conSenha.sendKeys("osvaldo");
//		cpf.click();
//		cpf.sendKeys("00000000000");
//		telefone.click();
//		telefone.sendKeys("1111111111");
//		rg.sendKeys("1234567-890");
//		dpSexo.selectByVisibleText("Masculino");
//		dpDia.selectByVisibleText("1");
//		dpMes.selectByVisibleText("Janeiro");
//		dpAno.selectByVisibleText("1990");
//		cep.click();
//		cep.sendKeys("00000000");
//		logradouro.sendKeys("Rua Balunjão");
//		numero.sendKeys("805");
//		complemento.sendKeys("Chaprau");
//		bairro.sendKeys("Tarantula");
//		dpPais.selectByVisibleText("Brasil");
//		new WebDriverWait(driver, 10).until(ExpectedConditions
//				.textToBePresentInElementLocated(By.name("idEstado"),
//						"São Paulo"));
//		dpEstado.selectByVisibleText("São Paulo");
//		new WebDriverWait(driver, 10).until(ExpectedConditions
//				.textToBePresentInElementLocated(By.name("idCidade"),
//						"São Paulo"));
//		dpCidade.selectByVisibleText("São Paulo");
//		botaoEnviar.submit();
//		Boolean foiCadastrado = new WebDriverWait(driver, 20)
//				.until(ExpectedConditions.textToBePresentInElementLocated(
//						By.tagName("h1"), "Adicionado com sucesso"));
//		assertTrue(foiCadastrado);
//	}
//}