package rv.atqc.gttesting.possibilityChangeMapTypePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.MapHeadForLoggedUserPage;

@Features("Checking possibility to change map type (Page Object)")
@Stories("Chrome browser")
public class PossibilityChangeMapTypeChromePageObject {
	private WebDriver driver;
	private MapHeadForLoggedUserPage MapHeadPage;
	
	

	@BeforeClass
	public void before() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
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

	@TestCaseId("RVAT-746")
	@Test
	public void checkPossibilityViewMapTypeButton() {
		Assert.assertTrue(MapHeadPage.getElementMapTypeButton().isDisplayed());
	}
	
	@TestCaseId("RVAT-751")
	@Test
	public void checkPossibilityClickMapTypeButton() {
		Assert.assertTrue(MapHeadPage.getElementMapTypeButton().isEnabled());
	}
	
	@TestCaseId("RVAT-761")
	@Test
	public void checkExistenceStreetsItem() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
				                     .getStreetsElement()
				                     .isEnabled());
		MapHeadPage.clickMapTypeButton();
	}
	
	@TestCaseId("RVAT-764")
	@Test
	public void checkExistenceOutdoorsItem() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
                .getOutdoorsElement()
                .isEnabled());
		MapHeadPage.clickMapTypeButton();
	}
	
	@TestCaseId("RVAT-767")
	@Test
	public void checkExistenceSatelliteItem() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
                .getSatelliteElement()
                .isEnabled());
		MapHeadPage.clickMapTypeButton();
	}
	
	//This test isn't recommended for automation
	@TestCaseId("RVAT-782")
	@Test
	public void checkPossibilitySetStreetsMapType() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
                .clickStreetsItem()
                .getMapImageStreets()
                .isDisplayed());
		MapHeadPage.clickMapTypeButton();
	}
	
	//This test isn't recommended for automation
	@TestCaseId("RVAT-783")
	@Test
	public void checkPossibilitySetOutdoorsMapType() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
                .clickOutdoorsItem()
                .getMapImageOutdoors()
                .isDisplayed());
		MapHeadPage.clickMapTypeButton();
	}
	
	//This test isn't recommended for automation
	@TestCaseId("RVAT-784")
	@Test
	public void checkPossibilitySetSatelliteMapType() {
		Assert.assertTrue(MapHeadPage.clickMapTypeButton()
                .clickSatelliteItem()
                .getMapImageSatellite()
                .isDisplayed());
		MapHeadPage.clickMapTypeButton();
	}

}
