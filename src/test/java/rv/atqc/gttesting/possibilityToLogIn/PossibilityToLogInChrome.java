package rv.atqc.gttesting.possibilityToLogIn;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

@Features("Checking possibility to log in")
@Stories("Chrome browser")
public class PossibilityToLogInChrome {
    private WebDriver driver;
    private String USER_LOGIN = "test@test.com";
    private String USER_PASSWORD = "Test@123";
    private String INVALID_PASSWORD = "111";
    private String TWO_AT_SIGNS_LOGIN = "test@@test.com";
    private String NO_DOMAIN_LOGIN = "test@";
    
    @TestCaseId("RVAT-538")
    @Test
    public void checkLogInWithExistingAccountChrome() {
        clickOnDropdownButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        clickOnDropdownButton();
        Assert.assertEquals(getProfileButtonText(), "Profile");
    }
    
    @TestCaseId("RVAT-541")
    @Test
    public void checkLogInWithIncorrectPasswordChrome() {
        clickOnDropdownButton();
        insertLogin(USER_LOGIN);
        insertPassword(INVALID_PASSWORD);
        clickOnLoginButton();
        Assert.assertEquals(getInvalidMailOrPasswordText(), "×\nInvalid email or password!");
    }
    
    @TestCaseId("RVAT-544")
    @Test
    public void checkLogInWithTwoAtSignsChrome() {
        clickOnDropdownButton();
        insertLogin(TWO_AT_SIGNS_LOGIN);
        insertPassword(USER_PASSWORD);
        Assert.assertEquals(getInvalidEmailText(), "Invalid email");
    }
    
    @TestCaseId("RVAT-548")
    @Test
    public void checkLogInWithNoDomainChrome() {
        clickOnDropdownButton();
        insertLogin(NO_DOMAIN_LOGIN);
        insertPassword(USER_PASSWORD);
        Assert.assertEquals(getInvalidEmailText(), "Invalid email");
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
