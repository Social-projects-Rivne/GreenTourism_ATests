package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;

public class RightNavigationForLoggedUserPage extends AbstractRightNavigation<RightNavigationForLoggedUserPage> {

	private int MAX_WAIT_TIME=10;
	
	protected RightNavigationForLoggedUserPage(WebDriver driver) {
		super(driver);
	}
	
	public MapHeadForLoggedUserPage clickMap(){
		waitForVisibilityOfElement(map,MAX_WAIT_TIME);
		map.click();
		return new MapHeadForLoggedUserPage(driver);
	}

}