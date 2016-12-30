package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GreenTourismHeadPage extends AbstractPage {

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/a/i")
	private WebElement leftNavButton;
	
	public GreenTourismHeadPage(WebDriver driver) {
		super(driver);
	}
	

	public LeftNavigationPage clickLeftNavButton() {
		leftNavButton.click();
		return new LeftNavigationPage(driver);
	}

	

}
