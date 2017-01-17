package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EventsPage extends AbstractPage<EventsPage> {

    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]")
    private WebElement eventsDropdownList;
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]/a")
    private WebElement eventsName;
    @FindBy(how = How.XPATH, using = "//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]/ul/li[1]/a")
    private WebElement gamePlaceFilter;
    @FindBy(how = How.XPATH, using = "//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]/ul/li[2]/a")
    private WebElement festivalPlaceFilter;
    @FindBy(how = How.XPATH, using = "//*[@id='main']/div/place-list/div/div/div[1]/div[2]/div/div[3]/ul/li[3]/ul/li[3]/a")
    private WebElement meetingPlaceFilter;
    @FindBy(how = How.XPATH, using = "//img[contains(@src,'assets/img/events/marker/green.png')]")
    private WebElement gameGreenIcon;
    @FindBy(how = How.XPATH, using = "//img[contains(@src,'assets/img/events/marker/red.png')]")
    private WebElement festivalRedIcon;
    @FindBy(how = How.XPATH, using = "//img[contains(@src,'assets/img/events/marker/blue.png')]")
    private WebElement meetingBlueIcon;

    protected EventsPage(WebDriver driver){
        super(driver);
    }

    public WebElement getEventsDropdownList(){
        return eventsDropdownList;
    }
    public WebElement getEventsName(){
        return eventsName;
    }
    public EventsPage clickGame(){
        gamePlaceFilter.click();
        return this;
    }
    public EventsPage clickFestival(){
        festivalPlaceFilter.click();
        return this;
    }
    public EventsPage clickMeeting(){
        meetingPlaceFilter.click();
        return this;
    }
    public WebElement getGameFilter(){
        return gamePlaceFilter;
    }
    public WebElement getFestivalFilter(){
        return festivalPlaceFilter;
    }
    public WebElement getMeetingFilter(){
        return meetingPlaceFilter;
    }
    public WebElement getGameGreenIcon(){ return gameGreenIcon; }
    public WebElement getFestivalRedIcon(){
        return festivalRedIcon;
    }
    public WebElement getMeetingBlueIcon(){
        return meetingBlueIcon;
    }
}
