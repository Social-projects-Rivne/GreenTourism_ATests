package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;

public class RightNavigationForLoggedUserPage extends AbstractRightNavigation<RightNavigationForGuestPage> {

	
	
	protected RightNavigationForLoggedUserPage(WebDriver driver) {
		super(driver);
	}
	
	public MapHeadForLoggedUserPage clickMap(){
		map.click();
		return new MapHeadForLoggedUserPage(driver);
	}

}