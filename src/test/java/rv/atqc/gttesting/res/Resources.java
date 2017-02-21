package rv.atqc.gttesting.res;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Resources {

	public static class UserTestData {
		private static Properties properties = init("user-information-test-data.properties");
		public static String VALID_NAME = properties.getProperty("valid-name");
		public static String INVALID_NAME = properties.getProperty("invalid-name");
		public static String EMPTY = properties.getProperty("empty");
		public static String VALID_EMAIL = properties.getProperty("valid-email");
		public static String INVALID_EMAIL = properties.getProperty("invalid-email");
		public static String PASSWORD7 = properties.getProperty("password-7");
		public static String PASSWORD8 = properties.getProperty("password-8");
		public static String PASSWORD9 = properties.getProperty("password-9");
		public static String VALID_NICK_NAME = properties.getProperty("valid-nick-name");
		public static String INVALID_NICK_NAME = properties.getProperty("invalid-nick-name");
		public static String VALID_PHONE = properties.getProperty("valid-phone");
		public static String INVALID_PHONE = properties.getProperty("invalid-phone");
		public static String INVALID_PHONE_WITH_LETTERS = properties.getProperty("invalid-phone-with-letters");
		public static String INVALID_PHONE_WITH_SPECIAL_SYMBOL = properties.getProperty("invalid-phone-with-special-symbol");
		public static String ADDRESS = properties.getProperty("address");
		public static String ADDRESS_WITH_SPECIAL_SYMBOL = properties.getProperty("address-with-special-symbol");
	}

	public static class SignUpErrorMessage {
		private static Properties properties = init("signup-error-message.properties");
		public static String FIRST_NAME_INVALID = properties.getProperty("first-name-invalid");
		public static String FIRST_NAME_EMPTY = properties.getProperty("first-name-is-empty");
		public static String LAST_NAME_INVALID = properties.getProperty("last-name-invalid");
		public static String LAST_NAME_EMPTY = properties.getProperty("last-name-is-empty");
		public static String EMAIL_INVALID = properties.getProperty("email-invalid");
		public static String EMAIL_EMPTY = properties.getProperty("email-is-empty");
		public static String PASSWORD_LONGER = properties.getProperty("password-longer");
		public static String PASSWORD_IS_EMPTY = properties.getProperty("password-is-empty");
		public static String PASSWORD_NO_MATCH = properties.getProperty("password-no-match");
		public static String NO_MESSAGE = properties.getProperty("no-message");
	}

	public static class LogInConstants {
		private static Properties properties = init("logInPageConstants.properties");
		public static String USER_EMAIL = properties.getProperty("email");
		public static String USER_PASSWORD = properties.getProperty("password");
		public static String EXPECTED_CHANGE_BUTTON_TEXT = properties.getProperty("changeButtonText");
		public static String EXPECTED_CANCEL_BUTTON_TEXT = properties.getProperty("cancelButtonText");
		public static String JPG_URL = properties.getProperty("JpgUrl");
		public static String JPEG_URL = properties.getProperty("JpegUrl");
		public static String PNG_URL = properties.getProperty("PngUrl");
		public static String MAX_WAIT_TIME = properties.getProperty("maxWaitTime");

	}

	public static class LogInMessage {
		private static Properties properties = init("user-information-test-data.properties");
		public static String USER_EMAIL = properties.getProperty("email");
		public static String USER_PASSWORD = properties.getProperty("password");
	}

	public static class GloblaConfig {
		private static Properties properties = init("global-config.properties");
		public static int MAX_TIME_WAIT = Integer.valueOf(properties.getProperty("max-time-wait"));
		public static int MIN_TIME_WAIT = Integer.valueOf(properties.getProperty("min-time-wait"));
		public static int MAX_TIMEOUT = Integer.valueOf(properties.getProperty("max-timeout"));
		public static int MIN_TIMEOUT = Integer.valueOf(properties.getProperty("min-timeout"));

	}

	public static class EditCommit {
		private static Properties properties = init("user-information-test-data.properties");
		public static String TEXT_BEFORE_EDIT = properties.getProperty("textBeforeEdit");
		public static String TEXT_AFTER_EDIT = properties.getProperty("textAfterEdit");
	}
	
	public static class Comment {
		private static Properties properties = init("comment.properties");
		public static String SIMPLE_COMMENT = properties.getProperty("simple-comment");
		public static String FORMATING_COMMENT = properties.getProperty("formating-comment");
	}

	private static Properties init(String propertiesTitle) {
		Properties properties = new Properties();
		InputStream input = null;
		try {
			input = Resources.class.getClassLoader().getResourceAsStream(propertiesTitle);
			properties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			closeSafely(input);
		}
		return properties;
	}

	private static void closeSafely(Closeable close) {
		if (close != null) {
			try {
				close.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
