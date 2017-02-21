package rv.atqc.gttesting.possibility_view_main_page;

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
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

@Features("Checking possibility to view main page")
@Stories("Chrome browser")
public class PossibilityViewMainPageChrome{

	private WebDriver driver;
	private WebDriverWait wait;
	private final int MAX_WAIT_TIME=10;
	
	@BeforeClass
	public void before(){		
		ChromeDriverManager.getInstance().setup();
		driver=new ChromeDriver();
		driver.get("https://green-tourism.herokuapp.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,MAX_WAIT_TIME);
	}
	
	@AfterClass
	public void afterMethod(){		
		driver.quit();
	}
	
	@TestCaseId("RVAT-540")
	@Test
	public void checkPossibilityViewTheTitle(){
		WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated 
				                            (By.xpath("//h2[text()='Find. Plan. Travel']")));
		Assert.assertTrue(titleElement.isDisplayed());
	}
	
	@TestCaseId("RVAT-543")
	@Test
	public void checkPossibilityViewMenuItem(){
		WebElement menuElement = wait.until(ExpectedConditions.visibilityOfElementLocated
					                       (By.xpath("//div[@id='navbar']//i[@class='fa fa-bars navtop']")));
		Assert.assertTrue(menuElement.isDisplayed());
	}
	
