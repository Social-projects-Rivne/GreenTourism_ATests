package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditProfilePage extends AbstractPage<EditProfilePage>{
	
	@FindBy(how = How.XPATH, using="/html/body/main/div/user-profile/div/div/section[2]/div[1]/div[2]/form/div[1]/div[1]/div/input")
	private WebElement firstNameInput;
	@FindBy(how = How.XPATH, using="/html/body/main/div/user-profile/div/div/section[2]/div[1]/div[2]/form/div[1]/div[2]/div/input")
	private WebElement lastNameInput;
	@FindBy(how = How.XPATH, using="/html/body/main/div/user-profile/div/div/section[2]/div[1]/div[2]/form/div[2]/input")
	private WebElement nick;
	@FindBy(how = How.XPATH, using="/html/body/main/div/user-profile/div/div/section[2]/div[1]/div[2]/form/div[3]/input")
	private WebElement phone;
	@FindBy(how = How.XPATH, using="/html/body/main/div/user-profile/div/div/section[2]/div[1]/div[2]/form/div[4]/input")
	private WebElement address;
	@FindBy(how = How.XPATH, using="/html/body/main/div/user-profile/div/div/section[2]/div[1]/div[2]/form/button")
	private WebElement cancel;
	@FindBy(how = How.XPATH, using="/html/body/main/div/user-profile/div/div/section[2]/div[1]/div[2]/form/input")
	private WebElement change;
	@FindBy(how = How.XPATH, using="/html/body/main/div/user-profile/div/div/section[2]/div[1]/div[2]/form")
	private WebElement editForm;
	
	protected EditProfilePage(WebDriver driver) {
		super(driver);
	}
	
	public EditProfilePage setFirstName(CharSequence arg){
		waitForVisibilityOfElement(firstNameInput, MAX_TIME_WAIT);
		firstNameInput.sendKeys(arg);
		return this;
	}
	
	public EditProfilePage setLastName(CharSequence arg){
		waitForVisibilityOfElement(lastNameInput, MAX_TIME_WAIT);
		lastNameInput.sendKeys(arg);
		return this;
	}
	
	public EditProfilePage clearPhone(){
		waitForVisibilityOfElement(phone, MAX_TIME_WAIT);
		phone.clear();
		return this;
	}
	
	public EditProfilePage setPhone(CharSequence arg){
		waitForVisibilityOfElement(phone, MAX_TIME_WAIT);
		phone.sendKeys(arg);
		return this;
	}
	
	public EditProfilePage clearAddress(){
		waitForVisibilityOfElement(address, MAX_TIME_WAIT);
		address.clear();
		return this;
	}
	
	public EditProfilePage setAddress(CharSequence arg){
		waitForVisibilityOfElement(address, MAX_TIME_WAIT);
		address.sendKeys(arg);
		return this;
	}
	
	public EditProfilePage clearFirstName(){
		waitForVisibilityOfElement(firstNameInput, MAX_TIME_WAIT);
		firstNameInput.clear();
		return this;
	}
	
	public EditProfilePage setNick(CharSequence arg){
		waitForVisibilityOfElement(nick, MAX_TIME_WAIT);
		nick.sendKeys(arg);
		return this;
	}
	
	
	public EditProfilePage clearNick(){
		waitForVisibilityOfElement(nick, MAX_TIME_WAIT);
		nick.clear();
		return this;
	}
	
	public EditProfilePage clearLastName(){
		waitForVisibilityOfElement(lastNameInput, MAX_TIME_WAIT);
		lastNameInput.clear();
		return this;
	}
	
	public WebElement getFirstName(){
		waitForVisibilityOfElement(firstNameInput, MAX_TIME_WAIT);
		return firstNameInput;
	}
	
	public WebElement getNick(){
		waitForVisibilityOfElement(nick, MAX_TIME_WAIT);
		return nick;
	}
	
	public WebElement getAddress(){
		waitForVisibilityOfElement(address, MAX_TIME_WAIT);
		return address;
	}
	public WebElement getPhone(){
		waitForVisibilityOfElement(phone, MAX_TIME_WAIT);
		return phone;
	}
	
	public WebElement getLastName(){
		waitForVisibilityOfElement(lastNameInput, MAX_TIME_WAIT);
		return lastNameInput;
	}
	
	public WebElement getEditForm(){
		waitForVisibilityOfElement(editForm, MAX_TIME_WAIT);
		return editForm;
	}
	
	public WebElement getChange(){
		waitForElementToBeClickable(change, MAX_TIME_WAIT);
		return change;
	}
	
	public WebElement getCancel(){
		waitForElementToBeClickable(cancel, MAX_TIME_WAIT);
		return cancel;
	}
	
	public boolean isChangeClickable(){
		return isElementClickable(change, MIN_TIME_WAIT);
	}
	public boolean isCancelClickable(){
		return isElementClickable(cancel, MIN_TIME_WAIT);
	}

}
