package rv.atqc.gttesting.archex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import rv.atqc.gttesting.archex.helpers.Acting;
import rv.atqc.gttesting.res.Resources;

public abstract class AbstractPage<T extends AbstractPage<T>> {

	protected WebDriver driver;
	protected JavascriptExecutor jse;
	protected int MAX_TIME_WAIT = Resources.GloblaConfig.MAX_TIME_WAIT;
	protected int MAX_TIMEOUT = Resources.GloblaConfig.MAX_TIMEOUT;
	protected int MIN_TIME_WAIT = Resources.GloblaConfig.MIN_TIME_WAIT;
	protected int MIN_TIMEOUT = Resources.GloblaConfig.MIN_TIMEOUT;

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

	public T executeScript(String script, Object... arr) {
		jse.executeScript(script, arr);
		return (T) this;
	}

	public T executeScript(String script) {
		jse.executeScript(script);
		return (T) this;
	}

	public T act(Acting acting) {
		acting.act(driver);
		return (T) this;
	}

	public T hoverElement(WebElement webElement) {
		Actions builder = new Actions(driver);
		builder.moveToElement(webElement).perform();
		return (T) this;
	}

	public T timeout(long time, TimeUnit timeUnit) {
		driver.manage().timeouts().implicitlyWait(time, timeUnit);
		return (T) this;
	}

	public T waitForVisibilityOfElement(WebElement webElement, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(webElement));
		return (T) this;
	}

	public T waitForInVisibilityOfElement(WebElement webElement, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOfAllElements(new ArrayList<WebElement>(Arrays.asList(webElement))));
		return (T) this;
	}

	public T waitForElementToBeClickable(WebElement webElement, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		return (T) this;
	}

	public T waitForVisibilityOfAll(ArrayList<WebElement> elements, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		return (T) this;
	}

	public T waitForInVisibilityOfAll(ArrayList<WebElement> elements, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
		return (T) this;
	}

	public T waitForPageLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, MAX_TIME_WAIT);
		wait.until(pageLoadCondition);
		return (T) this;
	}

	public void scroll(WebElement we, long timeOut) {
		new WebDriverWait(driver, timeOut).until(new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				return (Boolean) jse.executeScript(
						"return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
			}
		});
		executeScript("arguments[0].scrollIntoView(); scroll(0,52)", we);
	}

	public boolean isElementClickable(WebElement locator, long time) {
		try {
			WebElement clickableElement = new WebDriverWait(driver, time)
					.until(ExpectedConditions.elementToBeClickable(locator));
			return clickableElement != null;
		} catch (Exception exception) {
			return false;
		}
	}

	public void placeCursorOverElement(WebElement element) {
		String javaScript = "var evObj = document.createEvent('MouseEvents');" + "evObj.initMouseEvent(\"mouseover\","
				+ "true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evObj);";
		jse.executeScript(javaScript, element);
	}
	
	public T refresh(){
		driver.navigate().refresh();
		return (T) this;
	}

}