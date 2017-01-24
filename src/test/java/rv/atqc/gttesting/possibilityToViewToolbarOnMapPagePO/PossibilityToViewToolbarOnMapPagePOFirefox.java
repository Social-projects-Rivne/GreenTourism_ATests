package rv.atqc.gttesting.possibilityToViewToolbarOnMapPagePO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.MapHeadForLoggedUserPage;

public class PossibilityToViewToolbarOnMapPagePOFirefox {
	private WebDriver driver;
	private MapHeadForLoggedUserPage MapHeadPage;
	
	

	@BeforeClass
	public void before() {
		FirefoxDriverManager.getInstance().setup();
		driver = new FirefoxDriver();
		driver.get("https://green-tourism.herokuapp.com/");
		driver.manage().window().maximize();
		MapHeadPage = new LogInPage(driver).loging()
										   .getHeadForLoggedUserPage()
										   .clickRightNavButton()
										   .clickMap();
	}
	
	@AfterClass
	public void afterMethod() {
		driver.quit();
	}
	
	@Test
    public void checkValueOfPlacesButton(){
        Assert.assertTrue(MapHeadPage.getValueOfPlacesButton().isEnabled(), "This element doesn't exist");
    }
	
	@Test
    public void checkValueOfTracksButton(){
        Assert.assertTrue(MapHeadPage.getValueOfTracksButton().isEnabled(), "This element doesn't exist");
    }
	
	@Test
    public void checkValueOfEventsButton(){
        Assert.assertTrue(MapHeadPage.getValueOfEventsButton().isEnabled(), "This element doesn't exist");
    }
	
	@Test
    public void checkNewItemDropdownList(){
        Assert.assertTrue(MapHeadPage.getNewItemDropdownList().isEnabled(), "This element doesn't exist");
    }
	
	@Test
    public void checkCategoriesDropdownList(){
        Assert.assertTrue(MapHeadPage.getCategoriesDropdownList().isEnabled(), "This element doesn't exist");
    }
	
	@Test
    public void checkSearchInputField(){
        Assert.assertTrue(MapHeadPage.getSearchInputField().isEnabled(), "This element doesn't exist");
    }
	
	@Test
    public void checkSearchButton(){
        Assert.assertTrue(MapHeadPage.getSearchButton().isEnabled(), "This element doesn't exist");
    }
	
	@Test
    public void checkPlacesInLocationButton(){
        Assert.assertTrue(MapHeadPage.getPlacesInLocationButton().isEnabled(), "This element doesn't exist");
    }
	
	@Test
    public void checkEventsInLocationButton(){
        Assert.assertTrue(MapHeadPage.getEventsInLocationButton().isEnabled(), "This element doesn't exist");
    }
	
	@Test
    public void checkElementMapTypeButton(){
        Assert.assertTrue(MapHeadPage.getElementMapTypeButton().isEnabled(), "This element doesn't exist");
    }
	
	@Test
    public void checkTracksInLocationButton(){
        Assert.assertTrue(MapHeadPage.getTracksInLocationButton().isEnabled(), "This element doesn't exist");
    }
}
