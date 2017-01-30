package rv.atqc.gttesting.editmyprofiledata.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import rv.atqc.gttesting.archex.EditProfilePage;
import rv.atqc.gttesting.archex.HeadForGuestUserPage;
import rv.atqc.gttesting.archex.ProfilePage;
import rv.atqc.gttesting.res.Resources;

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

	@Test
	public void verifyNameOfEditButton() {
		Assert.assertTrue(pageProfile.getEditButton().getText().contains("Edit"));
	}

	@Test
	public void verifyExistenceOfTheEditButton() {
		Assert.assertTrue(pageProfile.getEditButton().isEnabled());
	}

	@Test
	public void verifyAppearanceOfFormplaceholdersAfterClickingEditButton() {
		Assert.assertTrue(page.getEditForm().isDisplayed());
	}

	@Test
	public void verifyEmptyFirstNameAndLastNamePlaceholders() {
		Assert.assertFalse(page.clearFirstName().clearLastName().isChangeClickable());
	}

	@Test
	public void verifyFilledFirstNameAndEmptyLastNamePlaceholders() {
		Assert.assertFalse(page.clearFirstName().setFirstName(Resources.UserTestData.VALID_NAME).clearLastName()
				.isChangeClickable());
	}

	@Test
	public void verifyEmptyFirstNameAndFilledLastNamePlaceholders() {
		Assert.assertFalse(page.clearFirstName().clearLastName().setLastName(Resources.UserTestData.VALID_NAME)
				.isChangeClickable());
	}

	@Test
	public void verifyExistenceOfFirstNamePlaceholder() {
		Assert.assertTrue(page.getFirstName().isDisplayed());
	}

	@Test
	public void verifyExistenceOfLastNamePlaceholder() {
		Assert.assertTrue(page.getLastName().isDisplayed());
	}

	@Test
    public void verifyExistenceOfNicknamePlaceholder(){
		Assert.assertTrue(page.getNick().isDisplayed());
    }
	
	@Test
    public void verifyExistenceOfPhoneNumberPlaceholder(){
		Assert.assertTrue(page.getPhone().isDisplayed());
    }
	
	@Test
    public void verifyExistenceOfAddressPlaceholder(){
		Assert.assertTrue(page.getAddress().isDisplayed());
    }
	
	@Test
    public void verifyExistenceOfTheChangeButton(){
		Assert.assertTrue(page.getChange().isDisplayed());
    }
	@Test
    public void verifyExistenceOfTheCancelButton(){
		Assert.assertTrue(page.getCancel().isDisplayed());
    }
	
	@Test
    public void VerifyClickThroughRateOfTheEditButton(){
        Assert.assertTrue(pageProfile.isEditClickable());
    }
	
	@Test
    public void verifyClickThroughRateOfTheChangeButton(){
		Assert.assertTrue(page.isChangeClickable());
    }
	
	@Test
    public void VerifyClickThroughRateOfTheCancelButton(){
		Assert.assertTrue(page.isCancelClickable());
    }
	
	@Test
    public void verifyNicknamePlaceholderFilledWithCharacters(){
		Assert.assertTrue(page.clearNick().setNick(Resources.UserTestData.VALID_NICK_NAME).isChangeClickable());
    }
	
	@Test
    public void verifyNicknamePlaceholderFilledWithSpecialCharacters(){
		Assert.assertTrue(page.clearNick().setNick(Resources.UserTestData.INVALID_NICK_NAME).isChangeClickable());
    }
	
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithValidNumber(){
		Assert.assertTrue(page.clearPhone().setPhone(Resources.UserTestData.VALID_PHONE).isChangeClickable());
    }
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithInvalidNumber(){
        Assert.assertFalse(page.clearPhone().setPhone(Resources.UserTestData.INVALID_PHONE).isChangeClickable());
    }
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithLetters(){
        Assert.assertFalse(page.clearPhone().setPhone(Resources.UserTestData.INVALID_PHONE_WITH_LETTERS).isChangeClickable());
    }
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithSpecialCharacters(){
        Assert.assertFalse(page.clearPhone().setPhone(Resources.UserTestData.INVALID_PHONE_WITH_SPECIAL_SYMBOL).isChangeClickable());
    }
	@Test
    public void verifyAddressPlaceholderFilledWithCharacters(){
        Assert.assertTrue(page.clearAddress().setAddress(Resources.UserTestData.ADDRESS).isChangeClickable());
    }
	@Test
    public void verifyAddressPlaceholderFilledWithSpecialCharacters(){
        Assert.assertTrue(page.clearAddress().setAddress(Resources.UserTestData.ADDRESS_WITH_SPECIAL_SYMBOL).isChangeClickable());
    }
	@AfterMethod
	public void after() {
		driver.quit();
	}
}