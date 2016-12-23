package rv.atqc.gttesting.changePassword;

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

public class ChangePassword {

	private static String MAIL = "romanukhaav@gmail.com";
	private static String MAIL2 = "romanukhaav@i.ua";
	private static String OLD_PASS = "123456789";
	private static String SHORT_PASS = "123456";
	private static String NEW_PASS = "12345678";
	private WebDriver driver;
	private WebDriverWait wait;
	private final int MAX_WAIT_TIME = 10;
	
	
	@BeforeMethod (groups = "static_password")
	public void before() {
		preconditions(MAIL, OLD_PASS);
	}
	
	@AfterMethod (groups = "static_password" + "change_password")
	public void afterMethod() {
		driver.close();
	}
	
	
	@Test (groups = "static_password") 
	public void isChangePassMenuPresent() {
		clickOnChangePassButton();
		Assert.assertEquals(getTextFromFildNewPass(), "New password");
	}
	
	
	@Test(groups = "static_password", dependsOnMethods = { "isChangePassMenuPresent" })
	public void inputShortPasswords() {
		clickOnChangePassButton();
		inputPassFild1(SHORT_PASS);
		inputPassFild2(SHORT_PASS);
		Assert.assertEquals(getErrorText(), "Password should be longer than 8 characters");	
	}
	
	
	@Test(groups = "static_password", dependsOnMethods = { "isChangePassMenuPresent" })
	public void inputDifferentPasswords() {
		clickOnChangePassButton();
		inputPassFild1(NEW_PASS);
		inputPassFild2(SHORT_PASS);
		Assert.assertEquals(getError2Text(), "Passwords doesn't match");
	}
	
	
	@BeforeMethod (groups = "change_password")
	public void beforeChangPass() {
		preconditions(MAIL2, OLD_PASS);		
	}
	
	
	@Test (groups = "change_password")
	public void changePassword() {
		clickOnChangePassButton();
		inputPassFild1(NEW_PASS);
		inputPassFild2(NEW_PASS);
		clickOnChangeButton();
		Assert.assertEquals(isProfileActive(), "Email:");
	}

	
	
	private void preconditions(String login, String password){
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
			driver.get("https://green-tourism.herokuapp.com/#!/");
			clickOnLoginMenu();	
			inputEmail(login);
			inputPass(password);
			clickOnLoginButton();
			wait = new WebDriverWait(driver,MAX_WAIT_TIME);
			wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath("//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[1]/input")));
	}
		  
	private void clickOnLoginMenu() {
        driver.findElement(By.cssSelector("#navbar > ul:nth-child(1) > li")).click();
    }
	
	private void inputEmail(String eml) {
		 driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[1]/input")).sendKeys(eml);
    }
	
	private void inputPass(String pass) {
		driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul[1]/li/ul/auth/div[2]/div/form/div[2]/input")).sendKeys(pass);
	}
	
	 private void clickOnLoginButton() {
	    driver.findElement(By.cssSelector("#navbar > ul:nth-child(1) > li > ul > auth > div:nth-child(2) > div > form > input")).click();
	 }
	 
	 private void clickOnChangePassButton() { 
		driver.findElement(By.cssSelector("#main > div > user-profile > div > div > section.col-sm-9 > div:nth-child(1) > h1 > button:nth-child(2)")).click();   
	 }									

	 private String getTextFromFildNewPass() {
	        return driver.findElement(By.xpath("//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[1]/input")).getAttribute("placeholder");
	 }
	 
	 private void inputPassFild1(String pass) {
	        driver.findElement(By.xpath("//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[1]/input")).sendKeys(pass);
	 }
	 
	 private void inputPassFild2(String pass) {
	        driver.findElement(By.xpath("//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[2]/input")).sendKeys(pass);
	 }
	 
	 private String getErrorText() {
	        return driver.findElement(By.xpath("//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[1]/div/p[2]")).getText();
	 }
	 
	 private String getError2Text() {
		 	clickOnLoginMenu();
	        return driver.findElement(By.xpath("//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[2]/div/p")).getText();
	 }
	 	 
	 private void clickOnChangeButton() { 
			driver.findElement(By.xpath("//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/input")).click();   
		 }
	
	 private String isProfileActive() {
		 	clickOnLoginMenu();
	        return driver.findElement(By.xpath("//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[1]/p[1]/strong")).getText();
	 }

}