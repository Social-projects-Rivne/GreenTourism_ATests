package rv.atqc.gttesting.driverfactory;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class Driver {
    public RemoteWebDriver init( DesiredCapabilities desiredCapabilities){
        int port = 32773;
        RemoteWebDriver driver = null;
        String url = new StringBuilder("http://localhost:")
                .append(port)
                .append("/wd/hub")
                .toString();
        try {
            driver = new RemoteWebDriver(new URL(url), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
    abstract RemoteWebDriver init();
}
