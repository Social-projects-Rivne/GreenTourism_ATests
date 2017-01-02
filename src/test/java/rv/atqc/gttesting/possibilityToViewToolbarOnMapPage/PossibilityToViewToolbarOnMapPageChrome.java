package rv.atqc.gttesting.possibilityToViewToolbarOnMapPage;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class PossibilityToViewToolbarOnMapPageChrome {
    private WebDriver driver;
    private String USER_LOGIN = "test@test.com";
    private String USER_PASSWORD = "Test@123";
    private WebDriverWait wait;
    private final int MAX_WAIT_TIME=10;
    
    @Test
    public void checkDefaultValueOfPlacesButtonChrome() {
        WebElement ValueOfPlacesButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath("//html/body/main/div/place-list/div/div/div[1]/div[1]/a[1]/i")));
        Assert.assertTrue(ValueOfPlacesButton.isDisplayed());
    }
    
    @Test
    public void checkDefaultValueOfTracksButtonChrome() {
        WebElement ValueOfTracksButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='main']/div/place-list/div/div/div[1]/div[1]/a[2]/i")));
        Assert.assertTrue(ValueOfTracksButton.isDisplayed());
    }
    
    @Test
    public void checkDefaultValueOfEventsButtonChrome() {
        WebElement ValueOfEventsButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='main']/div/place-list/div/div/div[1]/div[1]/a[3]/i")));
        Assert.assertTrue(ValueOfEventsButton.isDisplayed());
    }
    
    @Test
    public void checkNewItemDropdownListChrome() {
    	driver.manage().window().maximize();
        WebElement NewItemDropdownList = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='main']/div/place-list/div/div/div[1]/div[3]/div/div[1]/button")));
        Assert.assertTrue(NewItemDropdownList.isDisplayed());
    }
    
  /*  @Test
    public void checkMapTypeDropdownListChrome() {
        WebElement MapTypeDropdownList = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[2]/button")));
        Assert.assertTrue(MapTypeDropdownList.isDisplayed());
    }
    
    @Test
    public void checkCategoriesDropdownListChrome() {
        WebElement CategoriesDropdownList = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/button")));
        Assert.assertTrue(CategoriesDropdownList.isDisplayed());
    }*/
    
    @Test
    public void checkSearchInputFieldChrome() {
        WebElement SearchInputField = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='search']/div/input")));
        Assert.assertTrue(SearchInputField.isDisplayed());
    }
    
    @Test
    public void checkSearchButtonChrome() {
        WebElement SearchButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='search']/div/span[1]/button")));
        Assert.assertTrue(SearchButton.isDisplayed());
    }
    
    @Test
    public void checkPlacesInLocationButtonChrome() {
        WebElement PlacesInLocationButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='popularPlaces']")));
        Assert.assertTrue(PlacesInLocationButton.isDisplayed());
    }
    
    @Test
    public void checkTracksnLocationButtonChrome() {
        WebElement TracksInLocationButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='popularTracks']")));
        Assert.assertTrue(TracksInLocationButton.isDisplayed());
    }
    
    @Test
    public void checkEventsInLocationButtonChrome() {
        WebElement EventsInLocationButton = wait.until(ExpectedConditions.visibilityOfElementLocated 
                (By.xpath(".//*[@id='popularEvents']")));
        Assert.assertTrue(EventsInLocationButton.isDisplayed());
    }
    
    @BeforeClass
    public void beforeClass() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
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
