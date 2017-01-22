package rv.atqc.gttesting.possibilityToViewPopularPlacesInCurrentLocation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rv.atqc.gttesting.archex.MapHeadPageForGuestUserPage;
import rv.atqc.gttesting.archex.PopularPlacesInLocationPage;

public class PossibilityViewPopularPlacesInCurrentLocationChrome {

    private WebDriver driver;

    private final String MAP_LINK = "http://green-tourism.herokuapp.com/#!/places";

    PopularPlacesInLocationPage popularPlacesInLocationPage;

    @BeforeClass
    public void setUpDriverAndPreconditions() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get(MAP_LINK);
        driver.manage().window().maximize();
        popularPlacesInLocationPage = new MapHeadPageForGuestUserPage(driver).clickPopularPlacesInLocation();
    }
    @AfterClass
    public void quitDriver(){
        driver.quit();
    }
    @Test
    public void verifyExistenceOfPopularPlacesButton(){
        Assert.assertTrue(popularPlacesInLocationPage.getPopularPlacesButton().isEnabled());
    }
    @Test
    public void verifyDisplayOfPopularPlacesButton(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForVisibilityOfElement(popularPlacesInLocationPage.getPopularPlacesButton(), 5)
                .getPopularPlacesButton().isDisplayed());
    }
    @Test
    public void verifyClickThroughRateOfPopularPlacesButton(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForElementToBeClickable(popularPlacesInLocationPage.getPopularPlacesButton(), 5)
                .getPopularPlacesButton().isEnabled());
    }
}
