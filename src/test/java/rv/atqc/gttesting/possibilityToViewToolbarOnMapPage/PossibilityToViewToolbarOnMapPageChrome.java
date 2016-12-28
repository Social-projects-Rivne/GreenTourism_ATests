package rv.atqc.gttesting.possibilityToViewToolbarOnMapPage;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class PossibilityToViewToolbarOnMapPageChrome {

	private WebDriver driver;
    private String USER_LOGIN = "test@test.com";
    private String USER_PASSWORD = "Test@123";
    private WebDriverWait wait;
    private final int MAX_WAIT_TIME=10;
    
   @Test
   public void checkDefaultValueOfPlacesButtonChrome() {
        WebElement ValueOfPlacesButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath("//html/body/main/div/place-list/div/div/div[1]/div[1]/a[1]/i")));
        Assert.assertTrue(ValueOfPlacesButton.isDisplayed());
    }
    
    @BeforeClass
    public void beforeClass() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("https://green-tourism.herokuapp.com/#!/");
        clickOnDropdownButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        clickOnSandwichButton();
        clickOnMapPage();
        wait = new WebDriverWait(driver,MAX_WAIT_TIME);
    }
    
    @AfterClass
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
    
    private void clickOnSandwichButton() {
        driver.findElement(By.xpath("//html/body/header/nav/div/div[2]/ul[2]/li/a/i")).click();
    }
    
    private void clickOnMapPage() {
        driver.findElement(By.xpath("//html/body/header/nav/div/div[2]/ul[2]/li/ul/li[1]/a")).click();
    }
        
}
