package filterEventsOnTheMapByCategories;

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

/**
 * Created by Никита on 27.12.2016.
 */
public class US_FilterEventsOnTheMapByCategoriesWithFirefox {

    private WebDriver driver;
    private WebDriverWait wait;
    private final int MAX_WAIT_TIME=10;

    private WebElement categoriesDropdownList;
    private WebElement eventsDropdownList;

    private By categoriesLocator;
    private By eventsLocator;

    private final String mapLink = "http://green-tourism.herokuapp.com/#!/places";

    @BeforeMethod
    public void setUpDriverAndPreconditions() {
        FirefoxDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,MAX_WAIT_TIME);
        initializeLocators();
        setUpPreconditions();
    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void verifyExistenceOfEventsDropdownList(){
        Assert.assertTrue(exists(eventsDropdownList), "This element doesn't exist");
    }

    public void setUpPreconditions(){
        driver.get(mapLink);
        categoriesDropdownList = wait.until(ExpectedConditions.presenceOfElementLocated(categoriesLocator));
        categoriesDropdownList.click();
        eventsDropdownList = wait.until(ExpectedConditions.presenceOfElementLocated(eventsLocator));
        eventsDropdownList.click();
    }

    public void initializeLocators(){
        categoriesLocator = By.xpath("//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[2]/div/div[3]");
        eventsLocator = By.xpath("//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]");
    }
    public boolean exists(WebElement element){
        if (element == null){
            return false;
        }
        return true;
    }
}

