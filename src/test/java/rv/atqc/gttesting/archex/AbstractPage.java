package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage implements Scripts {

	protected WebDriver driver;
	// protected AbstractPage page;

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected <T extends AbstractPage> T getNewPage(Class<T> type) {
		return PageFactory.initElements(driver, type);
	}

}