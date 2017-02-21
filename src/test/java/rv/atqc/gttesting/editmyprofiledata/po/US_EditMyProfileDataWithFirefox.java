package rv.atqc.gttesting.editmyprofiledata.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import rv.atqc.gttesting.archex.EditProfilePage;
import rv.atqc.gttesting.archex.HeadForGuestUserPage;
import rv.atqc.gttesting.archex.ProfilePage;
import rv.atqc.gttesting.res.Resources;

@Features("Checking possibility to edit my profile data")
@Stories("Firefox browser")
public class US_EditMyProfileDataWithFirefox {

	private WebDriver driver;
	private ProfilePage pageProfile;
	private EditProfilePage page;

	@BeforeMethod
	public void before() {
		FirefoxDriverManager.getInstance().setup();
		driver = new FirefoxDriver();
		driver.get(" http://green-tourism.herokuapp.com");
		driver.manage().window().maximize();
		pageProfile = new HeadForGuestUserPage(driver).clickLeftNavButton().clickLogIn()
				.setLoginField(Resources.LogInMessage.USER_EMAIL).setPasswordField(Resources.LogInMessage.USER_PASSWORD).clickLogInButton().clickLeftNavButton()
				.clickProfile();
		page = pageProfile.clickEdit();
	}

	@TestCaseId("RVAT-556")
	@Test
	public void verifyNameOfEditButton() {
		String editTitle = pageProfile.getEditButton().getText();
		Assert.assertTrue(editTitle.contains("Edit"));
	}

	@TestCaseId("RVAT-558")
	@Test
	public void verifyExistenceOfTheEditButton() {
		WebElement editButton = pageProfile.getEditButton();
		Assert.assertTrue(editButton.isEnabled());
	}

	@TestCaseId("RVAT-560")
	@Test
	public void verifyAppearanceOfFormplaceholdersAfterClickingEditButton() {
		WebElement editForm = page.getEditForm();
		Assert.assertTrue(editForm.isDisplayed());
	}

	@TestCaseId("RVAT-562")
	@Test
	public void verifyEmptyFirstNameAndLastNamePlaceholders() {
		boolean isChangeClickable = page.clearFirstName()
										.clearLastName()
										.isChangeClickable();
		Assert.assertFalse(isChangeClickable);
	}

	@TestCaseId("RVAT-564")
	@Test
	public void verifyFilledFirstNameAndEmptyLastNamePlaceholders() {
		boolean isChangeClickable = page.clearFirstName()
										.setFirstName(Resources.UserTestData.VALID_NAME)
										.clearLastName()
										.isChangeClickable();
		Assert.assertFalse(isChangeClickable);
	}

	@TestCaseId("RVAT-566")
	@Test
	public void verifyEmptyFirstNameAndFilledLastNamePlaceholders() {
		boolean isChangeClickable = page.clearFirstName()
										.clearLastName()
										.setLastName(Resources.UserTestData.VALID_NAME)
										.isChangeClickable();
		Assert.assertFalse(isChangeClickable);
	}

	@TestCaseId("RVAT-648")
	@Test
	public void verifyExistenceOfFirstNamePlaceholder() {
		WebElement firstName = page.getFirstName();
		Assert.assertTrue(firstName.isDisplayed());
	}

	@TestCaseId("RVAT-650")
	@Test
	public void verifyExistenceOfLastNamePlaceholder() {
		WebElement lastName = page.getLastName();
		Assert.assertTrue(lastName.isDisplayed());
	}
	
	@TestCaseId("RVAT-652")
	@Test
    public void verifyExistenceOfNicknamePlaceholder(){
		WebElement nick = page.getNick();
		Assert.assertTrue(nick.isDisplayed());
    }
	
	@TestCaseId("RVAT-654")
	@Test
    public void verifyExistenceOfPhoneNumberPlaceholder(){
		WebElement phone = page.getPhone();
		Assert.assertTrue(phone.isDisplayed());
    }
	
