package rv.atqc.gttesting.view_decription_page_of_map_pointer;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rv.atqc.gttesting.archex.MapHeadPageForGuestUserPage;

/**
 * Created by roman on 25.01.17.
 */
public class ViewDecPageMapPointer_Firefox {
    private MapHeadPageForGuestUserPage page;
    private WebDriver driver;

    @BeforeMethod
    public void before() {
        FirefoxDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        driver.get("https://green-tourism.herokuapp.com/#!/places");
        page = new MapHeadPageForGuestUserPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void checkPresentPlasesOnMap_Chrome() {
        Assert.assertTrue(page.getPlasesOnMapChrome().isDisplayed());
    }

    @Test
    public void checkPresentButtonDetailsOnRaiseWindow_Chrome() {
        page.clickOnPlaceButton();
        Assert.assertTrue(page.getDetailsButton().isDisplayed());
    }

    @Test
    public void checkPresentButtonExitOnRaiseWindow_Chrome() {
        page.clickOnPlaceButton();
        Assert.assertTrue(page.getExitButtonOnRaiseWindow().isDisplayed());
    }

    @Test
    public void checkPresentImageOnRaiseWindow_Chrome() {
        page.clickOnPlaceButton();
        Assert.assertTrue(page.getImageOnRaiseWindow().isDisplayed());
    }

//    @Test
//    public void checkPresentsDatailsPage() {
//        page.clickOnPlaceButton();
//        Assert.assertTrue(page.getDetailsPage().isDisplayed());
//    }
}
