package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MapHeadPageForGuestUserPage extends AbstractMapHeadPage<MapHeadPageForGuestUserPage> {

	@FindBy(how = How.XPATH, using = "html/body/main/div/place-list/div/div/div[1]/div[2]/div/div[3]/button")
	private WebElement categories;
	@FindBy(how = How.XPATH, using = "//*[@id=\"popularPlaces\"]")
	private WebElement popularPlacesInLocation;
	@FindBy(css = ".leaflet-marker-icon")
	private WebElement place;
	@FindBy(xpath = "//*[@id=\"map\"]/div[1]/div[2]/div[4]/div/div[1]/div/div/a[2]")
	private WebElement detailButton;
	@FindBy(xpath = "//*[@id=\"main\"]/div/place-detail/div")
	private WebElement detailPage;
	@FindBy(xpath = "//*[@id=\"map\"]/div[1]/div[2]/div[4]/div/a")
	private WebElement exitButtonOnRaiseWindow;
	@FindBy(xpath = "//*[@id=\"map\"]/div[1]/div[2]/div[4]/div/div[1]/div/div/a[1]/img")
	private WebElement imageOnRaiseWindow;

	private final int MAX_WAIT_TIME = 20;

	public MapHeadPageForGuestUserPage(WebDriver driver) {
		super(driver);
	}

	public CategoriesPage clickCategories(){
		waitForElementToBeClickable(categories, MAX_WAIT_TIME);
		categories.click();
		return new CategoriesPage(driver);
	}

	public PopularPlacesInLocationPage clickPopularPlacesInLocationWithZoomOut(){
		ClickZoomOutButton();
		waitForElementToBeClickable(popularPlacesInLocation, MAX_WAIT_TIME);
		popularPlacesInLocation.click();
		return new PopularPlacesInLocationPage(driver);
	}

	public WebElement getPlasesOnMapChrome () {
		waitForVisibilityOfElement(place, MAX_WAIT_TIME);
		return place;
	}

	public void clickOnPlaceButton () {
		waitForElementToBeClickable(place, MAX_WAIT_TIME);
		place.click();
	}

	public WebElement getExitButtonOnRaiseWindow () {
		waitForElementToBeClickable(exitButtonOnRaiseWindow, MAX_WAIT_TIME);
		return exitButtonOnRaiseWindow;
	}


	public WebElement getDetailsButton () {
		waitForElementToBeClickable(detailButton, MAX_WAIT_TIME);
		return detailButton;
	}

	public WebElement getImageOnRaiseWindow () {
		waitForElementToBeClickable(imageOnRaiseWindow, MAX_WAIT_TIME);
		return imageOnRaiseWindow;
	}

	public WebElement getDetailsPage () {
		waitForElementToBeClickable(detailButton, MAX_WAIT_TIME);
		detailButton.click();
		waitForVisibilityOfElement(detailPage, MAX_WAIT_TIME);
		return detailPage;
	}
}
