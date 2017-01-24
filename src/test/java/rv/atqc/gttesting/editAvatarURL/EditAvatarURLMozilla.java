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
    private final int MAX_WAIT_TIME = 10;
    private final String JPG_URL="http://img1.jurko.net/avatar_17294.jpg";
    private final String JPEG_URL = "https://avatars0.githubusercontent.com/u/17428479?v=3&s=460";
    private final String PNG_URL = "http://pngimg.com/upload/small/arctic_fox_PNG18479.png";


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

    @Test
    public void checkPresentJPGAvatarInEditAvSystChrome() {
        clickOnLeftTopGreenButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        clickOnChangeButton();
        insertURL(JPG_URL);
        clickOnConfirmButton();
        Assert.assertTrue(getJPGAvatar().isDisplayed());
    }

    @Test

    public void checkPresentJPEGAvatarInEditAvSystChrome() {
        clickOnLeftTopGreenButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        clickOnChangeButton();
        insertURL(JPEG_URL);
        clickOnConfirmButton();
        Assert.assertTrue(getJPEGAvatar().isDisplayed());
    }

    @Test
    public void checkPresentPNGAvatarInEditAvSystMozilla() {
        clickOnLeftTopGreenButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        clickOnChangeButton();
        insertURL(PNG_URL);
        clickOnConfirmButton();
        Assert.assertTrue(getPNGAvatar().isDisplayed());
    }
    @Test
    public void checkSavingJPGAvatarInEditAvSystMozilla() {
        clickOnLeftTopGreenButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        clickOnChangeButton();
        insertURL(JPG_URL);
        clickOnConfirmButton();
        clickOnLeftTopGreenButton();
        clickOnLogOutButton();
        waitToLoadMainPage();
        clickOnLeftTopGreenButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        Assert.assertTrue(getJPGAvatar().isDisplayed());
    }

    private void waitToLoadMainPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/assets/img/welcome-page/m1.jpg']")));
    }

    private void clickOnChangeButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/button/span[1]"))).click();
    }

    private void clickOnLeftTopGreenButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown a.dropdown-toggle i.fa.fa-user.navtop"))).click();
    }

    private void clickOnConfirmButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/form/input"))).click();
    }

    private void insertLogin(String login) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[1]/input"))).sendKeys(login);
    }

    private void insertPassword(String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[2]/input"))).sendKeys(password);
    }

    private void clickOnLoginButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown.open ul.dropdown-menu.dropdown-auth.nav-ul auth.ng-isolate-scope div.ng-scope div.container.registration.ng-scope form.ng-dirty.ng-valid-parse.ng-valid-required.ng-valid-email.ng-valid.ng-valid-pattern input.btn.btn-success.btn-block.submit-btn"))).click();
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
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/img")));
    }

    private void insertURL(String url) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[1]/div[1]/form/div/input"))).sendKeys(url);
    }

    private WebElement getJPEGAvatar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://avatars0.githubusercontent.com/u/17428479?v=3&s=460']")));
    }

    private WebElement getPNGAvatar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='http://pngimg.com/upload/small/arctic_fox_PNG18479.png']")));
    }

    private WebElement getJPGAvatar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='http://img1.jurko.net/avatar_17294.jpg']")));
    }

    private void clickOnLogOutButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/li[2]/a"))).click();
    }
}
