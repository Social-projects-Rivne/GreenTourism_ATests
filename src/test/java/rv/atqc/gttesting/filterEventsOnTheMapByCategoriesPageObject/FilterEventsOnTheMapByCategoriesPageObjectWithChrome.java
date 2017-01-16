package rv.atqc.gttesting.filterEventsOnTheMapByCategoriesPageObject;

/**
 * Created by Никита on 12.01.2017.
 */
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rv.atqc.gttesting.archex.CategoriesPage;
import rv.atqc.gttesting.archex.EventsPage;
import rv.atqc.gttesting.archex.MapHeadPageForGuestUserPage;

public class FilterEventsOnTheMapByCategoriesPageObjectWithChrome {

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

    private final String mapLink = "http://green-tourism.herokuapp.com/#!/places";

    CategoriesPage categoriesPage;
    EventsPage eventsPage;
    MapHeadPageForGuestUserPage mapHeadPageForGuestUserPage;

    @BeforeMethod
    public void setUpDriverAndPreconditions() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // wait = new WebDriverWait(driver,MAX_WAIT_TIME);
        /*setUpPreconditions();*/
        driver.get(mapLink);
        eventsPage = new MapHeadPageForGuestUserPage(driver).clickCategories().clickEvents();
    }
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
    @Test
    public void verifyExistenceOfEventsDropdownList(){
        Assert.assertTrue(isElementEnabled(eventsPage.getEventsDropdownList()), "This element doesn't exist");
    }
    @Test
    public void verifyTitleOfEventsDropdownList(){
        //eventsName = wait.until(ExpectedConditions.presenceOfElementLocated(eventsNameLocator));
        Assert.assertTrue(eventsPage.getEventsName().getText().equalsIgnoreCase("Events"));
    }
    /*@Test
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
        Assert.assertTrue(isElementClickable(gamePlaceFilterNameLocator));
    }
    @Test
    public void verifyClickThroughRateOfPlaceFilterFestival(){
        Assert.assertTrue(isElementClickable(festivalPlaceFilterNameLocator));
    }
    @Test
    public void verifyClickThroughRateOfPlaceFilterMeeting(){
        Assert.assertTrue(isElementClickable(meetingPlaceFilterNameLocator));
    }
    @Test
    public void verifyDisplayOfGameGreenIconOnMap(){
        gamePlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(gamePlaceFilterNameLocator));
        gamePlaceFilter.click();
        Assert.assertTrue(isElementDisplayed(gameGreenIconLocator));
    }
    @Test
    public void verifyDisplayOfFestivalRedIconOnMap(){
        festivalPlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(festivalPlaceFilterNameLocator));
        festivalPlaceFilter.click();
        Assert.assertTrue(isElementDisplayed(festivalRedIconLocator));
    }
    @Test
    public void verifyDisplayOfMeetingBlueIconOnMap(){
        meetingPlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(meetingPlaceFilterNameLocator));
        meetingPlaceFilter.click();
        Assert.assertTrue(isElementDisplayed(meetingBlueIconLocator));
    }
    @Test
    public void verifyClickThroughRateOfGameIcon(){
        gamePlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(gamePlaceFilterNameLocator));
        gamePlaceFilter.click();
        Assert.assertTrue(isElementClickable(gameGreenIconLocator));
    }
    @Test
    public void verifyClickThroughRateOfFestivalIcon(){
        festivalPlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(festivalPlaceFilterNameLocator));
        festivalPlaceFilter.click();
        Assert.assertTrue(isElementClickable(festivalRedIconLocator));
    }
    @Test
    public void verifyClickThroughRateOfMeetingIcon(){
        meetingPlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(meetingPlaceFilterNameLocator));
        meetingPlaceFilter.click();
        Assert.assertTrue(isElementClickable(meetingBlueIconLocator));
    }

    public void setUpPreconditions(){
        driver.get(mapLink);
        *//*categoriesDropdownList = wait.until(ExpectedConditions.presenceOfElementLocated(categoriesLocator));
        categoriesDropdownList.click();
        eventsDropdownList = wait.until(ExpectedConditions.presenceOfElementLocated(eventsLocator));
        eventsDropdownList.click();*//*
        mapHeadPageForGuestUserPage.clickCategories().clickEvents();
    }*/
    public boolean isElementEnabled(WebElement element){
        return element.isEnabled();
    }
    public boolean isElementClickable(By locator){
        try{
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
            return clickableElement != null;
        }
        catch(Exception exception){
            return false;
        }
    }
    public boolean isElementDisplayed(By locator){
        try {
            WebElement displayedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return displayedElement.isDisplayed();
        }
        catch(Exception exception){
            return false;
        }
    }
}
