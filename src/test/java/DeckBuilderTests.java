import java.io.File;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import shadowverseportalpages.ClassSelectionDeckBuilderPage;
import shadowverseportalpages.MainDeckBuilderPage;



public class DeckBuilderTests {

	private WebDriver driver;
	private String deckBuilderURL = "https://shadowverse-portal.com/deckbuilder/classes?lang=en";
	

	@BeforeEach
	public void setupTest() {
		
		final File file = new File("chromedriver");
		
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.navigate().to("https://shadowverse-portal.com");
		
	}

	@ParameterizedTest
	@EnumSource(ShadowverseCharacterClasses.class)
	public void testUserIsAbleToBuildACustomDeck(ShadowverseCharacterClasses className) {
		
		driver.get(deckBuilderURL);
		new ClassSelectionDeckBuilderPage(driver).toClassDeckBuilder(className.toString());
		
		try {
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		
		new MainDeckBuilderPage(driver).testDeckBuilder(className.toString());
		driver.quit();
		
	}

}
