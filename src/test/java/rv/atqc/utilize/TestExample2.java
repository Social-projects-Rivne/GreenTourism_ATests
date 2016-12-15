package rv.atqc.utilize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rv.atqc.utilize.annotations.Driver;
import rv.atqc.utilize.drivers.DriverType;

@Driver(type = DriverType.CHROME)
public class TestExample2 {

	WebDriver driver;

	@BeforeMethod
	public void init() {
		driver = Drivers.getDriver(this);
	}

	@Test
	public void runTest2() {
		driver.get("https://duckduckgo.com/");
		if (driver.findElement(By.xpath("//*[@id=\"search_form_input_homepage\"]")).isEnabled()) {
			System.out.println("search is enabled!!!");
			driver.findElement(By.xpath("//*[@id=\"search_form_input_homepage\"]")).sendKeys("java");
			System.out.println("search is completed");
			driver.findElement(By.xpath("//*[@id=\"search_button_homepage\"]")).click();
			System.out.println("Done");
		}
		driver.close();
	}
}
