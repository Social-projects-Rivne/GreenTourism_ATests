package rv.atqc.gttesting.archex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GreenTourismHeadPage extends AbstractPage implements GreenTourismHeadScript {

	@FindBy(how = How.XPATH, using = "//*[@id=\"navbar\"]/ul[1]/li/a")
	public WebElement leftNavButton;

	private GreenTourismHeadPage page;
	
	public GreenTourismHeadPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected GreenTourismHeadPage getPage() {
		page = (page == null) ? PageFactory.initElements(driver, getClass()) : page;
		return page;
	}

	@Override
	public void clickLeftNavButton() {
		getPage().leftNavButton.click();
	}

}
