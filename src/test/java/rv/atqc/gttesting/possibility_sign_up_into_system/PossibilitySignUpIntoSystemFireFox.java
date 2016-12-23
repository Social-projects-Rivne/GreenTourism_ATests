package rv.atqc.gttesting.possibility_sign_up_into_system;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class PossibilitySignUpIntoSystemFireFox {

	private WebDriver driver;
	private WebDriverWait wait;

	private static final int MAX_WAIT_TIME = 10;

	private static final String NAME_VALID = "Anonym";
	private static final String ABSENCE = "";
	private static final String NAME_INVALIDE = "An786m";
	private static final CharSequence EMAIL_VALID = "first.last@domain.com";
	private static final CharSequence EMAIL_INVALID = "email@11111.222";

	private By signUpForm;
	private By firstName;
	private By lastName;
	private By email;
	private By password;
	private By confirmPassword;
	private By signUp;

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
		init();
	}

	private void init() {
		signUpForm = By.cssSelector(
				"html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown.open ul.dropdown-menu.dropdown-auth.nav-ul auth.ng-isolate-scope div.ng-scope div.container.registration.ng-scope form.ng-pristine.ng-invalid.ng-invalid-required.ng-valid-minlength.ng-valid-maxlength.ng-valid-email.ng-valid-pattern.ng-valid-match");
		firstName = By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[1]/input");
		lastName = By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[2]/input");
		email = By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[3]/input");
		password = By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[4]/input");
		confirmPassword = By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[5]/input");
		signUp = By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/input");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

	@Test(groups = "existence_of_signup", priority = 0)
	public void existenceSignUpForm() {
		Assert.assertTrue(isExist(signUpForm), "Signup form is not exist!!!");

	}

	@Test(groups = "existence_of_signup")
	public void existenceFirstNameInput() {
		Assert.assertTrue(isExist(firstName), "First name input is not exist!!!");

	}

	@Test(groups = "existence_of_signup")
	public void existenceLastNameInput() {
		Assert.assertTrue(isExist(lastName), "Last name input is not exist!!!");

	}

	@Test(groups = "existence_of_signup")
	public void existenceEmailInput() {
		Assert.assertTrue(isExist(email), "Email name input is not exist!!!");

	}

	@Test(groups = "existence_of_signup")
	public void existencePasswordInput() {
		Assert.assertTrue(isExist(password), "Password input is not exist!!!");

	}

	@Test(groups = "existence_of_signup")
	public void existenceConfitmPasswordInput() {
		Assert.assertTrue(isExist(confirmPassword), "Confirm password input is not exist!!!");

	}

	@Test(groups = "existence_of_signup")
	public void existenceSignUpButton() {
		Assert.assertTrue(isExist(signUp), "SignUp button is not exist!!!");
	}

	@BeforeMethod(groups = "validation_first_name")
	public void clearFirstName() {
		driver.findElement(firstName).clear();
	}

	@Test(groups = "validation_first_name", dependsOnMethods = { "existenceFirstNameInput" })
	public void validateFirstName() {
		driver.findElement(firstName).sendKeys(NAME_VALID);
		sleep(500);
		driver.findElement(lastName).sendKeys("");
		String error = driver
				.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[1]/p[3]"))
				.getText();
		StringBuilder out = new StringBuilder("System show error message: '").append(error)
				.append("' when user put valid data");
		Assert.assertTrue(error.length() == 0, out.toString());

	}

	@Test(groups = "validation_first_name", dependsOnMethods = { "existenceFirstNameInput" })
	public void absenceFirstName() {
		driver.findElement(firstName).sendKeys(ABSENCE);
		sleep(500);
		driver.findElement(lastName).sendKeys("");
		String error = driver
				.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[1]/p[3]"))
				.getText();
		StringBuilder out = new StringBuilder("System show error message: '").append(error)
				.append("' when user did not put empty string");
		Assert.assertTrue(error.equals("First name is required"), out.toString());

	}

	@Test(groups = "validation_first_name", dependsOnMethods = { "existenceFirstNameInput" })
	public void invalideteFirstName() {
		driver.findElement(firstName).sendKeys(NAME_INVALIDE);
		sleep(500);
		driver.findElement(lastName).sendKeys("");
		String error = driver
				.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[1]/p[3]"))
				.getText();
		StringBuilder out = new StringBuilder("System show error message: '").append(error)
				.append("' when user put invalid string");
		Assert.assertTrue(error.equals("First name is invalide"), out.toString());

	}

	@BeforeMethod(groups = "validation_last_name")
	public void clearLastName() {
		driver.findElement(lastName).clear();
	}

	@Test(groups = "validation_last_name", dependsOnMethods = { "existenceLastNameInput" })
	public void validateLasttName() {
		driver.findElement(lastName).sendKeys(NAME_VALID);
		sleep(500);
		driver.findElement(firstName).sendKeys("");
		String error = driver
				.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[2]/p[3]"))
				.getText();
		StringBuilder out = new StringBuilder("System show error message: '").append(error)
				.append("' when user put valid data");
		Assert.assertTrue(error.length() == 0, out.toString());

	}

	@Test(groups = "validation_last_name", dependsOnMethods = { "existenceLastNameInput" })
	public void absenceLastName() {
		driver.findElement(lastName).sendKeys(ABSENCE);
		sleep(500);
		driver.findElement(firstName).sendKeys("");
		String error = driver
				.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[2]/p[3]"))
				.getText();
		StringBuilder out = new StringBuilder("System show error message: '").append(error)
				.append("' when user put empty string");
		Assert.assertTrue(error.equals("Last name is required"), out.toString());

	}

	@Test(groups = "validation_last_name", dependsOnMethods = { "existenceLastNameInput" })
	public void invalideteLastName() {
		driver.findElement(lastName).sendKeys(NAME_INVALIDE);
		sleep(500);
		driver.findElement(firstName).sendKeys("");
		String error = driver
				.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[2]/p[3]"))
				.getText();
		StringBuilder out = new StringBuilder("System show error message: '").append(error)
				.append("' when user put invalid string");
		Assert.assertTrue(error.equals("Last name is invalide"), out.toString());

	}

	@BeforeMethod(groups = "validation_email")
	public void clearEmail() {
		driver.findElement(email).clear();
	}

	@Test(groups = "validation_email", dependsOnMethods = { "existenceEmailInput" })
	public void validateEmail() {
		driver.findElement(email).sendKeys(EMAIL_VALID);
		sleep(500);
		driver.findElement(firstName).sendKeys("");
		String error = driver
				.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[3]/p[1]"))
				.getText();
		StringBuilder out = new StringBuilder("System show error message: '").append(error)
				.append("' when user put valid data");
		Assert.assertTrue(error.length() == 0, out.toString());
	}

	@Test(groups = "validation_email", dependsOnMethods = { "existenceEmailInput" })
	public void absenceEmail() {
		driver.findElement(email).sendKeys(ABSENCE);
		sleep(500);
		driver.findElement(firstName).sendKeys("");
		String error = driver
				.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[3]/p[1]"))
				.getText();
		StringBuilder out = new StringBuilder("System show error message: '").append(error)
				.append("' when user put empty string");
		Assert.assertTrue(error.equals("Email is required"), out.toString());

	}

	@Test(groups = "validation_email", dependsOnMethods = { "existenceEmailInput" })
	public void invalideteEmail() {
		driver.findElement(email).sendKeys(EMAIL_INVALID);
		sleep(500);
		driver.findElement(firstName).sendKeys("");
		String error = driver
				.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[3]/p[1]"))
				.getText();
		StringBuilder out = new StringBuilder("System show error message: '").append(error)
				.append("' when user put invalid string");
		Assert.assertTrue(error.equals("Email is invalide"), out.toString());

	}

	private boolean isExist(By element) {
		return driver.findElement(element).isDisplayed();
	}

	private void sleep(long l) {
		try {
			Thread.sleep(l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
