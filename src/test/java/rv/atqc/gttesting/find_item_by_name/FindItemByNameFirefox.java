package rv.atqc.gttesting.find_item_by_name;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.PlacesPage;
import rv.atqc.gttesting.res.Resources;

@Features("Checking possibility to find item by name")
@Stories("Mozilla Firefox browser")
public class FindItemByNameFirefox {
	
	private WebDriver driver;
	private PlacesPage placesPage;
	
	@BeforeClass
	public void before(){		
		FirefoxDriverManager.getInstance().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://green-tourism.herokuapp.com"); 
		new LogInPage(driver).loging();
		placesPage = new PlacesPage(driver);	
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.get("https://green-tourism.herokuapp.com");
	}
	
	@AfterClass
	public void quitDriver(){
		driver.quit();
	}

	@TestCaseId("RVAT-993") 
	@Test
	public void checkSearchResultsField(){
		Assert.assertTrue(placesPage.lookForItem(Resources.FindPlace.VISIBLE_ITEM_NAME).getTextSearchResults().isDisplayed());    
	}
	
	@TestCaseId("RVAT-995")
	@Test
	public void checkSearchInptFieldSecurity(){
  		Assert.assertEquals(placesPage.lookForItem(Resources.FindPlace.SCRIPT). getTextSearchResults().getText(), placesPage.getNoItemMessage());
    }
	
	@TestCaseId("RVAT-997")
    @Test
    public void checkFailedRequestSearch(){
		Assert.assertTrue(placesPage.lookForItem(Resources.FindPlace.ERROR_ITEM_NAME).getFailedRequestField().isDisplayed());
    }
    
	@TestCaseId("RVAT-999")
    @Test
    public void checkFailedPlaceSearch(){
		Assert.assertEquals(placesPage.lookForItem(Resources.FindPlace.FAILED_PLACE_NAME). getTextSearchResults().getText(), placesPage.getNoItemMessage());
    }
    
	@TestCaseId("RVAT-1001")
    @Test
    public void checkSearchResultsFromVisibleRegion(){
		placesPage.lookForItem(Resources.FindPlace.VISIBLE_ITEM_NAME).getFoundResults().click();
    	Assert.assertEquals( driver.getCurrentUrl(), placesPage.getVisibleItemDetailsUrl());
    }
    
	@TestCaseId("RVAT-1003")
    @Test
    public void checkSearchResultsFromInvisibleRegion(){
		placesPage.lookForItem(Resources.FindPlace.INVISIBLE_ITEM_NAME).getInvisibleItemFoundResults().click();
    	Assert.assertEquals( driver.getCurrentUrl(), placesPage.getInvisibleItemDetailsUrl());
	}
    
	@TestCaseId("RVAT-1005")
	@Test
    public void checkItemFromVisibleRegion(){
		Assert.assertTrue(placesPage.lookForItem(Resources.FindPlace.VISIBLE_ITEM_NAME).getFoundItem().isDisplayed());
	}
	
	@TestCaseId("RVAT-1007")
	@Test
    public void checkItemFromInvisibleRegion(){
		Assert.assertTrue(placesPage.lookForItem(Resources.FindPlace.INVISIBLE_ITEM_NAME).getFoundItem().isDisplayed());
	}
	
	@TestCaseId("RVAT-1009")
	@Test
    public void checkItemDetailsFromInvisibleRegion(){
    	placesPage.lookForItem(Resources.FindPlace.INVISIBLE_ITEM_NAME).getFoundItem().click();
    	Assert.assertTrue(placesPage.getItemDetails().isDisplayed());
    }
	
	@TestCaseId("RVAT-1011")
	@Test
    public void checkItemDetailsUrlFromInvsibleRegion(){
		placesPage.lookForItem(Resources.FindPlace.INVISIBLE_ITEM_NAME).getFoundItem().click();
		placesPage.getItemDetails().click();
    	Assert.assertEquals(driver.getCurrentUrl(),placesPage.getInvisibleItemDetailsUrl());
    }
	
	@TestCaseId("RVAT-1013")
	@Test
    public void checkSearchResultsForTwoPlaces(){
		placesPage.lookForItem(Resources.FindPlace.DOUBLE_ITEM_NAME);
    	Assert.assertTrue(placesPage.getFoundResults().isDisplayed()&&placesPage.getVisibleItemFoundSecondResult().isDisplayed());
    }
	
	
}