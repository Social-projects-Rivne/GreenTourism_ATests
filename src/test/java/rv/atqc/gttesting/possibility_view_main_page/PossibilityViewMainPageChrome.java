package rv.atqc.gttesting.possibility_view_main_page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class PossibilityViewMainPageChrome{

	public WebDriver driver;
	
	@Test
	public void checkExistenceOfTheTitle(){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("https://green-tourism.herokuapp.com/");
		WebElement titleElement = driver.findElement(By.className("parallax-title"));
		Assert.assertTrue(titleElement.isDisplayed());
	}

	@BeforeClass
	public void before(){		
		ChromeDriverManager.getInstance().setup();
		driver=new ChromeDriver();
	}
	
	@AfterClass
	public void afterMethod(){		
		driver.quit();
	}
}
