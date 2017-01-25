package rv.atqc.gttesting.find_item_by_name;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.PlacesPage;

public class FindItemByNameChrome {
	private WebDriver driver;
	private PlacesPage placesPage;
	
	private final String VISIBLE_ITEM_NAME = "ASdazxc";
	private final String INVISIBLE_ITEM_NAME = "Hight Castle";
	private final String FAILED_PLACE_NAME = "FAILED_PLACE";
	private final String DOUBLE_ITEM_NAME = "sda";
	private final String ERROR_ITEM_NAME = "1";
	private final String SCRIPT = "<script>alert( 'Hello, World!' );</script>";
	
	@BeforeClass
	public void beforeClass() {
		ChromeDriverManager.getInstance().setup();
		//disable geolocation
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.geolocation", 2);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", prefs);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		
		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		driver.get("https://green-tourism.herokuapp.com"); 
		new LogInPage(driver).loging();
		placesPage = new PlacesPage(driver);
	}
	@AfterMethod
	public void afterMethod(){
		driver.get(placesPage.PLACES_PAGE_URL);
	}
	@AfterClass
	public void quitDriver(){
		driver.quit();
	}

	@Test
	public void checkSearchResultsField(){
		Assert.assertTrue(placesPage.lookForItem(VISIBLE_ITEM_NAME).getTextSearchResults().isDisplayed());    
	}
	@Test
	public void checkSearchInptFieldSecurity(){
  		Assert.assertEquals(placesPage.lookForItem(SCRIPT). getTextSearchResults().getText(), placesPage.getNoItemMessage());
    }
    @Test
    public void checkFailedRequestSearch(){
		Assert.assertTrue(placesPage.lookForItem(ERROR_ITEM_NAME).getFailedRequestField().isDisplayed());
    }
    @Test
    public void checkFailedPlaceSearch(){
		Assert.assertEquals(placesPage.lookForItem(FAILED_PLACE_NAME). getTextSearchResults().getText(), placesPage.getNoItemMessage());
    }
    @Test
    public void checkSearchResultsFromVisibleRegion(){
		placesPage.lookForItem(VISIBLE_ITEM_NAME).getFoundResults().click();
    	Assert.assertEquals( driver.getCurrentUrl(), placesPage.getVisibleItemDetailsUrl());
    }
    @Test
    public void checkSearchResultsFromInvisibleRegion(){
		placesPage.lookForItem(INVISIBLE_ITEM_NAME).getInvisibleItemFoundResults().click();
    	Assert.assertEquals( driver.getCurrentUrl(), placesPage.getInvisibleItemDetailsUrl());
	}
	@Test
    public void checkItemFromVisibleRegion(){
		Assert.assertTrue(placesPage.lookForItem(VISIBLE_ITEM_NAME).getFoundItem().isDisplayed());
	}
	@Test
    public void checkItemFromInvisibleRegion(){
		Assert.assertTrue(placesPage.lookForItem(INVISIBLE_ITEM_NAME).getFoundItem().isDisplayed());
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