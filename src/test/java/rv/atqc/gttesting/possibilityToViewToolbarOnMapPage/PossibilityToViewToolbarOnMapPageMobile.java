package rv.atqc.gttesting.possibilityToViewToolbarOnMapPage;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class PossibilityToViewToolbarOnMapPageMobile {
		private WebDriver driver;
    private String USER_LOGIN = "test@test.com";
    private String USER_PASSWORD = "Test@123";
    private String DEVICE_NAME = "Google Nexus 5";
    private WebDriverWait wait;
    private final int MAX_WAIT_TIME=10;
    
    @Test
    public void checkDefaultValueOfPlacesButtonMobile() {
        WebElement ValueOfPlacesButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath("html/body/main/div/place-list/div/div/div[1]/div[1]/a[1]/i")));
        Assert.assertTrue(ValueOfPlacesButton.isDisplayed());
    }
    
    @Test
    public void checkDefaultValueOfTracksButtonMobile() {
        WebElement ValueOfTracksButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath("html/body/main/div/place-list/div/div/div[1]/div[1]/a[2]/i")));
        Assert.assertTrue(ValueOfTracksButton.isDisplayed());
    }
    
    @Test
    public void checkDefaultValueOfEventsButtonMobile() {
        WebElement ValueOfEventsButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath("html/body/main/div/place-list/div/div/div[1]/div[1]/a[3]/i")));
        Assert.assertTrue(ValueOfEventsButton.isDisplayed());
    }
      
    @Test
    public void checkMapTypeDropdownListMobile() {
        WebElement MapTypeDropdownList = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath("html/body/main/div/place-list/div/div/div[1]/div[3]/div/div[2]/button")));
        Assert.assertTrue(MapTypeDropdownList.isDisplayed());
    }
    
    @Test
    public void checkPlacesDropdownListMobile() {
        WebElement PlacesDropdownList = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath("html/body/main/div/place-list/div/div/div[1]/div[3]/div/div[3]/button")));
        Assert.assertTrue(PlacesDropdownList.isDisplayed());
    }
    
    @Test
    public void checkTracksDropdownListMobile() {
        WebElement TracksDropdownList = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath("html/body/main/div/place-list/div/div/div[1]/div[3]/div/div[4]/button")));
        Assert.assertTrue(TracksDropdownList.isDisplayed());
    }
    
    @Test
    public void checkEventsDropdownListMobile() {
        WebElement EventsDropdownList = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath("html/body/main/div/place-list/div/div/div[1]/div[3]/div/div[5]/button")));
        Assert.assertTrue(EventsDropdownList.isDisplayed());
    }
    
    @Test
    public void checkSearchInputFieldMobile() {
        WebElement SearchInputField = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath("html/body/main/div/place-list/div/div/div[1]/div[4]/search-place/div/div/input")));
        Assert.assertTrue(SearchInputField.isDisplayed());
    }
    
    @Test
    public void checkSearchButtonMobile() {
        WebElement SearchButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath("html/body/main/div/place-list/div/div/div[1]/div[4]/search-place/div/div/span[1]/button")));
        Assert.assertTrue(SearchButton.isDisplayed());
    }
    
    @Test
    public void checkPlacesInLocationButtonMobile() {
        WebElement PlacesInLocationButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath("html/body/main/div/place-list/div/div/div[1]/div[5]/div/a[1]/i")));
        Assert.assertTrue(PlacesInLocationButton.isDisplayed());
    }
    
    @Test
    public void checkTracksnLocationButtonMobile() {
        WebElement TracksInLocationButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath("html/body/main/div/place-list/div/div/div[1]/div[5]/div/a[2]/i")));
        Assert.assertTrue(TracksInLocationButton.isDisplayed());
    }
    
    @Test
    public void checkEventsInLocationButtonMobile() {
        WebElement EventsInLocationButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath("html/body/main/div/place-list/div/div/div[1]/div[5]/div/a[3]/i")));
        Assert.assertTrue(EventsInLocationButton.isDisplayed());
    }
    
	@BeforeClass
    public void beforeClass() {
		ChromeDriverManager.getInstance().setup();
		Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", DEVICE_NAME);
         Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("mobileEmulation", mobileEmulation);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new ChromeDriver(capabilities);
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
        driver.findElement(By.xpath("html/body/header/nav/div/div[1]/ul[1]/li/a/i")).click();
    }

    private void clickOnLoginButton() {
        driver.findElement(By.xpath("html/body/header/nav/div/div[1]/ul[1]/li/ul/auth/div[2]/div/form/input")).click();
    }

    private void insertLogin(String login) {
        driver.findElement(By.xpath("html/body/header/nav/div/div[1]/ul[1]/li/ul/auth/div[2]/div/form/div[1]/input")).sendKeys(login);
    }
    
    private void insertPassword(String password) {
        driver.findElement(By.xpath("html/body/header/nav/div/div[1]/ul[1]/li/ul/auth/div[2]/div/form/div[2]/input")).sendKeys(password);
    }
    
    private void clickOnSandwichButton() {
        driver.findElement(By.xpath("html/body/header/nav/div/div[1]/ul[2]/li/a/i")).click();
    }
    
    private void clickOnMapPage() {
        driver.findElement(By.xpath("html/body/header/nav/div/div[1]/ul[2]/li/ul/li[1]/a")).click();
    }

}
