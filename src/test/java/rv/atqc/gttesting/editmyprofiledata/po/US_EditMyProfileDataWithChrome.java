package rv.atqc.gttesting.editmyprofiledata.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import rv.atqc.gttesting.archex.EditProfilePage;
import rv.atqc.gttesting.archex.HeadForGuestUserPage;
import rv.atqc.gttesting.archex.ProfilePage;
import rv.atqc.gttesting.res.Resources;

public class US_EditMyProfileDataWithChrome {

	private WebDriver driver;
	private ProfilePage pageProfile;
	private EditProfilePage page;

	@BeforeMethod
	public void before() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get(" http://green-tourism.herokuapp.com");
		driver.manage().window().maximize();
		pageProfile = new HeadForGuestUserPage(driver).clickLeftNavButton().clickLogIn()
				.setLoginField("juger@juger.juger").setPasswordField("11111111").clickLogInButton().clickLeftNavButton()
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
		Assert.assertFalse(page.clearFirstName().clearLastName().isChangeClicable());
	}

	@Test
	public void verifyFilledFirstNameAndEmptyLastNamePlaceholders() {
		Assert.assertFalse(page.clearFirstName().setFirstName(Resources.UserTestData.VALID_NAME).clearLastName()
				.isChangeClicable());
	}

	@Test
	public void verifyEmptyFirstNameAndFilledLastNamePlaceholders() {
		Assert.assertFalse(page.clearFirstName().clearLastName().setLastName(Resources.UserTestData.VALID_NAME)
				.isChangeClicable());
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
        Assert.assertTrue(pageProfile.isEditClicable());
    }
	
	@Test
    public void verifyClickThroughRateOfTheChangeButton(){
		Assert.assertTrue(page.isChangeClicable());
    }
	
	@Test
    public void VerifyClickThroughRateOfTheCancelButton(){
		Assert.assertTrue(page.isCancelClicable());
    }
	
	@Test
    public void verifyNicknamePlaceholderFilledWithCharacters(){
		Assert.assertTrue(page.clearNick().setNick(Resources.UserTestData.VALID_NICK_NAME).isChangeClicable());
    }
	
	@Test
    public void verifyNicknamePlaceholderFilledWithSpecialCharacters(){
		Assert.assertTrue(page.clearNick().setNick(Resources.UserTestData.INVALID_NICK_NAME).isChangeClicable());
    }
	
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithValidNumber(){
		Assert.assertTrue(page.clearPhone().setPhone(Resources.UserTestData.VALID_PHONE).isChangeClicable());
    }
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithInvalidNumber(){
        Assert.assertFalse(page.clearPhone().setPhone(Resources.UserTestData.INVALID_PHONE).isChangeClicable());
    }
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithLetters(){
        Assert.assertFalse(page.clearPhone().setPhone(Resources.UserTestData.INVALID_PHONE_WITH_LETTERS).isChangeClicable());
    }
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithSpecialCharacters(){
        Assert.assertFalse(page.clearPhone().setPhone(Resources.UserTestData.INVALID_PHONE_WITH_SPECIAL_SYMBOL).isChangeClicable());
    }
	@Test
    public void verifyAddressPlaceholderFilledWithCharacters(){
        Assert.assertTrue(page.clearAddress().setAddress(Resources.UserTestData.ADDRESS).isChangeClicable());
    }
	@Test
    public void verifyAddressPlaceholderFilledWithSpecialCharacters(){
        Assert.assertTrue(page.clearAddress().setAddress(Resources.UserTestData.ADDRESS_WITH_SPECIAL_SYMBOL).isChangeClicable());
    }
	@AfterMethod
	public void after() {
		driver.quit();
	}

}