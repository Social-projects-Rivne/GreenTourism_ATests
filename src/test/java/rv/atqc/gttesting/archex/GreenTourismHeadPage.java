package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GreenTourismHeadPage extends AbstractPage implements GreenTourismHeadScript {

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/a/i")
	public WebElement leftNavButton;
	
	public GreenTourismHeadPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void clickLeftNavButton() {
		leftNavButton.click();
	}

}
