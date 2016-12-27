package rv.atqc.gttesting.filer_places;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class FilterPlacesChrome{

	private WebDriver driver;
	private WebDriverWait wait;
	private final int MAX_WAIT_TIME=100;
	  
	@BeforeClass
	public void before(){		
		ChromeDriverManager.getInstance().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://green-tourism.herokuapp.com/#!/places");
		wait = new WebDriverWait(driver,MAX_WAIT_TIME);
		openCategoryPlaces();
	}
	
	@AfterClass
	public void afterMethod(){		
		driver.quit();
	}
	
	@Test
	public void testFilter01CampPlaces(){
		short filter [] = {1,0,0,0,0};
		setFilter(filter);
		Assert.assertTrue(checkFilter(filter));
	}
	
	
	
	private void setFilter(short[] filter){
		setCampPlacesFilter(filter[0]);
		setServicePlacesFilter(filter[1]);
		setHostelsPlacesFilter(filter[2]);
		setFeaturedPlacesFilter(filter[3]);
		setHealthcarePlacesFilter(filter[4]);		
	}
	
	private boolean checkFilter(short[] filter){
		boolean isVisiableElements = true;
		if (filter[0] == 1){
			isVisiableElements = isVisiableElements && isCampPlacesDisplayed();
		}
		
		if (filter[1] == 1){
			isVisiableElements = isVisiableElements && isServicePlacesDisplayed();
		}
		
		if (filter[2] == 1){
			isVisiableElements = isVisiableElements && isHostelsPlacesDisplayed();
		}
		
		if (filter[3] == 1){
			isVisiableElements = isVisiableElements && isFeaturedPlacesDisplayed();
		}
		
		if (filter[4] == 1){
			isVisiableElements = isVisiableElements && isHealthcarePlacesDisplayed();
		}
		
		return isVisiableElements;
	}
	
	
	private void setCampPlacesFilter(short select){
		if (select == 1){
			WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[1]")));
			linkElement.click();
		}		   
	 }

	private void setServicePlacesFilter(short select){
		if (select == 1){
			WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[2]")));
			linkElement.click();
		}		   
	 }
	
	private void setHostelsPlacesFilter(short select){
		if (select == 1){
			WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[3]")));
			linkElement.click();
		}		   
	 }
	
	private void setFeaturedPlacesFilter(short select){
		if (select == 1){
			WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[4]")));
			linkElement.click();
		}		   
	 }
	
	private void setHealthcarePlacesFilter(short select){
		if (select == 1){
			WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[5]")));
			linkElement.click();
		}		   
	 }
	
	private boolean isCampPlacesDisplayed(){
		WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
               (By.xpath("//*[@id='map']/div[1]/div[2]/div[1]/img[2]")));
		return linkElement.isDisplayed();
	}
	
	private boolean isServicePlacesDisplayed(){
		WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
               (By.xpath("//*[@id='map']/div[1]/div[2]/div[1]/img[7]")));
		return linkElement.isDisplayed();
	}
	
	private boolean isHostelsPlacesDisplayed(){
		WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//*[@id='map']/div[1]/div[2]/div[3]/img[5]")));
		return linkElement.isDisplayed();
	}
	
	private boolean isFeaturedPlacesDisplayed(){
		WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//*[@id='map']/div[1]/div[2]/div[1]/img[27]")));
		return linkElement.isDisplayed();
	}
	
	private boolean isHealthcarePlacesDisplayed(){
		WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//*[@id='map']/div[1]/div[2]/div[1]/img")));
		
		return linkElement.isDisplayed();
	}
	
	private void openCategoryPlaces(){
		WebElement CategoriesButton = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/button")));
		CategoriesButton.click();		
		
		WebElement PlacesButton = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]")));
		Actions builder = new Actions(driver);
		builder.moveToElement(PlacesButton).perform();
		
		//deselect all places
		WebElement CheckAllButton = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[6]")));
		CheckAllButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='map']/div[1]/div[2]/div[1]/img[27]")));
		CheckAllButton.click();
	}
	
}