package rv.atqc.utilize.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import rv.atqc.utilize.drivers.DriverType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Driver {
	DriverType type() default DriverType.CHROME;
}
