package rv.atqc.gttesting.filterEventsOnTheMapByCategoriesPageObject;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rv.atqc.gttesting.archex.EventsPage;
import rv.atqc.gttesting.archex.MapHeadPageForGuestUserPage;

public class FilterEventsOnTheMapByCategoriesPageObjectWithChrome {

    private WebDriver driver;
    private WebDriverWait wait;
    private final int MAX_WAIT_TIME = 10;

    private final String MAP_LINK = "http://green-tourism.herokuapp.com/#!/places";

    EventsPage eventsPage;

    @BeforeClass
    public void setUpDriverAndPreconditions() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get(MAP_LINK);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, MAX_WAIT_TIME);
        eventsPage = new MapHeadPageForGuestUserPage(driver).clickCategories().clickEvents();
    }
    @AfterClass
    public void quitDriver(){
        driver.quit();
    }
    @Test
    public void verifyExistenceOfEventsDropdownList(){
        Assert.assertTrue(isElementEnabled(eventsPage.getEventsDropdownList()), "This element doesn't exist");
    }
    @Test
    public void verifyTitleOfEventsDropdownList(){
        Assert.assertTrue(eventsPage.getEventsName().getText().equalsIgnoreCase("Events"));
    }
    @Test
    public void verifyExistenceOfPlaceFilterGame(){
        Assert.assertTrue(isElementEnabled(eventsPage.getGameFilter()), "This element doesn't exist");
    }
    @Test
    public void verifyExistenceOfPlaceFilterFestival(){
        Assert.assertTrue(isElementEnabled(eventsPage.getFestivalFilter()), "This element doesn't exist");
    }
    @Test
    public void verifyExistenceOfPlaceFilterMeeting(){
        Assert.assertTrue(isElementEnabled(eventsPage.getMeetingFilter()), "This element doesn't exist");
    }
    @Test
    public void verifyTitleOfPlaceFilterGame(){
        Assert.assertTrue(eventsPage.getGameFilter().getText().contains("Game"));
    }
    @Test
    public void verifyTitleOfPlaceFilterFestival(){
        Assert.assertTrue(eventsPage.getFestivalFilter().getText().contains("Festival"));
    }
    @Test
    public void verifyTitleOfPlaceFilterMeeting(){
        Assert.assertTrue(eventsPage.getMeetingFilter().getText().contains("Meeting"));
    }
    @Test
    public void verifyClickThroughRateOfPlaceFilterGame(){
        Assert.assertTrue(isElementClickable(eventsPage.getGameFilter()));
    }
    @Test
    public void verifyClickThroughRateOfPlaceFilterFestival(){
        Assert.assertTrue(isElementClickable(eventsPage.getFestivalFilter()));
    }
    @Test
    public void verifyClickThroughRateOfPlaceFilterMeeting(){
        Assert.assertTrue(isElementClickable(eventsPage.getMeetingFilter()));
    }
    @Test
    public void verifyDisplayOfGameGreenIconOnMap(){
        eventsPage.clickGame();
        Assert.assertTrue(isElementDisplayed(eventsPage.getGameGreenIcon()));
    }
    @Test
    public void verifyDisplayOfFestivalRedIconOnMap(){
        eventsPage.clickFestival();
        Assert.assertTrue(isElementDisplayed(eventsPage.getFestivalRedIcon()));
    }
    @Test
    public void verifyDisplayOfMeetingBlueIconOnMap(){
        eventsPage.clickMeeting();
        Assert.assertTrue(isElementDisplayed(eventsPage.getMeetingBlueIcon()));
    }
    @Test
    public void verifyClickThroughRateOfGameIcon(){
        eventsPage.clickGame();
        Assert.assertTrue(isElementClickable(eventsPage.getGameGreenIcon()));
    }
    @Test
    public void verifyClickThroughRateOfFestivalIcon(){
        eventsPage.clickFestival();
        Assert.assertTrue(isElementClickable(eventsPage.getFestivalRedIcon()));
    }
    @Test
    public void verifyClickThroughRateOfMeetingIcon(){
        eventsPage.clickMeeting();
        Assert.assertTrue(isElementClickable(eventsPage.getMeetingBlueIcon()));
    }

    public boolean isElementEnabled(WebElement element){
        return element.isEnabled();
    }
    public boolean isElementClickable(WebElement element){
        try{
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            return clickableElement != null;
        }
        catch(Exception exception){
            return false;
        }
    }
    public boolean isElementDisplayed(WebElement element){
        try {
            WebElement displayedElement = wait.until(ExpectedConditions.visibilityOf(element));
            return displayedElement.isDisplayed();
        }
        catch(Exception exception){
            return false;
        }
    }
}
