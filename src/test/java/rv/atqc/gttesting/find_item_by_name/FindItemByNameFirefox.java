package rv.atqc.gttesting.find_item_by_name;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.MapHeadPageForGuestUserPage;
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
	@BeforeMethod
	public void beforeMethod(){
		placesPage.getSearchField().clear();
	}

	@AfterClass
	    public void quitDriver(){
	 //       driver.quit();
	    }
    

	
  	@Test//перевірити захищеність від виконання javascript
	public void checkSearchInptFieldSecurity(){
  		Assert.assertTrue(placesPage.waitForVisibilityOfElement(placesPage.lookForPlace("<script>alert( 'Привет, Мир!' );</script>").getSearchField(),10));
  }
	/*
		@Test//перевірити наявність поля "результати пошуку"
	public void checkSearchResultsField(){
    	placesPage.lookForPlace("");      
    } 
	 
	@Test //перевірити роботу пошуку для неіснуючого місця
    public void checkFailedPlace(){
    	placesPage.lookForPlace("FAILED_PLACE");       
    }
	
	
    @Test //перевірити Місця з видимої зони
    public void checkPlaceFromVisibleRegion(){
    	placesPage.lookForPlace("ASdazxc");
    }

    @Test //перевірити Місця з віддаленої зони
    public void checkPlaceFromInvisibleRegion(){
    	placesPage.lookForPlace("Hight Castle");
    }
    */

}
