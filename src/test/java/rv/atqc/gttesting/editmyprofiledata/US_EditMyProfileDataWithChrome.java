package rv.atqc.gttesting.editmyprofiledata;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class US_EditMyProfileDataWithChrome {

    private WebDriver driver;

    @BeforeMethod
    public void setUpDriverAndPreconditions() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        setUpPreconditions();
    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        driver.close();
    }

    public void setUpPreconditions(){
        driver.get("https://green-tourism.herokuapp.com");
        //Toggle
        driver.findElement(By.cssSelector("#navbar > ul:nth-child(1) > li > a > i")).click();
        //E-mail
        driver.findElement(By.cssSelector("#navbar > ul:nth-child(1) > li > ul > auth > div:nth-child(2) > div > " +
                "form > div:nth-child(1) > input")).clear();
        driver.findElement(By.cssSelector("#navbar > ul:nth-child(1) > li > ul > auth > div:nth-child(2) > div > " +
                "form > div:nth-child(1) > input")).sendKeys("godwearsgucci@ukr.net");
        //Password
        driver.findElement(By.cssSelector("#navbar > ul:nth-child(1) > li > ul > auth > div:nth-child(2) > div > " +
                "form > div:nth-child(2) > input")).clear();
        driver.findElement(By.cssSelector("#navbar > ul:nth-child(1) > li > ul > auth > div:nth-child(2) > div > " +
                "form > div:nth-child(2) > input")).sendKeys("22121989");
        // Login click
        driver.findElement(By.cssSelector("#navbar > ul:nth-child(1) > li > ul > auth > div:nth-child(2) > div > " +
                "form > input")).click();
    }
    public String getTextOfEditButton(){
        return driver.findElement(By.cssSelector("#main > div > user-profile > div > div > section.col-sm-9 > div:nth-child(1) > h1 > button:nth-child(1)")).getText();
    }

    @Test
    public void verifyNameOfEditButton(){
        String actualTextOfEditButton = getTextOfEditButton();
        Assert.assertEquals(actualTextOfEditButton, "Edit");
    }
}
