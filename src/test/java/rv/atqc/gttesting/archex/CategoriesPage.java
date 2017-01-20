package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public abstract class CategoriesPage<T> extends AbstractPage<CategoriesPage<T>>{
	
	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-list/div/div/div[1]/div[2]/div/div[3]/button")
	protected WebElement categories;
	
	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[2]/a")
	protected WebElement tracks;
	
	@FindBy(how = How.XPATH, using = "//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]")
	protected WebElement placesButton;
	
	public CategoriesPage(WebDriver driver) {
		super(driver);
	}
	
	public CategoriesPage<T> clickCategories(){
		categories.click();
		return this;
	}
	
	public TracksPage clickTracks(){
		tracks.click();
		return new TracksPage(driver);
	}
	
	public PlacesPage clickPlaces(){
		placesButton.click();
		return new PlacesPage(driver);
	}
	
}
