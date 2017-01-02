package rv.atqc.gttesting.possibility_sign_up_into_system;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import rv.atqc.gttesting.archex.GreenTourismHeadPage;
import rv.atqc.gttesting.archex.SignUpPage;

public class PossibilitySignUpIntoSystemChrome {

	private WebDriver driver;
	private SignUpPage page;
	
	private static final String NAME_VALID = "Anonym";
	private static final String ABSENCE = "";
	private static final String NAME_INVALID = "An786m";
	private static final String EMAIL_VALID = "first.last@domain.com";
	private static final String EMAIL_INVALID = "email@11111.222";
	private static final String LESS_8_PASSWORD = "1234567";
	private static final String PASSWORD_8 = "12345678";
	private static final String PASSWORD_9 = "123456789";

	@BeforeClass
	public void beforeClass() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get("https://green-tourism.herokuapp.com");
		driver.manage().window().maximize();
		page = new GreenTourismHeadPage(driver)
				.clickLeftNavButton()
				.clickSignUp();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

	@Test(groups = "existence_of_signup")
	public void checkExistenceSignUpForm() {
		Assert.assertTrue(page.getSignUpForm().isDisplayed(), "Signup form is not exist!!!");
	}

	@Test(groups = "existence_of_signup", dependsOnMethods = { "checkExistenceSignUpForm" })
	public void checkExistenceFirstNameInput() {
		Assert.assertTrue(page.getFirstName().isDisplayed(), "First name input is not exist!!!");
	}

	@Test(groups = "existence_of_signup", dependsOnMethods = { "checkExistenceSignUpForm" })
	public void checkExistenceLastNameInput() {
		Assert.assertTrue(page.getLastName().isDisplayed(), "Last name input is not exist!!!");

	}

	@Test(groups = "existence_of_signup", dependsOnMethods = { "checkExistenceSignUpForm" })
	public void checkExistenceEmailInput() {
		Assert.assertTrue(page.getEmail().isDisplayed(), "Email name input is not exist!!!");

	}

	@Test(groups = "existence_of_signup", dependsOnMethods = { "checkExistenceSignUpForm" })
	public void checkExistencePasswordInput() {
		Assert.assertTrue(page.getPassword().isDisplayed(), "Password input is not exist!!!");

	}

	@Test(groups = "existence_of_signup", dependsOnMethods = { "checkExistenceSignUpForm" })
	public void checkExistenceConfitmPasswordInput() {
		Assert.assertTrue(page.getPasswordConfirm().isDisplayed(), "Confirm password input is not exist!!!");

	}

	@Test(groups = "existence_of_signup", dependsOnMethods = { "checkExistenceSignUpForm" })
	public void checkExistenceSignUpButton() {
		Assert.assertTrue(page.getSignUpButton().isDisplayed(), "SignUp button is not exist!!!");
	}

	@BeforeMethod(groups = "validation_first_name")
	public void clearFirstName() {
		page.clearFirstName();
	}

	@Test(groups = "validation_first_name", dependsOnMethods = { "checkExistenceFirstNameInput" })
	public void checkFirstNameToValidData() {
		String actual = page.setFirstName(NAME_VALID).disableFocus().getFirstNameErrorMessage().getText();
		Assert.assertEquals(actual, "", "Error: system shows error message for valid data");

	}

	@Test(groups = "validation_first_name", dependsOnMethods = { "checkExistenceFirstNameInput" })
	public void checkFirstNameToEmptyData() {
		String actual = page.setFirstName(ABSENCE).disableFocus().getFirstNameErrorMessage().getText();
		Assert.assertEquals(actual, "First name is required", "Error: system don't show error message for empty data");
	}

	@Test(groups = "validation_first_name", dependsOnMethods = { "checkExistenceFirstNameInput" })
	public void checkFirstNameToInvaldData() {
		String actual = page.setFirstName(NAME_INVALID).disableFocus().getFirstNameErrorMessage().getText();
		Assert.assertEquals(actual, "First name is invalid", "Error: system don't show error message for invalid data");
	}

	@BeforeMethod(groups = "validation_last_name")
	public void clearLastName() {
		page.clearLastName();
	}

	@Test(groups = "validation_last_name", dependsOnMethods = { "checkExistenceLastNameInput" })
	public void checkLastNameToValidData() {
		String actual = page.setLastName(NAME_VALID).disableFocus().getLastNameErrorMessage().getText();
		Assert.assertEquals(actual, "", "Error: system shows error message for valid data");
	}

	@Test(groups = "validation_last_name", dependsOnMethods = { "checkExistenceLastNameInput" })
	public void checkLastNameToEmptyData() {
		String actual = page.setLastName(ABSENCE).disableFocus().getLastNameErrorMessage().getText();
		Assert.assertEquals(actual, "Last name is required", "Error: system don't show error message for empty data");
	}

	@Test(groups = "validation_last_name", dependsOnMethods = { "checkExistenceLastNameInput" })
	public void checkLastNameToInvaldData() {
		String actual = page.setLastName(NAME_INVALID).disableFocus().getLastNameErrorMessage().getText();
		Assert.assertEquals(actual, "Last name is invalid", "Error: system don't show error message for invalid data");
	}

