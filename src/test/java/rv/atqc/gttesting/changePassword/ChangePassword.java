package rv.atqc.gttesting.changePassword;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePassword {
	
	private static String MAIL = "romanukhaav@gmail.com";
	private static String PASS = "123456789";
	private WebDriver driver;
	
	@BeforeMethod
	public void before() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get("https://green-tourism.herokuapp.com/#!/");
		clickOnLoginMenu();	
		inputEmail(MAIL);
		inputPass(PASS);
		clickOnLoginButton();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
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
	 	 
}