package rv.atqc.gttesting.possibilityToViewPopularPlacesInCurrentLocation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import rv.atqc.gttesting.archex.BigPopularPlacesInLocationPage;
import rv.atqc.gttesting.archex.MapHeadPageForGuestUserPage;
import rv.atqc.gttesting.archex.PopularPlacesInLocationPage;

public class PossibilityViewPopularPlacesInCurrentLocationChrome {

    private WebDriver driver;

    private final String MAP_LINK = "http://green-tourism.herokuapp.com/#!/places";
    private static final String POPULAR_PLACES = "Popular places";
    private final int MAX_WAIT_TIME = 20;

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
    @Test
    public void verifyExistenceOfPopularPlacesButton(){
        Assert.assertTrue(popularPlacesInLocationPage.getPopularPlacesButton().isEnabled());
    }
    @Test (dependsOnMethods = { "verifyExistenceOfPopularPlacesButton" })
    public void verifyDisplayOfPopularPlacesButton(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForVisibilityOfElement(popularPlacesInLocationPage.getPopularPlacesButton(), MAX_WAIT_TIME)
                .getPopularPlacesButton().isDisplayed());
    }
    @Test (dependsOnMethods = { "verifyDisplayOfPopularPlacesButton" })
    public void verifyClickThroughRateOfPopularPlacesButton(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForElementToBeClickable(popularPlacesInLocationPage.getPopularPlacesButton(), MAX_WAIT_TIME)
                .getPopularPlacesButton().isEnabled());
    }
    @Test (dependsOnMethods = { "verifyClickThroughRateOfPopularPlacesButton" })
    public void verifyExistenceOfPopularPlacesForm(){
        Assert.assertTrue(popularPlacesInLocationPage.getPopularPlacesForm().isEnabled());
    }
    @Test (dependsOnMethods = { "verifyExistenceOfPopularPlacesForm" })
    public void verifyDisplayOfPopularPlacesForm(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForVisibilityOfElement(popularPlacesInLocationPage.getPopularPlacesForm(), MAX_WAIT_TIME)
                .getPopularPlacesForm().isDisplayed());
    }
    @Test (dependsOnMethods = { "verifyDisplayOfPopularPlacesForm" })
    public void verifyTextOfPopularPlacesButton() {
        Assert.assertTrue(popularPlacesInLocationPage.getPopularPlacesButton().getText().contains(POPULAR_PLACES));
    }
    @Test (dependsOnMethods = { "verifyDisplayOfPopularPlacesForm" })
    public void verifyTextOfPopularPlacesForm() {
        Assert.assertTrue(popularPlacesInLocationPage.getPopularPlacesForm().getText().contains(POPULAR_PLACES));
    }
    @Test (dependsOnMethods = { "verifyDisplayOfPopularPlacesForm" })
    public void verifyExistenceOfPopularPlacesFormCloseButton() {
        Assert.assertTrue(popularPlacesInLocationPage.getClosePopularPlacesFormButton().isEnabled());
    }
    @Test (dependsOnMethods = { "verifyExistenceOfPopularPlacesFormCloseButton" })
    public void verifyDisplayOfPopularPlacesFormCloseButton() {
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForVisibilityOfElement(popularPlacesInLocationPage.getClosePopularPlacesFormButton(), MAX_WAIT_TIME)
                .getClosePopularPlacesFormButton().isDisplayed());
    }
    @Test (dependsOnMethods = { "verifyDisplayOfPopularPlacesFormCloseButton" })
    public void verifyClickThroughRateOfPopularPlacesFormCloseButton(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForElementToBeClickable(popularPlacesInLocationPage.getClosePopularPlacesFormButton(), MAX_WAIT_TIME)
                .getClosePopularPlacesFormButton().isEnabled());
    }
    @Test (dependsOnMethods = { "verifyDisplayOfPopularPlacesForm" })
    public void verifyExistenceOfImageInPopularPlacesForm(){
        Assert.assertTrue(popularPlacesInLocationPage.getImageInPopularPlacesForm().isEnabled());
    }
    @Test (dependsOnMethods = { "verifyExistenceOfImageInPopularPlacesForm" })
    public void verifyDisplayOfImageInPopularPlacesForm(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForVisibilityOfElement(popularPlacesInLocationPage.getImageInPopularPlacesForm(), MAX_WAIT_TIME)
                .getImageInPopularPlacesForm().isDisplayed());
    }
    @Test (dependsOnMethods = { "verifyDisplayOfImageInPopularPlacesForm" })
    public void verifyClickThroughRateOfImageInPopularPlacesForm(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForElementToBeClickable(popularPlacesInLocationPage.getImageInPopularPlacesForm(), MAX_WAIT_TIME)
                .getImageInPopularPlacesForm().isEnabled());
    }
    @BeforeMethod(groups = {POPULAR_PLACES})
    public void placeCursorOverImageInPopularPlacesForm(){
        Actions actions = new Actions(driver);
        actions.moveToElement(popularPlacesInLocationPage.getImageInPopularPlacesForm()).build().perform();
    }
    @Test(groups = {POPULAR_PLACES}, dependsOnMethods = { "verifyClickThroughRateOfImageInPopularPlacesForm" })
    public void verifyExistenceOfPopularPlacesIcon(){
        Assert.assertTrue(popularPlacesInLocationPage.getPopularPlacesIcon().isEnabled());
    }
    @Test(groups = {POPULAR_PLACES}, dependsOnMethods = { "verifyExistenceOfPopularPlacesIcon" })
    public void verifyDisplayOfPopularPlacesIcon(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForVisibilityOfElement(popularPlacesInLocationPage.getPopularPlacesIcon(), MAX_WAIT_TIME)
                .getPopularPlacesIcon().isDisplayed());
    }
    @Test(groups = {POPULAR_PLACES}, dependsOnMethods = { "verifyDisplayOfPopularPlacesIcon" })
    public void verifyClickThroughRateOfPopularPlacesIcon(){
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForElementToBeClickable(popularPlacesInLocationPage.getPopularPlacesIcon(), MAX_WAIT_TIME)
                .getPopularPlacesIcon().isEnabled());
    }
    @Test(groups = {POPULAR_PLACES}, dependsOnMethods = { "verifyClickThroughRateOfPopularPlacesIcon" })
    public void verifyExistenceOfDetailsButton(){
        popularPlacesInLocationPage.clickPopularPlacesIcon();
        Assert.assertTrue(popularPlacesInLocationPage.getDetailsButton().isEnabled());
    }
    @Test(groups = {POPULAR_PLACES}, dependsOnMethods = { "verifyExistenceOfDetailsButton" })
    public void verifyDisplayOfDetailsButton(){
        popularPlacesInLocationPage.clickPopularPlacesIcon();
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForVisibilityOfElement(popularPlacesInLocationPage.getDetailsButton(), MAX_WAIT_TIME)
                .getDetailsButton().isDisplayed());
    }
    @Test(groups = {POPULAR_PLACES}, dependsOnMethods = { "verifyDisplayOfDetailsButton" })
    public void verifyClickThroughRateOfDetailsButton(){
        popularPlacesInLocationPage.clickPopularPlacesIcon();
        Assert.assertTrue(popularPlacesInLocationPage
                .waitForElementToBeClickable(popularPlacesInLocationPage.getDetailsButton(), MAX_WAIT_TIME)
                .getDetailsButton().isEnabled());
    }
    @Test(groups = {POPULAR_PLACES}, dependsOnMethods = { "verifyClickThroughRateOfDetailsButton" })
    public void verifyHeadersAfterClickingDetailsButton(){
        popularPlacesInLocationPage.clickPopularPlacesIcon();
        String headerOfPopularPlaceIcon = popularPlacesInLocationPage
                .getDetailsWindowHeader().getText();
        System.out.println("header " + headerOfPopularPlaceIcon);
        bigPopularPlacesInLocationPage = popularPlacesInLocationPage.clickDetailsButton();
        String headerOfBigPopularPlacesInLocationPage = bigPopularPlacesInLocationPage
                .getHeaderOfPage().getText();
        System.out.println(headerOfBigPopularPlacesInLocationPage);

        Assert.assertTrue(headerOfPopularPlaceIcon.equalsIgnoreCase(headerOfBigPopularPlacesInLocationPage));
    }
}
