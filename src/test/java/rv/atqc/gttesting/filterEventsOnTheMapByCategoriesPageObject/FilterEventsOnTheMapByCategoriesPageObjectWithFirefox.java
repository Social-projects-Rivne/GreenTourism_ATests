package rv.atqc.gttesting.filterEventsOnTheMapByCategoriesPageObject;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import rv.atqc.gttesting.archex.EventsPage;
import rv.atqc.gttesting.archex.MapHeadPageForGuestUserPage;

@Features("Verify possibility to filter events on the map by categories")
@Stories("Firefox browser")
public class FilterEventsOnTheMapByCategoriesPageObjectWithFirefox {

    private WebDriver driver;

    private final String MAP_LINK = "http://green-tourism.herokuapp.com/#!/places";

    private final int MAX_WAIT_TIME = 15;

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

    @TestCaseId("RVAT-880")
    @Test
    public void verifyExistenceOfEventsDropdownList(){
        Assert.assertTrue(eventsPage.getEventsDropdownList().isEnabled(), "This element doesn't exist");
    }

    @TestCaseId("RVAT-882")
    @Test
    public void verifyTitleOfEventsDropdownList(){
        Assert.assertTrue(eventsPage.getEventsName().getText().equalsIgnoreCase("Events"));
    }

    @TestCaseId("RVAT-884")
    @Test
    public void verifyExistenceOfPlaceFilterGame(){
        Assert.assertTrue(eventsPage.getGameFilter().isEnabled(),"This element doesn't exist");
    }

    @TestCaseId("RVAT-886")
    @Test
    public void verifyExistenceOfPlaceFilterFestival(){
        Assert.assertTrue(eventsPage.getFestivalFilter().isEnabled(), "This element doesn't exist");
    }

    @TestCaseId("RVAT-888")
    @Test
    public void verifyExistenceOfPlaceFilterMeeting(){
        Assert.assertTrue(eventsPage.getMeetingFilter().isEnabled(), "This element doesn't exist");
    }

    @TestCaseId("RVAT-890")
    @Test
    public void verifyTitleOfPlaceFilterGame(){
        Assert.assertTrue(eventsPage
                .waitForVisibilityOfElement(eventsPage.getGameFilter(), MAX_WAIT_TIME)
                .getGameFilter()
                .getText()
                .contains("Game"));
    }

    @TestCaseId("RVAT-892")
    @Test
    public void verifyTitleOfPlaceFilterFestival(){
        Assert.assertTrue(eventsPage
                .waitForVisibilityOfElement(eventsPage.getFestivalFilter(), MAX_WAIT_TIME)
                .getFestivalFilter()
                .getText()
                .contains("Festival"));
    }

    @TestCaseId("RVAT-894")
    @Test
    public void verifyTitleOfPlaceFilterMeeting(){
        Assert.assertTrue(eventsPage
                .waitForVisibilityOfElement(eventsPage.getMeetingFilter(), MAX_WAIT_TIME)
                .getMeetingFilter()
                .getText()
                .contains("Meeting"));
    }

    @TestCaseId("RVAT-902")
    @Test
    public void verifyClickThroughRateOfPlaceFilterGame(){
        Assert.assertTrue(eventsPage
                .waitForElementToBeClickable(eventsPage.getGameFilter(), MAX_WAIT_TIME)
                .getGameFilter()
                .isEnabled());
    }

    @TestCaseId("RVAT-904")
    @Test
    public void verifyClickThroughRateOfPlaceFilterFestival(){
        Assert.assertTrue(eventsPage
                .waitForElementToBeClickable(eventsPage.getFestivalFilter(), MAX_WAIT_TIME)
                .getFestivalFilter()
                .isEnabled());
    }

    @TestCaseId("RVAT-906")
    @Test
    public void verifyClickThroughRateOfPlaceFilterMeeting(){
        Assert.assertTrue(eventsPage
                .waitForElementToBeClickable(eventsPage.getMeetingFilter(), MAX_WAIT_TIME)
                .getMeetingFilter()
                .isEnabled());
    }

    @TestCaseId("RVAT-908")
    @Test
    public void verifyDisplayOfGameGreenIconOnMap(){
        eventsPage.clickGame();
        Assert.assertTrue(eventsPage
                .waitForVisibilityOfElement(eventsPage.getGameGreenIcon(), MAX_WAIT_TIME)
                .getGameGreenIcon()
                .isDisplayed());
    }

    @TestCaseId("RVAT-910")
    @Test
    public void verifyDisplayOfFestivalRedIconOnMap(){
        eventsPage.clickFestival();
        Assert.assertTrue(eventsPage
                .waitForVisibilityOfElement(eventsPage.getFestivalRedIcon(), MAX_WAIT_TIME)
                .getFestivalRedIcon()
                .isDisplayed());
    }

    @TestCaseId("RVAT-912")
    @Test
    public void verifyDisplayOfMeetingBlueIconOnMap(){
        eventsPage.clickMeeting();
        Assert.assertTrue(eventsPage
                .waitForVisibilityOfElement(eventsPage.getMeetingBlueIcon(), MAX_WAIT_TIME)
                .getMeetingBlueIcon()
                .isDisplayed());
    }

    @TestCaseId("RVAT-896")
    @Test
    public void verifyClickThroughRateOfGameIcon(){
        eventsPage.clickGame();
        Assert.assertTrue(eventsPage
                .waitForElementToBeClickable(eventsPage.getGameGreenIcon(), MAX_WAIT_TIME)
                .getGameGreenIcon()
                .isEnabled());
    }

    @TestCaseId("RVAT-898")
    @Test
    public void verifyClickThroughRateOfFestivalIcon(){
        eventsPage.clickFestival();
        Assert.assertTrue(eventsPage
                .waitForElementToBeClickable(eventsPage.getFestivalRedIcon(), MAX_WAIT_TIME)
                .getFestivalRedIcon()
                .isEnabled());
    }

    @TestCaseId("RVAT-900")
    @Test
    public void verifyClickThroughRateOfMeetingIcon(){
        eventsPage.clickMeeting();
        Assert.assertTrue(eventsPage
                .waitForElementToBeClickable(eventsPage.getMeetingBlueIcon(), MAX_WAIT_TIME)
                .getMeetingBlueIcon()
                .isEnabled());
    }
}

