package loginpages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shadowverseportalpages.BasePage;

public class TwitterLoginPage extends BasePage implements LoginPage {
	
	@FindBy(id="username_or_email") 
	WebElement emailBox;
	
	@FindBy(id="password")
	WebElement passwordBox;
	
	@FindBy(id="allow")
	WebElement signInButton;
	
	String myEmail = "email@email.email";
	String myPassword = "insert_password";
	
	public TwitterLoginPage(WebDriver driver) {
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
	
	public void loginWithTwitter() {
		setEmail(myEmail);
		setPassword(myPassword);
		signInButton.click();
		pause();
		assertTrue(driver.getCurrentUrl().contains("mypage"));
		
	}

}
