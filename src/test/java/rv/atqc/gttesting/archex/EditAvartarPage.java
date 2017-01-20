package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAvartarPage extends ProfilePage {

    @FindBy(xpath = "//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/button/span[1]")
    private WebElement chengeButton;

    @FindBy(css = "#main > div > user-profile > div > div > section.col-sm-3 > div.user-page__avatar > button > span:nth-child(2)")
    private WebElement cancelButton;


    public EditAvartarPage(WebDriver driver) {
        super(driver);
    }

    public String getChangeButtonText() {
        waitForVisibilityOfElement(chengeButton, 10);
        return chengeButton.getText();
    }

    public String getCancelButtonText() {
        waitForVisibilityOfElement(cancelButton, 10);
        return cancelButton.getText();
    }

}
