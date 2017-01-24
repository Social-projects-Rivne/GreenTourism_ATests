package rv.atqc.gttesting.find_item_by_name;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.PlacesPage;

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
	public void checkSearchResultsField(){
		Assert.assertTrue(placesPage.lookForItem("ASdazxc").getTextSearchResults().isDisplayed());    
	}
	
  	@Test
	public void checkSearchInptFieldSecurity(){
  		Assert.assertEquals(placesPage.lookForItem("<script>alert( 'Hello, World!' );</script>"). getTextSearchResults().getText(), placesPage.getNoItemMessage());
    }
    
    @Test
    public void checkFailedRequestSearch(){
		Assert.assertTrue(placesPage.lookForItem("1").getFailedRequestField().isDisplayed());
    }
    
    @Test
    public void checkFailedPlaceSearch(){
		Assert.assertEquals(placesPage.lookForItem("FAILED_PLACE"). getTextSearchResults().getText(), placesPage.getNoItemMessage());
    }
    
    @Test
    public void checkSearchResultsFromVisibleRegion(){
		placesPage.lookForItem("ASdazxc").getFoundResults().click();
    	Assert.assertEquals( driver.getCurrentUrl(), placesPage.getVisibleItemDetailsUrl());
    }
    
    @Test
    public void checkSearchResultsFromInvisibleRegion(){
		placesPage.lookForItem("Hight Castle").getInvisibleItemFoundResults().click();
    	Assert.assertEquals( driver.getCurrentUrl(), placesPage.getInisibleItemDetailsUrl());
	}
    
    @Test
    public void checkItemFromVisibleRegion(){
		Assert.assertTrue(placesPage.lookForItem("ASdazxc").getFoundItem().isDisplayed());
	}
	
	@Test
    public void checkItemFromInisibleRegion(){
		Assert.assertTrue(placesPage.lookForItem("Hight Castle").getFoundItem().isDisplayed());
	}
}