package shadowverseportalpages;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import databaseobjects.CardDAO;

public class HomePage extends BasePage{

	By homePageCards = By.className("el-card-visual-name");
	
	@FindBy(className="is-login")
	WebElement signInButton;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	protected void selectCardListClass(String className) {
		
		String xPathString = "//img[contains(@class, 'js-select-class') and contains(@alt, '"
					+ className + "')]";

		WebElement classIcon = driver.findElement(By.xpath(xPathString));
		classIcon.click();
		pause();
	}

	public void testClassCardListCurrent(String className) {
		
		HashSet<String> actualCards = new HashSet<>();
		HashSet<String> expectedCards = new HashSet<>();
		List<WebElement> cardsOnPage;

		CardDAO cd = new CardDAO();
		
		expectedCards = (HashSet<String>) cd.getByClass(className, "homepagecards").stream()
				.map(element -> element.getName()).collect(Collectors.toSet());
		
		selectCardListClass(className);
		
		cardsOnPage = driver.findElements(homePageCards);
		actualCards = (HashSet<String>) cardsOnPage.stream()
				.map(element -> element.getText()).collect(Collectors.toSet());
	
		assertEquals(expectedCards, actualCards);
		
	}

	public void toLoginSelectionPage() {
		signInButton.click();
		pause();
	}
}
