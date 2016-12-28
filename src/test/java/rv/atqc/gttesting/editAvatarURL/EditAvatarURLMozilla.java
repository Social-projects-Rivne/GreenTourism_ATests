package rv.atqc.gttesting.editAvatarURL;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditAvatarURLMozilla {
    private WebDriver driver;
    WebDriverWait wait;
    private String USER_LOGIN = "17141@rambler.ru";
    private String USER_PASSWORD = "12345678";
    private final int MAX_WAIT_TIME = 5;

    @BeforeMethod
    public void before() {
        FirefoxDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        driver.get("https://green-tourism.herokuapp.com/#!/");
        wait = new WebDriverWait(driver, MAX_WAIT_TIME);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void checkChangeButtonTitleInChrome() {
        clickOnLeftTopGreenButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        Assert.assertEquals(getChangeButtonText(), "Change");
    }

    @Test
    public void checkCancelButtonInEditAvSystChrome() {
        clickOnLeftTopGreenButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        clickOnChangeButton();
        Assert.assertEquals(getCancelButtonText(), "Cancel");
    }

    @Test
    public void checkConfirmButtonInEditAvSystMozilla() {
        clickOnLeftTopGreenButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        clickOnChangeButton();
        Assert.assertTrue(getConfirmButton().isDisplayed());
    }

    @Test
    public void checkPresentFieldAvatarURLInEditAvSystMozilla() {
        clickOnLeftTopGreenButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        clickOnChangeButton();
        Assert.assertTrue(getAvaURLField().isDisplayed());
    }

    @Test
    public void checkPresentDefaultAvatarInEditAvSystMozilla() {
        clickOnLeftTopGreenButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        clickOnChangeButton();
        clickOnConfirmButton();
        Assert.assertTrue(getDefAvatar().isDisplayed());
    }

    private void clickOnChangeButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/button/span[1]"))).click();
    }

    private void clickOnLeftTopGreenButton() {
        driver.findElement(By.cssSelector("html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown a.dropdown-toggle i.fa.fa-user.navtop")).click();
    }

    private void clickOnConfirmButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/form/input"))).click();
    }

    private void insertLogin(String login) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[1]/input"))).sendKeys(login);
    }

    private void insertPassword(String password) {
        driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[2]/input")).sendKeys(password);
    }

    private void clickOnLoginButton() {
        driver.findElement(By.cssSelector("html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown.open ul.dropdown-menu.dropdown-auth.nav-ul auth.ng-isolate-scope div.ng-scope div.container.registration.ng-scope form.ng-dirty.ng-valid-parse.ng-valid-required.ng-valid-email.ng-valid.ng-valid-pattern input.btn.btn-success.btn-block.submit-btn")).click();
    }

    private String getChangeButtonText() {
        return  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#main > div > user-profile > div > div > section.col-sm-3 > div.user-page__avatar > button > span:nth-child(1)"))).getText();
    }

    private String getCancelButtonText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#main > div > user-profile > div > div > section.col-sm-3 > div.user-page__avatar > button > span:nth-child(2)"))).getText();
    }

    private WebElement getConfirmButton() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/form/input")));
    }

    private WebElement getAvaURLField() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/form/div/input")));
    }

    private WebElement getDefAvatar() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/img")));
    }
}
