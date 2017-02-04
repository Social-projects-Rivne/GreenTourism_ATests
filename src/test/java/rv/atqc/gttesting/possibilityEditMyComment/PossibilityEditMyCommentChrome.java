package rv.atqc.gttesting.possibilityEditMyComment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.LoggedPlaceViewPage;
import rv.atqc.gttesting.res.Resources;

public class PossibilityEditMyCommentChrome {
	private WebDriver driver;
	private LoggedPlaceViewPage placePage;
	private int afterMethodWaitTime=5000;
	private int afterClickWaitTime=3000;
	
	@BeforeClass
	public void beforeClass() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get("https://green-tourism.herokuapp.com/");
		driver.manage().window().maximize();
		new LogInPage(driver).loging().waitForPageLoad();
		driver.get("https://green-tourism.herokuapp.com/#!/places/584e7ef0b61f280400d36ebd");	
	    placePage = new LoggedPlaceViewPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	/*
	 * In these tests is used method Thread.sleep(), 
	 * because when some button is found, and we need 
	 * to click on it, the functionality of this element 
	 * has not been loaded yet, even when explicit waiters 
	 * and ExpectedConditions are used. More information 
	 * about similar issue is on the next web page
	 * http://stackoverflow.com/questions/31614205/selenium-wait-doesnt-wait-for-element-to-be-clickable
	 */
	@BeforeMethod
	public void beforeMethod() {
		try{
			Thread.sleep(afterMethodWaitTime);
			}
		catch (InterruptedException exception){
			exception.printStackTrace();
			} 
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
		try{
			Thread.sleep(afterClickWaitTime);
			}
		catch (InterruptedException exception){
			exception.printStackTrace();
			} 
		Assert.assertTrue(placePage.getTextarea().isDisplayed());
		placePage.clickCloseButton();
	}
	
	@Test
	public void checkPossibilityViewCloseButton() {
		placePage.clickEditButton().waitForPageLoad();
		try{
			Thread.sleep(afterClickWaitTime);
			}
		catch (InterruptedException exception){
			exception.printStackTrace();
			} 
		Assert.assertTrue(placePage.getCloseButton().isDisplayed());
		placePage.clickCloseButton();
	}
	
	@Test
	public void checkPossibilityClickCloseButton() {
		placePage.clickEditButton().waitForPageLoad();
		try{
			Thread.sleep(afterClickWaitTime);
			}
		catch (InterruptedException exception){
			exception.printStackTrace();
			} 
		Assert.assertTrue(placePage.getCloseButton().isEnabled());
		placePage.clickCloseButton();
	}
	
	@Test
	public void checkPossibilityViewUpdateButton() {
		placePage.clickEditButton().waitForPageLoad();
		try{
			Thread.sleep(afterClickWaitTime);
			}
		catch (InterruptedException exception){
			exception.printStackTrace();
			} 
		Assert.assertTrue(placePage.getUpdateButton().isDisplayed());
		placePage.clickCloseButton();
	}
	
	@Test
	public void checkPossibilityClickUpdateButton() {
		placePage.clickEditButton().waitForPageLoad();
		try{
			Thread.sleep(afterClickWaitTime);
			}
		catch (InterruptedException exception){
			exception.printStackTrace();
			} 
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
		try{
			Thread.sleep(afterClickWaitTime);
			}
		catch (InterruptedException exception){
			exception.printStackTrace();
			} 
		placePage.getTextarea().clear();
		Assert.assertFalse(placePage.getDisabledUpdateButton().isEnabled());
		placePage.clickCloseButton();
	}
}
