package rv.atqc.gttesting.editAvatarURl_ToPageObject;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rv.atqc.gttesting.archex.EditAvartarPage;
import rv.atqc.gttesting.archex.LogInPage;

public class EditAvatarUrlChrome_PO {
    private EditAvartarPage page;
    private WebDriver driver;

    @BeforeMethod
    public void before() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("https://green-tourism.herokuapp.com/");
        page = new LogInPage(driver).loging();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void insert() {
        System.out.println(page.getClass());
        Assert.assertEquals(page.getChangeButtonText(), "Change");
    }
}
