package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftNavigationPage extends GreenTourismHeadPage implements LeftNavigationScript {

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[1]/h6/a[1]")
	public WebElement logIn;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[1]/h6/a[2]")
	public WebElement signUp;

	public LeftNavigationPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void clickLogIn() {
		clickLeftNavButton();
		logIn.click();
	}

	@Override
	public void clickSignUp() {
		clickLeftNavButton();
		signUp.click();
	}

}
