package rv.atqc.gttesting.possibility_sign_up_into_system;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import rv.atqc.gttesting.archex.HeadForGuestUserPage;
import rv.atqc.gttesting.archex.HeadForLoggedUserPage;
import rv.atqc.gttesting.archex.SignUpPage;

public class PossibilitySignUpIntoSystemFireFox {

	private WebDriver driver;
	private SignUpPage page;
	
	
	private static final String EXISTENCE_OF_SIGNUP = "existence_of_signup";
	private static final String FIRST_NAME_VALIDATION = "validation_first_name";
	private static final String LAST_NAME_VALIDATION = "validation_last_name";
	private static final String EMAIL_VALIDATION = "validation_email";
	private static final String PASSWORD_VALIDATION = "validation_password";
	private static final String PASSWORD_CONFIRM_VALIDATION = "validation_password_confirm";
	private static final String PASSWORD_CONFIRM = "password_confirm";
	private static final String SIGNUP_FUNCTIONALITY = "signup_functionality";
	
	private static final String NAME_VALID = "Anonym";
	private static final String ABSENCE = "";
	private static final String NAME_INVALID = "An786m";
	private static final String EMAIL_VALID = "first.last@domain.com";
	private static final String EMAIL_INVALID = "email@11111.222";
	private static final String LESS_8_PASSWORD = "1234567";
	private static final String PASSWORD_8 = "12345678";
	private static final String PASSWORD_9 = "123456789";
	
	private void init(){
		FirefoxDriverManager.getInstance().setup();
		driver = new FirefoxDriver();
		driver.get("http://green-tourism.herokuapp.com");
		driver.manage().window().maximize();
		page = new HeadForGuestUserPage(driver)
				.clickLeftNavButton()
				.clickSignUp();
	}
	

	@BeforeGroups(groups ={ EXISTENCE_OF_SIGNUP,  FIRST_NAME_VALIDATION, LAST_NAME_VALIDATION, 
			EMAIL_VALIDATION, PASSWORD_VALIDATION, PASSWORD_CONFIRM_VALIDATION, PASSWORD_CONFIRM, SIGNUP_FUNCTIONALITY})
	public void beforeExistenceOfSignUp() {
		init();
	}

	@AfterGroups(groups ={ EXISTENCE_OF_SIGNUP,  FIRST_NAME_VALIDATION, LAST_NAME_VALIDATION, 
			EMAIL_VALIDATION, PASSWORD_VALIDATION, PASSWORD_CONFIRM_VALIDATION, PASSWORD_CONFIRM, SIGNUP_FUNCTIONALITY})
	public void afterClass() {
		driver.close();
	}

	@Test(groups = EXISTENCE_OF_SIGNUP)
	public void checkExistenceSignUpForm() {
		Assert.assertTrue(page.getSignUpForm().isDisplayed(), "Signup form is not exist!!!");
	}

	@Test(groups = EXISTENCE_OF_SIGNUP, dependsOnMethods = { "checkExistenceSignUpForm" })
	public void checkExistenceFirstNameInput() {
		Assert.assertTrue(page.getFirstName().isDisplayed(), "First name input is not exist!!!");
	}

	@Test(groups = EXISTENCE_OF_SIGNUP, dependsOnMethods = { "checkExistenceSignUpForm" })
	public void checkExistenceLastNameInput() {
		Assert.assertTrue(page.getLastName().isDisplayed(), "Last name input is not exist!!!");

	}

	@Test(groups = EXISTENCE_OF_SIGNUP, dependsOnMethods = { "checkExistenceSignUpForm" })
	public void checkExistenceEmailInput() {
		Assert.assertTrue(page.getEmail().isDisplayed(), "Email name input is not exist!!!");

	}

	@Test(groups = EXISTENCE_OF_SIGNUP, dependsOnMethods = { "checkExistenceSignUpForm" })
	public void checkExistencePasswordInput() {
		Assert.assertTrue(page.getPassword().isDisplayed(), "Password input is not exist!!!");

	}

