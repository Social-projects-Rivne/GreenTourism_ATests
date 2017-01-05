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

public class ChangePassSetCrome {

	private static String MAIL = "romanukhaav@i.ua";
	private static String OLD_PASS = "123456789";
	private static String NEW_PASS = "12345678";
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
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}	
	
	@Test
	public void changePassword() {
		logIn(MAIL, OLD_PASS);
		clickOnChangePassButton();
		inputPassField1(NEW_PASS);
		inputPassField2(NEW_PASS);
		clickOnChangeButton();
		Assert.assertEquals(isProfileActive(), "Email:");
	}

	@Test(dependsOnMethods = { "changePassword" })
	public void isNewPasswordLegal() {
		logIn(MAIL, NEW_PASS);

		//return System in previous state
		clickOnChangePassButton();
		inputPassField1(OLD_PASS);
		inputPassField2(OLD_PASS);
		clickOnChangeButton();
		
		Assert.assertEquals(isProfileActive(), "Email:");
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
	   
	private void inputPassField1(String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			"//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[1]/input"))).sendKeys(pass);
	}
	 
	private void inputPassField2(String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[2]/input"))).sendKeys(pass);
	}
	 	 
	private void clickOnChangeButton() { 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/input"))).click();   
	}
	
	private String isProfileActive() {
		 	clickOnLoginMenu();
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	        		"//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[1]/p[1]/strong"))).getText();
	}
	 
	private void logIn(String login, String password){
		 	inputEmail(login);
			inputPass(password);
			clickOnLoginButton();
			wait.until(ExpectedConditions.presenceOfElementLocated
						(By.xpath("//*[@id='main']/div/user-profile/div/div/section[2]/div[1]/div[3]/form/div[1]/input")));
	}
}