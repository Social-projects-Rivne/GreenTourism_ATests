package rv.atqc.gttesting.possibility_view_main_page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class PossibilityViewMainPageMozillaFirefox {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private final int MAX_WAIT_TIME=10;
	
	@BeforeClass
	public void before(){
		FirefoxDriverManager.getInstance().setup();
		driver = new FirefoxDriver();
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
	
	@Test
	public void checkPossibilityViewImage1(){
		WebElement imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath("//img[@src='/assets/img/welcome-page/m1.jpg']")));
		Assert.assertTrue(imageElement.isDisplayed());
	}
	
	@Test
	public void checkPossibilityViewImage2(){
		WebElement imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath("//img[@src='/assets/img/welcome-page/m2.jpg']")));
		Assert.assertTrue(imageElement.isDisplayed());
	}
	
	@Test
	public void checkPossibilityViewImage3(){
		WebElement imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath("//img[@src='/assets/img/welcome-page/m3.jpg']")));
		Assert.assertTrue(imageElement.isDisplayed());
	}
	
	@Test
	public void checkPossibilityViewLinkItemFindPlace(){
		WebElement linkItem = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.linkText("Find place")));
		Assert.assertTrue(linkItem.isDisplayed());
	}
	
	@Test
	public void checkPossibilityViewLinkItemPlanYourTrack(){
		WebElement linkItem = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.linkText("Plan your track")));
		Assert.assertTrue(linkItem.isDisplayed());
	}
	
	@Test
	public void checkPossibilityViewLinkItemFunOnEvents(){
		WebElement linkItem = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.linkText("Fun on events")));
		Assert.assertTrue(linkItem.isDisplayed());
	}
	
	@Test
	public void checkPossibilityViewTextBlock1(){
		String TextBlock1xpath="//div[@class='row'][1]/div[@class='col-md-6 "
				                 + "welcome-page-section-text']/p";
		
		WebElement textBlock1 = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath(TextBlock1xpath)));
		Assert.assertTrue(textBlock1.isDisplayed());
	}
}
