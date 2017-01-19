package rv.atqc.gttesting.archex;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoggedPlaceViewPage extends AbstractPlaceViewPage<LoggedPlaceViewPage> {

	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-detail/div/div/div[3]/div/comment/div/div[1]/div[2]/div[1]/textarea")
	private WebElement newComment;

	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-detail/div/div/div[3]/div/comment/div/div[1]/div[2]/div[2]/button")
	private WebElement postButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-detail/div/div/div[3]/div/comment/div/div[2]/div[2]/p[1]")
	private WebElement lastComment;

	public LoggedPlaceViewPage(WebDriver driver) {
		super(driver);
	}

	public LoggedPlaceViewPage setNewComment(CharSequence text) {
		waitForVisibilityOfElement(newComment).sendKeys(text);
		return this;
	}

	public LoggedPlaceViewPage scrollToNewComment() {
		scroll(newComment);
		return this;
	}

	public WebElement getNewComment() {
		return waitForVisibilityOfElement(newComment);
	}
	
	public WebElement getPostButton(){
		return waitForElementToBeClickable(postButton);
	}
	
	public LoggedPlaceViewPage clickPostButton(){
		waitForElementToBeClickable(postButton).click();
		return this;
	}
	
	public WebElement getLastComment(){
		timeout(5, TimeUnit.SECONDS);
		return waitForVisibilityOfElement(lastComment);
	}
}
