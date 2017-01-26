package rv.atqc.gttesting.view_decription_page_of_map_pointer;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rv.atqc.gttesting.archex.MapHeadPageForGuestUserPage;


public class ViewDecPageMapPointer_Chrome {
    private MapHeadPageForGuestUserPage page;
    private WebDriver driver;

    @BeforeMethod
    public void before() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
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

    @Test
    public void checkPresentTitleOnDatailsPage() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        Assert.assertTrue(page.getTitleOnDeskPage().isDisplayed());
    }

    @Test
    public void checkPresentImageOnDatailsPage() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        Assert.assertTrue(page.getTitleOnDeskPage().isDisplayed());
    }

    @Test
    public void checkPresentMapOnDatailsPage() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        Assert.assertTrue(page.getMapOnDeskPage().isDisplayed());
    }

    @Test
    public void checkPresentCloseButtonOnDatailsPage() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        Assert.assertTrue(page.getCloseButtonOnDeskPage().isDisplayed());
    }

    @Test
    public void checkWorkingCloseButtonOnDatailsPage() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        page.getCloseButtonOnDeskPage().click();
        Assert.assertTrue(page.getMapPage().isDisplayed());
    }

    @Test
    public void checkPresentElementsOnDatailsPage() {
        page.clickOnPlaceButton();
        page.getDetailsPage();
        Assert.assertTrue(page.getTitleOnDeskPage().isDisplayed());
        Assert.assertTrue(page.getTitleOnDeskPage().isDisplayed());
        Assert.assertTrue(page.getMapOnDeskPage().isDisplayed());
        Assert.assertTrue(page.getCloseButtonOnDeskPage().isDisplayed());
    }
}
