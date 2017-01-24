package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;

public class AbstractPlaceViewPage<T extends AbstractPlaceViewPage<T>> extends AbstractPage<T> {

	protected AbstractPlaceViewPage(WebDriver driver) {
		super(driver);
	}
	
}
