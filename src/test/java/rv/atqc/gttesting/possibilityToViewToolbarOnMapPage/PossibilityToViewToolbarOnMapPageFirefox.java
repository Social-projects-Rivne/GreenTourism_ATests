package rv.atqc.gttesting.possibilityToViewToolbarOnMapPage;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

@Features("Checking possibility to view toolbar on map page")
@Stories("Firefox browser")
public class PossibilityToViewToolbarOnMapPageFirefox {
    private WebDriver driver;
    private String USER_LOGIN = "test@test.com";
    private String USER_PASSWORD = "Test@123";
    private WebDriverWait wait;
    private final int MAX_WAIT_TIME=10;
    
    @TestCaseId("RVAT-716")
    @Test
    public void checkDefaultValueOfPlacesButtonFirefox() {
        WebElement ValueOfPlacesButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath("//html/body/main/div/place-list/div/div/div[1]/div[1]/a[1]/i")));
        Assert.assertTrue(ValueOfPlacesButton.isDisplayed());
    }
    
    @TestCaseId("RVAT-718")
    @Test
    public void checkDefaultValueOfTracksButtonFirefox() {
        WebElement ValueOfTracksButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='main']/div/place-list/div/div/div[1]/div[1]/a[2]/i")));
        Assert.assertTrue(ValueOfTracksButton.isDisplayed());
    }
    
    @TestCaseId("RVAT-721")
    @Test
    public void checkDefaultValueOfEventsButtonFirefox() {
        WebElement ValueOfEventsButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='main']/div/place-list/div/div/div[1]/div[1]/a[3]/i")));
        Assert.assertTrue(ValueOfEventsButton.isDisplayed());
    }
    
    @TestCaseId("RVAT-724")
    @Test
    public void checkNewItemDropdownListFirefox() {
    	WebElement NewItemDropdownList = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[1]/button")));
        Assert.assertTrue(NewItemDropdownList.isDisplayed());
    }
    
    @TestCaseId("RVAT-728")
    @Test
    public void checkMapTypeDropdownListFirefox() {
        WebElement MapTypeDropdownList = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[2]/button")));
        Assert.assertTrue(MapTypeDropdownList.isDisplayed());
    }
    
    @TestCaseId("RVAT-732")
    @Test
    public void checkCategoriesDropdownListFirefox() {
        WebElement CategoriesDropdownList = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/button")));
        Assert.assertTrue(CategoriesDropdownList.isDisplayed());
    }
    
    @TestCaseId("RVAT-736")
    @Test
    public void checkSearchInputFieldFirefox() {
        WebElement SearchInputField = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='search']/div/input")));
        Assert.assertTrue(SearchInputField.isDisplayed());
    }
    
    @TestCaseId("RVAT-740")
    @Test
    public void checkSearchButtonFirefox() {
        WebElement SearchButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='search']/div/span[1]/button")));
        Assert.assertTrue(SearchButton.isDisplayed());
    }
    
    @TestCaseId("RVAT-743")
    @Test
    public void checkPlacesInLocationButtonFirefox() {
        WebElement PlacesInLocationButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='popularPlaces']")));
        Assert.assertTrue(PlacesInLocationButton.isDisplayed());
    }
    
    @TestCaseId("RVAT-747")
    @Test
    public void checkTracksnLocationButtonFirefox() {
        WebElement TracksInLocationButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='popularTracks']")));
        Assert.assertTrue(TracksInLocationButton.isDisplayed());
    }
    
    @TestCaseId("RVAT-753")
    @Test
    public void checkEventsInLocationButtonFirefox() {
        WebElement EventsInLocationButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='popularEvents']")));
        Assert.assertTrue(EventsInLocationButton.isDisplayed());
    }
    
    @BeforeClass
    public void before() {
        FirefoxDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        driver.get("https://green-tourism.herokuapp.com/#!/");
        clickOnDropdownButton();
        insertLogin(USER_LOGIN);
        insertPassword(USER_PASSWORD);
        clickOnLoginButton();
        clickOnSandwichButton();
        clickOnMapPage();
        wait = new WebDriverWait(driver,MAX_WAIT_TIME);
    }
    
    @AfterClass
    public void afterMethod() {
        driver.close();
    }

    private void clickOnDropdownButton() {
        driver.findElement(By.xpath(".//*[@id='navbar']/ul[1]/li/a/i")).click();
    }

    private void clickOnLoginButton() {
        driver.findElement(By.xpath(".//*[@id='navbar']/ul[1]/li/ul/auth/div[2]/div/form/input")).click();
    }

    private void insertLogin(String login) {
        driver.findElement(By.xpath(".//*[@id='navbar']/ul[1]/li/ul/auth/div[2]/div/form/div[1]/input")).sendKeys(login);
    }
    
    private void insertPassword(String password) {
        driver.findElement(By.xpath(".//*[@id='navbar']/ul[1]/li/ul/auth/div[2]/div/form/div[2]/input")).sendKeys(password);
    }
    
    private void clickOnSandwichButton() {
        driver.findElement(By.xpath("//html/body/header/nav/div/div[2]/ul[2]/li/a/i")).click();
    }
    
    private void clickOnMapPage() {
        driver.findElement(By.xpath("//html/body/header/nav/div/div[2]/ul[2]/li/ul/li[1]/a")).click();
    }

}
