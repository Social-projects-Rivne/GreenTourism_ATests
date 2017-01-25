package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import rv.atqc.gttesting.res.Resources;

public class ProfilePage extends AbstractPage <ProfilePage> {

    @FindBy(css = "#main > div > user-profile > div > div > section.col-sm-3 > div.user-page__avatar > button > span:nth-child(1)")
    private WebElement chengeButton;


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getChangeButtonText() {
        waitForVisibilityOfElement(chengeButton, Integer.valueOf(Resources.LogInConstants.MAX_WAIT_TIME));
        return chengeButton.getText();
    }

    public EditAvartarPage getEditAvatarPage () {
        waitForVisibilityOfElement(chengeButton, Integer.valueOf(Resources.LogInConstants.MAX_WAIT_TIME));
        chengeButton.click();
        return new EditAvartarPage(driver);
    }

	public HeadForLoggedUserPage getHeadForLoggedUserPage() {
		return new HeadForLoggedUserPage(driver);
	}
}

