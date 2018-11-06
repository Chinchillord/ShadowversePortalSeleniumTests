package shadowverseportalpages;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import databaseobjects.Card;
import databaseobjects.CardDAO;


public class MainDeckBuilderPage extends BasePage{
	
	@FindBy(xpath="//input[@placeholder='Enter Card Name," + " Ability, etc.']")
	private WebElement searchBar;

	public MainDeckBuilderPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void testDeckBuilder(String className) {
		
		pause();
		List<Card> expectedDecklist = getDecklist(className);
		buildDeck(expectedDecklist);
		checkDeckContents(expectedDecklist, getCreatedDeckContents(className));
		
	}

	private void addToDeck(String cardName, int cardCount) {
		
		searchBar.sendKeys(cardName);
		List<WebElement> foundCards =
				driver.findElements(By.className("card-image"));
		
		for (int i = 0; i < cardCount; i++) {
			foundCards.get(0).click();
			pause();
		}
		
		searchBar.clear();
		
	}
	
	private List<Card> getDecklist(String className) {

		List<Card> expectedDecklist = new ArrayList<Card>();

		CardDAO cd = new CardDAO();

		expectedDecklist = cd.getByClass(className);
		return expectedDecklist;
			
	}

	private void buildDeck(List<Card> expectedDecklist) {
				
		for(Card card : expectedDecklist) {
				
				addToDeck(card.getName(), card.getCount());
				
		}
			
	}

	private List<Card> getCreatedDeckContents(String className) {
			
		List<Card> decklistOnPage = new ArrayList<Card>();
		List<WebElement> nameOfCardsInDeck = new ArrayList<WebElement>();
		List<WebElement> countOfCardsInDeck = new ArrayList<WebElement>();
			
		nameOfCardsInDeck = driver.findElements(By.className("el-card-list-info-name-text"));
		countOfCardsInDeck = driver.findElements(By.className("el-card-list-info-count"));

		for (int i = 0; i < nameOfCardsInDeck.size(); i++) {
				
			Card card = new Card
				(nameOfCardsInDeck.get(i).getText(), className,
						Integer.parseInt(countOfCardsInDeck.get(i).getText().substring(1)));
			
			decklistOnPage.add(card);

		}
			
		return decklistOnPage;
			
	}
			
	private void checkDeckContents(List<Card> expectedDecklist, List<Card> decklistOnPage) {
				
		assertEquals(expectedDecklist.size(), decklistOnPage.size());
			
		for (int i = 0; i < expectedDecklist.size(); i++) {
				
			assertEquals(expectedDecklist.get(i).getCount(), decklistOnPage.get(i).getCount());
			assertEquals(expectedDecklist.get(i).getName(), decklistOnPage.get(i).getName());
				
		}
			
	}

}
