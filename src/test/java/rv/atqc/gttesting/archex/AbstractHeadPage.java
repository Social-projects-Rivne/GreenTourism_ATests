package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public abstract class AbstractHeadPage<T extends AbstractHeadPage<T>> extends AbstractPage<T> {

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/a/i")
	protected WebElement leftNavButton;

	protected AbstractHeadPage(WebDriver driver) {
		super(driver);
	}

	protected abstract AbstractPage<?> clickLeftNavButton();

	public WebElement getLeftNavButton() {
		return leftNavButton;
	}
}
