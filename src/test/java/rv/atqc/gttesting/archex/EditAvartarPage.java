package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAvartarPage extends ProfilePage {

    private final int MAX_WAIT_TIME = 10;

    @FindBy(xpath = "//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/form/input")
    private WebElement confirmButton;
    @FindBy(css = "#main > div > user-profile > div > div > section.col-sm-3 > div.user-page__avatar > button > span:nth-child(2)")
    private WebElement cancelButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/button/span[1]")
    private WebElement chengeButton;


    public EditAvartarPage(WebDriver driver) {
        super(driver);
    }

    public String getChangeButtonText() {
        waitForVisibilityOfElement(chengeButton, MAX_WAIT_TIME);
        return chengeButton.getText();
    }

    public String getCancelButtonText() {
        waitForVisibilityOfElement(cancelButton, MAX_WAIT_TIME);
        return cancelButton.getText();
    }

    public WebElement getConfirmButton() {
        waitForVisibilityOfElement(confirmButton, MAX_WAIT_TIME);
        return confirmButton;
    }

}
