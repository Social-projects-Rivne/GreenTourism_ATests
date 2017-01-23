package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends AbstractPage {

    @FindBy(css = "#main > div > user-profile > div > div > section.col-sm-3 > div.user-page__avatar > button > span:nth-child(1)")
    private WebElement chengeButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getChangeButtonText() {
        waitForVisibilityOfElement(chengeButton, 10);
        return chengeButton.getText();
    }

    public EditAvartarPage getEditAvatarPage () {
        waitForVisibilityOfElement(chengeButton, 10);
        chengeButton.click();
        return new EditAvartarPage(driver);
    }
}