package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;

public class RightNavigationForGuestPage extends AbstractRightNavigation<RightNavigationForGuestPage> {

	
	
	protected RightNavigationForGuestPage(WebDriver driver) {
		super(driver);
	}
	
	public MapHeadPageForGuestUserPage clickMap(){
		map.click();
		return new MapHeadPageForGuestUserPage(driver);
	}

}