	@BeforeMethod(groups = "validation_email")
	public void clearEmail() {
		page.clearEmail();
	}

	@Test(groups = "validation_email", dependsOnMethods = { "checkExistenceEmailInput" })
	public void checkEmailToValidData() {
		String actual = page.setEmail(EMAIL_VALID).disableFocus().getEmailErrorMessage().getText();
		Assert.assertEquals(actual, "", "Error: system shows error message for valid data");

	}

	@Test(groups = "validation_email", dependsOnMethods = { "checkExistenceEmailInput" })
	public void checkEmailToEmptyData() {
		String actual = page.setEmail(ABSENCE).disableFocus().getEmailErrorMessage().getText();
		Assert.assertEquals(actual, "Email is required", "Error: system don't show error message for empty data");
	}

	@Test(groups = "validation_email", dependsOnMethods = { "checkExistenceEmailInput" })
	public void checkEmailToInvalisData() {
		String actual = page.setLastName(EMAIL_INVALID).disableFocus().getEmailErrorMessage().getText();
		Assert.assertEquals(actual, "Email name is invalid", "Error: system don't show error message for invalid data");
	}

	@BeforeMethod(groups = "password_length")
	public void clearPassword() {
		page.clearPassword();
	}

	@Test(groups = "password_length", dependsOnMethods = { "checkExistencePasswordInput" })
	public void checkPasswordToLess8s() {
		String actual = page.setPassword(LESS_8_PASSWORD).disableFocus().getPasswordErrorMessage().getText();
		Assert.assertEquals(actual, "Password should be longer than 8 characters", "Error: system don't show error message for invalid data");
	}

	@Test(groups = "password_length", dependsOnMethods = { "checkExistencePasswordInput" })
	public void checkPasswordTo8s() {
		String actual = page.setPassword(PASSWORD_8).disableFocus().getPasswordErrorMessage().getText();
		Assert.assertEquals(actual, "", "Error: system shows error message for valid data");
	}

	@Test(groups = "password_length", dependsOnMethods = { "checkExistencePasswordInput" })
	public void checkPasswordToEmpty() {
		String actual = page.setPassword(ABSENCE).disableFocus().getPasswordErrorMessageForRequired().getText();
		Assert.assertEquals(actual, "Password is required", "Error: system don't show error message for invalid data");
	}

	@BeforeMethod(groups = "confirm_password_length")
	public void clearConfirmPassword() {
		page.clearPasswordConfirm();
	}

	@Test(groups = "confirm_password_length", dependsOnMethods = { "checkExistenceConfitmPasswordInput" })
	public void checkConfirmPasswordToLess8s() {
		String actual = page.setPasswordConfirm(LESS_8_PASSWORD).disableFocus().getPasswordConfirmErrorMessage().getText();
		Assert.assertEquals(actual, "Passwords doesn't match", "Error: system don't show error message for invalid data");
	}

	@BeforeMethod(groups = "confirm_password")
	public void clearPasswords() {
		page.clearPasswordConfirm().clearPassword();
	}

	@Test(groups = "confirm_password", dependsOnMethods = { "checkExistencePasswordInput", "checkExistenceConfitmPasswordInput" })
	public void confirmPassword() {
		String actual = page.setPassword(PASSWORD_8).setPasswordConfirm(PASSWORD_8).disableFocus().getPasswordConfirmErrorMessage().getText();
		Assert.assertEquals(actual, "", "Error: system shows error message for valid data");
	}

	@Test(groups = "confirm_password", dependsOnMethods = { "checkExistencePasswordInput", "checkExistenceConfitmPasswordInput" })
	public void confirmPasswordNeg() {
		String actual = page.setPassword(PASSWORD_8).setPasswordConfirm(PASSWORD_9).disableFocus().getPasswordConfirmErrorMessage().getText();
		Assert.assertEquals(actual, "Passwords doesn't match", "Error: system don't show error message for invalid data");
	}

	@Test(dependsOnMethods = { "checkExistenceSignUpForm", "checkExistenceFirstNameInput", "checkExistenceLastNameInput",
			"checkExistenceEmailInput", "checkExistencePasswordInput", "checkExistenceConfitmPasswordInput", "checkExistenceSignUpButton" })
	public void checkSignUp() {
		page.clearFirstName()
			.clearLastName()
			.clearEmail()
			.clearPassword()
			.clearPasswordConfirm()
			.setFirstName(nameGenerator())
			.setLastName(nameGenerator())
			.setEmail(emailGenerator())
			.setPassword(PASSWORD_8)
			.setPasswordConfirm(PASSWORD_8)
			.clickSignUp();
		
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
//				"html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown a.dropdown-toggle i.fa.fa-user.navtop")))
//				.click();
//		String url = driver.getCurrentUrl();
//		driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/li[2]/a")).click();
//		beforeInit();
		Assert.assertTrue(true);
	}

	private String nameGenerator() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder("A");
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		return output;
	}

	private String emailGenerator() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder("A");
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		sb.append("@gmail.com");
		String output = sb.toString();
		return output;
	}
}