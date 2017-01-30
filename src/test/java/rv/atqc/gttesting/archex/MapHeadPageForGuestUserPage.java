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
	@FindBy(xpath = "//*[@id=\"map\"]/div[1]/div[2]/div[3]/img[1]")
	private WebElement place;
	@FindBy(xpath = "//*[@id=\"map\"]/div[1]/div[2]/div[4]/div/div[1]/div/div/a[2]")
	private WebElement detailButton;
	@FindBy(xpath = "//*[@id=\"main\"]/div/place-detail/div")
	private WebElement detailPage;
	@FindBy(xpath = "//*[@id=\"main\"]/div/place-detail/div/div/div[2]/div[1]/div/h2")
	private WebElement titleOnDeskPage;
	@FindBy(xpath = "//*[@id=\"firstimg\"]/img")
	private WebElement imageOnDeskPage;
	@FindBy(xpath = "/html/body/main/div/place-detail/div/div/div[2]/div[2]/div[2]/div[2]")
	private WebElement mapOnDeskPage;
	@FindBy(xpath = "//*[@id=\"close\"]")
	private WebElement closeButtonOnDeskPage;
	@FindBy(xpath = "//*[@id=\"search\"]/div/span[1]/button")
	private WebElement searchButtonOnMapPage;

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

	public WebElement getDetailsButton () {
		waitForElementToBeClickable(detailButton, MAX_WAIT_TIME);
		return detailButton;
	}

	public void getDetailsPage () {
		waitForElementToBeClickable(detailButton, MAX_WAIT_TIME);
		detailButton.click();
	}

	public WebElement getTitleOnDeskPage (){
		waitForVisibilityOfElement(titleOnDeskPage, MAX_WAIT_TIME);
		return titleOnDeskPage;
	}

	public WebElement getImageOnDeskPage (){
		waitForVisibilityOfElement(imageOnDeskPage, MAX_WAIT_TIME);
		return imageOnDeskPage;
	}

	public WebElement getMapOnDeskPage (){
		waitForVisibilityOfElement(mapOnDeskPage, MAX_WAIT_TIME);
		return mapOnDeskPage;
	}
	public WebElement getCloseButtonOnDeskPage (){
		waitForVisibilityOfElement(closeButtonOnDeskPage, MAX_WAIT_TIME);
		return closeButtonOnDeskPage;
	}

	public WebElement getMapPage (){
		waitForVisibilityOfElement(searchButtonOnMapPage, MAX_WAIT_TIME);
		return searchButtonOnMapPage;
	}


}
