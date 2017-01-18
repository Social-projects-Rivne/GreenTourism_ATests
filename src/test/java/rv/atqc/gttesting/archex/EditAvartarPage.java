package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAvartarPage extends LogInPage  {

    @FindBy(css = "#main > div > user-profile > div > div > section.col-sm-3 > div.user-page__avatar > button > span:nth-child(1)")
    private WebElement chengeButton;

    public EditAvartarPage(WebDriver driver) {
        super(driver);
    }

    public   String getChangeButtonText() {
        waitToVisibilityOfElement(chengeButton);
        return chengeButton.getText();
    }
}
