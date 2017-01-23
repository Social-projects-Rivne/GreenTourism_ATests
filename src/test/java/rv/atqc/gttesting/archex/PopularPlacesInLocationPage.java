package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PopularPlacesInLocationPage extends AbstractPage<PopularPlacesInLocationPage> {

    @FindBy(how = How.XPATH, using = "//*[@id=\"popularPlaces\"]")
    protected WebElement popularPlacesButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/place-list/div/div/div[2]/div[7]/div")
    protected WebElement popularPlacesForm;
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/place-list/div/div/div[2]/div[7]/a/i")
    protected WebElement closePopularPlacesFormButton;
    @FindBy(how = How.XPATH, using = "//img[contains(@src,'assets/img/places/marker/search.png')]")
    protected WebElement popularPlacesIcon;
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]" +
            "/div/place-list/div/div/div[2]/div[7]/div/location-places/div[1]/div/a[1]/div")
    protected WebElement imageInPopularPlacesForm;
    @FindBy(how = How.XPATH, using = "//*[@id=\"map\"]/div[1]/div[2]/div[4]/div/div[1]/div/div/button")
    protected WebElement detailsButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/place-list/div/div/div[2]/div[7]/div/location-places/div[1]/div/a[2]")
    //*[@id="main"]/div/place-list/div/div/div[2]/div[7]/div/location-places/div[1]/div/a[4]
    protected WebElement imageHeader;


    public PopularPlacesInLocationPage(WebDriver driver){
        super(driver);
    }

    public WebElement getPopularPlacesButton(){
        return popularPlacesButton;
    }
    public WebElement getPopularPlacesForm(){
        return popularPlacesForm;
    }
    public WebElement getClosePopularPlacesFormButton(){
        return closePopularPlacesFormButton;
    }
    public WebElement getPopularPlacesIcon(){
        return popularPlacesIcon;
    }
    public WebElement getImageInPopularPlacesForm(){
        return imageInPopularPlacesForm;
    }
    public WebElement getDetailsButton(){
        return detailsButton;
    }
    public WebElement getImageHeader(){
        return imageHeader;
    }
    public PopularPlacesInLocationPage clickPopularPlacesIcon(){
        waitForElementToBeClickable(popularPlacesIcon, 10);
        popularPlacesIcon.click();
        return this;
    }
    public BigPopularPlacesInLocationPage clickImageInPopularPlacesForm(){
        waitForElementToBeClickable(imageInPopularPlacesForm, 10);
        imageInPopularPlacesForm.click();
        return new BigPopularPlacesInLocationPage(driver);
    }
}
