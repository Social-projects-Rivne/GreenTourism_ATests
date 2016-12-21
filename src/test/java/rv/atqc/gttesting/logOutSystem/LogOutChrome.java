package rv.atqc.gttesting.logOutSystem;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutChrome {
    private WebDriver driver;
    private String USER_LOGIN = "17141@rambler.ru";
    private String USER_PASSWORD = "12345678";

    @Test
    public void checkLogOutButtonTitleInChrome() {
        clickOnLeftTopGreenButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        clickOnLeftTopGreenButton();
        Assert.assertEquals(getLogOutText(), "Log out");
    }

    @Test
    public void checkForgotPasswordLinkTitleInChrome() {
        clickOnLeftTopGreenButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        clickOnLeftTopGreenButton();
        clickOnLogOutButton();
        clickOnLeftTopGreenButton();
        Assert.assertEquals(getForgotPasswordText(), "Forgot password?");
    }

    @Test
    public void checkAbcentTitleLogOutChrome() {
        driver.get("https://green-tourism.herokuapp.com/#!/profile");
        Assert.assertFalse(isLogOutTitlePresent());
    }

    @BeforeMethod
    public void before() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("https://green-tourism.herokuapp.com/#!/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    private boolean isLogOutTitlePresent() {
        boolean isPresent;
        try {
            driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/li[2]/a"));
            isPresent = true;
        } catch (NoSuchElementException e) {
            isPresent = false;
        }
        return isPresent;
    }

    private void clickOnLeftTopGreenButton() {
        driver.findElement(By.cssSelector("html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown a.dropdown-toggle i.fa.fa-user.navtop")).click();
    }

    private void clickOnLoginButton() {
        driver.findElement(By.cssSelector("html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown.open ul.dropdown-menu.dropdown-auth.nav-ul auth.ng-isolate-scope div.ng-scope div.container.registration.ng-scope form.ng-dirty.ng-valid-parse.ng-valid-required.ng-valid-email.ng-valid.ng-valid-pattern input.btn.btn-success.btn-block.submit-btn")).click();
    }

    private void insertPassword(String password) {
        driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[2]/input")).sendKeys(password);
    }

    private void insertLogin(String login) {
        driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[1]/input")).sendKeys(login);
    }

    private String getLogOutText() {
        return driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/li[2]/a")).getText();
    }

    private String getForgotPasswordText() {
        return driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/p[1]/a")).getText();
    }

    private void clickOnLogOutButton() {
        driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/li[2]/a")).click();
    }
}
