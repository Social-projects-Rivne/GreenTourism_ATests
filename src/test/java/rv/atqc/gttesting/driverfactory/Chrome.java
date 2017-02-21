package rv.atqc.gttesting.driverfactory;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Chrome extends Driver {
    public RemoteWebDriver init() {
        return super.init( DesiredCapabilities.chrome());
    }
}
