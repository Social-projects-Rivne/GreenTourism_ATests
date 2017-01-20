package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import rv.atqc.gttesting.res.Resources;

public class LogInPage extends AbstractPage {

    @FindBy(css = "html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown.open ul.dropdown-menu.dropdown-auth.nav-ul auth.ng-isolate-scope div.ng-scope div.container.registration.ng-scope form.ng-dirty.ng-valid-parse.ng-valid-required.ng-valid-email.ng-valid.ng-valid-pattern input.btn.btn-success.btn-block.submit-btn")
    private WebElement loginButton;
    @FindBy(css = "html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown a.dropdown-toggle i.fa.fa-user.navtop")
    private WebElement leftTopGreenButton;
    @FindBy(xpath = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[1]/input")
    private WebElement emailField;
    @FindBy(xpath = "/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[2]/input")
    private WebElement passwordField;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage loging() {
        clickOnLeftTopGreenButton();
        insertEmail();
        insertPassword();
        clickOnLoginButton();
        return new ProfilePage(driver);
    }

    public LogInPage clickOnLeftTopGreenButton() {
        waitForVisibilityOfElement(leftTopGreenButton, 10);
        leftTopGreenButton.click();
        return this;
    }

    private LogInPage insertEmail() {
        waitForVisibilityOfElement(emailField, 10);
        emailField.sendKeys(Resources.LogInConstants.USER_EMAIL);
        return this;
    }

    private LogInPage insertPassword() {
        passwordField.sendKeys(Resources.LogInConstants.USER_PASSWORD);
        return this;
    }

    private LogInPage clickOnLoginButton() {
        loginButton.click();
        return this;
    }
}
