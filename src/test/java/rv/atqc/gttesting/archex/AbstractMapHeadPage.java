package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractMapHeadPage<T extends AbstractMapHeadPage<T>> extends AbstractPage<T> {

	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-list/div/div/div[1]/div[2]/div/div[3]/button")
	protected WebElement categories;
	@FindBy(how = How.XPATH, using = "//div[@id='navbar']//i[@class='fa fa-bars navtop']")
	protected WebElement mapType;	
	
	
	protected AbstractMapHeadPage(WebDriver driver) {
		super(driver);
	}
	
	public MapTypeMenuPage clickMapTypeMenu(){
		mapType.click();
		return new MapTypeMenuPage(driver);
	}
	
}