	@Test(groups = EXISTENCE_OF_SIGNUP, dependsOnMethods = { "checkExistenceSignUpForm" })
	public void checkExistenceConfitmPasswordInput() {
		Assert.assertTrue(page.getPasswordConfirm().isDisplayed(), "Confirm password input is not exist!!!");

	}

	@Test(groups = EXISTENCE_OF_SIGNUP, dependsOnMethods = { "checkExistenceSignUpForm" })
	public void checkExistenceSignUpButton() {
		Assert.assertTrue(page.getSignUpButton().isDisplayed(), "SignUp button is not exist!!!");
	}
	
	@BeforeMethod(groups = FIRST_NAME_VALIDATION)
	public void clearFirstName() {
		page.clearFirstName();
	}

	@Test(groups = FIRST_NAME_VALIDATION, dependsOnMethods = { "checkExistenceFirstNameInput" })
	public void checkFirstNameToValidData() {
		String actual = page.setFirstName(NAME_VALID).disableFocus().getFirstNameErrorMessage().getText();
		Assert.assertEquals(actual, "", "Error: system shows error message for valid data");

	}

	@Test(groups = FIRST_NAME_VALIDATION, dependsOnMethods = { "checkExistenceFirstNameInput" })
	public void checkFirstNameToEmptyData() {
		String actual = page.setFirstName(ABSENCE).disableFocus().getFirstNameErrorMessage().getText();
		Assert.assertEquals(actual, "First name is required", "Error: system don't show error message for empty data");
	}

	@Test(groups = FIRST_NAME_VALIDATION, dependsOnMethods = { "checkExistenceFirstNameInput" })
	public void checkFirstNameToInvaldData() {
		String actual = page.setFirstName(NAME_INVALID).disableFocus().getFirstNameErrorMessage().getText();
		Assert.assertEquals(actual, "First name is invalid", "Error: system don't show error message for invalid data");
	}

	@BeforeMethod(groups = LAST_NAME_VALIDATION)
	public void clearLastName() {
		page.clearLastName();
	}

	@Test(groups = LAST_NAME_VALIDATION, dependsOnMethods = { "checkExistenceLastNameInput" })
	public void checkLastNameToValidData() {
		String actual = page.setLastName(NAME_VALID).disableFocus().getLastNameErrorMessage().getText();
		Assert.assertEquals(actual, "", "Error: system shows error message for valid data");
	}

	@Test(groups = LAST_NAME_VALIDATION, dependsOnMethods = { "checkExistenceLastNameInput" })
	public void checkLastNameToEmptyData() {
		String actual = page.setLastName(ABSENCE).disableFocus().getLastNameErrorMessage().getText();
		Assert.assertEquals(actual, "Last name is required", "Error: system don't show error message for empty data");
	}

	@Test(groups = LAST_NAME_VALIDATION, dependsOnMethods = { "checkExistenceLastNameInput" })
	public void checkLastNameToInvaldData() {
		String actual = page.setLastName(NAME_INVALID).disableFocus().getLastNameErrorMessage().getText();
		Assert.assertEquals(actual, "Last name is invalid", "Error: system don't show error message for invalid data");
	}

	@BeforeMethod(groups = EMAIL_VALIDATION)
	public void clearEmail() {
		page.clearEmail();
	}

	@Test(groups = EMAIL_VALIDATION, dependsOnMethods = { "checkExistenceEmailInput" })
	public void checkEmailToValidData() {
		String actual = page.setEmail(EMAIL_VALID).disableFocus().getEmailErrorMessage().getText();
		Assert.assertEquals(actual, "", "Error: system shows error message for valid data");
	}

	@Test(groups = EMAIL_VALIDATION, dependsOnMethods = { "checkExistenceEmailInput" })
	public void checkEmailToEmptyData() {
		String actual = page.setEmail(ABSENCE).disableFocus().getEmailErrorMessage().getText();
		Assert.assertEquals(actual, "Email is required", "Error: system don't show error message for empty data");
	}

	@Test(groups = EMAIL_VALIDATION, dependsOnMethods = { "checkExistenceEmailInput" })
	public void checkEmailToInvalisData() {
		String actual = page.setLastName(EMAIL_INVALID).disableFocus().getEmailErrorMessage().getText();
		Assert.assertEquals(actual, "Email name is invalid", "Error: system don't show error message for invalid data");
	}
	
