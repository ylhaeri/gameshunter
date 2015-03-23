import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bobeira {

	public static void main(String[] args) throws InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(
				PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				"C:/Program Files/phantomjs-2.0.0-windows/bin/phantomjs.exe");
		WebDriver driver = new PhantomJSDriver(caps);
		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.get("http://mublack.no-ip.info/index.php?page_id=rankings");

		System.out.println("Inicio");
		Boolean achou = wait.until(textToBePresentInElementLocated(By.id("tmp_main"),
				"Tutano2000"));
		System.out.println("Fim");
		System.out.println(achou);
		driver.close();
	}
}