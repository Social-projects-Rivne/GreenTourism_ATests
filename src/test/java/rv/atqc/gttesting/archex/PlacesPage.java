package rv.atqc.gttesting.archex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PlacesPage extends AbstractPage<PlacesPage>{

	private final int MAX_WAIT_TIME = 15;
	private final String PLACES_PAGE_URL = "https://green-tourism.herokuapp.com/#!/places";
	private final String VISIBLE_ITEM_DETAILS_URL = "https://green-tourism.herokuapp.com/#!/places/57a4d84dca7a727c0ca59ba3";
	private final String INVISIBLE_ITEM_DETAILS_URL = "https://green-tourism.herokuapp.com/#!/places/584e7ef0b61f280400d36ebd";
	private final String  NO_ITEM_MESSAGE = "There are no such places and tracks, try else please";

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
	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/span[1]/button")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/place-list/div/div/div[2]/div[4]/a/i")
    private WebElement closeResultsButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/span[3]")
	private WebElement failedRequestField;	
    @FindBy(how = How.XPATH, using = "//*[@id=\"searchPlaces\"]/ul")
    private WebElement itemSearchResults;
    @FindBy(how = How.XPATH, using = "//*[@id=\"searchPlaces\"]/h3")
    private WebElement textSearchResults;    
    @FindBy(how = How.XPATH, using = "//*[@id=\"57a4d84dca7a727c0ca59ba3\"]/button/h3/a")
    private WebElement foundResultForVisibleItem;

    @FindBy(how = How.XPATH, using = "//*[@id=\"584e7ef0b61f280400d36ebd\"]/button/h3/a")
    private WebElement foundResultForInvisibleItem;
    @FindBy(how = How.XPATH, using = "//*[@id=\"map\"]/div[1]/div[2]/div[3]/img[1]")
    private WebElement foundItem;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"map\"]/div[1]/div[2]/div[4]/div/div[1]/div/div/button/a")
    private WebElement item1Details;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/place-list/div/div/div[2]/div[4]/a/i")
    private WebElement closeResultsButton;

	public PlacesPage(WebDriver driver){
		super(driver);
	}
	
	public String getNoItemMessage(){
		return NO_ITEM_MESSAGE;
	}
	
	public String getInvisibleItemDetailsUrl(){
		return INVISIBLE_ITEM_DETAILS_URL;
	}

	public String getVisibleItemDetailsUrl(){
		return VISIBLE_ITEM_DETAILS_URL;
	}
	
	public String getInisibleItemDetailsUrl(){
		return INVISIBLE_ITEM_DETAILS_URL;

	public WebElement getItemDetails(){
		waitForVisibilityOfElement(itemDetails, MAX_WAIT_TIME);
		return itemDetails;
	}
		
	public WebElement getVisibleItemFoundResults(){
		waitForVisibilityOfElement(foundResultForVisibleItem, MAX_WAIT_TIME);
		return foundResultForVisibleItem;
	}
	
	public WebElement getVisibleItemFoundSecondResult(){
		waitForVisibilityOfElement(foundResultForSecondVisibleItem, MAX_WAIT_TIME);
		return foundResultForSecondVisibleItem;

	}
	
	public WebElement getInvisibleItemFoundResults(){
		waitForVisibilityOfElement(foundResultForInvisibleItem, MAX_WAIT_TIME);
		return foundResultForInvisibleItem;
	}
	
	public WebElement getFailedRequestField(){
		waitForVisibilityOfElement(failedRequestField, MAX_WAIT_TIME);
		return failedRequestField;
	}

	public WebElement getTextSearchResults(){
		waitForVisibilityOfElement(textSearchResults, MAX_WAIT_TIME);
		return textSearchResults;
	}
	
	public PlacesPage timeout(long time, TimeUnit timeUnit) {
		driver.manage().timeouts().implicitlyWait(time, timeUnit);
		return this;
	}
	
	public WebElement getFoundItem(){
		waitForVisibilityOfElement(itemSearchResults, MAX_WAIT_TIME);
		hoverElement(itemSearchResults);
		timeout(2,TimeUnit.SECONDS);

		waitForElementToBeClickable(foundItem,MAX_WAIT_TIME);
		return foundItem;
	}

	public WebElement getFoundResults(){
		waitForVisibilityOfElement(itemSearchResults, MAX_WAIT_TIME);
		return itemSearchResults;
	}
	
	public PlacesPage closeResults(){
		waitForVisibilityOfElement(closeResultsButton, MAX_WAIT_TIME);
		closeResultsButton.click();
		waitForInVisibilityOfElement(itemSearchResults, MAX_WAIT_TIME);
		return this;
	}
	
	public PlacesPage lookForItem(String searchWord){
		driver.get(PLACES_PAGE_URL);
		waitForVisibilityOfElement(featuredPlace,MAX_WAIT_TIME);
		searchField.clear();
		searchField.sendKeys(searchWord);
		waitForVisibilityOfElement(searchButton, MAX_WAIT_TIME);
		searchButton.click();
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