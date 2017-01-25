package rv.atqc.gttesting.archex;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends AbstractPage<ProfilePage> {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	public HeadForLoggedUserPage getHeadForLoggedUserPage() {
		return new HeadForLoggedUserPage(driver);
	}
}
