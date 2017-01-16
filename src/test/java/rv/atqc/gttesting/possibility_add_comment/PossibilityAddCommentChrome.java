package rv.atqc.gttesting.possibility_add_comment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import rv.atqc.gttesting.archex.HeadForGuestUserPage;
import rv.atqc.gttesting.archex.LoggedPlaceViewPage;

public class PossibilityAddCommentChrome {
	
	private WebDriver driver;
	
	@Test
	public void beforeExistenceOfSignUp() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get(" http://green-tourism.herokuapp.com/#!/places/57a4d84dca7a727c0ca59ba3");
		driver.manage().window().maximize();
		new HeadForGuestUserPage(driver)
				.clickLeftNavButton()
				.clickLogIn()
				.setLoginField("juger@juger.juger")
				.setPasswordField("11111111")
				.clickLogInButton();
		driver.get(" http://green-tourism.herokuapp.com/#!/places/57a4d84dca7a727c0ca59ba3");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new LoggedPlaceViewPage(driver)
		.timeout(3, TimeUnit.SECONDS)
		.scrollToNewComment()
		.timeout(3, TimeUnit.SECONDS)
		.setNewComment("new Comment\n shdjfsdjdvjbvs");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	
	
	
}
