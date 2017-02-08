package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ru.yandex.qatools.allure.annotations.Step;

public class LoggedPlaceViewPage extends AbstractPlaceViewPage<LoggedPlaceViewPage> {

	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-detail/div/div/div[3]/div/comment/div/div[1]/div[2]/div[1]/textarea")
	private WebElement newComment;

	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-detail/div/div/div[3]/div/comment/div/div[1]/div[2]/div[2]/button")
	private WebElement postButton;

	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-detail/div/div/div[3]/div/comment/div/div[2]/div[2]/p[1]")
	private WebElement lastComment;

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Maks Kovalets')]/following-sibling::a[@title='Edit']/i")
	private WebElement editButton;

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Maks Kovalets')]/following-sibling::div/textarea")
	private WebElement editTextarea;

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Maks Kovalets')]/following-sibling::div/div/button[contains(text(),'Close')]")
	private WebElement closeButton;

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Maks Kovalets')]/following-sibling::div/div/button[contains(text(),'Update')]")
	private WebElement updateButton;

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Maks Kovalets')]/following-sibling::p[@class='ng-binding ng-scope']")
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
	
	public LoggedPlaceViewPage scrollToLastComment() {
		scroll(lastComment, MAX_TIME_WAIT);
		return this;
	}

	public WebElement getNewComment() {
		waitForVisibilityOfElement(newComment, MAX_TIME_WAIT);
		return newComment;
	}

	public WebElement getPostButton() {
		waitForVisibilityOfElement(postButton, MAX_TIME_WAIT);
		return postButton;
	}

	public LoggedPlaceViewPage clickPostButton() {
		waitForElementToBeClickable(postButton, MAX_TIME_WAIT);
		postButton.click();
		return this;
	}

	public WebElement getLastComment() {
		return lastComment;
	}

	public WebElement getEditButton() {
		waitForElementToBeClickable(editButton, MAX_TIME_WAIT);
		return editButton;
	}

	
	public WebElement getTextarea(){
		waitForVisibilityOfElement(editTextarea,MAX_TIME_WAIT);
		return editTextarea;
	}

	@Step("Edit button was clicked")
	public LoggedPlaceViewPage clickEditButton() {
		waitForElementToBeClickable(editButton, MAX_TIME_WAIT);
		editButton.click();
		return this;
	}

	
	public WebElement getCloseButton(){
		waitForElementToBeClickable(closeButton,MAX_TIME_WAIT);
		return closeButton;
	}

	@Step("Close button was clicked")
	public LoggedPlaceViewPage clickCloseButton() {
		waitForElementToBeClickable(closeButton, MAX_TIME_WAIT);
		closeButton.click();
		return this;
	}


	public WebElement getUpdateButton(){
		waitForElementToBeClickable(updateButton,MAX_TIME_WAIT);
		return updateButton;
	}

	@Step("New text: ( {0} ) was set in a changed comment")
	public LoggedPlaceViewPage setNewTextToEditedComment(CharSequence newText) {
		waitForElementToBeClickable(editButton, MAX_TIME_WAIT);
		editButton.click();
		waitForVisibilityOfElement(editTextarea, MAX_TIME_WAIT);
		editTextarea.clear();
		editTextarea.sendKeys(newText);
		waitForElementToBeClickable(updateButton, MAX_TIME_WAIT);
		updateButton.click();
		return this;
	}

	public WebElement getComment() {
		waitForVisibilityOfElement(comment, MAX_TIME_WAIT);
		return comment;
	}

	@Step("New text ( {0} ) was not set in a changed comment")
	public LoggedPlaceViewPage notSetNewTextToEditedComment(CharSequence newText) {
		waitForElementToBeClickable(editButton, MAX_TIME_WAIT);
		editButton.click();
		waitForVisibilityOfElement(editTextarea, MAX_TIME_WAIT);
		editTextarea.clear();
		editTextarea.sendKeys(newText);
		waitForElementToBeClickable(closeButton, MAX_TIME_WAIT);
		closeButton.click();
		return this;
	}

	public WebElement getDisabledUpdateButton() {
		return updateButton;
	}
}