	@TestCaseId("RVAT-655")
	@Test
    public void verifyExistenceOfAddressPlaceholder(){
		WebElement address = page.getAddress();
		Assert.assertTrue(address.isDisplayed());
    }
	
	@TestCaseId("RVAT-834")
	@Test
    public void verifyExistenceOfTheChangeButton(){
		WebElement changeButton = page.getChange();
		Assert.assertTrue(changeButton.isDisplayed());
    }
	
	@TestCaseId("RVAT-838")
	@Test
    public void verifyExistenceOfTheCancelButton(){
		WebElement cancel = page.getCancel();
		Assert.assertTrue(cancel.isDisplayed());
    }
	
	@TestCaseId("RVAT-832")
	@Test
    public void verifyClickThroughRateOfTheEditButton(){
		Assert.assertTrue(pageProfile.isEditClickable());
    }
	
	@TestCaseId("RVAT-836")
	@Test
    public void verifyClickThroughRateOfTheChangeButton(){
		Assert.assertTrue(page.isChangeClickable());
    }
	
	@TestCaseId("RVAT-840")
	@Test
    public void VerifyClickThroughRateOfTheCancelButton(){
		Assert.assertTrue(page.isCancelClickable());
    }
	
	@TestCaseId("RVAT-842")
	@Test
    public void verifyNicknamePlaceholderFilledWithCharacters(){
		boolean isChangeClickable = page.clearNick()
										.setNick(Resources.UserTestData.VALID_NICK_NAME)
										.isChangeClickable();
		Assert.assertTrue(isChangeClickable);
    }
	
	@TestCaseId("RVAT-844")
	@Test
    public void verifyNicknamePlaceholderFilledWithSpecialCharacters(){
		boolean isChangeClickable = page.clearNick()
										.setNick(Resources.UserTestData.INVALID_NICK_NAME)
										.isChangeClickable();
		Assert.assertTrue(isChangeClickable);
    }
	
	@TestCaseId("RVAT-846")
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithValidNumber(){
		boolean isChangeClickable = page.clearPhone()
				.setPhone(Resources.UserTestData.VALID_PHONE)
				.isChangeClickable();
		Assert.assertTrue(isChangeClickable);
    }
	
	@TestCaseId("RVAT-848")
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithInvalidNumber(){
        boolean isChangeClickable = page.clearPhone().setPhone(Resources.UserTestData.INVALID_PHONE).isChangeClickable();
		Assert.assertFalse(isChangeClickable);
    }
	
	@TestCaseId("RVAT-850")
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithLetters(){
        boolean isChangeClickable = page.clearPhone()
        								.setPhone(Resources.UserTestData.INVALID_PHONE_WITH_LETTERS)
        								.isChangeClickable();
		Assert.assertFalse(isChangeClickable);
    }
	
	@TestCaseId("RVAT-852")
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithSpecialCharacters(){
        boolean isChangeClickable = page.clearPhone()
        								.setPhone(Resources.UserTestData.INVALID_PHONE_WITH_SPECIAL_SYMBOL)
        								.isChangeClickable();
		Assert.assertFalse(isChangeClickable);
    }
	
	@TestCaseId("RVAT-854")
	@Test
    public void verifyAddressPlaceholderFilledWithCharacters(){
        boolean isChangeClickable = page.clearAddress()
        								.setAddress(Resources.UserTestData.ADDRESS)
        								.isChangeClickable();
		Assert.assertTrue(isChangeClickable);
    }
	
	@TestCaseId("RVAT-856")
	@Test
    public void verifyAddressPlaceholderFilledWithSpecialCharacters(){
        boolean isChangeClickable = page.clearAddress()
        								.setAddress(Resources.UserTestData.ADDRESS_WITH_SPECIAL_SYMBOL)
        								.isChangeClickable();
		Assert.assertTrue(isChangeClickable);
    }
	
	@AfterMethod
	public void after() {
		driver.quit();
	}
}