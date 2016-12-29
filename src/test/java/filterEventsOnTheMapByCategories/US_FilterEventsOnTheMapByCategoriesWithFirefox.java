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

public class US_FilterEventsOnTheMapByCategoriesWithFirefox {

    private WebDriver driver;
    private WebDriverWait wait;
    private final int MAX_WAIT_TIME=10;

    private WebElement categoriesDropdownList;
    private WebElement eventsDropdownList;
    private WebElement eventsName;
    private WebElement gamePlaceFilter;
    private WebElement festivalPlaceFilter;
    private WebElement meetingPlaceFilter;

    private By categoriesLocator;
    private By eventsLocator;
    private By eventsNameLocator;
    private By gamePlaceFilterLocator;
    private By festivalPlaceFilterLocator;
    private By meetingPlaceFilterLocator;

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
        driver.quit();
    }
    @Test
    public void verifyExistenceOfEventsDropdownList(){
        Assert.assertTrue(exists(eventsDropdownList), "This element doesn't exist");
    }
    @Test
    public void verifyTitleOfEventsDropdownList(){
        eventsName = wait.until(ExpectedConditions.presenceOfElementLocated(eventsNameLocator));
        Assert.assertTrue(eventsName.getText().equalsIgnoreCase("Events"));
    }
    @Test
    public void verifyExistenceOfPlaceFilterGame(){
        gamePlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(gamePlaceFilterLocator));
        Assert.assertTrue(exists(gamePlaceFilter), "This element doesn't exist");
    }
    @Test
    public void verifyExistenceOfPlaceFilterFestival(){
        festivalPlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(festivalPlaceFilterLocator));
        Assert.assertTrue(exists(festivalPlaceFilter), "This element doesn't exist");
    }
    @Test
    public void verifyExistenceOfPlaceFilterMeeting(){
        meetingPlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(meetingPlaceFilterLocator));
        Assert.assertTrue(exists(meetingPlaceFilter), "This element doesn't exist");
    }
    public void initializeLocators(){
        categoriesLocator = By.xpath("//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[2]/div/div[3]");
        eventsLocator = By.xpath("//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]");
        eventsNameLocator = By.xpath("//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]/a");
        gamePlaceFilterLocator = By.xpath("//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[3]/div/div[5]/ul/li[1]");
        festivalPlaceFilterLocator = By.xpath("//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]/ul/li[2]");
        meetingPlaceFilterLocator = By.xpath("//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]/ul/li[3]");
    }
    public void setUpPreconditions(){
        driver.get(mapLink);
        categoriesDropdownList = wait.until(ExpectedConditions.presenceOfElementLocated(categoriesLocator));
        categoriesDropdownList.click();
        eventsDropdownList = wait.until(ExpectedConditions.presenceOfElementLocated(eventsLocator));
        eventsDropdownList.click();
    }
    public boolean exists(WebElement element){
        if (!element.isEnabled()){
            return false;
        }
        return true;
    }
}

