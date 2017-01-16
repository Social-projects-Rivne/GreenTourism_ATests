package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoggedPlaceViewPage extends AbstractPlaceViewPage<LoggedPlaceViewPage>{

	
	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-detail/div/div/div[3]/div/comment/div/div[1]/div[2]/div[1]/textarea")
	public WebElement newComment;
	
	@FindBy(how = How.XPATH, using = "/html/body/main/div/place-detail/div/div/div[3]/div/comment/div/div[1]/div[2]/div[2]/button")
	public WebElement postButton;
	
	
	public LoggedPlaceViewPage(WebDriver driver) {
		super(driver);
	}
	
	public LoggedPlaceViewPage setNewComment(CharSequence text){
		newComment.sendKeys(text);
		return this;
	}
	
	public LoggedPlaceViewPage scrollToNewComment(){
//		executeScript("document.evaluate('/html/body/main/div/place-detail/div/div/div[3]/div/comment/div/div[1]/div[2]/div[1]/textarea', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.scrollIntoView();");
		scroll(newComment);
		return this;
	}

}
