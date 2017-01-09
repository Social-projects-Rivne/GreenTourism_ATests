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

	protected AbstractMapHeadPage(WebDriver driver) {
		super(driver);
	}

	public CategoriesPage clickCategories(){
		categories.click();
		return new CategoriesPage(driver);
	}
	
}
