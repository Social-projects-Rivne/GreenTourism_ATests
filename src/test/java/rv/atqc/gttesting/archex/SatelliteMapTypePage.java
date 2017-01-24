package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SatelliteMapTypePage extends AbstractPage<SatelliteMapTypePage>{
	@FindBy(how = How.XPATH, using = "//img[contains(@src,'server.arcgisonline.com')][1]")
	protected WebElement mapImageSatellite;
	
	protected SatelliteMapTypePage(WebDriver driver){
		super(driver);
	} 
	
	public WebElement getMapImageSatellite(){
		waitForVisibilityOfElement(mapImageSatellite,10);
		return mapImageSatellite;		
	}
}
