package rv.atqc.gttesting.editAvatarURl_ToPageObject;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.ProfilePage;
import rv.atqc.gttesting.driverfactory.DriverFactory;
import rv.atqc.gttesting.res.Resources;
import static rv.atqc.gttesting.res.Resources.LogInConstants.*;

@Features("Verify possibility edit avatar URL")
@Stories("Chrome browser")
public class EditAvatarUrlChrome_PO {
    private ProfilePage profilePage;
    private WebDriver driver;

    @BeforeMethod
    public void before() {
        ChromeDriverManager.getInstance().setup();
        driver = DriverFactory.init(DriverFactory.CHROME);
      //  driver = new ChromeDriver();
        driver.get("https://green-tourism.herokuapp.com/");
        profilePage = new LogInPage(driver).loging();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @TestCaseId("RVAT-644")
    @Test
    public void checkChangeButtonTitleIn_Chrome() {
        Assert.assertEquals(profilePage.getChangeButtonText(), Resources.LogInConstants.EXPECTED_CHANGE_BUTTON_TEXT);
    }

    @TestCaseId("RVAT-776")
    @Test
    public void checkCancelButtonTitleIn_Chrome() {
        Assert.assertEquals(profilePage.getEditAvatarPage().getCancelButtonText(), Resources.LogInConstants.EXPECTED_CANCEL_BUTTON_TEXT);
    }

    @TestCaseId("RVAT-778")
    @Test
    public void checkConfirmButtonInEditAvSyst_Chrome() {
        Assert.assertTrue(profilePage.getEditAvatarPage().getConfirmButton().isDisplayed());
    }

    @TestCaseId("RVAT-780")
    @Test
    public void checkPresentFieldAvatarURLInEditAvSyst_Chrome() {
        Assert.assertTrue(profilePage.getEditAvatarPage().getAvatarUrlField().isDisplayed());
    }

    @TestCaseId("RVAT-809")
    @Test
    public void checkPresentDefaultAvatarInEditAvSyst_Chrome() {
        Assert.assertTrue(profilePage.getEditAvatarPage().getDefAvatarImage().isDisplayed());
    }

    @TestCaseId("RVAT-811")
    @Test
    public void checkPresentJPGAvatarInEditAvSyst_Chrome() {
        profilePage.getEditAvatarPage().insertURL(JPG_URL);
        Assert.assertTrue(profilePage.getEditAvatarPage().getJPGAvatar().isDisplayed());
    }

    @TestCaseId("RVAT-813")
    @Test
    public void checkPresentJPEGAvatarInEditAvSyst_Chrome() {
        profilePage.getEditAvatarPage().insertURL(JPEG_URL);
        Assert.assertTrue(profilePage.getEditAvatarPage().getJPEGAvatar().isDisplayed());
    }

    @TestCaseId("RVAT-815")
    @Test
    public void checkPresentPNGAvatarInEditAvSyst_Chrome() {
        profilePage.getEditAvatarPage().insertURL(PNG_URL);
        Assert.assertTrue(profilePage.getEditAvatarPage().getPNGAvatar().isDisplayed());
    }

    @TestCaseId("RVAT-817")
    @Test
    public void checkSavingJPGAvatarInEditAvSyst_Chrome() {
        profilePage.getEditAvatarPage().insertURL(PNG_URL);
        profilePage.getEditAvatarPage().clickOnLogOutButton();
        driver.quit();
        before();
        Assert.assertTrue(profilePage.getEditAvatarPage().getPNGAvatar().isDisplayed());
    }
}
