package rv.atqc.gttesting.filter_places;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import rv.atqc.gttesting.archex.MapHeadPageForGuestUserPage;
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
		page = new MapHeadPageForGuestUserPage(driver)
				.clickCategories()
				.clickPlaces();
		page.hoverElement(page.getPlacesButton());
	}

	@AfterClass
	public void afterClass(){
		driver.close();
	}

	@Test
	public void testExistenceOfPlacesButton() {
		Assert.assertTrue(page.getPlacesButton().isDisplayed());
	}
	
	@Test
	public void testExistenceOfCheckAllButton() {
		Assert.assertTrue(page.getCheckAllButton().isDisplayed());
	}
	
	@Test
	public void testExistenceOfFilters() {
		Assert.assertTrue(page.getCampPlacesFilter().isDisplayed() && page.getFeaturedPlacesFilter().isDisplayed());
	}

	@Test
	public void testExistenceOfPlace() {
		Assert.assertTrue(page.getFeaturedPlace().isDisplayed());
	}
	
	@Test
	public void testExistenceOfPlaceLable() {
		Assert.assertTrue(page.getFeaturedPlaceLable().isDisplayed());
	}
		
	@Test //10000
	public void testFilter01CampPlaces(){
		boolean filter [] = {true,false,false,false,false};
		page.openCategoryPlaces().deselectPlaces().setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //01000
	public void testFilter02ServicePlaces(){
		boolean filter [] = {false,true,false,false,false};
		page.openCategoryPlaces().deselectPlaces().setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //10100
	public void testFilter03CampHostelsPlaces(){
		boolean filter [] = {true,true,false,false,false};
		page.openCategoryPlaces().deselectPlaces().setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //00011
	public void testFilter04FeaturedHealthcarePlaces(){
		boolean filter [] = {false,false,false,true,true};
		page.openCategoryPlaces().deselectPlaces().setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //11100
	public void testFilter05PlacesWithoutFeaturedHealthcare(){
		boolean filter [] = {true,true,true,false,false};
		page.openCategoryPlaces().deselectPlaces().setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //10101
	public void testFilter06PlacesWithoutServicesFeatured(){
		boolean filter [] = {true,false,true,false,true};
		page.openCategoryPlaces().deselectPlaces().setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));
	}
	
	@Test //01111
	public void testFilter07PlacesWithoutCamps(){
		boolean filter [] = {false,true,true,true,true};
		page.openCategoryPlaces().deselectPlaces().setFilters(filter);
		Assert.assertTrue(page.checkFilter(filter));        
	}

}