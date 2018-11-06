package shadowverseportalpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {
	
	@FindBy(xpath="//img[@alt='Deck Builder']")
	WebElement deckBuilderButton;
	
	public ProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void toClassSelectionDeckBuilderPage() {
		deckBuilderButton.click();
		pause();
	}
	
}
