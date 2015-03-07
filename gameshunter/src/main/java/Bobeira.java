import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

		driver.get("http://muldr.com.br/");

		WebElement onlines = driver.findElement(By
				.cssSelector("a[href*='_onlines']"));
		onlines.click();

		boolean logado = true;

		try {
			while (!logado == false) {
				logado = wait.until(textToBePresentInElementLocated(
						By.tagName("table"), "Tutano"));
				System.out.println("Logado");
				driver.navigate().refresh();
				Thread.sleep(30000);
			}
		} catch (TimeoutException e) {

			System.out.println("Deslogado");
			Calendar cal = Calendar.getInstance();
			cal.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			System.out.println(sdf.format(cal.getTime()));
		}
		driver.close();
	}
}