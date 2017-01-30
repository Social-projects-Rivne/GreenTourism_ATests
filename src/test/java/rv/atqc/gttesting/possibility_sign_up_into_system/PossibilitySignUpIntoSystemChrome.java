package rv.atqc.gttesting.possibility_sign_up_into_system;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import rv.atqc.gttesting.archex.HeadForGuestUserPage;
import rv.atqc.gttesting.archex.HeadForLoggedUserPage;
import rv.atqc.gttesting.archex.SignUpPage;
import rv.atqc.gttesting.res.Resources;

public class PossibilitySignUpIntoSystemChrome {

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
	

	@BeforeGroups(groups = {EXISTENCE_OF_SIGNUP, FIRST_NAME_VALIDATION, LAST_NAME_VALIDATION, 
							EMAIL_VALIDATION, PASSWORD_VALIDATION, PASSWORD_CONFIRM_VALIDATION, PASSWORD_CONFIRM, SIGNUP_FUNCTIONALITY})
	public void beforeExistenceOfSignUp() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get("https://green-tourism.herokuapp.com");
		driver.manage().window().maximize();
		page = new HeadForGuestUserPage(driver)
				.clickLeftNavButton()
				.clickSignUp();
	}

	@AfterGroups(groups = {EXISTENCE_OF_SIGNUP, FIRST_NAME_VALIDATION, LAST_NAME_VALIDATION, 
							EMAIL_VALIDATION, PASSWORD_VALIDATION, PASSWORD_CONFIRM_VALIDATION, PASSWORD_CONFIRM, SIGNUP_FUNCTIONALITY})
	public void afterClass() {
		driver.quit();
	}

	@Test(groups = {EXISTENCE_OF_SIGNUP})
	public void verifyExistenceOfSignUpForm() {
		WebElement signUpForm = page.getSignUpForm();
		Assert.assertTrue(signUpForm.isDisplayed());
	}

	@Test(groups = {EXISTENCE_OF_SIGNUP}, dependsOnMethods = {"verifyExistenceOfSignUpForm"})
	public void verifyExistenceOfFirstNameInput() {
		WebElement firstName = page.getFirstName();
		Assert.assertTrue(firstName.isDisplayed());
	}

	@Test(groups = {EXISTENCE_OF_SIGNUP}, dependsOnMethods = {"verifyExistenceOfSignUpForm"})
	public void verifyExistenceOfLastNameInput() {
		WebElement lastName = page.getLastName();
		Assert.assertTrue(lastName.isDisplayed());
	}

	@Test(groups = {EXISTENCE_OF_SIGNUP}, dependsOnMethods = {"verifyExistenceOfSignUpForm"})
	public void verifyExistenceOfEmailInput() {
		WebElement email = page.getEmail();
		Assert.assertTrue(email.isDisplayed());
	}

	@Test(groups = {EXISTENCE_OF_SIGNUP}, dependsOnMethods = {"verifyExistenceOfSignUpForm"})
	public void verifyExistenceOfPasswordInput() {
		WebElement password = page.getPassword();
		Assert.assertTrue(password.isDisplayed());

	}

	@Test(groups = {EXISTENCE_OF_SIGNUP}, dependsOnMethods = {"verifyExistenceOfSignUpForm"})
	public void verifyExistenceOfConfitmPasswordInput() {
		WebElement confirmPassword = page.getPasswordConfirm();
		Assert.assertTrue(confirmPassword.isDisplayed());
	}

	@Test(groups = {EXISTENCE_OF_SIGNUP}, dependsOnMethods = {"verifyExistenceOfSignUpForm"})
	public void verifyExistenceOfSignUpButton() {
		WebElement signUpButton = page.getSignUpButton();
		Assert.assertTrue(signUpButton.isDisplayed());
	}
	
	@BeforeMethod(groups = {FIRST_NAME_VALIDATION})
	public void clearFirstName() {
		page.clearFirstName();
	}

	@Test(groups = {FIRST_NAME_VALIDATION}, dependsOnMethods = {"verifyExistenceOfFirstNameInput"})
	public void verifyFirstNameInputToValidData() {
		String actual = page.setFirstName(Resources.UserTestData.VALID_NAME)
				.disableFocus()
				.getFirstNameErrorMessage()
				.getText();
		Assert.assertEquals(actual, Resources.SignUpErrorMessage.NO_MESSAGE);

	}

	@Test(groups = {FIRST_NAME_VALIDATION}, dependsOnMethods = { "verifyExistenceOfFirstNameInput" })
	public void verifyFirstNameInputToEmptyData() {
		String actual = page.setFirstName(Resources.UserTestData.EMPTY)
				.disableFocus()
				.getFirstNameErrorMessage()
				.getText();
		Assert.assertEquals(actual, Resources.SignUpErrorMessage.FIRST_NAME_EMPTY);
	}

	@Test(groups = {FIRST_NAME_VALIDATION}, dependsOnMethods = { "verifyExistenceOfFirstNameInput" })
	public void verifyFirstNameInputToInvaldData() {
		String actual = page.setFirstName(Resources.UserTestData.INVALID_NAME)
				.disableFocus()
				.getFirstNameErrorMessage()
				.getText();
		Assert.assertEquals(actual, Resources.SignUpErrorMessage.FIRST_NAME_INVALID);
	}

	@BeforeMethod(groups = {LAST_NAME_VALIDATION})
	public void clearLastName() {
		page.clearLastName();
	}

	@Test(groups = {LAST_NAME_VALIDATION}, dependsOnMethods = { "verifyExistenceOfLastNameInput" })
	public void verifyLastNameInputToValidData() {
		String actual = page.setLastName(Resources.UserTestData.VALID_NAME)
				.disableFocus()
				.getLastNameErrorMessage()
				.getText();
		Assert.assertEquals(actual, Resources.SignUpErrorMessage.NO_MESSAGE);
	}

	@Test(groups = {LAST_NAME_VALIDATION}, dependsOnMethods = { "verifyExistenceOfLastNameInput" })
	public void verifyLastNameInputToEmptyData() {
		String actual = page.setLastName(Resources.UserTestData.EMPTY)
				.disableFocus()
				.getLastNameErrorMessage()
				.getText();
		Assert.assertEquals(actual, Resources.SignUpErrorMessage.LAST_NAME_EMPTY);
	}

	@Test(groups = {LAST_NAME_VALIDATION}, dependsOnMethods = { "verifyExistenceOfLastNameInput" })
	public void verifyLastNameInputToInvalidData() {
		String actual = page.setLastName(Resources.UserTestData.INVALID_NAME)
				.disableFocus()
				.getLastNameErrorMessage()
				.getText();
		Assert.assertEquals(actual, Resources.SignUpErrorMessage.LAST_NAME_INVALID);
	}

	@BeforeMethod(groups = {EMAIL_VALIDATION})
	public void clearEmail() {
		page.clearEmail();
	}

	@Test(groups = {EMAIL_VALIDATION}, dependsOnMethods = { "verifyExistenceOfEmailInput" })
	public void verifyEmailInputToValidData() {
		String actual = page.setEmail(Resources.UserTestData.VALID_EMAIL)
				.disableFocus()
				.getEmailErrorMessage()
				.getText();
		Assert.assertEquals(actual, Resources.SignUpErrorMessage.NO_MESSAGE);
	}

	@Test(groups = {EMAIL_VALIDATION}, dependsOnMethods = { "verifyExistenceOfEmailInput" })
	public void verifyEmailInputToEmptyData() {
		String actual = page.setEmail(Resources.UserTestData.EMPTY)
				.disableFocus()
				.getEmailErrorMessage()
				.getText();
		Assert.assertEquals(actual, Resources.SignUpErrorMessage.EMAIL_EMPTY);
	}

	@Test(groups = {EMAIL_VALIDATION}, dependsOnMethods = { "verifyExistenceOfEmailInput" })
	public void verifyEmailInputToInvalidData() {
		String actual = page.setLastName(Resources.UserTestData.INVALID_EMAIL)
				.disableFocus()
				.getEmailErrorMessage()
				.getText();
		Assert.assertEquals(actual, Resources.SignUpErrorMessage.EMAIL_INVALID);
	}
	
	@BeforeMethod(groups = {PASSWORD_VALIDATION})
	public void clearPassword() {
		page.clearPassword();
	}

	@Test(groups = {PASSWORD_VALIDATION}, dependsOnMethods = { "verifyExistenceOfPasswordInput" })
	public void verifyPasswordInputToPasswordLess8Symbols() {
		String actual = page.setPassword(Resources.UserTestData.PASSWORD7)
				.disableFocus()
				.getPasswordErrorMessage()
				.getText();
		Assert.assertEquals(actual, Resources.SignUpErrorMessage.PASSWORD_LONGER);
	}

	@Test(groups = {PASSWORD_VALIDATION}, dependsOnMethods = { "verifyExistenceOfPasswordInput" })
	public void verifyPasswordInputToPassword8Symbols() {
		String actual = page.setPassword(Resources.UserTestData.PASSWORD8)
				.disableFocus()
				.getPasswordErrorMessage()
				.getText();
		Assert.assertEquals(actual, Resources.SignUpErrorMessage.NO_MESSAGE);
	}

	@Test(groups = {PASSWORD_VALIDATION}, dependsOnMethods = { "verifyExistenceOfPasswordInput" })
	public void verifyPasswordInputToEmptyPassword() {
		String actual = page.setPassword(Resources.UserTestData.EMPTY)
				.disableFocus()
				.getPasswordErrorMessageForRequired()
				.getText();
		Assert.assertEquals(actual, Resources.SignUpErrorMessage.PASSWORD_IS_EMPTY);
	}
	
	@BeforeMethod(groups = {PASSWORD_CONFIRM_VALIDATION})
	public void clearConfirmPassword() {
		page.clearPasswordConfirm();
	}

	@Test(groups = {PASSWORD_CONFIRM_VALIDATION}, dependsOnMethods = { "verifyExistenceOfConfitmPasswordInput" })
	public void verifyConfirmPasswordInputToPasswordLess8Symbols() {
		clearConfirmPassword();
		String actual = page.setPasswordConfirm(Resources.UserTestData.PASSWORD7)
				.disableFocus()
				.getPasswordConfirmErrorMessage()
				.getText();
		Assert.assertEquals(actual, Resources.SignUpErrorMessage.PASSWORD_NO_MATCH);
	}
	
	@BeforeMethod(groups = {PASSWORD_CONFIRM})
	public void clearPasswords() {
		page.clearPasswordConfirm().clearPassword();
	}

	@Test(groups = {PASSWORD_CONFIRM}, dependsOnMethods = { "verifyExistenceOfPasswordInput", "verifyExistenceOfConfitmPasswordInput" })
	public void verifyPasswordsAndConfirmPasswordInputsToEqualsPasswords() {
		String actual = page.setPassword(Resources.UserTestData.PASSWORD8)
				.setPasswordConfirm(Resources.UserTestData.PASSWORD8)
				.disableFocus()
				.getPasswordConfirmErrorMessage()
				.getText();
		Assert.assertEquals(actual, Resources.SignUpErrorMessage.NO_MESSAGE);
	}

	@Test(groups = {PASSWORD_CONFIRM}, dependsOnMethods = { "verifyExistenceOfPasswordInput", "verifyExistenceOfConfitmPasswordInput" })
	public void verifyPasswordsAndConfirmPasswordInputsToNoEqualsPasswords() {
		String actual = page.setPassword(Resources.UserTestData.PASSWORD8)
				.setPasswordConfirm(Resources.UserTestData.PASSWORD9)
				.disableFocus()
				.getPasswordConfirmErrorMessage()
				.getText();
		Assert.assertEquals(actual, Resources.SignUpErrorMessage.PASSWORD_NO_MATCH);
	}
	
	@BeforeMethod(groups = {SIGNUP_FUNCTIONALITY})
	public void clearSignUpForm() {
		page.clearFirstName()
			.clearLastName()
			.clearEmail()
			.clearPassword()
			.clearPasswordConfirm();
	}

	@Test(groups = {SIGNUP_FUNCTIONALITY}, dependsOnMethods = {"verifyExistenceOfSignUpForm"})
	public void verifySignUpSystem() {
		String expected = "https://green-tourism.herokuapp.com/#!/profile";
		HeadForLoggedUserPage headForLoggedUserPage = page.setFirstName(nameGenerator())
			.setLastName(nameGenerator())
			.setEmail(emailGenerator())
			.setPassword(Resources.UserTestData.PASSWORD8)
			.setPasswordConfirm(Resources.UserTestData.PASSWORD8)
			.clickSignUpButton();
		String url = headForLoggedUserPage.getCurrentUrl();
		Assert.assertEquals(url, expected);
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