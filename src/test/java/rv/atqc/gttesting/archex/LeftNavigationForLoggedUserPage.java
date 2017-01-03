package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftNavigationForLoggedUserPage extends AbstractPage<LeftNavigationForLoggedUserPage>{

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/li[1]/a")
	private WebElement profile;
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/li[2]/a")
	private WebElement logOut;
	
	protected LeftNavigationForLoggedUserPage(WebDriver driver) {
		super(driver);
	}
	
	public HeadForGuestUserPage clickLogOut(){
		logOut.click();
		return new HeadForGuestUserPage(driver);
	}
	
	public ProfilePage clickProfile(){
		profile.click();
		return new ProfilePage(driver);
	}
}
