package rv.atqc.gttesting.editAvatarURl_ToPageObject;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.ProfilePage;
import rv.atqc.gttesting.res.Resources;

import static rv.atqc.gttesting.res.Resources.LogInConstants.JPEG_URL;
import static rv.atqc.gttesting.res.Resources.LogInConstants.JPG_URL;
import static rv.atqc.gttesting.res.Resources.LogInConstants.PNG_URL;

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

    @Test
    public void checkChangeButtonTitleIn_Firefox() {
        Assert.assertEquals(profilePage.getChangeButtonText(), Resources.LogInConstants.EXPECTED_CHANGE_BUTTON_TEXT);
    }

    @Test
    public void checkCancelButtonTitleIn_Firefox() {
        Assert.assertEquals(profilePage.getEditAvatarPage().getCancelButtonText(), Resources.LogInConstants.EXPECTED_CANCEL_BUTTON_TEXT);
    }

    @Test
    public void checkConfirmButtonInEditAvSyst_Firefox() {
        Assert.assertTrue(profilePage.getEditAvatarPage().getConfirmButton().isDisplayed());
    }

    @Test
    public void checkPresentFieldAvatarURLInEditAvSyst_Firefox() {
        Assert.assertTrue(profilePage.getEditAvatarPage().getAvatarUrlField().isDisplayed());
    }

    @Test
    public void checkPresentDefaultAvatarInEditAvSyst_Firefox() {
        Assert.assertTrue(profilePage.getEditAvatarPage().getDefAvatarImage().isDisplayed());
    }

    @Test
    public void checkPresentJPGAvatarInEditAvSyst_Firefox() {
        profilePage.getEditAvatarPage().insertURL(JPG_URL);
        Assert.assertTrue(profilePage.getEditAvatarPage().getJPGAvatar().isDisplayed());
    }

    @Test
    public void checkPresentJPEGAvatarInEditAvSyst_Firefox() {
        profilePage.getEditAvatarPage().insertURL(JPEG_URL);
        Assert.assertTrue(profilePage.getEditAvatarPage().getJPEGAvatar().isDisplayed());
    }

    @Test
    public void checkPresentPNGAvatarInEditAvSyst_Firefox() {
        profilePage.getEditAvatarPage().insertURL(PNG_URL);
        Assert.assertTrue(profilePage.getEditAvatarPage().getPNGAvatar().isDisplayed());
    }

    @Test
    public void checkSavingJPGAvatarInEditAvSyst_Firefox() {
        profilePage.getEditAvatarPage().insertURL(PNG_URL);
        profilePage.getEditAvatarPage().clickOnLogOutButton();
        driver.quit();
        before();
        Assert.assertTrue(profilePage.getEditAvatarPage().getPNGAvatar().isDisplayed());
    }
}
