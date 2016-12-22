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
	
	
}
