package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LeftNavigationPage extends AbstractPage {

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[1]/h6/a[1]")
	private WebElement logIn;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[1]/h6/a[2]")
	private WebElement signUp;

	public LeftNavigationPage(WebDriver driver) {
		super(driver);
	}

	public void clickLogIn() {
		logIn.click();
	}

	public SignUpPage clickSignUp() {
		signUp.click();
		return new SignUpPage(driver);
	}

	
}
