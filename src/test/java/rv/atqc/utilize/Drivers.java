package rv.atqc.utilize;

import java.lang.annotation.Annotation;

import org.openqa.selenium.WebDriver;

import rv.atqc.utilize.annotations.Driver;
import rv.atqc.utilize.drivers.DriverFactory;
import rv.atqc.utilize.drivers.DriverType;

public class Drivers {
	public static WebDriver getDriver(Object obj) {
		
		Class<?> clazz = obj.getClass();
		Annotation a = clazz.getAnnotation(Driver.class);
		if(a == null)
			return DriverFactory.getDriver(DriverType.CHROME);
		else 
			return DriverFactory.getDriver(((Driver)a).type());
		
	}
}
