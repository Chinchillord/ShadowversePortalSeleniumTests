package shadowverseportalpages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	protected void checkItemIsVisible(WebElement element) {
		assertTrue(element.isDisplayed());
	}

	protected void pause() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(driver ->((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

	}
}
