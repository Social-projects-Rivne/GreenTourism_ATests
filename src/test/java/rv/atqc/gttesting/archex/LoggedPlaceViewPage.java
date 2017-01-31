package rv.atqc.gttesting.archex;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoggedPlaceViewPage extends AbstractPlaceViewPage<LoggedPlaceViewPage> {

	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-detail/div/div/div[3]/div/comment/div/div[1]/div[2]/div[1]/textarea")
	private WebElement newComment;

	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-detail/div/div/div[3]/div/comment/div/div[1]/div[2]/div[2]/button")
	private WebElement postButton;

	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-detail/div/div/div[3]/div/comment/div/div[2]/div[2]/p[1]")
	private WebElement lastComment;
	
	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Maks Kovalets')]/following-sibling::a[@title='Edit']")
	private WebElement editButton;
	
	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Maks Kovalets')]/following-sibling::div/textarea")
	private WebElement editTextarea;
	
	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Maks Kovalets')]/following-sibling::div/div/button[contains(text(),'Close')]")
	private WebElement closeButton;
	
	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Maks Kovalets')]/following-sibling::div/div/button[contains(text(),'Update')]")
	private WebElement updateButton;
	
	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Maks Kovalets')]/following-sibling::p[@class='ng-binding ng-scope']")
	private WebElement comment;
	
	public LoggedPlaceViewPage(WebDriver driver) {
		super(driver);
	}

	public LoggedPlaceViewPage setNewComment(CharSequence text) {
		waitForVisibilityOfElement(newComment, MAX_TIME_WAIT);
		newComment.sendKeys(text);
		return this;
	}

	public LoggedPlaceViewPage scrollToNewComment() {
		scroll(newComment, MAX_TIME_WAIT);
		return this;
	}

	public WebElement getNewComment() {
		waitForVisibilityOfElement(newComment, MAX_TIME_WAIT);
		return newComment;
	}

	public WebElement getPostButton() {
		waitForElementToBeClickable(postButton, MAX_TIME_WAIT);
		return postButton;
	}

	public LoggedPlaceViewPage clickPostButton() {
		waitForElementToBeClickable(postButton, MAX_TIME_WAIT);
		postButton.click();
		return this;
	}

	public WebElement getLastComment() {
		timeout(MAX_TIMEOUT, TimeUnit.SECONDS);
		return lastComment;
	}
	
	public WebElement getEditButton(){
		waitForVisibilityOfElement(editButton,MAX_TIME_WAIT);
		waitForElementToBeClickable(editButton,MAX_TIME_WAIT);
		return editButton;
	}
	
	public WebElement getTextarea(){
		waitForVisibilityOfElement(editTextarea,MAX_TIME_WAIT);
		return editTextarea;
	}
	
	public LoggedPlaceViewPage clickEditButton(){
		waitForElementToBeClickable(editButton,MAX_TIME_WAIT);
		editButton.click();
		return this;
	}
	
	public WebElement getCloseButton(){
		waitForVisibilityOfElement(closeButton,MAX_TIME_WAIT);
		waitForElementToBeClickable(closeButton,MAX_TIME_WAIT);
		return closeButton;
	}
	
	public LoggedPlaceViewPage clickCloseButton(){
		waitForElementToBeClickable(closeButton,MAX_TIME_WAIT);
		closeButton.click();
		return this;
	}
	
	public WebElement getUpdateButton(){
		waitForVisibilityOfElement(updateButton,MAX_TIME_WAIT);
		waitForElementToBeClickable(updateButton,MAX_TIME_WAIT);
		return updateButton;
	}
	
	public LoggedPlaceViewPage setNewTextToEditedComment(CharSequence newText){
		waitForElementToBeClickable(editButton,MAX_TIME_WAIT);
		editButton.click();
		waitForVisibilityOfElement(editTextarea,MAX_TIME_WAIT);
		editTextarea.clear();
		editTextarea.sendKeys(newText);
		waitForElementToBeClickable(updateButton,MAX_TIME_WAIT);
		updateButton.click();
		return this;
	}

	public WebElement getComment(){
		waitForVisibilityOfElement(comment,MAX_TIME_WAIT);
		return comment;
	}
	
	public LoggedPlaceViewPage notSetNewTextToEditedComment(CharSequence newText){
		waitForElementToBeClickable(editButton,MAX_TIME_WAIT);
		editButton.click();
		waitForVisibilityOfElement(editTextarea,MAX_TIME_WAIT);
		editTextarea.clear();
		editTextarea.sendKeys(newText);
		waitForElementToBeClickable(closeButton,MAX_TIME_WAIT);
		closeButton.click();
		return this;
	}
	
	public WebElement getDisabledUpdateButton(){
		return updateButton;
	}
}
