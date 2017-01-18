package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends LeftNavigationForGuestUserPage<LogInPage> {

    private final String mail = "17141@rambler.ru";
    private final String ps = "12345678";

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

    public EditAvartarPage loging() {
        clickOnLeftTopGreenButton();
        insertEmail();
        insertPassword();
        clickOnLoginButton();
        return new EditAvartarPage(driver);
    }

    public LogInPage clickOnLeftTopGreenButton() {
        waitToVisibilityOfElement(leftTopGreenButton);
        leftTopGreenButton.click();
        return this;
    }

    private LogInPage insertEmail() {
        waitToVisibilityOfElement(emailField);
        emailField.sendKeys(mail);
        return this;
    }

    private LogInPage insertPassword() {
        passwordField.sendKeys(ps);
        return this;
    }

    private LogInPage clickOnLoginButton() {
        loginButton.click();
        return this;
    }
}
