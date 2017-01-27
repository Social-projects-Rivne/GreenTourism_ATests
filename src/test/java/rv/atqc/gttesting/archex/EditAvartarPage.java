package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import rv.atqc.gttesting.res.Resources;

public class EditAvartarPage extends ProfilePage {

    private final int MAX_WAIT_TIME = 10;
    @FindBy(xpath = "//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/form/input")
    private WebElement confirmButton;
    @FindBy(css = "#main > div > user-profile > div > div > section.col-sm-3 > div.user-page__avatar > button > span:nth-child(2)")
    private WebElement cancelButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/button/span[1]")
    private WebElement chengeButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/form/div/input")
    private WebElement avatarUrlField;
    @FindBy(xpath = "//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/img")
    private WebElement defAvatar;
    @FindBy(xpath = "//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/form/div/input")
    private WebElement urlField;
    @FindBy(xpath = "//img[@src='http://img1.jurko.net/avatar_17294.jpg']")
    private WebElement gpgUrl;
    @FindBy(xpath = "//img[@src='https://avatars0.githubusercontent.com/u/17428479?v=3&s=460']")
    private WebElement gpegUrl;
    @FindBy(xpath = "//img[@src='http://pngimg.com/upload/small/arctic_fox_PNG18479.png']")
    private WebElement pngUrl;
    @FindBy(xpath = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/li[2]/a")
    private WebElement logOutButton;
    @FindBy(css = "html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown a.dropdown-toggle i.fa.fa-user.navtop")
    private WebElement leftTopGreenButton;
    @FindBy(xpath = "/html/body/main/div/welcome-page/div[1]/a")
    private WebElement mainPage;

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

    public WebElement getAvatarUrlField() {
        waitForVisibilityOfElement(avatarUrlField, MAX_WAIT_TIME);
        return avatarUrlField;
    }

    public WebElement getDefAvatarImage() {
        waitForElementToBeClickable(confirmButton, MAX_WAIT_TIME);
        confirmButton.click();
        waitForElementToBeClickable(chengeButton, MAX_WAIT_TIME);
        waitForVisibilityOfElement(defAvatar, MAX_WAIT_TIME);
        return defAvatar;
    }

    public void insertURL(String url) {
        waitForVisibilityOfElement(urlField, MAX_WAIT_TIME);
        urlField.sendKeys(url);
        waitForElementToBeClickable(confirmButton, MAX_WAIT_TIME);
        confirmButton.click();

    }

    public WebElement getJPGAvatar() {
        waitForVisibilityOfElement(gpgUrl, MAX_WAIT_TIME);
        return gpgUrl;
    }

    public WebElement getJPEGAvatar() {
        waitForVisibilityOfElement(gpegUrl, MAX_WAIT_TIME);
        return gpegUrl;
    }

    public WebElement getPNGAvatar() {
        waitForVisibilityOfElement(pngUrl, MAX_WAIT_TIME);
        return pngUrl;
    }

    public void clickOnLogOutButton() {
        waitForElementToBeClickable(leftTopGreenButton, MAX_WAIT_TIME);
        leftTopGreenButton.click();
        waitForVisibilityOfElement(logOutButton, MAX_WAIT_TIME);
        logOutButton.click();
    }
}
