package rv.atqc.gttesting.filer_places;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class FilterPlacesFirexox {


		private WebDriver driver;
		private WebDriverWait wait;
		private final int MAX_WAIT_TIME=20;
		
		
		private By CampPlace  =  By.xpath("//*[@id='map']/div[1]/div[2]/div[1]/img[2]");
		private By ServicePlace = By.xpath("//*[@id='map']/div[1]/div[2]/div[1]/img[7]");
		private By HostelsPlace = By.xpath("//*[@id='map']/div[1]/div[2]/div[3]/img[5]");
		private By FeaturedPlace = By.xpath("//*[@id='map']/div[1]/div[2]/div[1]/img[27]");
		private By HealthcarePlace = By.xpath("//*[@id='map']/div[1]/div[2]/div[1]/img");
		
		private By CampPlacesFilter  =  By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[1]");
		private By ServicePlacesFilter = By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[2]");
		private By HostelsPlacesFilter = By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[3]");
		private By FeaturedPlacesFilter = By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[4]");
		private By HealthcarePlacesFilter = By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[5]");

		
		@BeforeClass
		public void before(){		
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
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
			setFilters(filter);
			Assert.assertTrue(checkFilter(filter));
		}
		 
		@Test
		public void testFilter02ServicePlaces(){
			short filter [] = {0,1,0,0,0};
			setFilters(filter);
			Assert.assertTrue(checkFilter(filter));
		}	
		
		@Test
		public void testFilter03HostelsPlaces(){
			short filter [] = {0,0,1,0,0};
			setFilters(filter);
			Assert.assertTrue(checkFilter(filter));
		}
		
		
		private void setFilters(short[] filter){
			setPlacesFilter(CampPlacesFilter, filter[0]);
			setPlacesFilter(ServicePlacesFilter, filter[1]);
			setPlacesFilter(HostelsPlacesFilter, filter[2]);
			setPlacesFilter(FeaturedPlacesFilter, filter[3]);
			setPlacesFilter(HealthcarePlacesFilter, filter[4]);		
		}
		
		private boolean checkFilter(short[] filter){
			boolean isVisiableElements = true;
			if (filter[0] == 1){
				isVisiableElements = isVisiableElements && isPlacesDisplayed(CampPlace);
			}
			
			if (filter[1] == 1){
				isVisiableElements = isVisiableElements && isPlacesDisplayed(ServicePlace);
			}
			
			if (filter[2] == 1){
				isVisiableElements = isVisiableElements && isPlacesDisplayed(HostelsPlace);
			}
			
			if (filter[3] == 1){
				isVisiableElements = isVisiableElements && isPlacesDisplayed(FeaturedPlace);
			}
			
			if (filter[4] == 1){
				isVisiableElements = isVisiableElements && isPlacesDisplayed(HealthcarePlace);
			}
			
			return isVisiableElements;
		}
		
		
		private void setPlacesFilter(By element, short select){
			if (select == 1){
				WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
				linkElement.click();
			}		   
		 }

		
		private boolean isPlacesDisplayed(By element){
			WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));   
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(HealthcarePlace));
			CheckAllButton.click();
		}
		
	}