package rv.atqc.utilize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import rv.atqc.utilize.annotations.Driver;
import rv.atqc.utilize.drivers.DriverType;


// E X A M P L E
//@Driver(type = DriverType.CHROME)// set driver type
public class TestExample1 {

	public static void main(String[] args) {
		new TestExample1().test();
	}

	public void test() {
		WebDriver driver = Drivers.getDriver(this); // get web driver
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
