package shadowverseportalpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ClassSelectionDeckBuilderPage extends BasePage {


	public ClassSelectionDeckBuilderPage(WebDriver driver) {
		super(driver);
	}

	public void toClassDeckBuilder(String className) {
		
		String selectedXPath = "//img[@alt='"
				+ className + "craft']";
		
		WebElement selectedClassBanner = driver.findElement
				(By.xpath(selectedXPath));
		WebElement ourElement = selectedClassBanner.findElement(By.xpath(".."));
		ourElement.click();
		pause();
	}
}
