package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;

public class HeadForGuestUserPage extends AbstractHeadPage<HeadForLoggedUserPage> {

	public HeadForGuestUserPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public LogInPage clickLeftNavButton() {
		leftNavButton.click();
		return new LogInPage(driver);
	}

	@Override
	public RightNavigationForGuestPage clickRightNavButton() {
		rightNavButton.click();
		return new RightNavigationForGuestPage(driver);
	}

}
