package rv.atqc.gttesting.possibility_change_map_type;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

@Features("Checking possibility to change map type")
@Stories("Mozilla Firefox browser")
public class PossibilityChangeMapTypeMozillaPC {
	private WebDriver driver;
	private WebDriverWait wait;
	private final int MAX_WAIT_TIME = 10;
	private String USER_MAIL = "energmaxymys@gmail.com";
	private String USER_PASSWORD = "12345678";
	private String ProfileXpath=new String("//a[@ng-click='$ctrl.selectTab(1)']");
	
	@BeforeClass
	public void before() {
		FirefoxDriverManager.getInstance().setup();
		driver = new FirefoxDriver();
		driver.get("https://green-tourism.herokuapp.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, MAX_WAIT_TIME);

		WebElement loginOrSignupItem = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='navbar']//i[@class='fa fa-user navtop']")));
		loginOrSignupItem.click();

		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/" + "auth/div[2]/div/form/div[1]/input")));
		emailField.sendKeys(USER_MAIL);

		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/" + "auth/div[2]/div/form/div[2]/input")));
		passwordField.sendKeys(USER_PASSWORD);

		WebElement loginButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("html.ng-scope body header nav.navbar.navbar-default.navbar-"
						+ "fixed-top.navbar-style.ng-scope div.container.nav-padding "
						+ "div#navbar.collapse.navbar-collapse ul.nav.navbar-nav "
						+ "li.dropdown.open ul.dropdown-menu.dropdown-auth.nav-ul "
						+ "auth.ng-isolate-scope div.ng-scope div.container."
						+ "registration.ng-scope form.ng-dirty.ng-valid-parse.ng-valid-"
						+ "required.ng-valid-email.ng-valid.ng-valid-pattern input.btn.btn-"
						+ "success.btn-block.submit-btn")));
		loginButton.click();
		
		WebElement ProfileElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(ProfileXpath)));
		Boolean isProfileElementDisplayed = ProfileElement.isDisplayed();
		
		if(!isProfileElementDisplayed){
			throw new RuntimeException("User page isn't displayed correct");
		}

		WebElement menuItem = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='navbar']//i[@class='fa fa-bars navtop']")));
		menuItem.click();
		
		WebElement menuItemMap = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//div[@id='navbar']//a[@href='#!/places']")));
		menuItemMap.click();
	}

	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

	@TestCaseId("RVAT-793")
	@Test
	public void checkPossibilityViewMapTypeButton() {
		WebElement mapTypeButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@type='button' and contains" + "(., 'Map Type')]")));
		Assert.assertTrue(mapTypeButton.isDisplayed());
	}
	
	@TestCaseId("RVAT-794")
	@Test
	public void checkPossibilityClickMapTypeButton() {
		WebElement mapTypeButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@type='button' and contains" + "(., 'Map Type')]")));
		Assert.assertTrue(mapTypeButton.isEnabled());
	}
	
	@TestCaseId("RVAT-795")
	@Test
	public void checkExistenceStreetsItem() {
		WebElement mapTypeButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@type='button' and contains" + "(., 'Map Type')]")));
		mapTypeButton.click();
		WebElement streetsItem = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class='col-lg-5 col-md-5 hidden-sm"
						+ " hidden-xs map-menu-buttons-wrapper']//a[@id='streets']")));
	    Assert.assertTrue(streetsItem.isEnabled());
	}
	
	@TestCaseId("RVAT-796")
	@Test
	public void checkExistenceOutdoorsItem() {
		WebElement mapTypeButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@type='button' and contains" + "(., 'Map Type')]")));
		mapTypeButton.click();
		WebElement outdoorsItem = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class='col-lg-5 col-md-5 hidden-sm"
						+ " hidden-xs map-menu-buttons-wrapper']//a[@id='outdoors']")));
	    Assert.assertTrue(outdoorsItem.isEnabled());
	}
	
	@TestCaseId("RVAT-797")
	@Test
	public void checkExistenceSatelliteItem() {
		WebElement mapTypeButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@type='button' and contains" + "(., 'Map Type')]")));
		mapTypeButton.click();
		WebElement satelliteItem = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class='col-lg-5 col-md-5 hidden-sm"
						+ " hidden-xs map-menu-buttons-wrapper']//a[@id='satellite']")));
	    Assert.assertTrue(satelliteItem.isEnabled());
	}
	
	//This test isn't recommended for automation
	@TestCaseId("RVAT-798")
	@Test
	public void checkPossibilitySetStreetsMapType() {
		WebElement streetsItem = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='col-lg-5 col-md-5 hidden-sm"
						+ " hidden-xs map-menu-buttons-wrapper']//a[@id='streets']")));
	    streetsItem.click();
	    WebElement mapImage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[contains(@src,'tile.osm.org')][1]")));
	    Assert.assertTrue(mapImage.isDisplayed());
	}
	
	//This test isn't recommended for automation
	@TestCaseId("RVAT-799")
	@Test
	public void checkPossibilitySetOutdoorsMapType() {
		WebElement outdoorsItem = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='col-lg-5 col-md-5 hidden-sm"
						+ " hidden-xs map-menu-buttons-wrapper']//a[@id='outdoors']")));
	    outdoorsItem.click();
	    WebElement mapImage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[contains(@src,'tile.thunderforest.com')][1]")));
	    Assert.assertTrue(mapImage.isDisplayed());
	}
	
	//This test isn't recommended for automation
	@TestCaseId("RVAT-800")
	@Test
	public void checkPossibilitySetSatelliteMapType() {
		WebElement satelliteItem = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='col-lg-5 col-md-5 hidden-sm"
						+ " hidden-xs map-menu-buttons-wrapper']//a[@id='satellite']")));
	    satelliteItem.click();
	    WebElement mapImage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[contains(@src,'server.arcgisonline.com')][1]")));
	    Assert.assertTrue(mapImage.isDisplayed());
	}

}



