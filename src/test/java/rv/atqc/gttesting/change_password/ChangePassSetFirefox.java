package rv.atqc.gttesting.change_password;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.FirefoxDriverManager;


	public class ChangePassSetFirefox {

		private static String MAIL = "romanukhaav@i.ua";
		private static String OLD_PASS = "123456789";
		private static String NEW_PASS = "12345678";
		private WebDriver driver;
		private WebDriverWait wait;
		private final int MAX_WAIT_TIME = 10;
		
		@BeforeMethod
		public void before() {
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
			driver.get("http://green-tourism.herokuapp.com/#!/");
			clickOnLoginMenu();	
		}
		
		@AfterMethod
		public void afterMethod() {
			driver.close();
		}	
		
		@Test
		public void changePassword() {
			logIn(MAIL, OLD_PASS);
			clickOnChangePassButton();
			inputPassFild1(NEW_PASS);
			inputPassFild2(NEW_PASS);
			clickOnChangeButton();
			Assert.assertEquals(isProfileActive(), "Email:");
		}

		@Test(dependsOnMethods = { "changePassword" })
		public void isNewPasswordLegal() {
			logIn(MAIL, NEW_PASS);

			//return System in previous state
			clickOnChangePassButton();
			inputPassFild1(OLD_PASS);
			inputPassFild2(OLD_PASS);
			clickOnChangeButton();
			
			Assert.assertEquals(isProfileActive(), "Email:");
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
		   
		 private void inputPassFild1(String pass) {
		        driver.findElement(By.xpath("//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[1]/input")).sendKeys(pass);
		 }
		 
		 private void inputPassFild2(String pass) {
		        driver.findElement(By.xpath("//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[2]/input")).sendKeys(pass);
		 }
		 	 
		 private void clickOnChangeButton() { 
				driver.findElement(By.xpath("//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/input")).click();   
			 }
		
		 private String isProfileActive() {
			 	clickOnLoginMenu();
		        return driver.findElement(By.xpath("//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[1]/p[1]/strong")).getText();
		 }
		 
		 private void logIn(String login, String password){
			 	inputEmail(login);
				inputPass(password);
				clickOnLoginButton();
				wait = new WebDriverWait(driver,MAX_WAIT_TIME);
				wait.until(ExpectedConditions.presenceOfElementLocated
							(By.xpath("//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[1]/input")));
		 }
}