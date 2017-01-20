package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OutdoorsMapTypePage extends AbstractPage<OutdoorsMapTypePage> {
	@FindBy(how = How.XPATH, using = "//img[contains(@src,'tile.thunderforest.com')][1]")
	protected WebElement mapImageOutdoors;
	
	protected OutdoorsMapTypePage(WebDriver driver){
		super(driver);
	}

	public WebElement getMapImageOutdoors(){
		waitForVisibilityOfElement(mapImageOutdoors,10);
		return mapImageOutdoors;		
	}
}
