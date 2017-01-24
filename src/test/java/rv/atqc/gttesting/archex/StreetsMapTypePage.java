package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StreetsMapTypePage extends AbstractPage<StreetsMapTypePage>{
	@FindBy(how = How.XPATH, using = "//img[contains(@src,'tile.osm.org')][1]")
	protected WebElement mapImageStreets;
	
	protected StreetsMapTypePage(WebDriver driver){
		super(driver);
	}
	
	public WebElement getMapImageStreets(){
		waitForVisibilityOfElement(mapImageStreets,10);
		return mapImageStreets;		
	}

}