	@BeforeMethod(groups = PASSWORD_VALIDATION)
	public void clearPassword() {
		page.clearPassword();
	}

	@Test(groups = PASSWORD_VALIDATION, dependsOnMethods = { "checkExistencePasswordInput" })
	public void checkPasswordToLess8s() {
		String actual = page.setPassword(LESS_8_PASSWORD).disableFocus().getPasswordErrorMessage().getText();
		Assert.assertEquals(actual, "Password should be longer than 8 characters", "Error: system don't show error message for invalid data");
	}

	@Test(groups = PASSWORD_VALIDATION, dependsOnMethods = { "checkExistencePasswordInput" })
	public void checkPasswordTo8s() {
		String actual = page.setPassword(PASSWORD_8).disableFocus().getPasswordErrorMessage().getText();
		Assert.assertEquals(actual, "", "Error: system shows error message for valid data");
	}

	@Test(groups = PASSWORD_VALIDATION, dependsOnMethods = { "checkExistencePasswordInput" })
	public void checkPasswordToEmpty() {
		String actual = page.setPassword(ABSENCE).disableFocus().getPasswordErrorMessageForRequired().getText();
		Assert.assertEquals(actual, "Password is required", "Error: system don't show error message for invalid data");
	}
	
	@BeforeMethod(groups = PASSWORD_CONFIRM_VALIDATION)
	public void clearConfirmPassword() {
		page.clearPasswordConfirm();
	}

	@Test(groups = PASSWORD_CONFIRM_VALIDATION, dependsOnMethods = { "checkExistenceConfitmPasswordInput" })
	public void checkConfirmPasswordToLess8s() {
		clearConfirmPassword();
		String actual = page.setPasswordConfirm(LESS_8_PASSWORD).disableFocus().getPasswordConfirmErrorMessage().getText();
		Assert.assertEquals(actual, "Passwords doesn't match", "Error: system don't show error message for invalid data");
	}
	
	@BeforeMethod(groups = PASSWORD_CONFIRM)
	public void clearPasswords() {
		page.clearPasswordConfirm().clearPassword();
	}

	@Test(groups = PASSWORD_CONFIRM, dependsOnMethods = { "checkExistencePasswordInput", "checkExistenceConfitmPasswordInput" })
	public void confirmPassword() {
		String actual = page.setPassword(PASSWORD_8).setPasswordConfirm(PASSWORD_8).disableFocus().getPasswordConfirmErrorMessage().getText();
		Assert.assertEquals(actual, "", "Error: system shows error message for valid data");
	}

	@Test(groups = PASSWORD_CONFIRM, dependsOnMethods = { "checkExistencePasswordInput", "checkExistenceConfitmPasswordInput" })
	public void confirmPasswordNeg() {
		String actual = page.setPassword(PASSWORD_8).setPasswordConfirm(PASSWORD_9).disableFocus().getPasswordConfirmErrorMessage().getText();
		Assert.assertEquals(actual, "Passwords doesn't match", "Error: system don't show error message for invalid data");
	}

	@Test(groups = SIGNUP_FUNCTIONALITY, dependsOnGroups = {EXISTENCE_OF_SIGNUP})
	public void checkSignUp() {
		String expected = "https://green-tourism.herokuapp.com/#!/profile";
		HeadForLoggedUserPage headForLoggedUserPage = page.clearFirstName()
			.clearLastName()
			.clearEmail()
			.clearPassword()
			.clearPasswordConfirm()
			.setFirstName(nameGenerator())
			.setLastName(nameGenerator())
			.setEmail(emailGenerator())
			.setPassword(PASSWORD_8)
			.setPasswordConfirm(PASSWORD_8)
			.clickSignUpButton();
		String url = headForLoggedUserPage.getCurrentUrl();
		page = headForLoggedUserPage.clickLeftNavButton()
			.clickLogOut()
			.clickLeftNavButton()
			.clickSignUp();
		Assert.assertEquals(url, expected);;
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
		StringBuilder sb = new StringBuilder();
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