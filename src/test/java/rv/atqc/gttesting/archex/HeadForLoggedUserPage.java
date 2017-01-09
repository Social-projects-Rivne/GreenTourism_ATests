package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;

public class HeadForLoggedUserPage extends AbstractHeadPage<HeadForLoggedUserPage> {

	public HeadForLoggedUserPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public LeftNavigationForLoggedUserPage clickLeftNavButton() {
		leftNavButton.click();
		return new LeftNavigationForLoggedUserPage(driver);
	}

	@Override
	public MapHeadForLoggedUserPage clickRightNavButton() {
		rightNavButton.click();
		return new MapHeadForLoggedUserPage(driver);
	}

}
