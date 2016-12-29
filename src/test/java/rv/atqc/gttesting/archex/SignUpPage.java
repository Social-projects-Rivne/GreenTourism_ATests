package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends AbstractPage {

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[1]/input")
	public WebElement firstName;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[2]/input")
	public WebElement lastName;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[3]/input")
	public WebElement email;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[4]/input")
	public WebElement password;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[3]/div/form/div[5]/input")
	public WebElement passwordConfirm;
	
	public SignUpPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected void initPage() {
		PageFactory.initElements(driver, this);
	}

	public SignUpPage setFirstName(CharSequence text){
		firstName.sendKeys(text);
		return this;
	}
	
	public SignUpPage setLastName(CharSequence text){
		lastName.sendKeys(text);
		return this;
	}
	
	public SignUpPage setEmail(CharSequence text){
		email.sendKeys(text);
		return this;
	}
	
	public SignUpPage setPassword(CharSequence text){
		password.sendKeys(text);
		return this;
	}
	
	public SignUpPage setPasswordConfirm(CharSequence text){
		passwordConfirm.sendKeys(text);
		return this;
	}
}
