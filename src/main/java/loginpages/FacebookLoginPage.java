package loginpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import shadowverseportalpages.BasePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FacebookLoginPage extends BasePage implements LoginPage{
	
	By emailBox = By.id("email");
	By passwordBox = By.id("pass");
	By loginButton = By.id("loginbutton");
	
	String myEmail = "email@email.email";
	String myPassword = "insert_password";
	
	public FacebookLoginPage(WebDriver driver) {
		super(driver);
	}
	@Override		
	public void setEmail(String email) {
		driver.findElement(emailBox).sendKeys(email);
	}
	@Override
	public void setPassword(String password) {
		driver.findElement(passwordBox).sendKeys(password);
	}
	
	public void loginWithFacebook() {
		setEmail(myEmail);
		setPassword(myPassword);
		driver.findElement(loginButton).click();
		pause();
		assertTrue(driver.getCurrentUrl().contains("mypage"));
		
	}
}
