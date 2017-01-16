package rv.atqc.gttesting.archex;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import rv.atqc.gttesting.archex.helpers.Acting;

public abstract class AbstractPage<T extends AbstractPage<T>> {

	protected WebDriver driver;
	protected JavascriptExecutor jse;

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
		this.jse = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public T disableFocus() {
		return executeScript("document.activeElement.blur();");
	}

	public T executeScript(String script) {
		jse.executeScript(script);
		return (T) this;
	}
	
	public T executeScript(String script, Object...arr) {
		jse.executeScript(script, arr);
		return (T) this;
	}
	
	public T act(Acting acting){
		acting.act(driver);
		return (T) this;
	}
	
	public T timeout(long time, TimeUnit timeUnit){
		driver.manage().timeouts().implicitlyWait(time, timeUnit);
		return (T) this;
	}
	
	public void scroll(WebElement we){
		executeScript("arguments[0].scrollIntoView()", we);
	}
	
}
