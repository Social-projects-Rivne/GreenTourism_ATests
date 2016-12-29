package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

	protected WebDriver driver;
	protected AbstractPage page;

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	protected AbstractPage getNewPage() {
		return PageFactory.initElements(driver, getClass());
	}

	protected <T extends AbstractPage> T getPage(Class<T> type){
		page = (page == null) ? PageFactory.initElements(driver, type) : page;
		return type.cast(page);
	}
	
	public abstract AbstractPage initPage();
}