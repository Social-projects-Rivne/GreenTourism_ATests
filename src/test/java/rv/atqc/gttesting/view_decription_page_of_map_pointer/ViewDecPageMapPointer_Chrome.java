package rv.atqc.gttesting.view_decription_page_of_map_pointer;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import rv.atqc.gttesting.archex.MapHeadPageForGuestUserPage;
import java.util.HashMap;

@Features("Verify possibility to view deckriptoon psge on map pointer")
@Stories("Chrome browser")
public class ViewDecPageMapPointer_Chrome {
    private MapHeadPageForGuestUserPage page;
    private WebDriver driver;

    @BeforeMethod
    public void before() {
        ChromeDriverManager.getInstance().setup();
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.geolocation", 2);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", prefs);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.get("https://green-tourism.herokuapp.com/#!/places");
        page = new MapHeadPageForGuestUserPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @TestCaseId("RVAT-941")
    @Test
    public void checkPresentPlasesOnMap_Chrome() {
        Assert.assertTrue(page.getPlasesOnMapChrome().isDisplayed());
    }

    @TestCaseId("RVAT-1076")
    @Test
    public void checkPresentButtonDetailsOnRaiseWindow_Chrome() {
        page.clickOnPlaceButton();
        Assert.assertTrue(page.getDetailsButton().isDisplayed());
    }

    @TestCaseId("RVAT-1078")
    @Test
    public void checkPresentTitleOnDatailsPage_Chrome() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        Assert.assertTrue(page.getTitleOnDeskPage().isDisplayed());
    }

    @TestCaseId("RVAT-1080")
    @Test
    public void checkPresentImageOnDatailsPage_Chrome() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        Assert.assertTrue(page.getImageOnDeskPage().isDisplayed());
    }

    @TestCaseId("RVAT-1082")
    @Test
    public void checkPresentMapOnDatailsPage_Chrome() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        Assert.assertTrue(page.getMapOnDeskPage().isDisplayed());
    }

    @TestCaseId("RVAT-1084")
    @Test
    public void checkPresentCloseButtonOnDatailsPage_Chrome() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        Assert.assertTrue(page.getCloseButtonOnDeskPage().isDisplayed());
    }

    @TestCaseId("RVAT-1086")
    @Test
    public void checkWorkingCloseButtonOnDatailsPage_Chrome() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        page.getCloseButtonOnDeskPage().click();
        Assert.assertTrue(page.getMapPage().isDisplayed());
    }
}
