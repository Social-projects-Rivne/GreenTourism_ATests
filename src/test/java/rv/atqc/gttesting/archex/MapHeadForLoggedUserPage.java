package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MapHeadForLoggedUserPage extends AbstractMapHeadPage<MapHeadPageForGuestUserPage> {

	@FindBy(how = How.XPATH, using = "//button[@type='button'"
			                       + " and contains" + "(., 'Map Type')]")
	protected WebElement mapTypeButton;

	protected MapHeadForLoggedUserPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getElementMapTypeButton(){
		waitForVisibilityOfElement(mapTypeButton,10);
		waitForElementToBeClickable(mapTypeButton,10);
		return mapTypeButton;
	}
	
	public MapTypeMenuPage clickMapTypeButton(){
		waitForElementToBeClickable(mapTypeButton,10);
		mapTypeButton.click();
		return new MapTypeMenuPage(driver);
	}

}