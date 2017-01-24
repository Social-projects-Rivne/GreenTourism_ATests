package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MapHeadForLoggedUserPage extends AbstractMapHeadPage<MapHeadPageForGuestUserPage> {

	private final int MAX_WAIT_TIME=10;
	
	@FindBy(how = How.XPATH, using = "//button[@type='button'"
			                       + " and contains" + "(., 'Map Type')]")
	protected WebElement mapTypeButton;
    @FindBy(how = How.XPATH, using = "//html/body/main/div/place-list/div/div/div[1]/div[1]/a[1]/i")
    private WebElement valueOfPlacesButton;
    @FindBy(how = How.XPATH, using = ".//*[@id='main']/div/place-list/div/div/div[1]/div[1]/a[2]/i")
    private WebElement valueOfTracksButton;
    @FindBy(how = How.XPATH, using = ".//*[@id='main']/div/place-list/div/div/div[1]/div[1]/a[3]/i")
    private WebElement valueOfEventsButton;
    @FindBy(how = How.XPATH, using = ".//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[1]/button")
    private WebElement newItemDropdownList;
    @FindBy(how = How.XPATH, using = ".//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/button")
    private WebElement categoriesDropdownList;
    @FindBy(how = How.XPATH, using = ".//*[@id='search']/div/input")
    private WebElement searchInputField;
    @FindBy(how = How.XPATH, using = ".//*[@id='search']/div/span[1]/button")
    private WebElement searchButton;
    @FindBy(how = How.XPATH, using = ".//*[@id='popularPlaces']")
    private WebElement placesInLocationButton;
    @FindBy(how = How.XPATH, using = ".//*[@id='popularTracks']")
    private WebElement tracksInLocationButton;
    @FindBy(how = How.XPATH, using = ".//*[@id='popularEvents']")
    private WebElement eventsInLocationButton;

	protected MapHeadForLoggedUserPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getElementMapTypeButton(){
		waitForVisibilityOfElement(mapTypeButton,MAX_WAIT_TIME);
		waitForElementToBeClickable(mapTypeButton,MAX_WAIT_TIME);
		return mapTypeButton;
	}
	
    public WebElement getValueOfPlacesButton(){
        waitForVisibilityOfElement(valueOfPlacesButton, MAX_WAIT_TIME);
        return valueOfPlacesButton;
    }
    
    public WebElement getValueOfTracksButton(){
        waitForVisibilityOfElement(valueOfTracksButton, MAX_WAIT_TIME);
        return valueOfTracksButton;
    }
    
    public WebElement getValueOfEventsButton(){
        waitForVisibilityOfElement(valueOfEventsButton, MAX_WAIT_TIME);
        return valueOfEventsButton;
    }
    
    public WebElement getNewItemDropdownList(){
        waitForVisibilityOfElement(newItemDropdownList, MAX_WAIT_TIME);
        return newItemDropdownList;
    }
    
    public WebElement getCategoriesDropdownList(){
        waitForVisibilityOfElement(categoriesDropdownList, MAX_WAIT_TIME);
        return categoriesDropdownList;
    }
    
    public WebElement getSearchInputField(){
        waitForVisibilityOfElement(searchInputField, MAX_WAIT_TIME);
        return searchInputField;
    }
    
    public WebElement getSearchButton(){
        waitForVisibilityOfElement(searchButton, MAX_WAIT_TIME);
        return searchButton;
    }
    
    public WebElement getPlacesInLocationButton(){
        waitForVisibilityOfElement(placesInLocationButton, MAX_WAIT_TIME);
        return placesInLocationButton;
    }
    
    public WebElement getTracksInLocationButton(){
        waitForVisibilityOfElement(tracksInLocationButton, MAX_WAIT_TIME);
        return tracksInLocationButton;
    }
    
    public WebElement getEventsInLocationButton(){
        waitForVisibilityOfElement(eventsInLocationButton, MAX_WAIT_TIME);
        return eventsInLocationButton;
    }
	
	public MapTypeMenuPage clickMapTypeButton(){
		waitForElementToBeClickable(mapTypeButton, MAX_WAIT_TIME);
		mapTypeButton.click();
		return new MapTypeMenuPage(driver);
	}

}