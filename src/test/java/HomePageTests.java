import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import org.openqa.selenium.WebDriver;

import shadowverseportalpages.HomePage;

public class HomePageTests {

	private WebDriver driver;
	private String URL = "https://shadowverse-portal.com";

	@BeforeEach
	public void setupTest() {
		
		driver = TestHelper.setup(URL);
		
	}

	@ParameterizedTest
	@EnumSource(ShadowverseCharacterClasses.class)
	public void testUserIsPresentedWithAppropriateClassCardsOnHomepage(ShadowverseCharacterClasses className) {
		
		new HomePage(driver).testClassCardListCurrent(className.toString());
		driver.quit();
		
	}
}
