package rv.atqc.gttesting.possibilityToViewPopularPlacesInCurrentLocation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import rv.atqc.gttesting.archex.BigPopularPlacesInLocationPage;
import rv.atqc.gttesting.archex.MapHeadPageForGuestUserPage;
import rv.atqc.gttesting.archex.PopularPlacesInLocationPage;

@Features("Verify possibility to view popular places in current location")
@Stories("Chrome browser")
public class PossibilityViewPopularPlacesInCurrentLocationChrome {

    private WebDriver driver;

    private final String MAP_LINK = "http://green-tourism.herokuapp.com/#!/places";
    private static final String POPULAR_PLACES = "Popular places";
    private final int MAX_WAIT_TIME = 15;

    PopularPlacesInLocationPage popularPlacesInLocationPage;
    BigPopularPlacesInLocationPage bigPopularPlacesInLocationPage;

    @BeforeClass
    public void setUpDriverAndPreconditions() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get(MAP_LINK);
        driver.manage().window().maximize();
        popularPlacesInLocationPage = new MapHeadPageForGuestUserPage(driver)
                .clickPopularPlacesInLocationWithZoomOut();
    }

    @AfterClass
    public void quitDriver(){
        driver.quit();
    }

    @TestCaseId("RVAT-950")
    @Test
    public void verifyExistenceOfPopularPlacesButton(){
        Assert.assertTrue(popularPlacesInLocationPage.getPopularPlacesButton().isEnabled());
    }

    @TestCaseId("RVAT-952")
    @Test (dependsOnMethods = { "verifyExistenceOfPopularPlacesButton" })
    public void verifyDisplayOfPopularPlacesButton(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForVisibilityOfElement(popularPlacesInLocationPage.getPopularPlacesButton(), MAX_WAIT_TIME)
                .getPopularPlacesButton()
                .isDisplayed());
    }

    @TestCaseId("RVAT-954")
    @Test (dependsOnMethods = { "verifyDisplayOfPopularPlacesButton" })
    public void verifyClickThroughRateOfPopularPlacesButton(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForElementToBeClickable(popularPlacesInLocationPage.getPopularPlacesButton(), MAX_WAIT_TIME)
                .getPopularPlacesButton()
                .isEnabled());
    }

    @TestCaseId("RVAT-956")
    @Test (dependsOnMethods = { "verifyClickThroughRateOfPopularPlacesButton" })
    public void verifyExistenceOfPopularPlacesForm(){
        Assert.assertTrue(popularPlacesInLocationPage.getPopularPlacesForm().isEnabled());
    }

    @TestCaseId("RVAT-958")
    @Test (dependsOnMethods = { "verifyExistenceOfPopularPlacesForm" })
    public void verifyDisplayOfPopularPlacesForm(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForVisibilityOfElement(popularPlacesInLocationPage.getPopularPlacesForm(), MAX_WAIT_TIME)
                .getPopularPlacesForm()
                .isDisplayed());
    }

    @TestCaseId("RVAT-960")
    @Test (dependsOnMethods = { "verifyDisplayOfPopularPlacesForm" })
    public void verifyTextOfPopularPlacesButton() {
        Assert.assertTrue(popularPlacesInLocationPage
                .getPopularPlacesButton()
                .getText()
                .contains(POPULAR_PLACES));
    }

    @TestCaseId("RVAT-962")
    @Test (dependsOnMethods = { "verifyDisplayOfPopularPlacesForm" })
    public void verifyTextOfPopularPlacesForm() {
        Assert.assertTrue(popularPlacesInLocationPage
                .getPopularPlacesForm()
                .getText()
                .contains(POPULAR_PLACES));
    }

    @TestCaseId("RVAT-964")
    @Test (dependsOnMethods = { "verifyDisplayOfPopularPlacesForm" })
    public void verifyExistenceOfPopularPlacesFormCloseButton() {
        Assert.assertTrue(popularPlacesInLocationPage.getClosePopularPlacesFormButton().isEnabled());
    }

    @TestCaseId("RVAT-966")
    @Test (dependsOnMethods = { "verifyExistenceOfPopularPlacesFormCloseButton" })
    public void verifyDisplayOfPopularPlacesFormCloseButton() {
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForVisibilityOfElement(popularPlacesInLocationPage
                        .getClosePopularPlacesFormButton(), MAX_WAIT_TIME)
                .getClosePopularPlacesFormButton()
                .isDisplayed());
    }

    @TestCaseId("RVAT-968")
    @Test (dependsOnMethods = { "verifyDisplayOfPopularPlacesFormCloseButton" })
    public void verifyClickThroughRateOfPopularPlacesFormCloseButton(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForElementToBeClickable(popularPlacesInLocationPage
                        .getClosePopularPlacesFormButton(), MAX_WAIT_TIME)
                .getClosePopularPlacesFormButton()
                .isEnabled());
    }

    @TestCaseId("RVAT-970")
    @Test (dependsOnMethods = { "verifyDisplayOfPopularPlacesForm" })
    public void verifyExistenceOfImageInPopularPlacesForm(){
        Assert.assertTrue(popularPlacesInLocationPage.getImageInPopularPlacesForm().isEnabled());
    }

    @TestCaseId("RVAT-972")
    @Test (dependsOnMethods = { "verifyExistenceOfImageInPopularPlacesForm" })
    public void verifyDisplayOfImageInPopularPlacesForm(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForVisibilityOfElement(popularPlacesInLocationPage.getImageInPopularPlacesForm(), MAX_WAIT_TIME)
                .getImageInPopularPlacesForm()
                .isDisplayed());
    }

    @TestCaseId("RVAT-974")
    @Test (dependsOnMethods = { "verifyDisplayOfImageInPopularPlacesForm" })
    public void verifyClickThroughRateOfImageInPopularPlacesForm(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForElementToBeClickable(popularPlacesInLocationPage.getImageInPopularPlacesForm(), MAX_WAIT_TIME)
                .getImageInPopularPlacesForm()
                .isEnabled());
    }

    @BeforeMethod(groups = {POPULAR_PLACES})
    public void placeCursorOverImageInPopularPlacesForm(){
        popularPlacesInLocationPage.placeCursorOverElement(popularPlacesInLocationPage.getImageInPopularPlacesForm());
    }

    @TestCaseId("RVAT-976")
    @Test(groups = {POPULAR_PLACES}, dependsOnMethods = { "verifyClickThroughRateOfImageInPopularPlacesForm" })
    public void verifyExistenceOfPopularPlacesIcon(){
        Assert.assertTrue(popularPlacesInLocationPage.getPopularPlacesIcon().isEnabled());
    }

    @TestCaseId("RVAT-978")
    @Test(groups = {POPULAR_PLACES}, dependsOnMethods = { "verifyExistenceOfPopularPlacesIcon" })
    public void verifyDisplayOfPopularPlacesIcon(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForVisibilityOfElement(popularPlacesInLocationPage.getPopularPlacesIcon(), MAX_WAIT_TIME)
                .getPopularPlacesIcon()
                .isDisplayed());
    }

    @TestCaseId("RVAT-980")
    @Test(groups = {POPULAR_PLACES}, dependsOnMethods = { "verifyDisplayOfPopularPlacesIcon" })
    public void verifyClickThroughRateOfPopularPlacesIcon(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForElementToBeClickable(popularPlacesInLocationPage.getPopularPlacesIcon(), MAX_WAIT_TIME)
                .getPopularPlacesIcon()
                .isEnabled());
    }

    @TestCaseId("RVAT-982")
    @Test(groups = {POPULAR_PLACES}, dependsOnMethods = { "verifyClickThroughRateOfPopularPlacesIcon" })
    public void verifyExistenceOfDetailsButton(){
        popularPlacesInLocationPage.clickPopularPlacesIcon();
        Assert.assertTrue(popularPlacesInLocationPage.getDetailsButton().isEnabled());
    }

    @TestCaseId("RVAT-984")
    @Test(groups = {POPULAR_PLACES}, dependsOnMethods = { "verifyExistenceOfDetailsButton" })
    public void verifyDisplayOfDetailsButton(){
        popularPlacesInLocationPage.clickPopularPlacesIcon();
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForVisibilityOfElement(popularPlacesInLocationPage.getDetailsButton(), MAX_WAIT_TIME)
                .getDetailsButton()
                .isDisplayed());
    }

    @TestCaseId("RVAT-986")
    @Test(groups = {POPULAR_PLACES}, dependsOnMethods = { "verifyDisplayOfDetailsButton" })
    public void verifyClickThroughRateOfDetailsButton(){
        popularPlacesInLocationPage.clickPopularPlacesIcon();
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForElementToBeClickable(popularPlacesInLocationPage.getDetailsButton(), MAX_WAIT_TIME)
                .getDetailsButton()
                .isEnabled());
    }

    @TestCaseId("RVAT-988")
    @Test(groups = {POPULAR_PLACES}, dependsOnMethods = { "verifyClickThroughRateOfDetailsButton" })
    public void verifyHeadersAfterClickingImage(){
        String headerOfPopularPlaceImage = popularPlacesInLocationPage.getImageHeader().getText();
        bigPopularPlacesInLocationPage = popularPlacesInLocationPage.clickImageInPopularPlacesForm();
        String headerOfBigPopularPlacesInLocationPage = bigPopularPlacesInLocationPage.getHeaderOfPage().getText();
        Assert.assertTrue(headerOfPopularPlaceImage.equalsIgnoreCase(headerOfBigPopularPlacesInLocationPage));
    }
}
