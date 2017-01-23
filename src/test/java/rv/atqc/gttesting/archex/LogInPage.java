package rv.atqc.gttesting.archex;

import org.eclipse.jetty.util.resource.Resource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import rv.atqc.gttesting.res.Resources;

public class LogInPage extends LeftNavigationForGuestUserPage<LogInPage> {

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[1]/input")
	private WebElement loginField;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[2]/input")
	private WebElement passwordField;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/input")
	private WebElement logInButton;

	public LogInPage(WebDriver driver) {
		super(driver);
	}

	public LogInPage setLoginField(CharSequence text) {
		loginField.sendKeys(text);
		return this;
	}

	public LogInPage setPasswordField(CharSequence text) {
		passwordField.sendKeys(text);
		return this;
	}

	public HeadForLoggedUserPage clickLogInButton() {
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
