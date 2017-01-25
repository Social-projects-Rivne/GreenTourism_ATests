package rv.atqc.gttesting.editAvatarURl_ToPageObject;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.ProfilePage;
import rv.atqc.gttesting.res.Resources;

import static rv.atqc.gttesting.res.Resources.LogInConstants.*;

public class EditAvatarUrlChrome_PO {
    private ProfilePage profilePage;
    private WebDriver driver;

    @BeforeMethod
    public void before() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("https://green-tourism.herokuapp.com/");
        profilePage = new LogInPage(driver).loging();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void checkChangeButtonTitleInChrome() {
        Assert.assertEquals(profilePage.getChangeButtonText(), Resources.LogInConstants.EXPECTED_CHANGE_BUTTON_TEXT);
    }

    @Test
    public void checkCancelButtonTitleInChrome() {
        Assert.assertEquals(profilePage.getEditAvatarPage().getCancelButtonText(), Resources.LogInConstants.EXPECTED_CANCEL_BUTTON_TEXT);
    }

    @Test
    public void checkConfirmButtonInEditAvSystChrome() {
        Assert.assertTrue(profilePage.getEditAvatarPage().getConfirmButton().isDisplayed());
    }

    @Test
    public void checkPresentFieldAvatarURLInEditAvSystChrome() {
        Assert.assertTrue(profilePage.getEditAvatarPage().getAvatarUrlField().isDisplayed());
    }

    @Test
    public void checkPresentDefaultAvatarInEditAvSystChrome() {
        Assert.assertTrue(profilePage.getEditAvatarPage().getDefAvatarImage().isDisplayed());
    }

    @Test
    public void checkPresentJPGAvatarInEditAvSystChrome() {
        profilePage.getEditAvatarPage().insertURL(JPG_URL);
        Assert.assertTrue(profilePage.getEditAvatarPage().getJPGAvatar().isDisplayed());
    }

    @Test
    public void checkPresentJPEGAvatarInEditAvSystChrome() {
        profilePage.getEditAvatarPage().insertURL(JPEG_URL);
        Assert.assertTrue(profilePage.getEditAvatarPage().getJPEGAvatar().isDisplayed());
    }

    @Test
    public void checkPresentPNGAvatarInEditAvSystChrome() {
        profilePage.getEditAvatarPage().insertURL(PNG_URL);
        Assert.assertTrue(profilePage.getEditAvatarPage().getPNGAvatar().isDisplayed());
    }

    @Test
    public void checkSavingJPGAvatarInEditAvSystChrome() {
        profilePage.getEditAvatarPage().insertURL(PNG_URL);
        profilePage.getEditAvatarPage().clickOnLogOutButton();
        profilePage = new LogInPage(driver).loging();
        Assert.assertTrue(profilePage.getEditAvatarPage().getPNGAvatar().isDisplayed());
    }
}
