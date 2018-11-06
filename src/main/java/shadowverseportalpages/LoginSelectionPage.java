package shadowverseportalpages;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSelectionPage extends BasePage {

	@FindBy(className="is-facebook")
	private WebElement facebookLogin;

	@FindBy(className="is-twitter")
	private WebElement twitterLogin;

	@FindBy(className="is-google")
	private WebElement googleLogin;

	public LoginSelectionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	public void testLoginButtonsAvailable() {
		List<WebElement> loginButtons = Arrays.asList(facebookLogin, twitterLogin, googleLogin);
		loginButtons.stream().forEach(element -> checkItemIsVisible(element));
	}

	protected void navigateToLogin(WebElement element) {
		element.click();
		pause();
	}

	public void toFacebookLogin() {
		navigateToLogin(facebookLogin);
	}

	public void toTwitterLogin() {
		navigateToLogin(twitterLogin);
	}

	public void toGoogleLogin() {
		navigateToLogin(googleLogin);
	}
}
