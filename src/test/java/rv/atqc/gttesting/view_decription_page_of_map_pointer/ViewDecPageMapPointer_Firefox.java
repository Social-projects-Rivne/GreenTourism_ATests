package rv.atqc.gttesting.view_decription_page_of_map_pointer;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rv.atqc.gttesting.archex.MapHeadPageForGuestUserPage;

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
    public void checkPresentPlasesOnMap_Firefox() {
        Assert.assertTrue(page.getPlasesOnMapChrome().isDisplayed());
    }

    @Test
    public void checkPresentButtonDetailsOnRaiseWindow_Firefox() {
        page.clickOnPlaceButton();
        Assert.assertTrue(page.getDetailsButton().isDisplayed());
    }

    @Test
    public void checkPresentTitleOnDatailsPage_Firefox() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        Assert.assertTrue(page.getTitleOnDeskPage().isDisplayed());
    }

    @Test
    public void checkPresentImageOnDatailsPage_Firefox() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        Assert.assertTrue(page.getImageOnDeskPage().isDisplayed());
    }

    @Test
    public void checkPresentMapOnDatailsPage_Firefox() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        Assert.assertTrue(page.getMapOnDeskPage().isDisplayed());
    }

    @Test
    public void checkPresentCloseButtonOnDatailsPage_Firefox() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        Assert.assertTrue(page.getCloseButtonOnDeskPage().isDisplayed());
    }

    @Test
    public void checkWorkingCloseButtonOnDatailsPage_Firefox() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        page.getCloseButtonOnDeskPage().click();
        Assert.assertTrue(page.getMapPage().isDisplayed());
    }
}
