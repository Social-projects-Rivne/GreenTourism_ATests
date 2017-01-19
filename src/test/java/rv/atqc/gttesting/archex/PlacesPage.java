package rv.atqc.gttesting.archex;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PlacesPage extends CategoriesPage{

	private WebDriverWait wait;
	private final int MAX_WAIT_TIME = 20;
	private ArrayList <WebElement> placesList = new ArrayList<WebElement>();
	
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
		
	@FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[2]/div/div[3]/button")
	private WebElement categoriesButton;	
	
	@FindBy(how = How.XPATH, using = "//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[6]")
	private WebElement checkAllButton;
	
	
	public PlacesPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,MAX_WAIT_TIME);
	}
	
	private PlacesPage setPlacesFilter(WebElement element, boolean select){
		if (select == true)	element.click();
		return this;
	 }
	
	public PlacesPage clickOnCategoriesButton(){
		categoriesButton.click();
		return this;
	}
	
	public WebElement getCampPlace() {
		return campPlace;
	}

	public WebElement getServicePlace() {
		return servicePlace;
	}

	public WebElement getHostelsPlace() {
		return hostelsPlace;
	}

	public WebElement getFeaturedPlace() {
		return featuredPlace;
	}

	public WebElement getHealthcarePlace() {
		return healthcarePlace;
	}

	public void setFilters(boolean[] filter){
		openCategoryPlaces();
		setPlacesFilter(campPlacesFilter, filter[0]);
		setPlacesFilter(servicePlacesFilter, filter[1]);
		setPlacesFilter(hostelsPlacesFilter, filter[2]);
		setPlacesFilter(featuredPlacesFilter, filter[3]);
		setPlacesFilter(healthcarePlacesFilter, filter[4]);
	}
	
	public boolean checkFilter(boolean[] filter){
		boolean isVisiableElements = true;
		if (filter[0] == true)
			isVisiableElements = isVisiableElements && isPlacesDisplayed(campPlace);
		if (filter[1] == true)
			isVisiableElements = isVisiableElements && isPlacesDisplayed(servicePlace);
		if (filter[2] == true)
			isVisiableElements = isVisiableElements && isPlacesDisplayed(hostelsPlace);			
		if (filter[3] == true)
			isVisiableElements = isVisiableElements && isPlacesDisplayed(featuredPlace);		
		if (filter[4] == true)
			isVisiableElements = isVisiableElements && isPlacesDisplayed(healthcarePlace);
		return isVisiableElements;
	}
		
	public boolean isPlacesDisplayed(WebElement element){
		try{
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();
		}
		catch(Exception exception){
			return false;
		}
	}	
	
	public PlacesPage openCategoryPlaces(){	
		this.hoverPlacesButton();
		placesList.add(campPlace);
		placesList.add(servicePlace);
		placesList.add(hostelsPlace);
		placesList.add(featuredPlace);
		placesList.add(healthcarePlace);
		
		//deselect all places
		checkAllButton.click();	
		wait.until(ExpectedConditions.visibilityOfAllElements(placesList));
		checkAllButton.click();
		wait.until(ExpectedConditions.invisibilityOfAllElements(placesList));
		return this;
	}	
}
