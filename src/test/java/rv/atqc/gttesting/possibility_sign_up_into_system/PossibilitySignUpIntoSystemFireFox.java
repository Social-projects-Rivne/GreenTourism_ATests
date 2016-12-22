package rv.atqc.gttesting.possibility_sign_up_into_system;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class PossibilitySignUpIntoSystemFireFox {

	private WebDriver driver;
	private WebDriverWait wait;
	private static final int MAX_WAIT_TIME = 10;

	@BeforeClass
	public void beforeClass() {
		FirefoxDriverManager.getInstance().setup();
		driver = new FirefoxDriver();
		driver.get("https://green-tourism.herokuapp.com");
		wait = new WebDriverWait(driver, MAX_WAIT_TIME);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
				"html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown a.dropdown-toggle i.fa.fa-user.navtop")))
				.click();
		driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[1]/h6/a[2]")).click();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

	@Test(groups = "existence_of_signup")
	public void existenceSignUpForm() {
		Assert.assertTrue(
				isExist(By.cssSelector(
						"html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown.open ul.dropdown-menu.dropdown-auth.nav-ul auth.ng-isolate-scope div.ng-scope div.container.registration.ng-scope form.ng-pristine.ng-invalid.ng-invalid-required.ng-valid-minlength.ng-valid-maxlength.ng-valid-email.ng-valid-pattern.ng-valid-match")),
				"Signup form is not exist!!!");

	}
	
	@Test(groups = "existence_of_signup")
	public void existenceFirstNameInput() {
		Assert.assertTrue(
				isExist(By.xpath(
						"/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[1]/input")),
				"First name input is not exist!!!");

	}

	@Test(groups = "existence_of_signup")
	public void existenceLastNameInput() {
		Assert.assertTrue(
				isExist(By.xpath(
						"/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[2]/input")),
				"First name input is not exist!!!");

	}
	
	@Test(groups = "existence_of_signup")
	public void existenceEmailInput() {
		Assert.assertTrue(
				isExist(By.xpath(
						"/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[3]/input")),
				"First name input is not exist!!!");

	}
	
	@Test(groups = "existence_of_signup")
	public void existencePasswordInput() {
		Assert.assertTrue(
				isExist(By.xpath(
						"/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[4]/input")),
				"Password input is not exist!!!");

	}
	
	protected boolean isExist(By element) {
		try {
			driver.findElement(element);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
