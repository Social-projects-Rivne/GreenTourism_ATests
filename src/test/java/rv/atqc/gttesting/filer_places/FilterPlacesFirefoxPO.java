package rv.atqc.gttesting.filer_places;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import rv.atqc.gttesting.archex.PlacesPage;

public class FilterPlacesFirefoxPO {
	
	private WebDriver driver;
	private PlacesPage page;
	
	@BeforeClass
	public void before(){		
		FirefoxDriverManager.getInstance().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();		
		driver.get("https://green-tourism.herokuapp.com/#!/places");
		page = new PlacesPage(driver).openCategories();
	}

	@AfterClass
	public void afterClass(){		
		driver.close();
	}


	@Test //10000
	public void testFilter01CampPlaces(){
		boolean filter [] = {true,false,false,false,false};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //01000
	public void testFilter02ServicePlaces(){
		boolean filter [] = {false,true,false,false,false};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //00100
	public void testFilter03HostelsPlaces(){
		boolean filter [] = {false,false,true,false,false};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //00010
	public void testFilter04FeaturedPlaces(){
		boolean filter [] = {false,false,false,true,false};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //00001
	public void testFilter05HealthcarePlaces(){
		boolean filter [] = {false,false,false,false,true};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //11000
	public void testFilter06CampServicePlaces(){
		boolean filter [] = {true,true,false,false,false};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //01100
	public void testFilter07ServiceHostelsPlaces(){
		boolean filter [] = {false,true,true,false,false};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //00110
	public void testFilter08HostelsFeaturedPlaces(){
		boolean filter [] = {false,false,true,true,false};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //00011
	public void testFilter09FeaturedHealthcarePlaces(){
		boolean filter [] = {false,false,false,true,true};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //10001
	public void testFilter10CampHealthcarePlaces(){
		boolean filter [] = {true,false,false,false,true};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //11100
	public void testFilter11PlacesWithoutFeaturedHealthcare(){
		boolean filter [] = {true,true,true,false,false};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //01110
	public void testFilter12PlacesWithoutCampHealthcare(){
		boolean filter [] = {false,true,true,true,false};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //00111
	public void testFilter13PlacesWithoutCampService(){
		boolean filter [] = {false,false,true,true,true};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //10011
	public void testFilter14PlacesWithoutServiceHostels(){
		boolean filter [] = {true,false,false,true,true};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //11001
	public void testFilter15PlacesWithoutHostelsFeatured(){
		boolean filter [] = {true,true,false,false,true};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //10101
	public void testFilter16PlacesWithoutServicesFeatured(){
		boolean filter [] = {true,false,true,false,true};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //11110
	public void testFilter17PlacesWithoutHealthcare(){
		boolean filter [] = {true,true,true,true,false};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //01111
	public void testFilter18PlacesWithoutCamps(){
		boolean filter [] = {false,true,true,true,true};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));        
	}

	@Test //00000
	public void testFilter19AllPlacesDeselected(){
		boolean filter [] = {true,true,true,true,true};
		page.openCategoryPlaces();
		Assert.assertFalse(page.checkFilter(filter));
	}
	
	@Test //11111
	public void testFilter20AllPlacesSelected(){
		boolean filter [] = {true,true,true,true,true};
		page.setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
}