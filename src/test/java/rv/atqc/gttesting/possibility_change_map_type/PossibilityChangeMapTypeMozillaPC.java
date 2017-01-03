package rv.atqc.gttesting.possibility_change_map_type;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class PossibilityChangeMapTypeMozillaPC {
	private WebDriver driver;
	private WebDriverWait wait;
	private final int MAX_WAIT_TIME = 10;
	private String USER_MAIL = "energmaxymys@gmail.com";
	private String USER_PASSWORD = "12345678";

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

		WebElement menuItem = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='navbar']//i[@class='fa fa-bars navtop']")));
		menuItem.click();

		WebElement menuItemMap = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Map")));
		menuItemMap.click();

	}

	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

	@Test
	public void checkPossibilityViewMapTypeButton() {
		WebElement mapTypeButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@type='button' and contains" + "(., 'Map Type')]")));
		Assert.assertTrue(mapTypeButton.isDisplayed());
	}
	
	@Test
	public void checkPossibilityClickMapTypeButton() {
		WebElement mapTypeButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@type='button' and contains" + "(., 'Map Type')]")));
		Assert.assertTrue(mapTypeButton.isEnabled());
	}
	
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

}
