package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MapHeadPageForGuestUserPage extends AbstractMapHeadPage<MapHeadPageForGuestUserPage>{

	@FindBy(how = How.XPATH, using = "html/body/main/div/place-list/div/div/div[1]/div[2]/div/div[3]/button")
	public WebElement categories;

	public MapHeadPageForGuestUserPage(WebDriver driver) {
		super(driver);
	}

	public CategoriesPage clickCategories(){
		categories.click();
		return new CategoriesPage(driver);
	}
}
