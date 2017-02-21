package rv.atqc.gttesting.editAvatarURl_ToPageObject;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.ProfilePage;
import rv.atqc.gttesting.res.Resources;

import static rv.atqc.gttesting.res.Resources.LogInConstants.JPEG_URL;
import static rv.atqc.gttesting.res.Resources.LogInConstants.JPG_URL;
import static rv.atqc.gttesting.res.Resources.LogInConstants.PNG_URL;

@Features("Verify possibility edit avatar URL")
@Stories("Firefox browser")
public class EditAvatarUrlFirefox_PO {
    private ProfilePage profilePage;
    private WebDriver driver;

    @BeforeMethod
    public void before() {
        FirefoxDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        driver.get("https://green-tourism.herokuapp.com/");
        profilePage = new LogInPage(driver).loging();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @TestCaseId("RVAT-645")
    @Test
    public void checkChangeButtonTitleIn_Firefox() {
        Assert.assertEquals(profilePage.getChangeButtonText(), Resources.LogInConstants.EXPECTED_CHANGE_BUTTON_TEXT);
    }

    @TestCaseId("RVAT-777")
    @Test
    public void checkCancelButtonTitleIn_Firefox() {
        Assert.assertEquals(profilePage.getEditAvatarPage().getCancelButtonText(), Resources.LogInConstants.EXPECTED_CANCEL_BUTTON_TEXT);
    }

    @TestCaseId("RVAT-779")
    @Test
    public void checkConfirmButtonInEditAvSyst_Firefox() {
        Assert.assertTrue(profilePage.getEditAvatarPage().getConfirmButton().isDisplayed());
    }

    @TestCaseId("RVAT-781")
    @Test
    public void checkPresentFieldAvatarURLInEditAvSyst_Firefox() {
        Assert.assertTrue(profilePage.getEditAvatarPage().getAvatarUrlField().isDisplayed());
    }

    @TestCaseId("RVAT-810")
    @Test
    public void checkPresentDefaultAvatarInEditAvSyst_Firefox() {
        Assert.assertTrue(profilePage.getEditAvatarPage().getDefAvatarImage().isDisplayed());
    }

    @TestCaseId("RVAT-812")
    @Test
    public void checkPresentJPGAvatarInEditAvSyst_Firefox() {
        profilePage.getEditAvatarPage().insertURL(JPG_URL);
        Assert.assertTrue(profilePage.getEditAvatarPage().getJPGAvatar().isDisplayed());
    }

    @TestCaseId("RVAT-814")
    @Test
    public void checkPresentJPEGAvatarInEditAvSyst_Firefox() {
        profilePage.getEditAvatarPage().insertURL(JPEG_URL);
        Assert.assertTrue(profilePage.getEditAvatarPage().getJPEGAvatar().isDisplayed());
    }

    @TestCaseId("RVAT-816")
    @Test
    public void checkPresentPNGAvatarInEditAvSyst_Firefox() {
        profilePage.getEditAvatarPage().insertURL(PNG_URL);
        Assert.assertTrue(profilePage.getEditAvatarPage().getPNGAvatar().isDisplayed());
    }

    @TestCaseId("RVAT-818")
    @Test
    public void checkSavingJPGAvatarInEditAvSyst_Firefox() {
        profilePage.getEditAvatarPage().insertURL(PNG_URL);
        profilePage.getEditAvatarPage().clickOnLogOutButton();
        driver.quit();
        before();
        Assert.assertTrue(profilePage.getEditAvatarPage().getPNGAvatar().isDisplayed());
    }
}
