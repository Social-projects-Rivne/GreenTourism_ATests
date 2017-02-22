package rv.atqc.gttesting.EffectiveLocators;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class ClassAbsoluteXPath {

        private WebDriver driver;
        private WebDriverWait wait;
        private final int MAX_WAIT_TIME=10;

        private WebElement categoriesDropdownList;
        private WebElement eventsDropdownList;
        private WebElement eventsName;
        private WebElement gamePlaceFilter;
        private WebElement festivalPlaceFilter;
        private WebElement meetingPlaceFilter;
        private WebElement gamePlaceFilterName;
        private WebElement festivalPlaceFilterName;
        private WebElement meetingPlaceFilterName;

        private By categoriesLocator =
                By.xpath("/html/body/main/div/place-list/div/div/div/div[2]/div/div[3]/button");
        private By eventsLocator =
                By.xpath("/html/body/main/div/place-list/div/div/div/div[2]/div/div[3]/ul/li[3]");
        private By eventsNameLocator =
                By.xpath("/html/body/main/div/place-list/div/div/div/div[2]/div/div[3]/ul/li[3]/a");
        private By gamePlaceFilterLocator =
                By.xpath("/html/body/main/div/place-list/div/div/div/div[2]/div/div[3]/ul/li[3]/ul/li");
        private By festivalPlaceFilterLocator =
                By.xpath("/html/body/main/div/place-list/div/div/div/div[2]/div/div[3]/ul/li[3]/ul/li[2]");
        private By meetingPlaceFilterLocator =
                By.xpath("/html/body/main/div/place-list/div/div/div/div[2]/div/div[3]/ul/li[3]/ul/li[3]");
        private By gamePlaceFilterNameLocator =
                By.xpath("/html/body/main/div/place-list/div/div/div/div[2]/div/div[3]/ul/li[3]/ul/li/a");
        private By festivalPlaceFilterNameLocator =
                By.xpath("/html/body/main/div/place-list/div/div/div/div[2]/div/div[3]/ul/li[3]/ul/li[2]/a");
        private By meetingPlaceFilterNameLocator =
                By.xpath("/html/body/main/div/place-list/div/div/div/div[2]/div/div[3]/ul/li[3]/ul/li[3]/a");
        private By gameGreenIconLocator = By.xpath("//img[contains(@src,'assets/img/events/marker/green.png')]");
        private By festivalRedIconLocator = By.xpath("//img[contains(@src,'assets/img/events/marker/red.png')]");
        private By meetingBlueIconLocator = By.xpath("//img[contains(@src,'assets/img/events/marker/blue.png')]");

        private final String mapLink = "http://green-tourism.herokuapp.com/#!/places";

        @BeforeClass
        public void setUpDriverAndPreconditions() {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver,MAX_WAIT_TIME);
            setUpPreconditions();
        }
        @AfterClass
        public void quitDriver(){
            driver.quit();
        }
        @Test
        public void verifyExistenceOfEventsDropdownList(){
            Assert.assertTrue(isElementEnabled(eventsDropdownList), "This element doesn't exist");
        }
        @Test
        public void verifyTitleOfEventsDropdownList(){
            eventsName = wait.until(ExpectedConditions.presenceOfElementLocated(eventsNameLocator));
            Assert.assertTrue(eventsName.getText().equalsIgnoreCase("Events"));
        }
        @Test
        public void verifyExistenceOfPlaceFilterGame(){
            gamePlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(gamePlaceFilterLocator));
            Assert.assertTrue(isElementEnabled(gamePlaceFilter), "This element doesn't exist");
        }
        @Test
        public void verifyExistenceOfPlaceFilterFestival(){
            festivalPlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(festivalPlaceFilterLocator));
            Assert.assertTrue(isElementEnabled(festivalPlaceFilter), "This element doesn't exist");
        }
        @Test
        public void verifyExistenceOfPlaceFilterMeeting(){
            meetingPlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(meetingPlaceFilterLocator));
            Assert.assertTrue(isElementEnabled(meetingPlaceFilter), "This element doesn't exist");
        }
        @Test
        public void verifyTitleOfPlaceFilterGame(){
            gamePlaceFilterName = wait.until(ExpectedConditions.presenceOfElementLocated(gamePlaceFilterNameLocator));
            Assert.assertTrue(gamePlaceFilterName.getText().contains("Game"));
        }
        @Test
        public void verifyTitleOfPlaceFilterFestival(){
            festivalPlaceFilterName = wait.until(ExpectedConditions.presenceOfElementLocated(festivalPlaceFilterNameLocator));
            Assert.assertTrue(festivalPlaceFilterName.getText().contains("Festival"));
        }
        @Test
        public void verifyTitleOfPlaceFilterMeeting(){
            meetingPlaceFilterName = wait.until(ExpectedConditions.presenceOfElementLocated(meetingPlaceFilterNameLocator));
            Assert.assertTrue(meetingPlaceFilterName.getText().contains("Meeting"));
        }
        @Test
        public void verifyClickThroughRateOfPlaceFilterGame(){
            Assert.assertTrue(isElementClickable(gamePlaceFilterNameLocator));
        }
        @Test
        public void verifyClickThroughRateOfPlaceFilterFestival(){
            Assert.assertTrue(isElementClickable(festivalPlaceFilterNameLocator));
        }
        @Test
        public void verifyClickThroughRateOfPlaceFilterMeeting(){
            Assert.assertTrue(isElementClickable(meetingPlaceFilterNameLocator));
        }
        @Test
        public void verifyDisplayOfGameGreenIconOnMap(){
            gamePlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(gamePlaceFilterNameLocator));
            gamePlaceFilter.click();
            Assert.assertTrue(isElementDisplayed(gameGreenIconLocator));
        }
        @Test
        public void verifyDisplayOfFestivalRedIconOnMap(){
            festivalPlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(festivalPlaceFilterNameLocator));
            festivalPlaceFilter.click();
            Assert.assertTrue(isElementDisplayed(festivalRedIconLocator));
        }
        @Test
        public void verifyDisplayOfMeetingBlueIconOnMap(){
            meetingPlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(meetingPlaceFilterNameLocator));
            meetingPlaceFilter.click();
            Assert.assertTrue(isElementDisplayed(meetingBlueIconLocator));
        }
        @Test
        public void verifyClickThroughRateOfGameIcon(){
            gamePlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(gamePlaceFilterNameLocator));
            gamePlaceFilter.click();
            Assert.assertTrue(isElementClickable(gameGreenIconLocator));
        }
        @Test
        public void verifyClickThroughRateOfFestivalIcon(){
            festivalPlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(festivalPlaceFilterNameLocator));
            festivalPlaceFilter.click();
            Assert.assertTrue(isElementClickable(festivalRedIconLocator));
        }
        @Test
        public void verifyClickThroughRateOfMeetingIcon(){
            meetingPlaceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(meetingPlaceFilterNameLocator));
            meetingPlaceFilter.click();
            Assert.assertTrue(isElementClickable(meetingBlueIconLocator));
        }

        public void setUpPreconditions(){
            driver.get(mapLink);
            categoriesDropdownList = wait.until(ExpectedConditions.presenceOfElementLocated(categoriesLocator));
            categoriesDropdownList.click();
            eventsDropdownList = wait.until(ExpectedConditions.presenceOfElementLocated(eventsLocator));
            eventsDropdownList.click();
        }
        public boolean isElementEnabled(WebElement element){
            return element.isEnabled();
        }
        public boolean isElementClickable(By locator){
            try{
                WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
                return clickableElement != null;
            }
            catch(Exception exception){
                return false;
            }
        }
        public boolean isElementDisplayed(By locator){
            try {
                WebElement displayedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                return displayedElement.isDisplayed();
            }
            catch(Exception exception){
                return false;
            }
        }
}

