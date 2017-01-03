package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpPage extends AbstractPage<SignUpPage> {
	
	@FindBy(how = How.CSS, using = "html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown.open ul.dropdown-menu.dropdown-auth.nav-ul auth.ng-isolate-scope div.ng-scope div.container.registration.ng-scope form.ng-pristine.ng-invalid.ng-invalid-required.ng-valid-minlength.ng-valid-maxlength.ng-valid-email.ng-valid-pattern.ng-valid-match")
	private WebElement signUpForm;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[1]/input")
	private WebElement firstName;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[2]/input")
	private WebElement lastName;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[3]/input")
	private WebElement email;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[4]/input")
	private WebElement password;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[5]/input")
	private WebElement passwordConfirm;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/input")
	private WebElement signUpButton;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[1]/p[3]")
	private WebElement firstNameErrorMessage;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[2]/p[3]")
	private WebElement lastNameErrorMessage;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[3]/p[1]")
	private WebElement emailErrorMessage;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[4]/p[1]")
	private WebElement passwordErrorMessage;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[4]/p[2]")
	private WebElement passwordErrorMessageForRequired;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[5]/p[1]")
	private WebElement passwordConfirmErrorMessage;

	public SignUpPage(WebDriver driver) {
		super(driver);
	}

	public SignUpPage setFirstName(CharSequence text) {
		firstName.sendKeys(text);
		return this;
	}

	public SignUpPage setLastName(CharSequence text) {
		lastName.sendKeys(text);
		return this;
	}

	public SignUpPage setEmail(CharSequence text) {
		email.sendKeys(text);
		return this;
	}

	public SignUpPage setPassword(CharSequence text) {
		password.sendKeys(text);
		return this;
	}

	public SignUpPage setPasswordConfirm(CharSequence text) {
		passwordConfirm.sendKeys(text);
		return this;
	}

	public SignUpPage clearFirstName() {
		firstName.clear();
		return this;
	}

	public SignUpPage clearLastName() {
		lastName.clear();
		return this;
	}

	public SignUpPage clearEmail() {
		email.clear();
		return this;
	}

	public SignUpPage clearPassword() {
		password.clear();
		return this;
	}

	public SignUpPage clearPasswordConfirm() {
		passwordConfirm.clear();
		return this;
	}
	
	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getPasswordConfirm() {
		return passwordConfirm;
	}

	public WebElement getSignUpButton() {
		return signUpButton;
	}

	public WebElement getFirstNameErrorMessage() {
		return firstNameErrorMessage;
	}

	public WebElement getLastNameErrorMessage() {
		return lastNameErrorMessage;
	}

	public WebElement getEmailErrorMessage() {
		return emailErrorMessage;
	}

	public WebElement getPasswordErrorMessage() {
		return passwordErrorMessage;
	}

	public WebElement getPasswordErrorMessageForRequired() {
		return passwordErrorMessageForRequired;
	}

	public WebElement getPasswordConfirmErrorMessage() {
		return passwordConfirmErrorMessage;
	}

	public HeadForLoggedUserPage clickSignUp() {
		signUpButton.click();
		return new HeadForLoggedUserPage(driver);
	}
	
	
	public WebElement getSignUpForm() {
		return signUpForm;
	}
}
