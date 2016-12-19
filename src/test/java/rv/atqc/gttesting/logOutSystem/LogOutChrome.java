package rv.atqc.gttesting.logOutSystem;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutChrome {
    private WebDriver driver;

    @Test
    public void identifyLogOutButtonChrome() {
        clickOnLeftTopGreenButton();
        insertLogin();
        insertPassword();
        clickOnLoginButton();
        clickOnLeftTopGreenButton();
        Assert.assertEquals(getLogOutText(), "Log out");
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


    private void clickOnLeftTopGreenButton() {
        driver.findElement(By.cssSelector("html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown a.dropdown-toggle i.fa.fa-user.navtop")).click();
    }

    private void clickOnLoginButton() {
        driver.findElement(By.cssSelector("html.ng-scope body header nav.navbar.navbar-default.navbar-fixed-top.navbar-style.ng-scope div.container.nav-padding div#navbar.collapse.navbar-collapse ul.nav.navbar-nav li.dropdown.open ul.dropdown-menu.dropdown-auth.nav-ul auth.ng-isolate-scope div.ng-scope div.container.registration.ng-scope form.ng-dirty.ng-valid-parse.ng-valid-required.ng-valid-email.ng-valid.ng-valid-pattern input.btn.btn-success.btn-block.submit-btn")).click();
    }

    private void insertPassword() {
        driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[2]/input")).sendKeys("12345678");
    }

    private void insertLogin() {
        driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[1]/input")).sendKeys("17141@rambler.ru");
    }

    private String getLogOutText() {
        return driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/li[2]/a")).getText();
    }
}
