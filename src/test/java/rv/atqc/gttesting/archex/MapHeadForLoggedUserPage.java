package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MapHeadForLoggedUserPage extends AbstractMapHeadPage<MapHeadPageForGuestUserPage> {

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
		waitForVisibilityOfElement(mapTypeButton,10);
		waitForElementToBeClickable(mapTypeButton,10);
		return mapTypeButton;
	}
	
    public WebElement getValueOfPlacesButton(){
        waitForVisibilityOfElement(valueOfPlacesButton, 10);
        return valueOfPlacesButton;
    }
    
    public WebElement getValueOfTracksButton(){
        waitForVisibilityOfElement(valueOfTracksButton, 10);
        return valueOfTracksButton;
    }
    
    public WebElement getValueOfEventsButton(){
        waitForVisibilityOfElement(valueOfEventsButton, 10);
        return valueOfEventsButton;
    }
    
    public WebElement getNewItemDropdownList(){
        waitForVisibilityOfElement(newItemDropdownList, 10);
        return newItemDropdownList;
    }
    
    public WebElement getCategoriesDropdownList(){
        waitForVisibilityOfElement(categoriesDropdownList, 10);
        return categoriesDropdownList;
    }
    
    public WebElement getSearchInputField(){
        waitForVisibilityOfElement(searchInputField, 10);
        return searchInputField;
    }
    
    public WebElement getSearchButton(){
        waitForVisibilityOfElement(searchButton, 10);
        return searchButton;
    }
    
    public WebElement getPlacesInLocationButton(){
        waitForVisibilityOfElement(placesInLocationButton, 10);
        return placesInLocationButton;
    }
    
    public WebElement getTracksInLocationButton(){
        waitForVisibilityOfElement(tracksInLocationButton, 10);
        return tracksInLocationButton;
    }
    
    public WebElement getEventsInLocationButton(){
        waitForVisibilityOfElement(eventsInLocationButton, 10);
        return eventsInLocationButton;
    }
	
	public MapTypeMenuPage clickMapTypeButton(){
		waitForElementToBeClickable(mapTypeButton,10);
		mapTypeButton.click();
		return new MapTypeMenuPage(driver);
	}

}