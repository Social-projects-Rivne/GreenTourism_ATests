package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

	protected WebDriver driver;

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	protected AbstractPage getNewPage() {
		return PageFactory.initElements(driver, getClass());
	}

	protected AbstractPage getPage(){
		return PageFactory.initElements(driver, getClass());
	}
}