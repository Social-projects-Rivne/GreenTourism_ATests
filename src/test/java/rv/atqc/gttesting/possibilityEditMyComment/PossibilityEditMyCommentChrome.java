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
	private LoggedPlaceViewPage placePage;
	
	@BeforeClass
	public void before() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get("https://green-tourism.herokuapp.com/");
		driver.manage().window().maximize();
		new LogInPage(driver).loging().waitForPageLoad();
		driver.get("https://green-tourism.herokuapp.com/#!/places/584e7ef0b61f280400d36ebd");	
	    placePage = new LoggedPlaceViewPage(driver);
	}

	@AfterClass
	public void afterMethod() {
		driver.quit();
	}

	@Test
	public void checkPossibilityViewEditButton() {
		Assert.assertTrue(placePage.getEditButton().isDisplayed());
	}
	
	@Test
	public void checkPossibilityClickEditButton() {
		Assert.assertTrue(placePage.getEditButton().isEnabled());
	}
	
	@Test
	public void checkPossibilityViewTextarea() {
		placePage.clickEditButton().waitForPageLoad();
		Assert.assertTrue(placePage.getTextarea().isDisplayed());
		placePage.clickCloseButton();
	}
	
	@Test
	public void checkPossibilityViewCloseButton() {
		placePage.clickEditButton().waitForPageLoad();
		Assert.assertTrue(placePage.getCloseButton().isDisplayed());
		placePage.clickCloseButton();
	}
	
	@Test
	public void checkPossibilityClickCloseButton() {
		placePage.clickEditButton().waitForPageLoad();
		Assert.assertTrue(placePage.getCloseButton().isEnabled());
		placePage.clickCloseButton();
	}
	
	@Test
	public void checkPossibilityViewUpdateButton() {
		placePage.clickEditButton().waitForPageLoad();
		Assert.assertTrue(placePage.getUpdateButton().isDisplayed());
		placePage.clickCloseButton();
	}
	
	@Test
	public void checkPossibilityClickUpdateButton() {
		placePage.clickEditButton().waitForPageLoad();
		Assert.assertTrue(placePage.getUpdateButton().isEnabled());
		placePage.clickCloseButton();
	}
	
	@Test
	public void checkPossibilityEditMyComment() {
		Assert.assertTrue(placePage.setNewTextToEditedComment(Resources.EditCommit.TEXT_AFTER_EDIT)
		                           .getComment()
		                           .getText()
		                           .contentEquals(Resources.EditCommit.TEXT_AFTER_EDIT));
		placePage.setNewTextToEditedComment(Resources.EditCommit.TEXT_BEFORE_EDIT);
	}
	
	@Test
	public void checkPossibilityCancelEditMyComment() {
		Assert.assertFalse(placePage.notSetNewTextToEditedComment(Resources.EditCommit.TEXT_AFTER_EDIT)
		                            .getComment()
		                            .getText()
		                            .contentEquals(Resources.EditCommit.TEXT_AFTER_EDIT));
	}
	
	@Test
	public void checkDisablingOfButtonUpdate() {
		placePage.clickEditButton().waitForPageLoad();
		placePage.getTextarea().clear();
		Assert.assertFalse(placePage.getDisabledUpdateButton().isEnabled());
		placePage.clickCloseButton();
	}
}
