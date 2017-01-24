package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MapHeadPageForGuestUserPage extends AbstractMapHeadPage<MapHeadPageForGuestUserPage> {

    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[3]/div/div[2]/button")
    private WebElement logIn;

    public MapHeadPageForGuestUserPage(WebDriver driver) {
        super(driver);
    }
    public void clickOn () {

        logIn.click();
    }

}
