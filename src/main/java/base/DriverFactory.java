package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
	
	
	// ThreadLocal driver for thread safety
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver initDriver(String browser, boolean runOnCloud) {
        try {
            if (runOnCloud) {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setBrowserName(browser);
                caps.setCapability("platform", "Windows 11");
                caps.setCapability("version", "latest");

                // Example: BrowserStack URL (replace with your username/key)
                String cloudURL = "https://USERNAME:ACCESS_KEY@hub-cloud.browserstack.com/wd/hub";
                tlDriver.set(new RemoteWebDriver(new URL(cloudURL), caps));
            } else {
                switch (browser.toLowerCase()) {
                    case "chrome":
                        tlDriver.set(new ChromeDriver());
                        break;
                    case "firefox":
                        tlDriver.set(new FirefoxDriver());
                        break;
                    case "edge":
                        tlDriver.set(new EdgeDriver());
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported browser: " + browser);
                }
            }
            getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            getDriver().manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        getDriver().quit();
        tlDriver.remove();
    }
	
	

}
