package possibilityEditMyCommentAllure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.LoggedPlaceViewPage;
import rv.atqc.gttesting.res.Resources;

public class possibilityEditMyCommentChromeAllure {
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
		pause(afterMethodWaitTime);
	}

	@TestCaseId("RVAT-921")
	@Features("Checking possibility to view edit button")
	@Stories("Possibility Edit My Comment Chrome")
	@Test
	public void checkPossibilityViewEditButton() {
		Assert.assertTrue(placePage.getEditButton().isDisplayed());
	}
	
	@TestCaseId("RVAT-922")
	@Features("Checking possibility to click edit button")
	@Stories("Possibility Edit My Comment Chrome")
	@Test
	public void checkPossibilityClickEditButton() {
		Assert.assertTrue(placePage.getEditButton().isEnabled());
	}
	
	@TestCaseId("RVAT-923")
	@Features("Checking possibility to view textarea")
	@Stories("Possibility Edit My Comment Chrome")
	@Test
	public void checkPossibilityViewTextarea() {
		placePage.clickEditButton().waitForPageLoad();
		pause(afterClickWaitTime);
		Assert.assertTrue(placePage.getTextarea().isDisplayed());
		placePage.clickCloseButton();
	}
	
	@TestCaseId("RVAT-924")
	@Features("Checking possibility to view close button")
	@Stories("Possibility Edit My Comment Chrome")
	@Test
	public void checkPossibilityViewCloseButton() {
		placePage.clickEditButton().waitForPageLoad();
		pause(afterClickWaitTime);
		Assert.assertTrue(placePage.getCloseButton().isDisplayed());
		placePage.clickCloseButton();
	}
	
	@TestCaseId("RVAT-925")
	@Features("Checking possibility to click close button")
	@Stories("Possibility Edit My Comment Chrome")
	@Test
	public void checkPossibilityClickCloseButton() {
		placePage.clickEditButton().waitForPageLoad();
		pause(afterClickWaitTime);
		Assert.assertTrue(placePage.getCloseButton().isEnabled());
		placePage.clickCloseButton();
	}
	
	@TestCaseId("RVAT-926")
	@Features("Checking possibility to view update button")
	@Stories("Possibility Edit My Comment Chrome")
	@Test
	public void checkPossibilityViewUpdateButton() {
		placePage.clickEditButton().waitForPageLoad();
		pause(afterClickWaitTime);
		Assert.assertTrue(placePage.getUpdateButton().isDisplayed());
		placePage.clickCloseButton();
	}
	
	@TestCaseId("RVAT-927")
	@Features("Checking possibility to click update button")
	@Stories("Possibility Edit My Comment Chrome")
	@Test
	public void checkPossibilityClickUpdateButton() {
		placePage.clickEditButton().waitForPageLoad();
		pause(afterClickWaitTime);
		Assert.assertTrue(placePage.getUpdateButton().isEnabled());
		placePage.clickCloseButton();
	}
	
	@TestCaseId("RVAT-928")
	@Features("Checking possibility to edit my comment")
	@Stories("Possibility Edit My Comment Chrome")
	@Test
	public void checkPossibilityEditMyComment() {
		Assert.assertTrue(placePage.setNewTextToEditedComment(Resources.EditCommit.TEXT_AFTER_EDIT)
		                           .getComment()
		                           .getText()
		                           .contentEquals(Resources.EditCommit.TEXT_AFTER_EDIT));
		placePage.setNewTextToEditedComment(Resources.EditCommit.TEXT_BEFORE_EDIT);
	}
	
	@TestCaseId("RVAT-929")
	@Features("Checking possibility to cancel editing my comment")
	@Stories("Possibility Edit My Comment Chrome")
	@Test
	public void checkPossibilityCancelEditMyComment() {
		Assert.assertFalse(placePage.notSetNewTextToEditedComment(Resources.EditCommit.TEXT_AFTER_EDIT)
		                            .getComment()
		                            .getText()
		                            .contentEquals(Resources.EditCommit.TEXT_AFTER_EDIT));
	}
	
	@TestCaseId("RVAT-930")
	@Features("Checking disabling of update button")
	@Stories("Possibility Edit My Comment Chrome")
	@Test
	public void checkDisablingOfButtonUpdate() {
		placePage.clickEditButton().waitForPageLoad();
		pause(afterClickWaitTime);
		placePage.getTextarea().clear();
		Assert.assertFalse(placePage.getDisabledUpdateButton().isEnabled());
		placePage.clickCloseButton();
	}
	
	@Step("Pause was made")
	private void pause(int timeToWait){
		try{
			Thread.sleep(timeToWait);
			}
		catch (InterruptedException exception){
			exception.printStackTrace();
			} 
	}
}

