package rv.atqc.gttesting.possibility_view_main_page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class PossibilityViewMainPageChrome{

	private WebDriver driver;
	private WebDriverWait wait;
	private final int MAX_WAIT_TIME=10;
	
	@BeforeClass
	public void before(){		
		ChromeDriverManager.getInstance().setup();
		driver=new ChromeDriver();
		driver.get("https://green-tourism.herokuapp.com/");
		wait = new WebDriverWait(driver,MAX_WAIT_TIME);
	}
	
	@AfterClass
	public void afterMethod(){		
		driver.quit();
	}
	
	@Test
	public void checkPossibilityViewTheTitle(){
		WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated 
				                            (By.xpath("//h2[text()='Find. Plan. Travel']")));
		Assert.assertTrue(titleElement.isDisplayed());
	}
	
	@Test
	public void checkPossibilityViewMenuItem(){
		WebElement menuElement = wait.until(ExpectedConditions.visibilityOfElementLocated
					                       (By.xpath("//div[@id='navbar']//i[@class='fa fa-bars navtop']")));
		Assert.assertTrue(menuElement.isDisplayed());
	}
	
	@Test
	public void checkPossibilityViewLoginOrSignupItem(){
		WebElement loginOrSignupItem = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath("//div[@id='navbar']//i[@class='fa fa-user navtop']")));
		Assert.assertTrue(loginOrSignupItem.isDisplayed());
	}
	
	@Test
	public void checkPossibilityViewGreenTourismLink1(){
		WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath("//div[@class='hidden-xs logo']")));
		Assert.assertTrue(linkElement.isDisplayed());
	}
	
	@Test
	public void checkPossibilityViewNavigationItem(){
		WebElement navigationItem = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath("//i[@class='fa fa-angle-down']")));
		Assert.assertTrue(navigationItem.isDisplayed());
	}
	
	@Test
	public void checkPossibilityViewElementWithBackgroundImage(){
		WebElement backgroundImageElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath("//div[@class='parallax hidden-xs hidden-sm']")));
		Assert.assertTrue(backgroundImageElement.isDisplayed());
	}
}
