package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage implements Scripts{

	protected WebDriver driver;
	protected AbstractPage page;

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	protected <T extends AbstractPage> T getNewPage(Class<T> type){
		return PageFactory.initElements(driver, type);
	}

	protected <T extends AbstractPage> T getPage(Class<T> type){
		page = (page == null) ? PageFactory.initElements(driver, type) : page;
		return type.cast(page);
	}
	
	
}