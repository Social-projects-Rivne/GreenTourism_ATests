package rv.atqc.gttesting.archex;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import rv.atqc.gttesting.archex.helpers.Acting;

public abstract class AbstractPage<T extends AbstractPage<T>> {

	protected WebDriver driver;
	protected JavascriptExecutor jse;
	protected WebDriverWait wait;

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
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
	
	
	public WebElement waitForVisibilityOfElement(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
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
		wait.until(new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				return (Boolean)jse.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
			}	
		});
		executeScript("arguments[0].scrollIntoView()", we);
	}
	
}
