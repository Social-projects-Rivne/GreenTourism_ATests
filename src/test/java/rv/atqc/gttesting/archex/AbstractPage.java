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
	
	public T act(Acting acting){
		acting.act(driver);
		return (T) this;
	}
	
	public T hoverElement(WebElement webElement){
		Actions builder = new Actions(driver);
		builder.moveToElement(webElement).perform();
		return (T) this;
	}
	
    public T waitForVisibilityOfElement(WebElement webElement, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return (T) this;
    }
    
    public T waitForElementToBeClickable(WebElement webElement, int timeout)  {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return (T) this;
    }
    
    public T waitForInVisibilityOfElement(WebElement webElement, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.invisibilityOfAllElements(new ArrayList<WebElement>(Arrays.asList(webElement))));
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
	
}   