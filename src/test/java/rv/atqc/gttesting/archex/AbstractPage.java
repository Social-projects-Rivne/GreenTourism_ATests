package rv.atqc.gttesting.archex;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

	protected WebDriver driver;
	protected JavascriptExecutor jse;
	

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
		this.jse = (JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
	}
	
	protected String getCurrentUrl(){
		return driver.getCurrentUrl();
	}
	
	public AbstractPage enableFocus(){
		jse.executeScript("document.activeElement.blur();");
		return this;
	}
	
	public AbstractPage executeScript(String script){
		jse.executeScript(script);
		return this;
	}

	protected <T extends AbstractPage> T getNewPage(Class<T> type) {
		return PageFactory.initElements(driver, type);
	}
	

}