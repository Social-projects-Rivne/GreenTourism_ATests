package rv.atqc.gttesting.archex;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import rv.atqc.gttesting.res.Resources;

public class PlacesPage extends AbstractPage<PlacesPage>{

	private final int MAX_WAIT_TIME = 5;
	
	@FindBy(how = How.XPATH, using = "//*[@id='map']/div[1]/div[2]/div[1]/img[1]")
	private WebElement campPlace;
	@FindBy(how = How.XPATH, using = "//*[@id='map']/div[1]/div[2]/div[1]/img[7]")
	private WebElement servicePlace;
	@FindBy(how = How.XPATH, using = "//*[@id='map']/div[1]/div[2]/div[3]/img[2]")
	private WebElement hostelsPlace;
	@FindBy(how = How.XPATH, using = "//*[@id='map']/div[1]/div[2]/div[1]/img[5]")
	private WebElement featuredPlace;
	@FindBy(how = How.XPATH, using = "//*[@id='map']/div[1]/div[2]/div[1]/img")
	private WebElement healthcarePlace;
	
	private ArrayList <WebElement> placesList = new ArrayList<WebElement>(Arrays.asList(
			campPlace, servicePlace, hostelsPlace, featuredPlace, healthcarePlace));
	
	@FindBy(how = How.XPATH, using = "//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[1]")
	private WebElement campPlacesFilter;
	@FindBy(how = How.XPATH, using = "//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[2]")
	private WebElement servicePlacesFilter;
	@FindBy(how = How.XPATH, using = "//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[3]")
	private WebElement hostelsPlacesFilter;
	@FindBy(how = How.XPATH, using = "//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[4]")
	private WebElement featuredPlacesFilter;
	@FindBy(how = How.XPATH, using = "//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[5]")
	private WebElement healthcarePlacesFilter;	
	
	private ArrayList <WebElement> filterList = new ArrayList<WebElement>(Arrays.asList(
			campPlacesFilter, servicePlacesFilter, hostelsPlacesFilter, featuredPlacesFilter, healthcarePlacesFilter));
	
	@FindBy(how = How.XPATH, using = "//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[6]")
	private WebElement checkAllButton;
	@FindBy(how = How.XPATH, using = "//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]")
	protected WebElement placesButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/input")
	protected WebElement searchField;
	//@FindBy(how = How.CSS, using = "#search > div > span.input-group-btn")
	//@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/span[1]/button/text()")
	//protected WebElement searchButton;
    @FindBy(how = How.XPATH, using = ".//*[@id='search']/div/span[1]/button")
    private WebElement searchButton;
	
    @FindBy(how = How.XPATH, using = "//*[@id=\"searchPlaces\"]/ul")
    private WebElement searchResults;

    
	
	public PlacesPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getСampPlace(){
		waitForVisibilityOfElement(campPlace, MAX_WAIT_TIME);
		return campPlace;
	}
	
	public WebElement getSearchField(){
		waitForVisibilityOfElement(searchField, MAX_WAIT_TIME);
		return searchField;
	}
	
	public PlacesPage hoverSearchResults(){
		this.waitForVisibilityOfElement(searchResults, MAX_WAIT_TIME);
		Actions builder = new Actions(driver);
		builder.moveToElement(searchResults).perform();
		return this;
	}
	
	public PlacesPage lookForPlace(String searchword){
			waitForVisibilityOfElement(searchField,10);
			searchField.sendKeys(searchword);
			waitForElementToBeClickable(searchButton,10);
			this.disableFocus().hoverElement(searchButton);
			searchButton.click();
			waitForElementToBeClickable(searchResults,10);
			this.hoverElement(searchResults);
			return this;
	}
	
	public void setFilters(boolean[] filter){
		openCategoryPlaces();
		for (int i=0; i<5; i++){
			if (filter[i] == true){
				filterList.get(i).click();
			}
		}
	}
	
	public boolean checkFilter(boolean[] filter){
		boolean isVisiableElements = true;
		for (int i=0; i<5; i++){
			if (filter[i] == true)
				isVisiableElements = isVisiableElements && isPlacesDisplayed(placesList.get(i), MAX_WAIT_TIME);
		}
		return isVisiableElements;
	}

	public boolean isPlacesDisplayed(WebElement webElement, int timeout){
		try{
			waitForVisibilityOfElement(webElement, MAX_WAIT_TIME);
			return webElement.isDisplayed();
		}
		catch(Exception exception){
			return false;
		}
    }

	public PlacesPage openCategoryPlaces(){
		this.waitForVisibilityOfElement(placesButton, MAX_WAIT_TIME);
		Actions builder = new Actions(driver);
		builder.moveToElement(placesButton).perform();
		
		//deselect all places
		checkAllButton.click();	
		waitForVisibilityOfAll(placesList, MAX_WAIT_TIME);
		checkAllButton.click();
		waitForInVisibilityOfAll(placesList, MAX_WAIT_TIME);
		return this;
	}	
}