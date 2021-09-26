package test.Drivers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.logging.Level;

public class Browser {

    private ThreadLocal<RemoteWebDriver> WEB_DRIVER;

    public void setUp(String browser_name) throws Exception {

        WEB_DRIVER = new ThreadLocal<>();
        MutableCapabilities mutableCapabilities;
        if (browser_name.equalsIgnoreCase("chrome")) {
            mutableCapabilities = new ChromeOptions();

        } else if (browser_name.equalsIgnoreCase("firefox")) {
            mutableCapabilities = new FirefoxOptions();

        } else {
            throw new RuntimeException("Please pass valid Browser name....");
        }

        // this sends Network.enable to chromedriver
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        mutableCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        WEB_DRIVER.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), mutableCapabilities));
    }

    public WebDriver getDriver() {
        return WEB_DRIVER.get();
    }

    public void tearDown() {
        WEB_DRIVER.get().quit();
    }

}
