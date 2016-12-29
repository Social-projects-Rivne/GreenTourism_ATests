package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class SimpleTester {

	public static void main(String[] args) {
		ChromeDriverManager.getInstance().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://green-tourism.herokuapp.com");
		LeftNavigationPage page = new LeftNavigationPage(driver);
		page.initPage();
		page.clickLeftNavButton();
		page.clickSignUp();
	}

}
