package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage extends AbstractPage<ProfilePage> {
	
	
	@FindBy(how = How.XPATH, using="/html/body/main/div/user-profile/div/div/section[2]/div[1]/h1/button[1]")
	private WebElement edit;
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	public EditProfilePage clickEdit(){
		waitForVisibilityOfElement(edit, MAX_TIME_WAIT);
		edit.click();
		return new EditProfilePage(driver);
	}
	
	public WebElement getEditButton(){
		waitForVisibilityOfElement(edit, MAX_TIME_WAIT);
		return edit;
	}
	
	public HeadForLoggedUserPage getHeadForLoggedUserPage(){
		return new HeadForLoggedUserPage(driver);
	}
	
	public boolean isEditClicable(){
		return isElementClickable(edit, MIN_TIME_WAIT);
	}
}
