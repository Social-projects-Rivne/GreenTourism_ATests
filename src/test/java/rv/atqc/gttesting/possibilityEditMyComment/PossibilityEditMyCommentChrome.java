package rv.atqc.gttesting.possibilityEditMyComment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.LoggedPlaceViewPage;
import rv.atqc.gttesting.res.Resources;

public class PossibilityEditMyCommentChrome {
	private WebDriver driver;
	private LoggedPlaceViewPage PlacePage;
	

	@BeforeClass
	public void before() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get("https://green-tourism.herokuapp.com/");
		driver.manage().window().maximize();
		new LogInPage(driver).loging().waitForPageLoad();
		driver.get("https://green-tourism.herokuapp.com/#!/places/584e7ef0b61f280400d36ebd");	
	    PlacePage = new LoggedPlaceViewPage(driver);
	}

	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

	@Test
	public void checkPossibilityViewEditButton() {
		Assert.assertTrue(PlacePage.getEditButton().isDisplayed());
	}
	
	@Test
	public void checkPossibilityClickEditButton() {
		Assert.assertTrue(PlacePage.getEditButton().isEnabled());
	}
	
	@Test
	public void checkPossibilityViewTextarea() {
		Assert.assertTrue(PlacePage.getTextarea().isDisplayed());
		PlacePage.clickCloseButton();
	}
	
	@Test
	public void checkPossibilityViewCloseButton() {
		Assert.assertTrue(PlacePage.getCloseButton().isDisplayed());
		PlacePage.clickCloseButton();
	}
	
	@Test
	public void checkPossibilityClickCloseButton() {
		Assert.assertTrue(PlacePage.getCloseButton().isEnabled());
		PlacePage.clickCloseButton();
	}
	
	@Test
	public void checkPossibilityViewUpdateButton() {
		Assert.assertTrue(PlacePage.getUpdateButton().isDisplayed());
		PlacePage.clickCloseButton();
	}
	
	@Test
	public void checkPossibilityClickUpdateButton() {
		Assert.assertTrue(PlacePage.getUpdateButton().isEnabled());
		PlacePage.clickCloseButton();
	}
	
	@Test
	public void checkPossibilityEditMyComment() {
		Assert.assertTrue(PlacePage.setNewTextToEditedComment(Resources.EditCommit.TEXT_AFTER_EDIT)
		                           .getComment()
		                           .getText()
		                           .contentEquals(Resources.EditCommit.TEXT_AFTER_EDIT));
		PlacePage.setNewTextToEditedComment(Resources.EditCommit.TEXT_BEFORE_EDIT);
	}
	
	@Test
	public void checkPossibilityCancelEditMyComment() {
		Assert.assertFalse(PlacePage.notSetNewTextToEditedComment(Resources.EditCommit.TEXT_AFTER_EDIT)
		                            .getComment()
		                            .getText()
		                            .contentEquals(Resources.EditCommit.TEXT_AFTER_EDIT));
	}
	
	@Test
	public void checkDisablingOfButtonUpdate() {
		PlacePage.getTextarea().clear();
		Assert.assertFalse(PlacePage.getDisabledUpdateButton().isEnabled());
		PlacePage.clickCloseButton();
	}	
}
