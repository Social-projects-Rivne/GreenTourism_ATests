package rv.atqc.gttesting.SearchOnMapPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import rv.atqc.gttesting.archex.PlacesPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

@Features("Checking possibility to search for items on map page")
@Stories("Chrome browser")
public class SearchOnMapPageChrome {
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
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		placesPage = new PlacesPage(driver);
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.get("https://green-tourism.herokuapp.com/#!/places");
	}
	
	@AfterClass
	public void quitDriver(){
	      driver.quit();
	}
	
	@TestCaseId("RVAT-942")
	@Test
	public void searchForExistingPlace(){
		Assert.assertTrue(placesPage.lookForItem(EXISTING_PLACE).getTextSearchResults().isDisplayed());    
	}
	
	@TestCaseId("RVAT-944")
	@Test
	public void searchForExistingTrack(){
		Assert.assertTrue(placesPage.lookForItem(EXISTING_TRACK).getTextSearchResults().isDisplayed());    
	}
	
	@TestCaseId("RVAT-946")
    @Test
    public void searchForNonExistingItem(){
		Assert.assertEquals(placesPage.lookForItem(NON_EXISTING_ITEM). getTextSearchResults().getText(), placesPage.getNoItemMessage());
    }

	@TestCaseId("RVAT-948")
    @Test
    public void shortSeacthRequest(){
		Assert.assertTrue(placesPage.lookForItem(SHORT_REQUEST).getFailedRequestField().isDisplayed());
    }
	
	@TestCaseId("RVAT-990")
  	@Test
	public void checkSearchInputFieldSecurity(){
  		Assert.assertEquals(placesPage.lookForItem(SCRIPT). getTextSearchResults().getText(), placesPage.getNoItemMessage());
    }

	@TestCaseId("RVAT-1500")
	@Test
    public void checkItemDetailsFromInvisibleRegion(){
    	placesPage.lookForItem(INVISIBLE_ITEM_NAME).getFoundItem().click();
    	Assert.assertTrue(placesPage.getItemDetails().isDisplayed());
    }
	
	@TestCaseId("RVAT-1502")
	@Test
    public void checkItemDetailsUrlFromInvsibleRegion(){
		placesPage.lookForItem(INVISIBLE_ITEM_NAME).getFoundItem().click();
		placesPage.getItemDetails().click();
    	Assert.assertEquals(driver.getCurrentUrl(),placesPage.getInvisibleItemDetailsUrl());
    }
	
	@TestCaseId("RVAT-1504")
	@Test
    public void checkSearchResultsForTwoPlaces(){
		placesPage.lookForItem(DOUBLE_ITEM_NAME);
    	Assert.assertTrue(placesPage.getFoundResults().isDisplayed()&&placesPage.getVisibleItemFoundSecondResult().isDisplayed());
    }
     
}