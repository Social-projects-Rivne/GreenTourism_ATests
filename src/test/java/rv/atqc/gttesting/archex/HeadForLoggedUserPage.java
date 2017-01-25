package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;

public class HeadForLoggedUserPage extends AbstractHeadPage<HeadForLoggedUserPage> {

	private int MAX_WAIT_TIME=10;
	
	public HeadForLoggedUserPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public LeftNavigationForLoggedUserPage clickLeftNavButton() {
		leftNavButton.click();
		return new LeftNavigationForLoggedUserPage(driver);
	}

	@Override
	public RightNavigationForLoggedUserPage clickRightNavButton() {
		waitForVisibilityOfElement(rightNavButton,MAX_WAIT_TIME);
		rightNavButton.click();
		return new RightNavigationForLoggedUserPage(driver);
	}

	
}
