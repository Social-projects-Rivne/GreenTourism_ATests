package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

	protected WebDriver driver;

	

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
		initPage();
	}

	protected <T extends AbstractPage> T getNewPage(Class<T> type) {
		return PageFactory.initElements(driver, type);
	}
	

	
	protected abstract void initPage();

}