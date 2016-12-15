package rv.atqc.gttesting.logUotSystem;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by roman on 15.12.16.
 */
public class or454AllName {
    public static void main(String[] args) {

        ChromeDriverManager.getInstance().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://green-tourism.herokuapp.com/#!/");
        //driver.close();
    }
}