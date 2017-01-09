package rv.atqc.gttesting.change_password;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePassCheckChrome {

	private static String MAIL = "romanukhaav@gmail.com";
	private static String PASS = "123456789";
	private static String SHORT_PASS = "123456";
	private WebDriver driver;
	private WebDriverWait wait;
	private final int MAX_WAIT_TIME = 10;
	
	
	@BeforeMethod
	public void before() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://green-tourism.herokuapp.com/#!/");
		wait = new WebDriverWait(driver,MAX_WAIT_TIME);
		clickOnLoginMenu();	
		inputEmail(MAIL);
		inputPass(PASS);
		clickOnLoginButton();
		wait.until(ExpectedConditions.presenceOfElementLocated
					(By.xpath("//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[1]/input")));
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	
	
	@Test
	public void isChangePassMenuPresent() {
		clickOnChangePassButton();
		Assert.assertEquals(getTextFromFildNewPass(), "New password");
	}
	
	@Test
	public void inputShortPasswords() {
		clickOnChangePassButton();
		inputPassField1(SHORT_PASS);
		inputPassField2(SHORT_PASS);
		Assert.assertEquals(getError1Text(), "Password should be longer than 8 characters");	
	}
	
	@Test
	public void inputDifferentPasswords() {
		clickOnChangePassButton();
		inputPassField1(PASS);
		inputPassField2(SHORT_PASS);
		Assert.assertEquals(getError2Text(), "Passwords doesn't match");
	}

	@Test
	public void inputEmptyPasswords() {
		clickOnChangePassButton();
		inputPassField1("");
		inputPassField2("");
		Assert.assertEquals(getError3Text(), "Password required");
	}
			
		  
	private void clickOnLoginMenu() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#navbar > ul:nth-child(1) > li"))).click();
    }
	
	private void inputEmail(String eml) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[1]/input"))).sendKeys(eml);
    }
	
	private void inputPass(String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[2]/input"))).sendKeys(pass);
	}
	
	 private void clickOnLoginButton() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				 "#navbar > ul:nth-child(1) > li > ul > auth > div:nth-child(2) > div > form > input"))).click();
	 }
	 
	 private void clickOnChangePassButton() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				 "#main > div > user-profile > div > div > section.col-sm-9 > div:nth-child(1) > h1 > button:nth-child(2)"))).click();   
	 }									

	 private String getTextFromFildNewPass() {
		 return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				 "//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[1]/input"))).getAttribute("placeholder");
	 }
	   
	 private void inputPassField1(String pass) {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				 "//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[1]/input"))).sendKeys(pass);
	 }
	 
	 private void inputPassField2(String pass) {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				 "//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[2]/input"))).sendKeys(pass);
	 }
	 
	 private String getError1Text() {
		 return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				 "//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[1]/div/p[2]"))).getText();
	 }
	 
	 private String getError2Text() {
		 	clickOnLoginMenu();
		 	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 			"//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[2]/div/p"))).getText();
	 }
	 
	 private String getError3Text() {
		 	clickOnLoginMenu();
		 	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 			"//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[1]/div/p[1]"))).getText();
	 }
}