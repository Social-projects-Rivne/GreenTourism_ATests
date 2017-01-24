package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import rv.atqc.gttesting.res.Resources;

public class LogInPage extends LeftNavigationForGuestUserPage<LogInPage> {

    @FindBy(css = "html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown.open ul.dropdown-menu.dropdown-auth.nav-ul auth.ng-isolate-scope div.ng-scope div.container.registration.ng-scope form.ng-dirty.ng-valid-parse.ng-valid-required.ng-valid-email.ng-valid.ng-valid-pattern input.btn.btn-success.btn-block.submit-btn")
    private WebElement loginButton;
    @FindBy(css = "html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown a.dropdown-toggle i.fa.fa-user.navtop")
    private WebElement leftTopGreenButton;
    @FindBy(xpath = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[1]/input")
    private WebElement emailField;
    @FindBy(xpath = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[2]/input")
    private WebElement passwordField;
    @FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[1]/input")
    private WebElement loginField;
    @FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/input")
    private WebElement logInButton;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public LogInPage clickOnLeftTopGreenButton() {
        waitForElementToBeClickable(leftTopGreenButton, Integer.valueOf(Resources.LogInConstants.MAX_WAIT_TIME));
        leftTopGreenButton.click();
        return this;
    }

    private LogInPage insertEmail() {
        waitForVisibilityOfElement(emailField, Integer.valueOf(Resources.LogInConstants.MAX_WAIT_TIME));
        emailField.sendKeys(Resources.LogInConstants.USER_EMAIL);
        return this;
    }

    private LogInPage insertPassword() {
        passwordField.sendKeys(Resources.LogInConstants.USER_PASSWORD);
        return this;
    }

    private LogInPage clickOnLoginButton() {
        loginButton.click();
        return this;
    }

	public LogInPage setLoginField(CharSequence text) {
		waitForVisibilityOfElement(loginField, MAX_TIME_WAIT);
		loginField.sendKeys(text);
		return this;
	}

	public LogInPage setPasswordField(CharSequence text) {
		waitForVisibilityOfElement(passwordField, MAX_TIME_WAIT);
		passwordField.sendKeys(text);
		return this;
	}

	public HeadForLoggedUserPage clickLogInButton() {
		waitForElementToBeClickable(logInButton, MAX_TIME_WAIT);
		logInButton.click();
		return new HeadForLoggedUserPage(driver);
	}

	public ProfilePage loging() {
		new HeadForGuestUserPage(driver)
		.clickLeftNavButton().clickLogIn();
		setLoginField(Resources.LogInMessage.USER_EMAIL);
		setPasswordField(Resources.LogInMessage.USER_PASSWORD);
		clickLogInButton();
		return new ProfilePage(driver);
	}

}
