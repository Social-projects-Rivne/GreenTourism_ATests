package rv.atqc.gttesting.res.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import rv.atqc.gttesting.res.Resources;

public class ResourcesHelperTest {
	Properties properties;
	
	@BeforeClass
	public void before() {
		properties = new Properties();
		InputStream input = null;
		try {
			input = Resources.class.getClassLoader().getResourceAsStream("user-information-test-data.properties");
			properties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void checkValidName() {
		Assert.assertEquals(Resources.UserTestData.VALID_NAME, properties.getProperty("valid-name"), "Valid name doesn't match");
	}

	@Test
	public void checkInvalidEmail() {
		Assert.assertEquals(Resources.UserTestData.INVALID_EMAIL, properties.getProperty("invalid-email"), "Invalid email doesn't match");
	}

	@Test
	public void checkPassword8() {
		Assert.assertEquals(Resources.UserTestData.PASSWORD8, properties.getProperty("password-8"), "Password8 doesn't match");
	}

}
