package rv.atqc.gttesting.find_item_by_name;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.PlacesPage;

public class FindItemByNameChrome {
	private WebDriver driver;
	private PlacesPage placesPage;
	
	@BeforeClass
	public void beforeExistenceOfSignUp() {
		ChromeDriverManager.getInstance().setup();
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.geolocation", 2);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", prefs);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		driver.get("https://green-tourism.herokuapp.com");
		new LogInPage(driver).loging();		
		
		driver.get("https://green-tourism.herokuapp.com/#!/places");
		placesPage = new PlacesPage(driver);		
	}

	@AfterClass
	    public void quitDriver(){
	 //       driver.quit();
	    }
	


    @Test
    public void verifyPlaceFromInvisibleRegion(){
    	placesPage.lookForPlace("Hight Castle");
    }
    
}