	@TestCaseId("RVAT-545")
	@Test
	public void checkPossibilityViewLoginOrSignupItem(){
		WebElement loginOrSignupItem = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath("//div[@id='navbar']//i[@class='fa fa-user navtop']")));
		Assert.assertTrue(loginOrSignupItem.isDisplayed());
	}
	
	@TestCaseId("RVAT-550")
	@Test
	public void checkPossibilityViewGreenTourismLink1(){
		WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath("//div[@class='hidden-xs logo']")));
		Assert.assertTrue(linkElement.isDisplayed());
	}
	
	@TestCaseId("RVAT-574")
	@Test
	public void checkPossibilityViewNavigationItem(){
		WebElement navigationItem = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath("//i[@class='fa fa-angle-down']")));
		Assert.assertTrue(navigationItem.isDisplayed());
	}
	
	@TestCaseId("RVAT-575")
	@Test
	public void checkPossibilityViewElementWithBackgroundImage(){
		WebElement backgroundImageElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath("//div[@class='parallax hidden-xs hidden-sm']")));
		Assert.assertTrue(backgroundImageElement.isDisplayed());
	}
	
	@TestCaseId("RVAT-576")
	@Test
	public void checkPossibilityViewImage1(){
		WebElement imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath("//img[@src='/assets/img/welcome-page/m1.jpg']")));
		Assert.assertTrue(imageElement.isDisplayed());
	}
	
	@TestCaseId("RVAT-577")
	@Test
	public void checkPossibilityViewImage2(){
		WebElement imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath("//img[@src='/assets/img/welcome-page/m2.jpg']")));
		Assert.assertTrue(imageElement.isDisplayed());
	}
	
	@TestCaseId("RVAT-578")
	@Test
	public void checkPossibilityViewImage3(){
		WebElement imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath("//img[@src='/assets/img/welcome-page/m3.jpg']")));
		Assert.assertTrue(imageElement.isDisplayed());
	}
	
	@TestCaseId("RVAT-579")
	@Test
	public void checkPossibilityViewLinkItemFindPlace(){
		WebElement linkItem = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.linkText("Find place")));
		Assert.assertTrue(linkItem.isDisplayed());
	}
	
	@TestCaseId("RVAT-580")
	@Test
	public void checkPossibilityViewLinkItemPlanYourTrack(){
		WebElement linkItem = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.linkText("Plan your track")));
		Assert.assertTrue(linkItem.isDisplayed());
	}
	
	@TestCaseId("RVAT-581")
	@Test
	public void checkPossibilityViewLinkItemFunOnEvents(){
		WebElement linkItem = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.linkText("Fun on events")));
		Assert.assertTrue(linkItem.isDisplayed());
	}
	
	@TestCaseId("RVAT-582")
	@Test
	public void checkPossibilityViewTextBlock1(){
		String TextBlock1xpath="//div[@class='row'][1]/div[@class='col-md-6 "
				                 + "welcome-page-section-text']/p";
		
		WebElement textBlock1 = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath(TextBlock1xpath)));
		Assert.assertTrue(textBlock1.isDisplayed());
	}
	
	@TestCaseId("RVAT-583")
	@Test
	public void checkPossibilityViewTextBlock2(){
		String TextBlock2xpath="//div[@class='col-md-6 col-md-pull-6 "
				               + "welcome-page-section-text']/p";
		
		WebElement textBlock2 = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath(TextBlock2xpath)));
		Assert.assertTrue(textBlock2.isDisplayed());
	}
	
	@TestCaseId("RVAT-584")
	@Test
	public void checkPossibilityViewTextBlock3(){
		String TextBlock3xpath="//div[@class='row'][3]/div[@class='col-md-6 "
				                 + "welcome-page-section-text']/p";
		
		WebElement textBlock3 = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath(TextBlock3xpath)));
		Assert.assertTrue(textBlock3.isDisplayed());
	}
	
	@TestCaseId("RVAT-585")
	@Test
	public void checkPossibilityViewLinkItemGoToSearch1(){
		String linkItemXpath="//div[@class='row'][1]/div[@class='col-md-6 welcome-"
				              + "page-section-text']/div/a";
		WebElement linkItem = wait.until(ExpectedConditions.visibilityOfElementLocated
				                        (By.xpath(linkItemXpath)));
		Assert.assertTrue(linkItem.isDisplayed());
	}
	
	@TestCaseId("RVAT-586")
	@Test
	public void checkPossibilityViewLinkItemGoToSearch2(){
		String linkItemXpath="//div[@class='row']/div[@class='col-md-6 col-md-pull-6 "
				              + "welcome-page-section-text']/div/a";
		WebElement linkItem = wait.until(ExpectedConditions.visibilityOfElementLocated
				                        (By.xpath(linkItemXpath)));
		Assert.assertTrue(linkItem.isDisplayed());
	}
	
	@TestCaseId("RVAT-587")
	@Test
	public void checkPossibilityViewLinkItemGoToSearch3(){
		String linkItemXpath="//div[@class='row'][3]/div[@class='col-md-6 welcome-"
				              + "page-section-text']/div/a";
		WebElement linkItem = wait.until(ExpectedConditions.visibilityOfElementLocated
				                        (By.xpath(linkItemXpath)));
		Assert.assertTrue(linkItem.isDisplayed());
	}
	
	@TestCaseId("RVAT-588")
	@Test
	public void checkPossibilityViewGreenTourismLink2(){
		WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.xpath("//div[@class='footer-content']/a")));
		Assert.assertTrue(linkElement.isDisplayed());
	}
	
	@TestCaseId("RVAT-589")
	@Test
	public void checkPossibilityViewTheGreenTourismTeamLink(){
		WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.linkText("The GreenTourism Team")));
		Assert.assertTrue(linkElement.isDisplayed());
	}
	
	@TestCaseId("RVAT-590")
	@Test
	public void checkPossibilityViewTwitterLink(){
		WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.linkText("Twitter")));
		Assert.assertTrue(linkElement.isDisplayed());
	}
	
	@TestCaseId("RVAT-591")
	@Test
	public void checkPossibilityViewGooglePlusLink(){
		WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.linkText("Google+")));
		Assert.assertTrue(linkElement.isDisplayed());
	}
	
	@TestCaseId("RVAT-592")
	@Test
	public void checkPossibilityViewFacebookLink(){
		WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated
				                           (By.linkText("Facebook")));
		Assert.assertTrue(linkElement.isDisplayed());
	}
}

