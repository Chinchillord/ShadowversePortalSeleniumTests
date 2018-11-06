package loginpages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shadowverseportalpages.BasePage;

public class GoogleLoginPage extends BasePage implements LoginPage {
	
	@FindBy(id="identifierId") 
	WebElement emailBox;
	
	@FindBy(name="password")
	WebElement passwordBox;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement nextButton;
	
	String myEmail = "email@email.email";
	String myPassword = "insert_password";
	
	public GoogleLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@Override		
	public void setEmail(String email) {
		emailBox.sendKeys(email);
	}
	@Override
	public void setPassword(String password) {
		passwordBox.sendKeys(password);
	}
	
	public void loginWithGoogle() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		setEmail(myEmail);
		nextButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		setPassword(myPassword);
		nextButton.click();
		pause();
		assertTrue(driver.getCurrentUrl().contains("mypage"));
		
		
	}
}

