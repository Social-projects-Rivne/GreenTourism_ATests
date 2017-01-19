package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MapTypeMenuPage extends AbstractPage<MapTypeMenuPage>{
	
	@FindBy(how = How.XPATH, using = "//div[@class='col-lg-5 col-md-5 hidden-sm"
						+ " hidden-xs map-menu-buttons-wrapper']//a[@id='streets']")
	protected WebElement streets;
	@FindBy(how = How.XPATH, using = "//div[@class='col-lg-5 col-md-5 hidden-sm"
						+ " hidden-xs map-menu-buttons-wrapper']//a[@id='outdoors']")
	protected WebElement outdoors;
	@FindBy(how = How.XPATH, using = "//div[@class='col-lg-5 col-md-5 hidden-sm"
						+ " hidden-xs map-menu-buttons-wrapper']//a[@id='satellite']")
	protected WebElement satellite;
	
	protected MapTypeMenuPage(WebDriver driver){
		super(driver);
	}
	
	public StreetsMapTypePage clickStreetsItem(){
		streets.click();
		return(new StreetsMapTypePage(driver));
	}
	
	public OutdoorsMapTypePage clickOutdoorsItem(){
		outdoors.click();
		return(new OutdoorsMapTypePage(driver));
	}

	public SatelliteMapTypePage clickSatelliteItem(){
		satellite.click();
		return(new SatelliteMapTypePage(driver));
	}
	
	public WebElement getStreetsElement(){
		waitForVisibilityOfElement(streets,10);
		waitForElementToBeClickable(streets,10);
		return streets;
	}
	
	public WebElement getOutdoorsElement(){
		waitForVisibilityOfElement(outdoors,10);
		waitForElementToBeClickable(outdoors,10);
		return outdoors;
	}
	
	public WebElement getSatelliteElement(){
		waitForVisibilityOfElement(satellite,10);
		waitForElementToBeClickable(satellite,10);
		return satellite;
	}
}
