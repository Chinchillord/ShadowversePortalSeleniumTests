import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import loginpages.FacebookLoginPage;
import loginpages.GoogleLoginPage;
import loginpages.TwitterLoginPage;
import shadowverseportalpages.HomePage;
import shadowverseportalpages.LoginSelectionPage;


public class LoginTests {

	private WebDriver driver;
	private String URL = "https://shadowverse-portal.com";

	@BeforeEach
	public void setupTest() {
		
		driver = TestHelper.setup(URL);
		
	}

	@Test
	public void testUserGivenVisualChoiceOfLoginPreference() {
		
		new HomePage(driver).toLoginSelectionPage();
		new LoginSelectionPage(driver).testLoginButtonsAvailable();
		driver.quit();
		
	}

	@Test
	public void testUserIsAbleToLoginUsingFacebook() {
		
		new HomePage(driver).toLoginSelectionPage();
		new LoginSelectionPage(driver).toFacebookLogin();
		new FacebookLoginPage(driver).loginWithFacebook();
		driver.quit();
		
	}
	
	@Test
	public void testUserIsAbleToLoginUsingGoogle() {
		
		new HomePage(driver).toLoginSelectionPage();
		new LoginSelectionPage(driver).toGoogleLogin();
		new GoogleLoginPage(driver).loginWithGoogle();
		driver.quit();
		
	}
	
	@Test
	public void testUserisAbletoLoginUsingTwitter() {
		
		new HomePage(driver).toLoginSelectionPage();
		new LoginSelectionPage(driver).toTwitterLogin();
		new TwitterLoginPage(driver).loginWithTwitter();
		driver.quit();
		
	}

}
