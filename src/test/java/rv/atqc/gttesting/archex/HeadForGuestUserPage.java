package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;

public class HeadForGuestUserPage extends AbstractHeadPage<HeadForLoggedUserPage> {

	public HeadForGuestUserPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public LeftNavigationForGuestUserPage clickLeftNavButton() {
		getLeftNavButton().click();
		return new LeftNavigationForGuestUserPage(driver);
	}

}
