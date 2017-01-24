package rv.atqc.gttesting.possibility_add_comment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import rv.atqc.gttesting.archex.HeadForGuestUserPage;
import rv.atqc.gttesting.archex.LoggedPlaceViewPage;

public class PossibilityAddCommentChrome {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void before(){
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get(" http://green-tourism.herokuapp.com");
		driver.manage().window().maximize();
		new HeadForGuestUserPage(driver)
				.clickLeftNavButton()
				.clickLogIn()
				.setLoginField("juger@juger.juger")
				.setPasswordField("11111111")
				.clickLogInButton();
		driver.get("http://green-tourism.herokuapp.com/#!/places/57a4d84dca7a727c0ca59ba3");
	}
	
	@Test
	public void existenceOfTextArea() {
		WebElement we = new LoggedPlaceViewPage(driver)
		.scrollToNewComment()
		.getNewComment();
		Assert.assertTrue(we.isDisplayed(), "Text area for new comment is not exist!!!");
		
	}
	
	@Test
	public void existenceOfPostButton() {
		WebElement we = new LoggedPlaceViewPage(driver)
		.scrollToNewComment()
		.setNewComment("s")
		.getPostButton();
		Assert.assertTrue(we.isDisplayed(), "Post button for new comment is not exist!!!");
		
	}
	
	@Test
	public void existenceOfLastAddedComment() {
		String newComment = "New comment";
		WebElement we = new LoggedPlaceViewPage(driver)
		.scrollToNewComment()
		.setNewComment(newComment)
		.clickPostButton()
		.getLastComment();
		Assert.assertTrue(we.getText().contains(newComment), "New comment is not exist!!!");
	}
	
	@Test
	public void checkFormatOfLastAddedComment() {
		String newComment = "New\n comment";
		WebElement we = new LoggedPlaceViewPage(driver)
		.scrollToNewComment()
		.setNewComment(newComment)
		.clickPostButton()
		.getLastComment();
		Assert.assertTrue(we.getText().contains("<br>") || we.getText().contains("</br>"), "New comment is not formating!!!");
	}
	
	@AfterMethod
	public void after(){
		driver.quit();
	}
	
}
