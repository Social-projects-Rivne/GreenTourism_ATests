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
    private WebElement gamePlaceFilterName;
    private WebElement festivalPlaceFilterName;
    private WebElement meetingPlaceFilterName;

    private By categoriesLocator;
    private By eventsLocator;
    private By eventsNameLocator;
    private By gamePlaceFilterLocator;
    private By festivalPlaceFilterLocator;
    private By meetingPlaceFilterLocator;
    private By gamePlaceFilterNameLocator;
    private By festivalPlaceFilterNameLocator;
    private By meetingPlaceFilterNameLocator;

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
        Assert.assertTrue(isElementEnabled(eventsDropdownList), "This element doesn't exist");
    }
    @Test
    public void verifyTitleOfEventsDropdownList(){
        eventsName = wait.until(ExpectedConditions.presenceOfElementLocated(eventsNameLocator));
        Assert.assertTrue(eventsName.getText().equalsIgnoreCase("Events"));
    }
    @Test
    public void verifyExistenceOfPlaceFilterGame(){
        gamePlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(gamePlaceFilterLocator));
        Assert.assertTrue(isElementEnabled(gamePlaceFilter), "This element doesn't exist");
    }
    @Test
    public void verifyExistenceOfPlaceFilterFestival(){
        festivalPlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(festivalPlaceFilterLocator));
        Assert.assertTrue(isElementEnabled(festivalPlaceFilter), "This element doesn't exist");
    }
    @Test
    public void verifyExistenceOfPlaceFilterMeeting(){
        meetingPlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(meetingPlaceFilterLocator));
        Assert.assertTrue(isElementEnabled(meetingPlaceFilter), "This element doesn't exist");
    }
    @Test
    public void verifyTitleOfPlaceFilterGame(){
        gamePlaceFilterName = wait.until(ExpectedConditions.presenceOfElementLocated(gamePlaceFilterNameLocator));
        Assert.assertTrue(gamePlaceFilterName.getText().contains("Game"));
    }
    @Test
    public void verifyTitleOfPlaceFilterFestival(){
        festivalPlaceFilterName = wait.until(ExpectedConditions.presenceOfElementLocated(festivalPlaceFilterNameLocator));
        Assert.assertTrue(festivalPlaceFilterName.getText().contains("Festival"));
    }
    @Test
    public void verifyTitleOfPlaceFilterMeeting(){
        meetingPlaceFilterName = wait.until(ExpectedConditions.presenceOfElementLocated(meetingPlaceFilterNameLocator));
        Assert.assertTrue(meetingPlaceFilterName.getText().contains("Meeting"));
    }
    @Test
    public void verifyClickThroughRateOfPlaceFilterGame(){
        Assert.assertTrue(isElementClickable(gamePlaceFilter, gamePlaceFilterNameLocator));
    }
    @Test
    public void verifyClickThroughRateOfPlaceFilterFestival(){
        Assert.assertTrue(isElementClickable(festivalPlaceFilter, festivalPlaceFilterNameLocator));
    }
    public void initializeLocators(){
        categoriesLocator = By.xpath("//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[2]/div/div[3]");
        eventsLocator = By.xpath("//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]");
        eventsNameLocator = By.xpath("//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]/a");
        gamePlaceFilterLocator = By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[3]/div/div[5]/ul/li[1]/a");
        festivalPlaceFilterLocator = By.xpath("//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]/ul/li[2]");
        meetingPlaceFilterLocator = By.xpath("//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]/ul/li[3]");
        gamePlaceFilterNameLocator = By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]/ul/li[1]/a");
        festivalPlaceFilterNameLocator = By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]/ul/li[2]/a");
        meetingPlaceFilterNameLocator = By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]/ul/li[3]/a");
    }
    public void setUpPreconditions(){
        driver.get(mapLink);
        categoriesDropdownList = wait.until(ExpectedConditions.presenceOfElementLocated(categoriesLocator));
        categoriesDropdownList.click();
        eventsDropdownList = wait.until(ExpectedConditions.presenceOfElementLocated(eventsLocator));
        eventsDropdownList.click();
    }
    public boolean isElementEnabled(WebElement element){
        return element.isEnabled();
    }
    public boolean isElementClickable(WebElement element, By locator){
        try{
            WebElement clickableElement = element;
            clickableElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        }
        catch(Exception exception){
            return false;
        }
    }
}

