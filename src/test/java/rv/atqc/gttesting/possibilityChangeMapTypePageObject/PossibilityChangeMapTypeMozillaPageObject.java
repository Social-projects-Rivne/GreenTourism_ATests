package rv.atqc.gttesting.possibilityChangeMapTypePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.MapHeadForLoggedUserPage;

public class PossibilityChangeMapTypeMozillaPageObject {
	private WebDriver driver;
	private MapHeadForLoggedUserPage MapHeadPage;
	
	

	@BeforeClass
	public void before() {
		FirefoxDriverManager.getInstance().setup();
		driver = new FirefoxDriver();
		driver.get("https://green-tourism.herokuapp.com/");
		driver.manage().window().maximize();
		MapHeadPage=new LogInPage(driver).loging()
				                         .waitForPageLoad()
										 .getHeadForLoggedUserPage()
										 .clickRightNavButton()
										 .clickMap();
	}

	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

	@Test
	public void checkPossibilityViewMapTypeButton() {
		Assert.assertTrue(MapHeadPage.getElementMapTypeButton().isDisplayed());
	}
	
	@Test
	public void checkPossibilityClickMapTypeButton() {
		Assert.assertTrue(MapHeadPage.getElementMapTypeButton().isEnabled());
	}
	

	@Test
	public void checkExistenceStreetsItem() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
				                     .getStreetsElement()
				                     .isEnabled());
		MapHeadPage.clickMapTypeButton();
	}
	
	@Test
	public void checkExistenceOutdoorsItem() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
                .getOutdoorsElement()
                .isEnabled());
		MapHeadPage.clickMapTypeButton();
	}
	
	@Test
	public void checkExistenceSatelliteItem() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
                .getSatelliteElement()
                .isEnabled());
		MapHeadPage.clickMapTypeButton();
	}
	
	//This test isn't recommended for automation
	@Test
	public void checkPossibilitySetStreetsMapType() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
                .clickStreetsItem()
                .getMapImageStreets()
                .isDisplayed());
		MapHeadPage.clickMapTypeButton();
	}
	
	//This test isn't recommended for automation
	@Test
	public void checkPossibilitySetOutdoorsMapType() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
                .clickOutdoorsItem()
                .getMapImageOutdoors()
                .isDisplayed());
		MapHeadPage.clickMapTypeButton();
	}
	
	//This test isn't recommended for automation
	@Test
	public void checkPossibilitySetSatelliteMapType() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
                .clickSatelliteItem()
                .getMapImageSatellite()
                .isDisplayed());
		MapHeadPage.clickMapTypeButton();
	}

}
