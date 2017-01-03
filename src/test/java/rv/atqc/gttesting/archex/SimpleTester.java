package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class SimpleTester {

//	public static void main(String[] args) {
//		ChromeDriverManager.getInstance().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://green-tourism.herokuapp.com");
//		GreenTourismHeadPage page = new GreenTourismHeadPage(driver);
//		SignUpPage signUpPage = page.clickLeftNavButton().clickSignUp();
//		String actual = signUpPage.setFirstName("Juger").getFirstNameErrorMessage().getText();
//		Assert.assertEquals(actual, "", "Error");
//		// .setLastName("Juger").setEmail("shfgs@gmail.com").setPassword("asdfghjk")
//		// .setPasswordConfirm("asdfghjk").<SignUpPage>clickSignUp();
//	}

	@Test
	public void test() {
		ChromeDriverManager.getInstance().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://green-tourism.herokuapp.com");
//		AbstractHeadPage page = new AbstractHeadPage(driver);
//		SignUpPage signUpPage = page.clickLeftNavButton().clickSignUp();
//		String actual = signUpPage.setFirstName("").disableFocus().getFirstNameErrorMessage().getText();
//		Assert.assertEquals(actual, "First name is required", "Error");
	}
}
