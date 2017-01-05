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
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement nicknameField;
    private WebElement phoneNumberField;
    private WebElement addressField;
    private WebElement changeButton;
    private WebElement cancelButton;

    private By dropdownToggleLocator;
    private By emailFieldLocator;
    private By passwordFieldLocator;
    private By loginButtonLocator;
    private By editButtonLocator;
    private By editFormLocator;
    private By firstNameFieldLocator;
    private By lastNameFieldLocator;
    private By changeButtonLocator;
    private By nicknameFieldLocator;
    private By phoneNumberFieldLocator;
    private By addressFieldLocator;
    private By cancelButtonLocator;

    private final String siteLink = "http://green-tourism.herokuapp.com";
    private final String email = "godwearsgucci@ukr.net";
    private final String password = "22121989";
    private final String firstName = "Nick";
    private final String lastName = "Melnyk";
    private final String nicknameWithCharacters = "NICK";

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
        clickEditButton();
        Assert.assertTrue(isElementDisplayed(editFormLocator));
    }
    @Test
    public void verifyEmptyFirstNameAndLastNamePlaceholders(){
        clickEditButton();
        clearFirstNameField();
        clearLastNameField();
        Assert.assertFalse(isElementClickable(changeButtonLocator));
    }
    @Test
    public void verifyFilledFirstNameAndEmptyLastNamePlaceholders(){
        clickEditButton();
        fillFirstNameField(firstName);
        clearLastNameField();
        Assert.assertFalse(isElementClickable(changeButtonLocator));
    }
    @Test
    public void verifyEmptyFirstNameAndFilledLastNamePlaceholders(){
        clickEditButton();
        clearFirstNameField();
        fillLastNameField(lastName);
        Assert.assertFalse(isElementClickable(changeButtonLocator));
    }
    @Test
    public void verifyExistenceOfFirstNamePlaceholder(){
        clickEditButton();
        firstNameField = wait.until(ExpectedConditions.presenceOfElementLocated(firstNameFieldLocator));
        Assert.assertTrue(firstNameField.isEnabled());
    }
    @Test
    public void verifyExistenceOfLastNamePlaceholder(){
        clickEditButton();
        lastNameField = wait.until(ExpectedConditions.presenceOfElementLocated(lastNameFieldLocator));
        Assert.assertTrue(lastNameField.isEnabled());
    }
    @Test
    public void verifyExistenceOfNicknamePlaceholder(){
        clickEditButton();
        nicknameField = wait.until(ExpectedConditions.presenceOfElementLocated(nicknameFieldLocator));
        Assert.assertTrue(nicknameField.isEnabled());
    }
    @Test
    public void verifyExistenceOfPhoneNumberPlaceholder(){
        clickEditButton();
        phoneNumberField = wait.until(ExpectedConditions.presenceOfElementLocated(phoneNumberFieldLocator));
        Assert.assertTrue(phoneNumberField.isEnabled());
    }
    @Test
    public void verifyExistenceOfAddressPlaceholder(){
        clickEditButton();
        addressField = wait.until(ExpectedConditions.presenceOfElementLocated(addressFieldLocator));
        Assert.assertTrue(addressField.isEnabled());
    }
    @Test
    public void VerifyClickThroughRateOfTheEditButton(){
        Assert.assertTrue(isElementClickable(editButtonLocator));
    }
    @Test
    public void verifyExistenceOfTheChangeButton(){
        clickEditButton();
        changeButton = wait.until(ExpectedConditions.presenceOfElementLocated(changeButtonLocator));
        Assert.assertTrue(changeButton.isEnabled());
    }
    @Test
    public void verifyClickThroughRateOfTheChangeButton(){
        clickEditButton();
        Assert.assertTrue(isElementClickable(changeButtonLocator));
    }
    @Test
    public void verifyExistenceOfTheCancelButton(){
        clickEditButton();
        cancelButton = wait.until(ExpectedConditions.presenceOfElementLocated(cancelButtonLocator));
        Assert.assertTrue(cancelButton.isEnabled());
    }
    @Test
    public void VerifyClickThroughRateOfTheCancelButton(){
        clickEditButton();
        Assert.assertTrue(isElementClickable(cancelButtonLocator));
    }
    @Test
    public void verifyNicknamePlaceholderFilledWithCharacters(){
        clickEditButton();
        inputNicknameField(nicknameWithCharacters);
        Assert.assertTrue(isElementClickable(changeButtonLocator));
    }
    public void initializeLocators(){
        dropdownToggleLocator = By.xpath("//*[@id=\"navbar\"]/ul[1]/li/a/i");
        emailFieldLocator = By.xpath("//*[@id=\"navbar\"]/ul[1]/li/ul/auth/div[2]/div/form/div[1]/input");
        passwordFieldLocator = By.xpath("//*[@id=\"navbar\"]/ul[1]/li/ul/auth/div[2]/div/form/div[2]/input");
        loginButtonLocator = By.xpath("//*[@id=\"navbar\"]/ul[1]/li/ul/auth/div[2]/div/form/input");
        editButtonLocator = By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[2]/div[1]/h1/button[1]");
        editFormLocator = By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[2]/div[1]/div[2]/form");
        firstNameFieldLocator = By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[2]/div[1]/div[2]/form/div[1]/div[1]/div/input");
        lastNameFieldLocator = By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[2]/div[1]/div[2]/form/div[1]/div[2]/div/input");
        changeButtonLocator = By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[2]/div[1]/div[2]/form/input");
        nicknameFieldLocator = By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[2]/div[1]/div[2]/form/div[2]/input");
        phoneNumberFieldLocator = By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[2]/div[1]/div[2]/form/div[3]/input");
        addressFieldLocator = By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[2]/div[1]/div[2]/form/div[4]/input");
        cancelButtonLocator = By.xpath("//*[@id=\"main\"]/div/user-profile/div/div/section[2]/div[1]/div[2]/form/button");
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
        loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
        loginButton.click();
    }
    public void clickEditButton(){
        editButton = wait.until(ExpectedConditions.elementToBeClickable(editButtonLocator));
        editButton.click();
    }
    public void clearFirstNameField(){
        firstNameField = wait.until(ExpectedConditions.presenceOfElementLocated(firstNameFieldLocator));
        firstNameField.clear();
    }
    public void clearLastNameField(){
        lastNameField = wait.until(ExpectedConditions.presenceOfElementLocated(lastNameFieldLocator));
        lastNameField.clear();
    }
    public void fillFirstNameField(String firstName){
        clearFirstNameField();
        firstNameField.sendKeys(firstName);
    }
    public void fillLastNameField(String lastName){
        clearLastNameField();
        lastNameField.sendKeys(lastName);
    }
    public void inputNicknameField(String nickname){
        nicknameField = wait.until(ExpectedConditions.presenceOfElementLocated(nicknameFieldLocator));
        nicknameField.clear();
        nicknameField.sendKeys(nickname);
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