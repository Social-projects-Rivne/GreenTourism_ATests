package rv.atqc.gttesting.editmyprofiledata.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		pageProfile = new HeadForGuestUserPage(driver)
				.clickLeftNavButton()
				.clickLogIn()
				.setLoginField(Resources.LogInMessage.USER_EMAIL)
				.setPasswordField(Resources.LogInMessage.USER_PASSWORD)
				.clickLogInButton()
				.clickLeftNavButton()
				.clickProfile();
		page = pageProfile.clickEdit();
	}

	@Test
	public void verifyNameOfEditButton() {
		String editTitle = pageProfile.getEditButton().getText();
		Assert.assertTrue(editTitle.contains("Edit"));
	}

	@Test
	public void verifyExistenceOfTheEditButton() {
		WebElement editButton = pageProfile.getEditButton();
		Assert.assertTrue(editButton.isEnabled());
	}

	@Test
	public void verifyAppearanceOfFormplaceholdersAfterClickingEditButton() {
		WebElement editForm = page.getEditForm();
		Assert.assertTrue(editForm.isDisplayed());
	}

	@Test
	public void verifyEmptyFirstNameAndLastNamePlaceholders() {
		boolean isChangeClickable = page.clearFirstName()
										.clearLastName()
										.isChangeClickable();
		Assert.assertFalse(isChangeClickable);
	}

	@Test
	public void verifyFilledFirstNameAndEmptyLastNamePlaceholders() {
		boolean isChangeClickable = page.clearFirstName()
										.setFirstName(Resources.UserTestData.VALID_NAME)
										.clearLastName()
										.isChangeClickable();
		Assert.assertFalse(isChangeClickable);
	}

	@Test
	public void verifyEmptyFirstNameAndFilledLastNamePlaceholders() {
		boolean isChangeClickable = page.clearFirstName()
										.clearLastName()
										.setLastName(Resources.UserTestData.VALID_NAME)
										.isChangeClickable();
		Assert.assertFalse(isChangeClickable);
	}

	@Test
	public void verifyExistenceOfFirstNamePlaceholder() {
		WebElement firstName = page.getFirstName();
		Assert.assertTrue(firstName.isDisplayed());
	}

	@Test
	public void verifyExistenceOfLastNamePlaceholder() {
		WebElement lastName = page.getLastName();
		Assert.assertTrue(lastName.isDisplayed());
	}

	@Test
    public void verifyExistenceOfNicknamePlaceholder(){
		WebElement nick = page.getNick();
		Assert.assertTrue(nick.isDisplayed());
    }
	
	@Test
    public void verifyExistenceOfPhoneNumberPlaceholder(){
		WebElement phone = page.getPhone();
		Assert.assertTrue(phone.isDisplayed());
    }
	
	@Test
    public void verifyExistenceOfAddressPlaceholder(){
		WebElement address = page.getAddress();
		Assert.assertTrue(address.isDisplayed());
    }
	
	@Test
    public void verifyExistenceOfTheChangeButton(){
		WebElement changeButton = page.getChange();
		Assert.assertTrue(changeButton.isDisplayed());
    }
	@Test
    public void verifyExistenceOfTheCancelButton(){
		WebElement cancel = page.getCancel();
		Assert.assertTrue(cancel.isDisplayed());
    }
	
	@Test
    public void verifyClickThroughRateOfTheEditButton(){
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
		boolean isChangeClickable = page.clearNick()
										.setNick(Resources.UserTestData.VALID_NICK_NAME)
										.isChangeClickable();
		Assert.assertTrue(isChangeClickable);
    }
	
	@Test
    public void verifyNicknamePlaceholderFilledWithSpecialCharacters(){
		boolean isChangeClickable = page.clearNick()
										.setNick(Resources.UserTestData.INVALID_NICK_NAME)
										.isChangeClickable();
		Assert.assertTrue(isChangeClickable);
    }
	
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithValidNumber(){
		boolean isChangeClickable = page.clearPhone()
				.setPhone(Resources.UserTestData.VALID_PHONE)
				.isChangeClickable();
		Assert.assertTrue(isChangeClickable);
    }
	
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithInvalidNumber(){
        boolean isChangeClickable = page.clearPhone().setPhone(Resources.UserTestData.INVALID_PHONE).isChangeClickable();
		Assert.assertFalse(isChangeClickable);
    }
	
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithLetters(){
        boolean isChangeClickable = page.clearPhone()
        								.setPhone(Resources.UserTestData.INVALID_PHONE_WITH_LETTERS)
        								.isChangeClickable();
		Assert.assertFalse(isChangeClickable);
    }
	
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithSpecialCharacters(){
        boolean isChangeClickable = page.clearPhone()
        								.setPhone(Resources.UserTestData.INVALID_PHONE_WITH_SPECIAL_SYMBOL)
        								.isChangeClickable();
		Assert.assertFalse(isChangeClickable);
    }
	
	@Test
    public void verifyAddressPlaceholderFilledWithCharacters(){
        boolean isChangeClickable = page.clearAddress()
        								.setAddress(Resources.UserTestData.ADDRESS)
        								.isChangeClickable();
		Assert.assertTrue(isChangeClickable);
    }
	
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