package rv.atqc.gttesting.filer_places;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class FilterPlacesChrome{

	private WebDriver driver;
	private WebDriverWait wait;
	private final int MAX_WAIT_TIME=20;

	private By CampPlace  =  By.xpath("//*[@id='map']/div[1]/div[2]/div[1]/img[1]");
	private By ServicePlace = By.xpath("//*[@id='map']/div[1]/div[2]/div[1]/img[7]");
	private By HostelsPlace = By.xpath("//*[@id='map']/div[1]/div[2]/div[3]/img[2]");
	private By FeaturedPlace = By.xpath("//*[@id='map']/div[1]/div[2]/div[1]/img[5]");
	private By HealthcarePlace = By.xpath("//*[@id='map']/div[1]/div[2]/div[1]/img");
	
	private By CampPlacesFilter  =  By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[1]");
	private By ServicePlacesFilter = By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[2]");
	private By HostelsPlacesFilter = By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[3]");
	private By FeaturedPlacesFilter = By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[4]");
	private By HealthcarePlacesFilter = By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[1]/ul/li[5]");

	
	@BeforeClass
	public void beforeClass(){
		ChromeDriverManager.getInstance().setup();
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.geolocation", 2);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", prefs);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();		
		driver.get("https://green-tourism.herokuapp.com/#!/places");
		wait = new WebDriverWait(driver,MAX_WAIT_TIME);		
	}
	
	@BeforeMethod
	public void beforeTest(){
		openCategoryPlaces();
	}
	
	@AfterMethod
	public void afterTest(){
		WebElement CategoriesButton = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/button")));
		CategoriesButton.click();
	}
	
	@AfterClass
	public void afterClass(){		
		driver.close();
	}
	

	@Test //10000
	public void testFilter01CampPlaces(){
		boolean filter [] = {true,false,false,false,false};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}

	@Test //01000
	public void testFilter02ServicePlaces(){
		boolean filter [] = {false,true,false,false,false};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}
	
	@Test //00100
	public void testFilter03HostelsPlaces(){
		boolean filter [] = {false,false,true,false,false};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}
	
	@Test //00010
	public void testFilter04FeaturedPlaces(){
		boolean filter [] = {false,false,false,true,false};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}
	
	@Test //00001
	public void testFilter05HealthcarePlaces(){
		boolean filter [] = {false,false,false,false,true};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}
	
	@Test //11000
	public void testFilter06CampServicePlaces(){
		boolean filter [] = {true,true,false,false,false};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}

	@Test //01100
	public void testFilter07ServiceHostelsPlaces(){
		boolean filter [] = {false,true,true,false,false};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}
	
	@Test //00110
	public void testFilter08HostelsFeaturedPlaces(){
		boolean filter [] = {false,false,true,true,false};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}
	
	@Test //00011
	public void testFilter09FeaturedHealthcarePlaces(){
		boolean filter [] = {false,false,false,true,true};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}
	
	@Test //10001
	public void testFilter10CampHealthcarePlaces(){
		boolean filter [] = {true,false,false,false,true};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}

	@Test //11100
	public void testFilter11PlacesWithoutFeaturedHealthcare(){
		boolean filter [] = {true,true,true,false,false};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}

	@Test //01110
	public void testFilter12PlacesWithoutCampHealthcare(){
		boolean filter [] = {false,true,true,true,false};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}

	@Test //00111
	public void testFilter13PlacesWithoutCampService(){
		boolean filter [] = {false,false,true,true,true};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}
	
	@Test //10011
	public void testFilter14PlacesWithoutServiceHostels(){
		boolean filter [] = {true,false,false,true,true};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}
	
	@Test //11001
	public void testFilter15PlacesWithoutHostelsFeatured(){
		boolean filter [] = {true,true,false,false,true};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}
	
	@Test //10101
	public void testFilter16PlacesWithoutServicesFeatured(){
		boolean filter [] = {true,false,true,false,true};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}
	
	@Test //11110
	public void testFilter17PlacesWithoutHealthcare(){
		boolean filter [] = {true,true,true,true,false};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}

	@Test //01111
	public void testFilter18PlacesWithoutCamps(){
		boolean filter [] = {false,true,true,true,true};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));        
	}
	
	@Test //00000
	public void testFilter19AllPlacesDeselected(){
		Assert.assertTrue(	driver.findElements(CampPlace).isEmpty()
						  &&driver.findElements(ServicePlace).isEmpty()
						  &&driver.findElements(HostelsPlace).isEmpty()
						  &&driver.findElements(FeaturedPlace).isEmpty()
						  &&driver.findElements(HealthcarePlace).isEmpty());
	}

	@Test //11111
	public void testFilter20AllPlacesSelected(){
		boolean filter [] = {true,true,true,true,true};
		setFilters(filter);
		Assert.assertTrue(checkFilter(filter));
	}


	private void setFilters(boolean[] filter){
		setPlacesFilter(CampPlacesFilter, filter[0]);
		setPlacesFilter(ServicePlacesFilter, filter[1]);
		setPlacesFilter(HostelsPlacesFilter, filter[2]);
		setPlacesFilter(FeaturedPlacesFilter, filter[3]);
		setPlacesFilter(HealthcarePlacesFilter, filter[4]);
	}
	
	private boolean checkFilter(boolean[] filter){
		boolean isVisiableElements = true;
		if (filter[0] == true)
			isVisiableElements = isVisiableElements && isPlacesDisplayed(CampPlace);
		if (filter[1] == true)
			isVisiableElements = isVisiableElements && isPlacesDisplayed(ServicePlace);
		if (filter[2] == true)
			isVisiableElements = isVisiableElements && isPlacesDisplayed(HostelsPlace);			
		if (filter[3] == true)
			isVisiableElements = isVisiableElements && isPlacesDisplayed(FeaturedPlace);		
		if (filter[4] == true)
			isVisiableElements = isVisiableElements && isPlacesDisplayed(HealthcarePlace);
		return isVisiableElements;
	}
		
	private void setPlacesFilter(By element, boolean select){
		if (select == true){
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(CampPlace));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ServicePlace));
		wait.until(ExpectedConditions.visibilityOfElementLocated(HostelsPlace));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FeaturedPlace));
		wait.until(ExpectedConditions.visibilityOfElementLocated(HealthcarePlace));
		CheckAllButton.click();
	}
}