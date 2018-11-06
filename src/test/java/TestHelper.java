import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestHelper {
	
	public static WebDriver setup(String URL) {
		
		final File file = new File("chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(URL);
		return driver;
		
	}

}
