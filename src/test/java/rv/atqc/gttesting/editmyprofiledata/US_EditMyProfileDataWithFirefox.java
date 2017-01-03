package rv.atqc.gttesting.editmyprofiledata;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class US_EditMyProfileDataWithFirefox {

    private WebDriver driver;
    private WebDriverWait wait;
    private final int MAX_WAIT_TIME=10;

    private WebElement dropdownToggle;
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement loginButton;
    private WebElement editButton;

    private By dropdownToggleLocator;
    private By emailFieldLocator;
    private By passwordFieldLocator;
    private By loginButtonLocator;
    private By editButtonLocator;
    private By editFormLocator;

    private final String siteLink = "http://green-tourism.herokuapp.com";
    private final String email = "godwearsgucci@ukr.net";
    private final String password = "22121989";

    @BeforeMethod
    public void setUpDriverAndPreconditions() {
        FirefoxDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,MAX_WAIT_TIME);
        initializeLocators();
        setUpPreconditions();
    }
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
    @Test
    public void verifyNameOfEditButton(){
        editButton = wait.until(ExpectedConditions.presenceOfElementLocated(editButtonLocator));
        Assert.assertTrue(editButton.getText().contains("Edit"));
    }
    @Test
    public void verifyExistenceOfTheEditButton(){
        editButton = wait.until(ExpectedConditions.presenceOfElementLocated(editButtonLocator));
        Assert.assertTrue(editButton.isEnabled());
    }
    @Test
    public void verifyAppearanceOfFormplaceholdersAfterClickingEditButton(){
        editButton = wait.until(ExpectedConditions.presenceOfElementLocated(editButtonLocator));
        editButton.click();
        Assert.assertTrue(isElementDisplayed(editFormLocator));
    }
    public void initializeLocators(){
        dropdownToggleLocator = By.xpath("//*[@id=\"navbar\"]/ul[1]/li/a/i");
        emailFieldLocator = By.xpath("//*[@id=\"navbar\"]/ul[1]/li/ul/auth/div[2]/div/form/div[1]/input");
        passwordFieldLocator = By.xpath("//*[@id=\"navbar\"]/ul[1]/li/ul/auth/div[2]/div/form/div[2]/input");
        loginButtonLocator = By.xpath("//*[@id=\"navbar\"]/ul[1]/li/ul/auth/div[2]/div/form/input");
        editButtonLocator = By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[2]/div[1]/h1/button[1]");
        editFormLocator = By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[2]/div[1]/div[2]/form");
    }
    public void setUpPreconditions(){
        driver.get(siteLink);
        clickDropdownToggle();
        inputEmail(email);
        inputPassword(password);
        clickLoginButton();
    }
    public void clickDropdownToggle(){
        dropdownToggle = wait.until(ExpectedConditions.presenceOfElementLocated(dropdownToggleLocator));
        dropdownToggle.click();
    }
    public void inputEmail(String email){
        emailField = wait.until(ExpectedConditions.presenceOfElementLocated(emailFieldLocator));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void inputPassword(String password){
        passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(passwordFieldLocator));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(loginButtonLocator));
        loginButton.click();
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



