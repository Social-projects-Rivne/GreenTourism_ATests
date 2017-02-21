package rv.atqc.gttesting.possibilityToLogIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

@Features("Checking possibility to log in")
@Stories("Firefox browser")
public class PossibilityToLogInFirefox {
    private WebDriver driver;
    WebDriverWait wait;
    private String USER_LOGIN = "test@test.com";
    private String USER_PASSWORD = "Test@123";
    private String INVALID_PASSWORD = "111";
    private String TWO_AT_SIGNS_LOGIN = "test@@test.com";
    private String NO_DOMAIN_LOGIN = "test@";
    private long MAX_WAIT_TIME = 5;
    
    @TestCaseId("RVAT-539")
    @Test
    public void checkLogInWithExistingAccountFirefox() {
        clickOnDropdownButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        clickOnDropdownButton();
        Assert.assertEquals(getProfileButtonText(), "Profile");
    }
    
    @TestCaseId("RVAT-542")
    @Test
    public void checkLogInWithIncorrectPasswordFirefox() {
        clickOnDropdownButton();
        insertLogin(USER_LOGIN);
        insertPassword(INVALID_PASSWORD);
        clickOnLoginButton();
        Assert.assertEquals(getInvalidMailOrPasswordText(), "×\nInvalid email or password!");
    }
    
    @TestCaseId("RVAT-546")
    @Test
    public void checkLogInWithTwoAtSignsFirefox() {
        clickOnDropdownButton();
        insertLogin(TWO_AT_SIGNS_LOGIN);
        insertPassword(USER_PASSWORD);
        Assert.assertEquals(getInvalidEmailText(), "Invalid email");
    }
    
    @TestCaseId("RVAT-549")
    @Test
    public void checkLogInWithNoDomainFirefox() {
        clickOnDropdownButton();
        insertLogin(NO_DOMAIN_LOGIN);
        insertPassword(USER_PASSWORD);
        Assert.assertEquals(getInvalidEmailText(), "Invalid email");
    }
  
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

    private void clickOnDropdownButton() {
        driver.findElement(By.xpath(".//*[@id='navbar']/ul[1]/li/a/i")).click();
    }

    private void clickOnLoginButton() {
        driver.findElement(By.xpath(".//*[@id='navbar']/ul[1]/li/ul/auth/div[2]/div/form/input")).click();
    }

    private void insertLogin(String login) {
        driver.findElement(By.xpath(".//*[@id='navbar']/ul[1]/li/ul/auth/div[2]/div/form/div[1]/input")).sendKeys(login);
    }
    
    private void insertPassword(String password) {
        driver.findElement(By.xpath(".//*[@id='navbar']/ul[1]/li/ul/auth/div[2]/div/form/div[2]/input")).sendKeys(password);
    }
    
    private String getProfileButtonText() {
        return driver.findElement(By.xpath(".//*[@id='navbar']/ul[1]/li/ul/li[1]/a")).getText();
    }
    
    private String getInvalidMailOrPasswordText() {
        return driver.findElement(By.xpath(".//*[@id='main']/div[1]")).getText();
    }
    
    private String getInvalidEmailText() {
    	return driver.findElement(By.xpath("html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[1]/p[1]")).getText();
    }

}
