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
		Assert.assertTrue(placesPage.lookForItem("Basiv Kyt").getTextSearchResults().isDisplayed());    
	}
	
	@Test
	public void searchForExistingTrack(){
		Assert.assertTrue(placesPage.lookForItem("AWESOME").getTextSearchResults().isDisplayed());    
	}
	
    @Test
    public void shortSeacthRequest(){
		Assert.assertTrue(placesPage.lookForItem("12").getFailedRequestField().isDisplayed());
    }
	
    @Test
    public void searchForNonExistingItem(){
		Assert.assertEquals(placesPage.lookForItem("bla-bla"). getTextSearchResults().getText(), placesPage.getNoItemMessage());
    }
	
  	@Test
	public void checkSearchInputFieldSecurity(){
  		Assert.assertEquals(placesPage.lookForItem("<script>alert( 'Hello, World!' );</script>"). getTextSearchResults().getText(), placesPage.getNoItemMessage());
    }
     
}