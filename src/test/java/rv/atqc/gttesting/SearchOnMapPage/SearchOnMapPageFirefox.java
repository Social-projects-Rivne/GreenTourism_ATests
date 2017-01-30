package rv.atqc.gttesting.SearchOnMapPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import rv.atqc.gttesting.archex.PlacesPage;

public class SearchOnMapPageFirefox {
	private WebDriver driver;
	private PlacesPage placesPage;
	private String EXISTING_PLACE = "Basiv Kyt";
	private String EXISTING_TRACK = "AWESOME";
	private String NON_EXISTING_ITEM = "bla-bla";
	private String SHORT_REQUEST = "12";
	private String SCRIPT = "<script>alert( 'Hello, World!' );</script>";
	private final String INVISIBLE_ITEM_NAME = "Hight Castle";
	private final String DOUBLE_ITEM_NAME = "sda";
	
	@BeforeClass
	public void beforeClass() {
		FirefoxDriverManager.getInstance().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		placesPage = new PlacesPage(driver);
		driver.get("https://green-tourism.herokuapp.com/#!/places");
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.get("https://green-tourism.herokuapp.com/#!/places");
	}
	
	@AfterClass
	public void quitDriver(){
	      driver.quit();
	}
	
	@Test
	public void searchForExistingPlace(){
		Assert.assertTrue(placesPage.lookForItem(EXISTING_PLACE).getTextSearchResults().isDisplayed());    
	}
	
	@Test
	public void searchForExistingTrack(){
		Assert.assertTrue(placesPage.lookForItem(EXISTING_TRACK).getTextSearchResults().isDisplayed());    
	}
	
    @Test
    public void shortSeacthRequest(){
		Assert.assertTrue(placesPage.lookForItem(SHORT_REQUEST).getFailedRequestField().isDisplayed());
    }
	
    @Test
    public void searchForNonExistingItem(){
		Assert.assertEquals(placesPage.lookForItem(NON_EXISTING_ITEM). getTextSearchResults().getText(), placesPage.getNoItemMessage());
    }
	
  	@Test
	public void checkSearchInputFieldSecurity(){
  		Assert.assertEquals(placesPage.lookForItem(SCRIPT). getTextSearchResults().getText(), placesPage.getNoItemMessage());
    }
  	
	@Test
    public void checkItemDetailsFromInvisibleRegion(){
    	placesPage.lookForItem(INVISIBLE_ITEM_NAME).getFoundItem().click();
    	Assert.assertTrue(placesPage.getItemDetails().isDisplayed());
    }
	
	@Test
    public void checkItemDetailsUrlFromInvsibleRegion(){
		placesPage.lookForItem(INVISIBLE_ITEM_NAME).getFoundItem().click();
		placesPage.getItemDetails().click();
    	Assert.assertEquals(driver.getCurrentUrl(),placesPage.getInvisibleItemDetailsUrl());
    }
	
	@Test
    public void checkSearchResultsForTwoPlaces(){
		placesPage.lookForItem(DOUBLE_ITEM_NAME);
    	Assert.assertTrue(placesPage.getFoundResults().isDisplayed()&&placesPage.getVisibleItemFoundSecondResult().isDisplayed());
    }
     
}