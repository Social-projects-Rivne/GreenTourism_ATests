package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CategoriesPage extends AbstractPage<CategoriesPage>{

	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[2]/a")
	protected WebElement tracks;
	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]/a")
	protected WebElement events;
	
	protected CategoriesPage(WebDriver driver) {
		super(driver);
	}
	
	public TracksPage clickTracks(){
		tracks.click();
		return new TracksPage(driver);
	}
	public EventsPage clickEvents(){
		events.click();
		return new EventsPage(driver);
	}
}
