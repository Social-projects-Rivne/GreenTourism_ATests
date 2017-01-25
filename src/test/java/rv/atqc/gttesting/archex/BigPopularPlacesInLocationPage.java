package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BigPopularPlacesInLocationPage extends AbstractPage<BigPopularPlacesInLocationPage> {

    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/place-detail/div/div/div[2]/div[1]/div/h2")
    private WebElement headerOfPage;

    private final int MAX_TIME_WAIT = 15;

    public BigPopularPlacesInLocationPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHeaderOfPage(){
        waitForVisibilityOfElement(headerOfPage, MAX_TIME_WAIT);
        return headerOfPage;
    }
}
