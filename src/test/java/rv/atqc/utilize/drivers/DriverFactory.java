package rv.atqc.utilize.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;

public class DriverFactory {
	public static WebDriver getDriver(DriverType type) {
		switch (type) {
		case FIREFOX:
			FirefoxDriverManager.getInstance().setup();
			return new FirefoxDriver();
		case CHROME:
			ChromeDriverManager.getInstance().setup();
			return new ChromeDriver();
		case OPERA:
			OperaDriverManager.getInstance().setup();
			return new OperaDriver();
		case INTERNETEXPLORER:
			InternetExplorerDriverManager.getInstance().setup();
			return new InternetExplorerDriver();
		}
		throw new IllegalArgumentException();
	}
}
