package rv.atqc.gttesting.filterEventsOnTheMapByCategoriesPageObject;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rv.atqc.gttesting.archex.EventsPage;
import rv.atqc.gttesting.archex.MapHeadPageForGuestUserPage;

public class FilterEventsOnTheMapByCategoriesPageObjectWithFirefox {

    private WebDriver driver;

    private final String MAP_LINK = "http://green-tourism.herokuapp.com/#!/places";

    EventsPage eventsPage;

    @BeforeClass
    public void setUpDriverAndPreconditions() {
        FirefoxDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        driver.get(MAP_LINK);
        driver.manage().window().maximize();
        eventsPage = new MapHeadPageForGuestUserPage(driver).clickCategories().clickEvents();
    }
    @AfterClass
    public void quitDriver(){
        driver.quit();
    }
    @Test
    public void verifyExistenceOfEventsDropdownList(){
        Assert.assertTrue(eventsPage.getEventsDropdownList().isEnabled(), "This element doesn't exist");
    }
    @Test
    public void verifyTitleOfEventsDropdownList(){
        Assert.assertTrue(eventsPage.getEventsName().getText().equalsIgnoreCase("Events"));
    }
    @Test
    public void verifyExistenceOfPlaceFilterGame(){
        Assert.assertTrue(eventsPage.getGameFilter().isEnabled(),"This element doesn't exist");
    }
    @Test
    public void verifyExistenceOfPlaceFilterFestival(){
        Assert.assertTrue(eventsPage.getFestivalFilter().isEnabled(), "This element doesn't exist");
    }
    @Test
    public void verifyExistenceOfPlaceFilterMeeting(){
        Assert.assertTrue(eventsPage.getMeetingFilter().isEnabled(), "This element doesn't exist");
    }
    @Test
    public void verifyTitleOfPlaceFilterGame(){
        Assert.assertTrue(eventsPage.waitForVisibilityOfElement(eventsPage.getGameFilter(), 5)
                .getGameFilter().getText().contains("Game"));
    }
    @Test
    public void verifyTitleOfPlaceFilterFestival(){
        Assert.assertTrue(eventsPage.waitForVisibilityOfElement(eventsPage.getFestivalFilter(), 5)
                .getFestivalFilter().getText().contains("Festival"));
    }
    @Test
    public void verifyTitleOfPlaceFilterMeeting(){
        Assert.assertTrue(eventsPage.waitForVisibilityOfElement(eventsPage.getMeetingFilter(), 5)
                .getMeetingFilter().getText().contains("Meeting"));
    }
    @Test
    public void verifyClickThroughRateOfPlaceFilterGame(){
        Assert.assertTrue(eventsPage.waitForElementToBeClickable(eventsPage.getGameFilter(), 5)
                .getGameFilter().isEnabled());
    }
    @Test
    public void verifyClickThroughRateOfPlaceFilterFestival(){
        Assert.assertTrue(eventsPage.waitForElementToBeClickable(eventsPage.getFestivalFilter(), 5)
                .getFestivalFilter().isEnabled());
    }
    @Test
    public void verifyClickThroughRateOfPlaceFilterMeeting(){
        Assert.assertTrue(eventsPage.waitForElementToBeClickable(eventsPage.getMeetingFilter(), 5)
                .getMeetingFilter().isEnabled());
    }
    @Test
    public void verifyDisplayOfGameGreenIconOnMap(){
        eventsPage.clickGame();
        Assert.assertTrue(eventsPage.waitForVisibilityOfElement(eventsPage.getGameGreenIcon(), 5)
                .getGameGreenIcon().isDisplayed());
    }
    @Test
    public void verifyDisplayOfFestivalRedIconOnMap(){
        eventsPage.clickFestival();
        Assert.assertTrue(eventsPage.waitForVisibilityOfElement(eventsPage.getFestivalRedIcon(), 5)
                .getFestivalRedIcon().isDisplayed());
    }
    @Test
    public void verifyDisplayOfMeetingBlueIconOnMap(){
        eventsPage.clickMeeting();
        Assert.assertTrue((eventsPage.waitForVisibilityOfElement(eventsPage.getMeetingBlueIcon(), 5)
                .getMeetingBlueIcon().isDisplayed()));
    }
    @Test
    public void verifyClickThroughRateOfGameIcon(){
        eventsPage.clickGame();
        Assert.assertTrue(eventsPage.waitForElementToBeClickable(eventsPage.getGameGreenIcon(), 5)
                .getGameGreenIcon().isEnabled());
    }
    @Test
    public void verifyClickThroughRateOfFestivalIcon(){
        eventsPage.clickFestival();
        Assert.assertTrue(eventsPage.waitForElementToBeClickable(eventsPage.getFestivalRedIcon(), 5)
                .getFestivalRedIcon().isEnabled());
    }
    @Test
    public void verifyClickThroughRateOfMeetingIcon(){
        eventsPage.clickMeeting();
        Assert.assertTrue(eventsPage.waitForElementToBeClickable(eventsPage.getMeetingBlueIcon(), 5)
                .getMeetingBlueIcon().isEnabled());
    }
}

