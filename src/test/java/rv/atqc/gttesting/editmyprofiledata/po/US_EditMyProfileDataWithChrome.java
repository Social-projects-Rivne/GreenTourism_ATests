package rv.atqc.gttesting.editmyprofiledata.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import rv.atqc.gttesting.archex.EditProfilePage;
import rv.atqc.gttesting.archex.HeadForGuestUserPage;
import rv.atqc.gttesting.archex.ProfilePage;
import rv.atqc.gttesting.res.Resources;


@Features("Checking possibility to edit my profile data")
@Stories("Chrome browser")
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

	@TestCaseId("RVAT-547")
	@Test
	public void verifyNameOfEditButton() {
		String editTitle = pageProfile.getEditButton().getText();
		Assert.assertTrue(editTitle.contains("Edit"));
	}

	@TestCaseId("RVAT-557")
	@Test
	public void verifyExistenceOfTheEditButton() {
		WebElement editButton = pageProfile.getEditButton();
		Assert.assertTrue(editButton.isEnabled());
	}

	@TestCaseId("RVAT-559")
	@Test
	public void verifyAppearanceOfFormplaceholdersAfterClickingEditButton() {
		WebElement editForm = page.getEditForm();
		Assert.assertTrue(editForm.isDisplayed());
	}

	@TestCaseId("RVAT-561")
	@Test
	public void verifyEmptyFirstNameAndLastNamePlaceholders() {
		boolean isChangeClickable = page.clearFirstName()
										.clearLastName()
										.isChangeClickable();
		Assert.assertFalse(isChangeClickable);
	}

	@TestCaseId("RVAT-563")
	@Test
	public void verifyFilledFirstNameAndEmptyLastNamePlaceholders() {
		boolean isChangeClickable = page.clearFirstName()
										.setFirstName(Resources.UserTestData.VALID_NAME)
										.clearLastName()
										.isChangeClickable();
		Assert.assertFalse(isChangeClickable);
	}

	@TestCaseId("RVAT-565")
	@Test
	public void verifyEmptyFirstNameAndFilledLastNamePlaceholders() {
		boolean isChangeClickable = page.clearFirstName()
										.clearLastName()
										.setLastName(Resources.UserTestData.VALID_NAME)
										.isChangeClickable();
		Assert.assertFalse(isChangeClickable);
	}

	@TestCaseId("RVAT-647")
	@Test
	public void verifyExistenceOfFirstNamePlaceholder() {
		WebElement firstName = page.getFirstName();
		Assert.assertTrue(firstName.isDisplayed());
	}

	@TestCaseId("RVAT-649")
	@Test
	public void verifyExistenceOfLastNamePlaceholder() {
		WebElement lastName = page.getLastName();
		Assert.assertTrue(lastName.isDisplayed());
	}

	@TestCaseId("RVAT-651")
	@Test
    public void verifyExistenceOfNicknamePlaceholder(){
		WebElement nick = page.getNick();
		Assert.assertTrue(nick.isDisplayed());
    }
	
	@TestCaseId("RVAT-653")
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
	
	@TestCaseId("RVAT-833")
	@Test
    public void verifyExistenceOfTheChangeButton(){
		WebElement changeButton = page.getChange();
		Assert.assertTrue(changeButton.isDisplayed());
    }
	
	@TestCaseId("RVAT-837")
	@Test
    public void verifyExistenceOfTheCancelButton(){
		WebElement cancel = page.getCancel();
		Assert.assertTrue(cancel.isDisplayed());
    }
	
	@TestCaseId("RVAT-831")
	@Test
    public void verifyClickThroughRateOfTheEditButton(){
		Assert.assertTrue(pageProfile.isEditClickable());
    }
	
	@TestCaseId("RVAT-835")
	@Test
    public void verifyClickThroughRateOfTheChangeButton(){
		Assert.assertTrue(page.isChangeClickable());
    }
	
	@TestCaseId("RVAT-839")
	@Test
    public void VerifyClickThroughRateOfTheCancelButton(){
		Assert.assertTrue(page.isCancelClickable());
    }
	
	@TestCaseId("RVAT-841")
	@Test
    public void verifyNicknamePlaceholderFilledWithCharacters(){
		boolean isChangeClickable = page.clearNick()
										.setNick(Resources.UserTestData.VALID_NICK_NAME)
										.isChangeClickable();
		Assert.assertTrue(isChangeClickable);
    }
	
	@TestCaseId("RVAT-843")
	@Test
    public void verifyNicknamePlaceholderFilledWithSpecialCharacters(){
		boolean isChangeClickable = page.clearNick()
										.setNick(Resources.UserTestData.INVALID_NICK_NAME)
										.isChangeClickable();
		Assert.assertTrue(isChangeClickable);
    }
	
	@TestCaseId("RVAT-845")
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithValidNumber(){
		boolean isChangeClickable = page.clearPhone()
				.setPhone(Resources.UserTestData.VALID_PHONE)
				.isChangeClickable();
		Assert.assertTrue(isChangeClickable);
    }
	
	@TestCaseId("RVAT-847")
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithInvalidNumber(){
        boolean isChangeClickable = page.clearPhone().setPhone(Resources.UserTestData.INVALID_PHONE).isChangeClickable();
		Assert.assertFalse(isChangeClickable);
    }
	
	@TestCaseId("RVAT-849")
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithLetters(){
        boolean isChangeClickable = page.clearPhone()
        								.setPhone(Resources.UserTestData.INVALID_PHONE_WITH_LETTERS)
        								.isChangeClickable();
		Assert.assertFalse(isChangeClickable);
    }
	
	@TestCaseId("RVAT-851")
	@Test
    public void verifyFilledPhoneNumberPlaceholderWithSpecialCharacters(){
        boolean isChangeClickable = page.clearPhone()
        								.setPhone(Resources.UserTestData.INVALID_PHONE_WITH_SPECIAL_SYMBOL)
        								.isChangeClickable();
		Assert.assertFalse(isChangeClickable);
    }
	
	@TestCaseId("RVAT-853")
	@Test
    public void verifyAddressPlaceholderFilledWithCharacters(){
        boolean isChangeClickable = page.clearAddress()
        								.setAddress(Resources.UserTestData.ADDRESS)
        								.isChangeClickable();
		Assert.assertTrue(isChangeClickable);
    }
	
	@TestCaseId("RVAT-855")
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