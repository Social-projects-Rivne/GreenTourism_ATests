package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.AfterMethod;

public class LeftNavigationForGuestUserPage<T extends LeftNavigationForGuestUserPage<T>> extends AbstractPage<T> {

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[1]/h6/a[1]")
	private WebElement logIn;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[1]/h6/a[2]")
	private WebElement signUp;

	public LeftNavigationForGuestUserPage(WebDriver driver) {
		super(driver);
	}

	public LogInPage clickLogIn() {
		logIn.click();
		return new LogInPage(driver);
	}

	public SignUpPage clickSignUp() {
		signUp.click();
		return new SignUpPage(driver);
	}

	@AfterMethod
	public void after(){
		driver.quit();
	}
}
