package rv.atqc.gttesting.editAvatarURl_ToPageObject;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rv.atqc.gttesting.archex.EditAvartarPage;
import rv.atqc.gttesting.archex.LogInPage;
import rv.atqc.gttesting.archex.ProfilePage;
import rv.atqc.gttesting.res.Resources;

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
    public void checkChangeButtonTitleInChrome() {
        System.out.println(profilePage.getClass());
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
}
