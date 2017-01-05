package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public abstract class AbstractRightNavigation<T extends AbstractRightNavigation<T>> extends AbstractPage<T> {
	
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[2]/li/ul/li[1]/a")
	protected WebElement map;
	
	protected AbstractRightNavigation(WebDriver driver) {
		super(driver);
	}

	protected abstract AbstractPage<?> clickMap();
	
}
