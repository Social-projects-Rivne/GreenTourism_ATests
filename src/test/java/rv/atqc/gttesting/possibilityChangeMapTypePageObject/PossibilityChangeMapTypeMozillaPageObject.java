package rv.atqc.gttesting.possibilityChangeMapTypePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.MapHeadForLoggedUserPage;

@Features("Checking possibility to change map type (Page Object)")
@Stories("Mozilla Firefox browser")
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

	@TestCaseId("RVAT-793")
	@Test
	public void checkPossibilityViewMapTypeButton() {
		Assert.assertTrue(MapHeadPage.getElementMapTypeButton().isDisplayed());
	}
	
	@TestCaseId("RVAT-794")
	@Test
	public void checkPossibilityClickMapTypeButton() {
		Assert.assertTrue(MapHeadPage.getElementMapTypeButton().isEnabled());
	}
	

	@TestCaseId("RVAT-795")
	@Test
	public void checkExistenceStreetsItem() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
				                     .getStreetsElement()
				                     .isEnabled());
		MapHeadPage.clickMapTypeButton();
	}
	
	@TestCaseId("RVAT-796")
	@Test
	public void checkExistenceOutdoorsItem() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
                .getOutdoorsElement()
                .isEnabled());
		MapHeadPage.clickMapTypeButton();
	}
	
	@TestCaseId("RVAT-797")
	@Test
	public void checkExistenceSatelliteItem() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
                .getSatelliteElement()
                .isEnabled());
		MapHeadPage.clickMapTypeButton();
	}
	
	//This test isn't recommended for automation
	@TestCaseId("RVAT-798")
	@Test
	public void checkPossibilitySetStreetsMapType() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
                .clickStreetsItem()
                .getMapImageStreets()
                .isDisplayed());
		MapHeadPage.clickMapTypeButton();
	}
	
	//This test isn't recommended for automation
	@TestCaseId("RVAT-799")
	@Test
	public void checkPossibilitySetOutdoorsMapType() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
                .clickOutdoorsItem()
                .getMapImageOutdoors()
                .isDisplayed());
		MapHeadPage.clickMapTypeButton();
	}
	
	//This test isn't recommended for automation
	@TestCaseId("RVAT-780")
	@Test
	public void checkPossibilitySetSatelliteMapType() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
                .clickSatelliteItem()
                .getMapImageSatellite()
                .isDisplayed());
		MapHeadPage.clickMapTypeButton();
	}

}
