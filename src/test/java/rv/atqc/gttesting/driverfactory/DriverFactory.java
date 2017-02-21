package rv.atqc.gttesting.driverfactory;

import org.openqa.selenium.remote.RemoteWebDriver;

public enum DriverFactory {
    FIREFOX, CHROME;
//    public static RemoteWebDriver init(String browser, int port){
//        DriverFactory df = DriverFactory.valueOf(browser);
//        switch (df){
//            case FIREFOX: return new Firefox().init(port);
//            case CHROME: return new Chrome().init(port);
//            default: throw  new IllegalArgumentException();
//        }
//    }

    public static RemoteWebDriver init(DriverFactory df){
        switch (df){
            case FIREFOX: return new Firefox().init();
            case CHROME: return new Chrome().init();
            default: throw  new IllegalArgumentException();
        }
    }
}
